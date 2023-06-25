package com.api.Develcode.shared.exception.apiHandler;

import com.api.Develcode.shared.exception.EntityInUseException;
import com.api.Develcode.shared.exception.EntityNotFoundException;
import com.api.Develcode.shared.exception.GenericException;
import com.api.Develcode.shared.exception.InvalidIdException;
import com.api.Develcode.shared.exception.UniqueConstraintViolationException;
import com.fasterxml.jackson.databind.JsonMappingException.Reference;
import com.fasterxml.jackson.databind.exc.InvalidFormatException;
import com.fasterxml.jackson.databind.exc.PropertyBindingException;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.springframework.beans.TypeMismatchException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import org.springframework.web.servlet.NoHandlerFoundException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@ControllerAdvice
public class ApiExceptionHandler extends ResponseEntityExceptionHandler {

    public static final String MSG_ERRO_GENERICA_USUARIO_FINAL = "Ocorreu um erro interno inesperado no sistema. Tente novamente e se "
            + "o problema persistir, entre em contato com o administrador do sistema.";

    @Override
    protected ResponseEntity<Object> handleExceptionInternal(Exception ex, Object body, HttpHeaders headers,
            HttpStatusCode statusCode, WebRequest request) {
        // Pattern RFC 7809
        if (body == null || body instanceof String) {
            String detail = gethandleExceptionDetail(body, statusCode);

            body = createProblemBuilder(statusCode, detail).build();
        }

        return super.handleExceptionInternal(ex, body, headers, statusCode, request);
    }

