package com.example.tollpayment.model;

import java.util.ArrayList;
import java.util.List;

public class Vehicle {
    private String vehicleNo;
    private String vehicleType;
    private boolean isVip;
    private List<Journey> journeys;

    public Vehicle(String vehicleNo, String vehicleType, boolean isVip) {
        this.vehicleNo = vehicleNo;
        this.vehicleType = vehicleType;
        this.isVip = isVip;
        this.journeys = new ArrayList<>();
    }

    public void addJourney(Journey journey) {
        journeys.add(journey);
    }

    // Getters and setters

    public String getVehicleNo() { return vehicleNo; }
    public String getVehicleType() { return vehicleType; }
    public boolean getIsVip() { return isVip; }
    public List<Journey> getJourneys() { return journeys; }
}
