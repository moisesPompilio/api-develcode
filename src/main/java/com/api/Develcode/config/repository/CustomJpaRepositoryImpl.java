package com.api.Develcode.config.repository;

import jakarta.persistence.EntityManager;
import org.springframework.data.jpa.repository.support.JpaEntityInformation;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;

import com.api.Develcode.shared.generic.repository.CustomJpaRepository;

import java.io.Serializable;

public class CustomJpaRepositoryImpl<T,ID> extends SimpleJpaRepository<T,ID>
        implements CustomJpaRepository<T,ID>, Serializable {

    private final EntityManager manager;

    public CustomJpaRepositoryImpl(JpaEntityInformation<T, ?> entityInformation, EntityManager entityManager) {
        super(entityInformation, entityManager);
        this.manager = entityManager;
    }

    @Override
    public T refresh(T t) {
        manager.refresh(t);
        return t;
    }

    @Override
    public void detach(T t) {
        manager.refresh(t);
    }
}

