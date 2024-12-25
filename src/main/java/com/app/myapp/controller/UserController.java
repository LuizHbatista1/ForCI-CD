package com.app.myapp.controller;

import com.app.myapp.DTOS.UserDTO;
import com.app.myapp.domain.User;
import com.app.myapp.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/user")
    public ResponseEntity<User>createUser(@RequestBody UserDTO userDTO){

        User newUser = userService.createAndSaveUser(userDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(newUser);

    }


}
