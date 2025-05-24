package com.myapp.business; 

public interface PricingStrategy { 
    double calculate(MediaItem item, int days); 
}