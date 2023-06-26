package com.api.Develcode.modules.user.application.model.output;

import java.time.LocalDate;
import java.util.UUID;

import com.api.Develcode.shared.generic.model.DataTransferObject;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Schema(description = "Modelo de saida de dados para usuario")
@Data
public class UserOutputModel implements DataTransferObject {
    
    @Schema(example = "3fa85f64-5717-4562-b3fc-2c963f66afa6")
    private UUID id;

    @Schema(example = "Junior Silval")
    private String nome;

    @Schema(example = "https://blog.zooxsmart.com/hubfs/Capa---Artigo-de-Blog---Desenvolvedor%2C-voc%C3%AA-sabe-quando-dizer-n%C3%A3o-ao-seu-chefe.jpg#keepProtocol")
    private String foto;

    @Schema(example = "2000-06-17")
    private LocalDate dataDeNascimento;
}
