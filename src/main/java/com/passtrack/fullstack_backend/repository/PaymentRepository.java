package com.passtrack.fullstack_backend.repository;

import com.passtrack.fullstack_backend.model.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRepository extends JpaRepository <Payment, Long> {
}
