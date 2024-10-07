package com.passtrack.fullstack_backend.repository;

import com.passtrack.fullstack_backend.model.Bus;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BusRepository extends JpaRepository <Bus, Long> {
}
