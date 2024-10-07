package com.passtrack.fullstack_backend.controller;


import com.passtrack.fullstack_backend.exception.PaymentNotFoundException;
import com.passtrack.fullstack_backend.model.Payment;
import com.passtrack.fullstack_backend.repository.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PaymentController {

    @Autowired
    private PaymentRepository paymentRepository;

    @PostMapping("/payment")
    Payment newPayment(@RequestBody Payment newPayment){
        return paymentRepository.save(newPayment);
    }

    @GetMapping("/payments")
    List<Payment> getAllPayments(){
        return paymentRepository.findAll();
    }

    @GetMapping("/payment/{paymentId}")
    Payment getPaymentById(@PathVariable Long paymentId){
        return paymentRepository.findById(paymentId)
                .orElseThrow(()->new PaymentNotFoundException(paymentId));
    }

    @PutMapping("/payment/{paymentId}")
    Payment updatePayment (@RequestBody Payment newPayment, @PathVariable Long paymentId){
        return paymentRepository.findById(paymentId)
                .map(payment -> {
                    payment.setAmount(newPayment.getAmount());
                    payment.setPaymentDate(newPayment.getPaymentDate());
                    payment.setBooking_BusId(newPayment.getBooking_BusId());
                    payment.setBooking_UserId(newPayment.getBooking_UserId());
                    return paymentRepository.save(payment);
                }).orElseThrow(()->new PaymentNotFoundException(paymentId));
    }

    @DeleteMapping("/payments/{paymentId}")
    String deletePayment(@PathVariable Long paymentId){
        if(!paymentRepository.existsById(paymentId)){
            throw new PaymentNotFoundException(paymentId);
        }
        paymentRepository.deleteById(paymentId);
        return "Payment with id "+paymentId+ "has been deleted successfully";
    }
}
