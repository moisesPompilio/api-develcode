package com.api.Develcode.modules.user.domain.usecase;

import java.util.UUID;

import com.api.Develcode.modules.user.application.model.input.UserInputModel;
import com.api.Develcode.modules.user.application.model.mapper.UserMapperModel;
import com.api.Develcode.modules.user.application.model.output.UserOutputModel;
import com.api.Develcode.modules.user.domain.entity.User;
import com.api.Develcode.shared.exception.EntityNotFoundException;
import com.api.Develcode.shared.exception.InvalidIdException;
import com.api.Develcode.shared.generic.repository.GenericRepository;
import com.api.Develcode.shared.generic.usecase.GenericUseCase;


public class GetByIdUserUseCase extends GenericUseCase<User, UserInputModel, UserOutputModel> {
    public GetByIdUserUseCase(GenericRepository<User, UUID> repositorio) {
        super(new UserMapperModel(), repositorio);
    }

    public User execute(String idString) {
        try {
            UUID id = UUID.fromString(idString);
            User user = this.repositorio.findById(id)
                    .orElseThrow(() -> new EntityNotFoundException(idString));
            return user;

        } catch (IllegalArgumentException ex) {
            throw new InvalidIdException(idString);
        }
    }
}
