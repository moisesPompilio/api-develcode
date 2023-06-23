package com.api.Develcode.modules.user.domain.usecase;

import java.util.Optional;
import java.util.UUID;

import com.api.Develcode.modules.user.adapter.repository.UserRepository;
import com.api.Develcode.modules.user.application.model.mapper.UserMapperModel;
import com.api.Develcode.modules.user.application.model.output.UserOutputModel;
import com.api.Develcode.modules.user.domain.entity.UserEntity;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class GetByIdUserUseCase {
    private UserRepository userRepository;
    private final UserMapperModel mapper;

    public GetByIdUserUseCase(UserRepository userRepository) {
        this.userRepository = userRepository;
        this.mapper = new UserMapperModel();
    }

    public UserOutputModel execute(String idString) {
        UUID id = UUID.fromString(idString);
        Optional<UserEntity> user = userRepository.findById(id);
        return mapper.toOutput(user.get());
    }
}