    private static String gethandleExceptionDetail(Object body, HttpStatusCode statusCode) {
        return body != null ? (String) body : HttpStatus.valueOf(statusCode.value()).getReasonPhrase();
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Object> handleUncaughtException(Exception ex, WebRequest request) {
        HttpStatus status = HttpStatus.INTERNAL_SERVER_ERROR;
        String detail = MSG_ERRO_GENERICA_USUARIO_FINAL;

        ex.printStackTrace();

        Problem problem = createProblemBuilder(status, detail).build();

        return handleExceptionInternal(ex, problem, new HttpHeaders(), status, request);
    }

    // EXCEPTIONS DE NEGÓCIO

    @ExceptionHandler(GenericException.class)
    public ResponseEntity<?> handleGenericException(GenericException ex, WebRequest request) {
        HttpStatus statusCode = HttpStatus.BAD_REQUEST;
        String detail = ex.getMessage();

        Problem problem = createProblemBuilder(statusCode, detail)
                .userMessage(detail)
                .build();

        return handleExceptionInternal(ex, problem, new HttpHeaders(), statusCode, request);
    }

    @ExceptionHandler({
            EntityNotFoundException.class,
    })
    public ResponseEntity<?> handleEntityNotFoundException(EntityNotFoundException ex, WebRequest request) {
        HttpStatus statusCode = HttpStatus.NOT_FOUND;
        String detail = ex.getMessage();

        Problem problem = createProblemBuilder(statusCode, detail)
                .userMessage(detail)
                .build();

        return handleExceptionInternal(ex, problem, new HttpHeaders(), statusCode, request);
    }

    @ExceptionHandler({
            UniqueConstraintViolationException.class,
    })
    public ResponseEntity<?> handleUniqueConstraintViolationException(UniqueConstraintViolationException ex, WebRequest request) {
        HttpStatus statusCode = HttpStatus.CONFLICT;
        String detail = ex.getMessage();

        Problem problem = createProblemBuilder(statusCode, detail)
                .userMessage(detail)
                .build();

        return handleExceptionInternal(ex, problem, new HttpHeaders(), statusCode, request);
    }

    @ExceptionHandler(EntityInUseException.class)
    public ResponseEntity<?> handleEntityInUseException(EntityInUseException ex, WebRequest request) {
        HttpStatus statusCode = HttpStatus.CONFLICT;
        String detail = ex.getMessage();

        Problem problem = createProblemBuilder(statusCode, detail)
                .userMessage(detail)
                .build();

        return handleExceptionInternal(ex, problem, new HttpHeaders(), statusCode, request);
    }

    @ExceptionHandler(InvalidIdException.class)
    public ResponseEntity<?> handleIdInvalidIdException(InvalidIdException ex, WebRequest request) {
        HttpStatus statusCode = HttpStatus.BAD_REQUEST;
        String detail = ex.getMessage();

        Problem problem = createProblemBuilder(statusCode, detail)
                .userMessage(detail)
                .build();

        return handleExceptionInternal(ex, problem, new HttpHeaders(), statusCode, request);
    }

    // BODY EXCEPTION

    @Override
    protected ResponseEntity<Object> handleHttpMessageNotReadable(HttpMessageNotReadableException ex,
            HttpHeaders headers, HttpStatusCode status, WebRequest request) {
        Throwable rootCause = ExceptionUtils.getRootCause(ex);

        String detail = "O corpo da requisição está inválido. Verifique o erro de sintaxe.";

        if (rootCause instanceof InvalidFormatException invalidEx) {
            detail = getInvalidFormatDetail(invalidEx);

        }
        if (rootCause instanceof PropertyBindingException ignoredEx) {
            detail = getPropertyBindingDetail(ignoredEx);
        }

        Problem problem = createProblemBuilder(status, detail).build();

        return handleExceptionInternal(ex, problem, new HttpHeaders(), status, request);
    }

    private static String getPropertyBindingDetail(PropertyBindingException ignoredEx) {
        String path = JoinPath(ignoredEx.getPath());

        return String.format("A propriedade '%s' não existe. "
                + "Corrija ou remova essa propriedade e tente novamente.", path);
    }

    private static String getInvalidFormatDetail(InvalidFormatException invalidEx) {
        String path = JoinPath(invalidEx.getPath());

        return String.format("A propriedade '%s' recebeu o valor '%s', "
                + "que é de um tipo inválido. Corrija e informe um valor compatível com o tipo %s.",
                path, invalidEx.getValue(), invalidEx.getTargetType().getSimpleName());
    }

    private static String JoinPath(List<Reference> path) {
        return path
                .stream().map(Reference::getFieldName)
                .collect(Collectors.joining("."));
    }

    // PATH VARIABLE EXCEPTION

    @Override
    protected ResponseEntity<Object> handleTypeMismatch(TypeMismatchException ex, HttpHeaders headers,
            HttpStatusCode status, WebRequest request) {
        String detail = String.format("O parâmetro de URL '%s' recebeu o valor '%s'," +
                "que é um tipo inválido. Corrija e informe um valor compatível com o tipo '%s'",
                ((MethodArgumentTypeMismatchException) ex).getName(), ex.getValue(),
                ex.getRequiredType().getSimpleName());

        Problem problem = createProblemBuilder(status, detail).build();

        return handleExceptionInternal(ex, problem, new HttpHeaders(), status, request);
    }

    // METHOD NOT ALLOWED EXCEPTION

    @Override
    protected ResponseEntity<Object> handleNoHandlerFoundException(NoHandlerFoundException ex, HttpHeaders headers,
            HttpStatusCode status, WebRequest request) {
        String detail = String.format("O recurso '%s' que você tentou acessar não existe.",
                ex.getRequestURL());

        Problem problem = createProblemBuilder(status, detail).build();

        return handleExceptionInternal(ex, problem, new HttpHeaders(), status, request);
    }

    // VALIDATION EXCEPTIONS

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
            HttpHeaders headers, HttpStatusCode status, WebRequest request) {
        String detail = String
                .format("Um ou mais campos estão inválidos. Faça o preenchimento correto e tente novamente.");

        BindingResult bindingResult = ex.getBindingResult();
        List<Problem.Field> fields = bindingResult.getFieldErrors().stream()
                .map(fieldError -> Problem.Field.builder()
                        .name(fieldError.getField())
                        .userMessage(fieldError.getDefaultMessage())
                        .build())
                .collect(Collectors.toList());

        Problem problem = createProblemBuilder(status, detail)
                .userMessage(detail)
                .fields(fields)
                .build();

        return handleExceptionInternal(ex, problem, new HttpHeaders(), status, request);
    }

    // UTILITÁRIOS

    private Problem.ProblemBuilder createProblemBuilder(HttpStatusCode statusCode, String detail) {
        return Problem.builder()
                .status(statusCode.value())
                .detail(detail)
                .timestamp(LocalDateTime.now())
                .userMessage(MSG_ERRO_GENERICA_USUARIO_FINAL);
    }

}
