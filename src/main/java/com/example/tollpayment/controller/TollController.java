package com.example.tollpayment.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.tollpayment.model.TollGate;
import com.example.tollpayment.model.Vehicle;
import com.example.tollpayment.service.TollService;

import java.util.List;

@RestController
@RequestMapping("/api")
public class TollController {

    @Autowired
    private TollService tollService;

    @PostMapping("/journey")
    public String startJourney(@RequestParam String vehicleNo,
                               @RequestParam String vehicleType,
                               @RequestParam boolean isVip,
                               @RequestParam int start,
                               @RequestParam int destination) {
        return tollService.processJourney(vehicleNo, vehicleType, isVip, start, destination);
    }

    @GetMapping("/vehicles")
    public List<Vehicle> getVehicles() {
        return tollService.getAllVehicles();
    }
   

    @GetMapping("/tollgates")
    public List<TollGate> getTollGates() {
        return tollService.getAllTollGates();
    }
}
