package com.api.Develcode.shared.exception.apiHandler;

import com.fasterxml.jackson.annotation.JsonInclude;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.List;

@Schema(description = "Modelo de resposta de erro")
@JsonInclude(JsonInclude.Include.NON_NULL)
@Getter
@Builder
public class Problem {

    @Schema(example = "400")
    private Integer status;
    @Schema(example = "Esse id é invalido: id")
    private String detail;
    @Schema(example = "Esse id é invalido: id")
    private String userMessage;
    @Schema(example = "2023-06-25T21:45:09.200376405")
    private LocalDateTime timestamp;
    private List<Field> fields;

    @Getter
    @Builder
    public static class Field {

        private String name;
        private String userMessage;

    }

}
