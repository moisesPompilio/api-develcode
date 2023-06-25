package com.api.Develcode.modules.user.domain.usecase;

import java.util.UUID;

import com.api.Develcode.modules.user.application.model.input.UserInputModel;
import com.api.Develcode.modules.user.application.model.mapper.UserMapperModel;
import com.api.Develcode.modules.user.application.model.output.UserOutputModel;
import com.api.Develcode.modules.user.domain.entity.User;
import com.api.Develcode.shared.generic.repository.GenericRepository;
import com.api.Develcode.shared.generic.usecase.GenericUseCase;

public class ReloadUserUseCase extends GenericUseCase<User, UserInputModel, UserOutputModel> {
    public ReloadUserUseCase(GenericRepository<User, UUID> repositorio) {
        super(new UserMapperModel(), repositorio);
    }

    public void execute(User userEntity) {
        this.repositorio.flush();
        this.repositorio.refresh(userEntity);
    }
}
