package com.api.Develcode.modules.user.domain.usecase;

import java.util.UUID;

import com.api.Develcode.modules.user.adapter.repository.UserRepository;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class DeleteByIdUserUseCase {
    private UserRepository userRepository;
    
    public DeleteByIdUserUseCase(UserRepository userRepository){
        this.userRepository = userRepository;
     }
     public void execute(String idString){
        UUID id = UUID.fromString(idString);
        userRepository.deleteById(id);
        userRepository.flush();
     } 
}
