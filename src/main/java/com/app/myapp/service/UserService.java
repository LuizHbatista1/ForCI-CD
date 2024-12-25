package com.app.myapp.service;

import com.app.myapp.DTOS.UserDTO;
import com.app.myapp.domain.User;
import com.app.myapp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User createAndSaveUser(UserDTO userDTO){

        User newUser = new User(userDTO);
        newUser.setName(newUser.getName());
        newUser.setEmail(newUser.getEmail());
        newUser.setPassword(newUser.getPassword());
        this.userRepository.save(newUser);
        return newUser;

    }

}
