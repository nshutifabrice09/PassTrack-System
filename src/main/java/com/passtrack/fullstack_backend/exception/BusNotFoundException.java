package com.passtrack.fullstack_backend.exception;

public class BusNotFoundException extends RuntimeException{

    public BusNotFoundException(Long busId){
        super("Could not find the bus with id" +busId);
    }
}
