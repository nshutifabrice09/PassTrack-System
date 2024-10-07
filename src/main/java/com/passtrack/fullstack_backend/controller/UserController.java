package com.passtrack.fullstack_backend.controller;


import com.passtrack.fullstack_backend.exception.UserNotFoundException;
import com.passtrack.fullstack_backend.model.User;
import com.passtrack.fullstack_backend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @PostMapping("/user")
    User newUser(@RequestBody User newUser){
        return userRepository.save(newUser);
    }

    @GetMapping("/users")
    List<User> getAllUsers(){
        return userRepository.findAll();
    }

    @GetMapping("/user{userId}")
    User getUserById(@PathVariable Long userId){
        return userRepository.findById(userId)
                .orElseThrow(()->new UserNotFoundException(userId));
    }

    @PutMapping("/user/{userId}")
    User updateUser(@RequestBody User newUser, @PathVariable Long userId){
        return userRepository.findById(userId)
                .map(user -> {
                    user.setName(newUser.getName());
                    user.setEmail(newUser.getName());
                    user.setPassword(newUser.getPassword());
                    user.setPhoneNumber(newUser.getPhoneNumber());
                    return userRepository.save(user);
                }).orElseThrow(()->new UserNotFoundException(userId));
    }

    @DeleteMapping("/users/{userId}")
    String deleteUser (@PathVariable Long userId){
        if(!userRepository.existsById(userId)){
            throw new UserNotFoundException(userId);
        }
        userRepository.deleteById(userId);
        return "User with id "+userId+" has been deleted successfully";
    }
}

