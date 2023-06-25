package com.api.Develcode.modules.user.domain.usecase;

import java.util.UUID;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;

import com.api.Develcode.modules.user.adapter.repository.UserRepository;
import com.api.Develcode.modules.user.application.model.input.UserInputModel;
import com.api.Develcode.modules.user.application.model.mapper.UserMapperModel;
import com.api.Develcode.modules.user.application.model.output.UserOutputModel;
import com.api.Develcode.modules.user.domain.entity.User;
import com.api.Develcode.shared.exception.EntityInUseException;
import com.api.Develcode.shared.exception.EntityNotFoundException;
import com.api.Develcode.shared.exception.InvalidIdException;
import com.api.Develcode.shared.generic.usecase.GenericUseCase;


public class DeleteByIdUserUseCase extends GenericUseCase<User, UserInputModel, UserOutputModel> {
    public DeleteByIdUserUseCase(UserRepository userRepository) {
        super(new UserMapperModel(), userRepository);
    }
     public void execute(String idString){
      try {
         UUID id = UUID.fromString(idString);
         this.repositorio.deleteById(id);
         this.repositorio.flush();
      } catch (EmptyResultDataAccessException ex) {
            throw new EntityNotFoundException(idString);
        } catch (DataIntegrityViolationException ex) {
            throw new EntityInUseException();
        } catch (IllegalArgumentException ex) {
            throw new InvalidIdException(idString);
        }
     } 
}
