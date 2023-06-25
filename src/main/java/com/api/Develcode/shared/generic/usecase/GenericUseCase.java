package com.api.Develcode.shared.generic.usecase;

import java.util.UUID;

import com.api.Develcode.shared.generic.mapper.GenericMapper;
import com.api.Develcode.shared.generic.model.DataTransferObject;
import com.api.Develcode.shared.generic.model.GenericEntity;
import com.api.Develcode.shared.generic.repository.GenericRepository;

import lombok.RequiredArgsConstructor;


@RequiredArgsConstructor
public abstract class GenericUseCase<DomainModel extends GenericEntity, InputModel extends DataTransferObject, OutputModel extends DataTransferObject> {

    protected final GenericMapper<DomainModel, InputModel, OutputModel> mapper;
    protected final GenericRepository<DomainModel, UUID> repositorio;
}
