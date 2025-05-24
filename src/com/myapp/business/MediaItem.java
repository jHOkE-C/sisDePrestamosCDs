package com.myapp.business; 

public abstract class MediaItem { 
    private final String title; 
    public MediaItem(String title) { this.title = title; } 
    public String getTitle() { return title; } 
    public abstract double getPricePerDay(); 
}