package com.myapp.business; 

public class BluRayFactory extends MediaFactory { 
    public MediaItem createMedia(String title) { return new BluRay(title); } 
}