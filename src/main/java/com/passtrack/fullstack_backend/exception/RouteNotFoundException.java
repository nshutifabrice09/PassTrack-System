package com.passtrack.fullstack_backend.exception;

public class RouteNotFoundException extends RuntimeException{

    public RouteNotFoundException (Long routeId){
        super("Could not find the route with id " +routeId);
    }
}
