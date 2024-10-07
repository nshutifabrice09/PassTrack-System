package com.passtrack.fullstack_backend.exception;

public class UserNotFoundException extends RuntimeException{
    public UserNotFoundException(Long userId){
        super("Could not find the route with id "+ userId );
    }
}
