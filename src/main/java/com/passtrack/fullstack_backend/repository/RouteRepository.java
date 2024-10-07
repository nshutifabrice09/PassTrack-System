package com.passtrack.fullstack_backend.repository;

import com.passtrack.fullstack_backend.model.Route;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RouteRepository extends JpaRepository <Route, Long> {
}
