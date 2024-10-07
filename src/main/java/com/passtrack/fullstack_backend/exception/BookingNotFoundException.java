package com.passtrack.fullstack_backend.exception;

public class BookingNotFoundException extends RuntimeException{

    public BookingNotFoundException(Long bookingId){
        super("Could not find the booking with id " +bookingId);
    }
}
