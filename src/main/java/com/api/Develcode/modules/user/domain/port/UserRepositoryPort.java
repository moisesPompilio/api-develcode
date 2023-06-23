package com.api.Develcode.modules.user.domain.port;

import com.api.Develcode.modules.user.domain.entity.UserEntity;

public interface UserRepositoryPort<UserEntity, UUID> {
    UserEntity[] findAll();
    UserEntity save(UserEntity userEntity);
    UserEntity findById(String id);
    void deleteById(String id);
    void flush();
    UserEntity refresh(UserEntity entity);
}
