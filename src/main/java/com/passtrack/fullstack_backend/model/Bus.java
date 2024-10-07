package com.passtrack.fullstack_backend.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Bus {
    @Id
    @GeneratedValue
    private Long plateNumber;
    private String busId;
    private String routeId;
    private float price;

    public Long getPlateNumber() {
        return plateNumber;
    }

    public void setPlateNumber(Long plateNumber) {
        this.plateNumber = plateNumber;
    }

    public String getBusId() {
        return busId;
    }

    public void setBusId(String busId) {
        this.busId = busId;
    }

    public String getRouteId() {
        return routeId;
    }

    public void setRouteId(String routeId) {
        this.routeId = routeId;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }
}
