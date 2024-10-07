package com.passtrack.fullstack_backend.model;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
public class Payment {

    @Id
    @GeneratedValue
    private Long paymentId;
    private float amount;
    private LocalDate paymentDate;
    private Long booking_BusId;
    private Long booking_UserId;

    public Long getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(Long paymentId) {
        this.paymentId = paymentId;
    }

    public float getAmount() {
        return amount;
    }

    public void setAmount(float amount) {
        this.amount = amount;
    }

    public LocalDate getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(LocalDate paymentDate) {
        this.paymentDate = paymentDate;
    }

    public Long getBooking_BusId() {
        return booking_BusId;
    }

    public void setBooking_BusId(Long booking_BusId) {
        this.booking_BusId = booking_BusId;
    }

    public Long getBooking_UserId() {
        return booking_UserId;
    }

    public void setBooking_UserId(Long booking_UserId) {
        this.booking_UserId = booking_UserId;
    }
}
