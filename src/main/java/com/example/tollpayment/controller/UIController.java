package com.example.tollpayment.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.example.tollpayment.service.TollService;

@Controller
public class UIController {

    @Autowired
    private TollService tollService;

    @GetMapping("/")
    public String home() {
        return "index";
    }

    @GetMapping("/journey")
    public String showJourneyForm() {
        return "journey";
    }

    @PostMapping("/journey")
    public String submitJourney(@RequestParam String vehicleNo,
                                @RequestParam String vehicleType,
                                @RequestParam boolean isVip,
                                @RequestParam int start,
                                @RequestParam int destination,
                                Model model) {
        String message = tollService.processJourney(vehicleNo, vehicleType, isVip, start, destination);
        model.addAttribute("message", message);
        return "journey";
    }

    @GetMapping("/vehicles")
    public String showVehicles(Model model) {
        model.addAttribute("vehicles", tollService.getAllVehicles());
        return "vehicles";
    }

    @GetMapping("/tollgates")
    public String showTollGates(Model model) {
        model.addAttribute("tollgates", tollService.getAllTollGates());
        return "tollgates";
    }
}

