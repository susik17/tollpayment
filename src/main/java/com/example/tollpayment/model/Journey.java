package com.example.tollpayment.model;



import java.util.List;

public class Journey {
    private int start;
    private int destination;
    private List<Integer> tollsPassed;
    private int amtPaid;

    public Journey(int start, int destination, List<Integer> tollsPassed, int amtPaid) {
        this.start = start;
        this.destination = destination;
        this.tollsPassed = tollsPassed;
        this.amtPaid = amtPaid;
    }

    // Getters
    public int getStart() { return start; }
    public int getDestination() { return destination; }
    public List<Integer> getTollsPassed() { return tollsPassed; }
    public int getAmtPaid() { return amtPaid; }
}
