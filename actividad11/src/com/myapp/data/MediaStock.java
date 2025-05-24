package com.myapp.data; 

public class MediaStock { 
    private final String title;
    private int dvdCount;
    private int bluRayCount;
    
    public MediaStock(String title, int dvdCount, int bluRayCount) {
        this.title = title;
        this.dvdCount = dvdCount;
        this.bluRayCount = bluRayCount;
    }
    
    public boolean isAvailable(String mediaType) {
        if (mediaType.equalsIgnoreCase("DVD")) {
            return dvdCount > 0;
        } else if (mediaType.equalsIgnoreCase("BluRay")) {
            return bluRayCount > 0;
        }
        return false;
    }
    
    public void decrementDVDCount() {
        if (dvdCount > 0) dvdCount--;
    }
    
    public void decrementBluRayCount() {
        if (bluRayCount > 0) bluRayCount--;
    }
    
    // Getters
    public String getTitle() { return title; }
    public int getDvdCount() { return dvdCount; }
    public int getBluRayCount() { return bluRayCount; }
}