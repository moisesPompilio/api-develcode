package com.api.Develcode.modules.user.domain.usecase;


import com.api.Develcode.modules.user.adapter.repository.UserRepository;
import com.api.Develcode.modules.user.application.model.input.UserInputModel;
import com.api.Develcode.modules.user.application.model.mapper.UserMapperModel;
import com.api.Develcode.modules.user.domain.entity.UserEntity;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class CreateUserUseCase {
    private UserRepository userRepository;
    
    private final UserMapperModel mapper;
    public CreateUserUseCase(UserRepository userRepository){
        this.userRepository = userRepository;
        this.mapper = new UserMapperModel();
     }
     public void execute(UserInputModel userInput){
        UserEntity userEntity = mapper.toDomain(userInput);
        recarregar(this.userRepository.save(userEntity));
     }
     
     private void recarregar(UserEntity userEntity) {
         this.userRepository.flush();
         this.userRepository.refresh(userEntity);
     }
}
