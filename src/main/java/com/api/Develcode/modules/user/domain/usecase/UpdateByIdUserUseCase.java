package com.api.Develcode.modules.user.domain.usecase;

import org.springframework.dao.DataIntegrityViolationException;

import com.api.Develcode.modules.user.adapter.repository.UserRepository;
import com.api.Develcode.modules.user.application.model.input.UserInputModel;
import com.api.Develcode.modules.user.application.model.mapper.UserMapperModel;
import com.api.Develcode.modules.user.application.model.output.UserOutputModel;
import com.api.Develcode.modules.user.domain.entity.User;
import com.api.Develcode.shared.exception.UniqueConstraintViolationException;
import com.api.Develcode.shared.generic.usecase.GenericUseCase;

public class UpdateByIdUserUseCase extends GenericUseCase<User, UserInputModel, UserOutputModel> {
    public UpdateByIdUserUseCase(UserRepository userRepository) {
        super(new UserMapperModel(), userRepository);
    }

    public void execute(String idString, UserInputModel userInputModel) {
        try {
            GetByIdUserUseCase getByIdUserUseCase = new GetByIdUserUseCase(this.repositorio);
            User user = getByIdUserUseCase.execute(idString);
            this.mapper.updateEntity(userInputModel, user);
            ReloadUserUseCase reloadUserUseCase = new ReloadUserUseCase(this.repositorio);
            reloadUserUseCase.execute(user);
        } catch (DataIntegrityViolationException ex) {
            throw new UniqueConstraintViolationException(User.class);
        }
    }

}
