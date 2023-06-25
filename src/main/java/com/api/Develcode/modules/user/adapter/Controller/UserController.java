package com.api.Develcode.modules.user.adapter.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.api.Develcode.modules.user.application.model.input.UserInputModel;
import com.api.Develcode.modules.user.application.model.output.UserOutputModel;
import com.api.Develcode.modules.user.application.service.UserService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/user")
@CrossOrigin
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void CreateUserControleer(@RequestBody @Valid UserInputModel userInputModel) {
        this.userService.CreateUserService(userInputModel);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void DeleteUserControleer(@PathVariable String id){
        this.userService.DeleteByIdService(id);
    }

    @GetMapping
    public List<UserOutputModel> GetAllUserController() {
        return this.userService.GetAllUserService();
    }

    @PutMapping("/{id}")
    public void UpdateByIdUserControleer(@PathVariable String id, @RequestBody @Valid UserInputModel userInputModel){
        this.userService.UpdateByIdUserService(id, userInputModel);
    }
}

