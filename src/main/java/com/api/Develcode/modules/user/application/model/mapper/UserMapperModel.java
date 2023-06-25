package com.api.Develcode.modules.user.application.model.mapper;

import org.springframework.stereotype.Component;

import com.api.Develcode.modules.user.application.model.input.UserInputModel;
import com.api.Develcode.modules.user.application.model.output.UserOutputModel;
import com.api.Develcode.modules.user.domain.entity.User;
import com.api.Develcode.shared.generic.mapper.GenericMapper;

@Component
public class UserMapperModel  extends GenericMapper<User, UserInputModel, UserOutputModel>{
    public UserMapperModel() {
        super(User.class, UserInputModel.class, UserOutputModel.class);
    }
}
