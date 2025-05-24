package com.myapp.business; 

public class StandardPricingStrategy implements PricingStrategy { 
    public double calculate(MediaItem item, int days) { 
        return item.getPricePerDay() * days; 
    } 
}