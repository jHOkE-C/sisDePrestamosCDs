package com.myapp.business; 

import java.time.LocalDateTime;

public class LoanRecord { 
    private final String title;
    private final String mediaType;
    private final int days;
    private final boolean withInsurance;
    private final double cost;
    private final LocalDateTime timestamp;
    
    public LoanRecord(String title, String mediaType, int days, boolean withInsurance, double cost) {
        this.title = title;
        this.mediaType = mediaType;
        this.days = days;
        this.withInsurance = withInsurance;
        this.cost = cost;
        this.timestamp = LocalDateTime.now();
    }
    
    // Getters
    public String getTitle() { return title; }
    public String getMediaType() { return mediaType; }
    public int getDays() { return days; }
    public boolean isWithInsurance() { return withInsurance; }
    public double getCost() { return cost; }
    public LocalDateTime getTimestamp() { return timestamp; }
    
    @Override
    public String toString() {
        return String.format("%s (%s) - %d días - Seguro: %s - Costo: %.2f - %s",
            title, mediaType, days, withInsurance ? "Sí" : "No", cost, timestamp);
    }
}