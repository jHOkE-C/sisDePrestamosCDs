package com.myapp.business; 

public class DVDFactory extends MediaFactory { 
    public MediaItem createMedia(String title) { return new DVD(title); } 
}