package com.myapp.presentation; 

public class LoanRequestDTO { 
    private String title, type; 
    private int days; 
    private boolean member, insurance; 

    public void validate() { 
        if (title == null || title.isBlank()) throw new IllegalArgumentException("Título vacío."); 
        if (!type.equalsIgnoreCase("DVD") && !type.equalsIgnoreCase("BluRay")) 
            throw new IllegalArgumentException("Tipo inválido."); 
        if (days <= 0) throw new IllegalArgumentException("Días debe ser > 0."); 
    } 

    // Getters y setters 
    public String getTitle() { return title; } 
    public void setTitle(String title) { this.title = title; } 
    public String getType() { return type; } 
    public void setType(String type) { this.type = type; } 
    public int getDays() { return days; } 
    public void setDays(int days) { this.days = days; } 
    public boolean isMember() { return member; } 
    public void setMember(boolean member) { this.member = member; } 
    public boolean isInsurance() { return insurance; } 
    public void setInsurance(boolean insurance) { this.insurance = insurance; } 
}