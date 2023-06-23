package com.api.Develcode.modules.user.domain.usecase;

import java.util.UUID;

import com.api.Develcode.modules.user.adapter.repository.UserRepository;
import com.api.Develcode.modules.user.application.model.input.UserInputModel;
import com.api.Develcode.modules.user.application.model.mapper.UserMapperModel;
import com.api.Develcode.modules.user.domain.entity.UserEntity;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class UpdateByIdUserUseCase {
    private UserRepository userRepository;
    private final UserMapperModel mapper;

    public UpdateByIdUserUseCase(UserRepository userRepository) {
        this.userRepository = userRepository;
        this.mapper = new UserMapperModel();
    }

    public void execute(String idString, UserInputModel userInputModel) {
        UUID id = UUID.fromString(idString);
        UserEntity user = userRepository.findById(id).get();
        this.mapper.updateEntity(userInputModel, user);
        this.userRepository.flush();
        this.userRepository.refresh(user);
    }
}
