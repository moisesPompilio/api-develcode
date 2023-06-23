package com.api.Develcode.modules.user.application.model.output;

import java.time.LocalDate;
import java.util.UUID;

import com.api.Develcode.shared.generic.model.DataTransferObject;

import lombok.Data;

@Data
public class UserOutputModel implements DataTransferObject {
    
    private UUID id;

    private String nome;

    private String foto;

    private LocalDate dataDeNascimento;
}
