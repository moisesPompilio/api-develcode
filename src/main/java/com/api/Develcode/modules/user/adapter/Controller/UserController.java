package com.api.Develcode.modules.user.adapter.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.api.Develcode.modules.user.application.model.input.UserInputModel;
import com.api.Develcode.modules.user.application.model.output.UserOutputModel;
import com.api.Develcode.modules.user.application.service.UserService;
import com.api.Develcode.shared.exception.apiHandler.Problem;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/user")
@CrossOrigin
public class UserController {
    @Autowired
    private UserService userService;

    @Operation(summary = "Criar novo usuario")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "201", description = "Usuario criado com sucesso"),
        @ApiResponse(responseCode = "400", description = "Erros de validação"),
        @ApiResponse(responseCode = "409", description = "Conflito"),
        @ApiResponse(responseCode = "500", description = "Erro interno do servidor", content = @Content(schema = @Schema(implementation = Problem.class)))
    })
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void CreateUserControleer(@RequestBody @Valid UserInputModel userInputModel) {
        this.userService.CreateUserService(userInputModel);
    }

    @Operation(summary = "Deletar usuario")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "204", description = "Usuario deletado com sucesso"),
        @ApiResponse(responseCode = "400", description = "Erros de validação"),
        @ApiResponse(responseCode = "404", description = "Recurso não encontrado"),
        @ApiResponse(responseCode = "500", description = "Erro interno do servidor", content = @Content(schema = @Schema(implementation = Problem.class)))
    })
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void DeleteUserControleer(@PathVariable String id){
        this.userService.DeleteByIdService(id);
    }

    @Operation(summary = "Listar usuarios")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Usuario Listados com sucesso"),
        @ApiResponse(responseCode = "500", description = "Erro interno do servidor", content = @Content(schema = @Schema(implementation = Problem.class)))
    })
    @GetMapping
    public List<UserOutputModel> GetAllUserController() {
        return this.userService.GetAllUserService();
    }

    @Operation(summary = "Alterar usuario")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Usuario alterado com sucesso"),
        @ApiResponse(responseCode = "400", description = "Erros de validação"),
        @ApiResponse(responseCode = "404", description = "Recurso não encontrado"),
        @ApiResponse(responseCode = "409", description = "Conflito"),
        @ApiResponse(responseCode = "500", description = "Erro interno do servidor", content = @Content(schema = @Schema(implementation = Problem.class)))
    })
    @PutMapping("/{id}")
    public void UpdateByIdUserControleer(@PathVariable String id, @RequestBody @Valid UserInputModel userInputModel){
        this.userService.UpdateByIdUserService(id, userInputModel);
    }
}

