package com.myapp.business; 

public class DVD extends MediaItem { 
    public DVD(String title) { super(title); } 
    public double getPricePerDay() { return 1.5; } 
}