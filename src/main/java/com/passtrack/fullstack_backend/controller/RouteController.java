package com.passtrack.fullstack_backend.controller;

import com.passtrack.fullstack_backend.exception.RouteNotFoundException;
import com.passtrack.fullstack_backend.model.Route;
import com.passtrack.fullstack_backend.repository.RouteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class RouteController {

    @Autowired
    private RouteRepository routeRepository;

    @PostMapping("/route")
    Route newRoute(@RequestBody Route newRoute){
        return routeRepository.save(newRoute);

    }

    @GetMapping("/routes")
    List<Route> getAllRoutes(){
        return routeRepository.findAll();
    }

    @GetMapping("/route/{routeId}")
    Route getRouteById (@PathVariable Long routeId){
        return routeRepository.findById(routeId)
                .orElseThrow (()-> new RouteNotFoundException(routeId));
    }

    @PutMapping("/routes/{routeId}")
    Route updateRoute(@RequestBody Route newRoute, @PathVariable Long routeId){
        return routeRepository.findById(routeId)
                .map(route -> {
                    route.setStartLocation(newRoute.getStartLocation());
                    route.setEndLocation(newRoute.getEndLocation());
                    route.setSchedule(newRoute.getSchedule());
                    return routeRepository.save(route);
                }).orElseThrow(()-> new RouteNotFoundException(routeId));
    }

    @DeleteMapping("/routes/{routeId}")
    String deleteRoute(@PathVariable Long routeId){
        if(!routeRepository.existsById(routeId)){
            throw new RouteNotFoundException(routeId);
        }
        routeRepository.deleteById(routeId);
        return "Route with id "+routeId+" has been deleted successfully";
    }
}
