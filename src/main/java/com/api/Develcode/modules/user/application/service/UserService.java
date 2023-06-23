package com.api.Develcode.modules.user.application.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.Develcode.modules.user.adapter.repository.UserRepository;
import com.api.Develcode.modules.user.application.model.input.UserInputModel;
import com.api.Develcode.modules.user.application.model.output.UserOutputModel;
import com.api.Develcode.modules.user.domain.usecase.CreateUserUseCase;
import com.api.Develcode.modules.user.domain.usecase.DeleteByIdUserUseCase;
import com.api.Develcode.modules.user.domain.usecase.GetAllUserUseCase;
import com.api.Develcode.modules.user.domain.usecase.GetByIdUserUseCase;
import com.api.Develcode.modules.user.domain.usecase.UpdateByIdUserUseCase;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class UserService {
    @Autowired
    private UserRepository repository;

    public void CreateUserService(UserInputModel userInput) {
        CreateUserUseCase createUserUseCase = new CreateUserUseCase(repository);
        createUserUseCase.execute(userInput);
    }

    public void DeleteByIdService(String id) {
        DeleteByIdUserUseCase deleteByIdUserUseCase = new DeleteByIdUserUseCase(repository);
        deleteByIdUserUseCase.execute(id);
    }

    public List<UserOutputModel> GetAllUserService() {
        GetAllUserUseCase getAllUserUseCase = new GetAllUserUseCase(repository);
        return getAllUserUseCase.execute();
    }
    
    public UserOutputModel GetByIdUserService(String id) {
        GetByIdUserUseCase getAllUserUseCase = new GetByIdUserUseCase(repository);
        return getAllUserUseCase.execute(id);
    }

    public void UpdateByIdUserService(String id, UserInputModel userInputModel){
        UpdateByIdUserUseCase updateByIdUserUseCase = new UpdateByIdUserUseCase(repository);
        updateByIdUserUseCase.execute(id, userInputModel);
    }
}
