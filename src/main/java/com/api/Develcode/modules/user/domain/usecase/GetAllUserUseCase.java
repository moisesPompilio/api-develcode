package com.api.Develcode.modules.user.domain.usecase;

import java.util.List;

import com.api.Develcode.modules.user.adapter.repository.UserRepository;
import com.api.Develcode.modules.user.application.model.input.UserInputModel;
import com.api.Develcode.modules.user.application.model.mapper.UserMapperModel;
import com.api.Develcode.modules.user.application.model.output.UserOutputModel;
import com.api.Develcode.modules.user.domain.entity.User;
import com.api.Develcode.shared.generic.usecase.GenericUseCase;


public class GetAllUserUseCase extends GenericUseCase<User, UserInputModel, UserOutputModel> {
    public GetAllUserUseCase(UserRepository userRepository) {
        super(new UserMapperModel(), userRepository);
    }

     public List<UserOutputModel> execute() {    
        List<User> users = this.repositorio.findAll();
        return mapper.toOutputCollection(users);
     } 
}
