package com.api.Develcode.modules.user.adapter.repository;


import java.util.UUID;

import com.api.Develcode.modules.user.domain.entity.User;
import com.api.Develcode.shared.generic.repository.GenericRepository;

public interface UserRepository extends GenericRepository<User, UUID> {
    
}
