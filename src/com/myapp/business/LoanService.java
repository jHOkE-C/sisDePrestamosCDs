package com.myapp.business; 

import com.myapp.data.MediaRepository; 
import com.myapp.data.MediaStock; 

public class LoanService { 
    private final MediaRepository repository; 
    private static final double INSURANCE_FEE = 2.0; 

    public LoanService(MediaRepository repository) { 
        this.repository = repository; 
    } 

    public double processLoan(String title, String type, int days, boolean isMember, boolean withInsurance) { 
        MediaStock stock = repository.findStock(title) 
            .orElseThrow(() -> new IllegalArgumentException("Título no existe.")); 
        if (!stock.isAvailable(type)) 
            throw new IllegalStateException("Sin stock disponible para ese tipo."); 

        MediaFactory factory = type.equalsIgnoreCase("BluRay") ? new BluRayFactory() : new DVDFactory(); 
        MediaItem item = factory.createMedia(title); 

        PricingStrategy strat = isMember ? new MemberPricingStrategy() : new StandardPricingStrategy(); 
        double cost = strat.calculate(item, days); 
        if (withInsurance) cost += INSURANCE_FEE; 

        repository.saveLoanRecord(title, type, days, withInsurance, cost); 
        repository.decrementStock(title, type); 

        return cost; 
    } 
}