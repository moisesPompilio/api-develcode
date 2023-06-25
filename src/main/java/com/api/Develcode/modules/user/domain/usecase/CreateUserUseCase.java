package com.api.Develcode.modules.user.domain.usecase;

import org.springframework.dao.DataIntegrityViolationException;

import com.api.Develcode.modules.user.adapter.repository.UserRepository;
import com.api.Develcode.modules.user.application.model.input.UserInputModel;
import com.api.Develcode.modules.user.application.model.mapper.UserMapperModel;
import com.api.Develcode.modules.user.application.model.output.UserOutputModel;
import com.api.Develcode.modules.user.domain.entity.User;
import com.api.Develcode.shared.exception.UniqueConstraintViolationException;
import com.api.Develcode.shared.generic.usecase.GenericUseCase;

public class CreateUserUseCase extends GenericUseCase<User, UserInputModel, UserOutputModel> {
    public CreateUserUseCase(UserRepository userRepository) {
        super(new UserMapperModel(), userRepository);
    }

    public void execute(UserInputModel userInput) {
        try {
            User userEntity = mapper.toDomain(userInput);
            ReloadUserUseCase reloadUserUseCase = new ReloadUserUseCase(repositorio);
            reloadUserUseCase.execute(this.repositorio.save(userEntity));
        } catch (DataIntegrityViolationException ex) {
            throw new UniqueConstraintViolationException(User.class);
        }

    }
}
