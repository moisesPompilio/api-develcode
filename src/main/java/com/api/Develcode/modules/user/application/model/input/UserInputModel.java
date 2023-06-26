package com.api.Develcode.modules.user.application.model.input;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

import com.api.Develcode.shared.generic.model.DataTransferObject;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;

@Schema(description = "Modelo de entrada de dados para usuario")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserInputModel implements DataTransferObject {

    @Schema(example = "Junior Silval")
    @NotEmpty
    private String nome;

    @Schema(example = "https://blog.zooxsmart.com/hubfs/Capa---Artigo-de-Blog---Desenvolvedor%2C-voc%C3%AA-sabe-quando-dizer-n%C3%A3o-ao-seu-chefe.jpg#keepProtocol")
    @NotEmpty
    private String foto;

    @Schema(example = "2000-06-17")
    private LocalDate dataDeNascimento;
}
