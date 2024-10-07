package com.passtrack.fullstack_backend.exception;

public class PaymentNotFoundException extends RuntimeException{
    public PaymentNotFoundException(Long paymentId){
        super("Could not find the payment with id" +paymentId);
    }
}
