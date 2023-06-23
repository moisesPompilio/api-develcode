package com.api.Develcode.modules.user.domain.usecase;

import java.util.List;

import com.api.Develcode.modules.user.adapter.repository.UserRepository;
import com.api.Develcode.modules.user.application.model.mapper.UserMapperModel;
import com.api.Develcode.modules.user.application.model.output.UserOutputModel;
import com.api.Develcode.modules.user.domain.entity.UserEntity;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class GetAllUserUseCase {
    
    private UserRepository userRepository;
    private final UserMapperModel mapper;

    public GetAllUserUseCase(UserRepository userRepository){
        this.userRepository = userRepository;
        this.mapper = new UserMapperModel();
     }

     public List<UserOutputModel> execute() {    
        List<UserEntity> users = userRepository.findAll();
        return mapper.toOutputCollection(users);
     } 
}
