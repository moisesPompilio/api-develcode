package com.api.Develcode.modules.user.application.model.input;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

import com.api.Develcode.shared.generic.model.DataTransferObject;

import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserInputModel implements DataTransferObject {

    @NotEmpty
    private String nome;

    @NotEmpty
    private String foto;

    private LocalDate dataDeNascimento;
}
