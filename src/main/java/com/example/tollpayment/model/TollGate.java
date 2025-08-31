package com.example.tollpayment.model;


import java.util.HashMap;
import java.util.Map;

public class TollGate {
    private String tollId;
    private Map<String, Integer> chargesPerVehicle; // VehicleType -> Charge
    private int totalRevenue;

    public TollGate(String tollId) {
        this.tollId = tollId;
        this.chargesPerVehicle = new HashMap<>();
        this.totalRevenue = 0;
    }

    public void setChargeForVehicleType(String vehicleType, int charge) {
        chargesPerVehicle.put(vehicleType, charge);
    }

    public int calculateToll(String vehicleType, boolean isVip) {
        int charge = chargesPerVehicle.getOrDefault(vehicleType, 0);
        if (isVip) {
            charge = charge - (charge * 20) / 100; // 20% discount
        }
        return charge;
    }

    public void recordPayment(int amtPaid) {
        totalRevenue += amtPaid;
    }

    // Getters
    public String getTollId() { return tollId; }
    public int getTotalRevenue() { return totalRevenue; }
    public Map<String, Integer> getChargesPerVehicle() { return chargesPerVehicle; }
}
