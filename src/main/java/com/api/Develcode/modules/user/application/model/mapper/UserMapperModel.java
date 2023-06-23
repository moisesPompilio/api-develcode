package com.api.Develcode.modules.user.application.model.mapper;

import org.springframework.stereotype.Component;

import com.api.Develcode.modules.user.application.model.input.UserInputModel;
import com.api.Develcode.modules.user.application.model.output.UserOutputModel;
import com.api.Develcode.modules.user.domain.entity.UserEntity;
import com.api.Develcode.shared.generic.mapper.GenericMapper;

@Component
public class UserMapperModel  extends GenericMapper<UserEntity, UserInputModel, UserOutputModel>{
    public UserMapperModel() {
        super(UserEntity.class, UserInputModel.class, UserOutputModel.class);
    }
}
