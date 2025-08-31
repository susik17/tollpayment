package com.example.tollpayment.service;



import org.springframework.stereotype.Service;

import com.example.tollpayment.model.Journey;
import com.example.tollpayment.model.TollGate;
import com.example.tollpayment.model.Vehicle;

import java.util.*;

@Service
public class TollService {
    private List<TollGate> tollGates = new ArrayList<>();
    private Map<String, Vehicle> vehicleRecords = new HashMap<>();

    public TollService() {
        // Initialize toll gates with IDs and charges
        TollGate tollA = new TollGate("TollA");
        tollA.setChargeForVehicleType("CAR", 25);
        tollA.setChargeForVehicleType("TRUCK", 50);

        TollGate tollB = new TollGate("TollB");
        tollB.setChargeForVehicleType("CAR", 30);
        tollB.setChargeForVehicleType("TRUCK", 60);

        tollGates.add(tollA);
        tollGates.add(tollB);
    }

    public synchronized String processJourney(String vehicleNo, String vehicleType, boolean isVip, int start, int destination) {
        Vehicle vehicle = vehicleRecords.computeIfAbsent(vehicleNo, v -> new Vehicle(v, vehicleType, isVip));

        // Calculate toll route (forward route)
        List<Integer> tollRoute = findCircularShortRoute(start, destination);

        int totalAmount = 0;
        for (int tollIndex : tollRoute) {
            TollGate tollGate = tollGates.get(tollIndex);
            int charge = tollGate.calculateToll(vehicleType, isVip);
            tollGate.recordPayment(charge);
            totalAmount += charge;
        }

        vehicle.addJourney(new Journey(start, destination, tollRoute, totalAmount));

        return "Journey completed. Total paid: " + totalAmount;
    }

    // Find shortest circular route forward from start to end (0-based index)
    private List<Integer> findCircularShortRoute(int start, int end) {
        List<Integer> route = new ArrayList<>();
        int i = start;
        while (true) {
            route.add(i);
            if (i == end) break;
            i++;
            if (i == tollGates.size()) {
                i = 0; // wrap around
            }
        }
        return route;
    }

    public List<Vehicle> getAllVehicles() {
        return new ArrayList<>(vehicleRecords.values());
    }

    public List<TollGate> getAllTollGates() {
        return Collections.unmodifiableList(tollGates);
    }
}

