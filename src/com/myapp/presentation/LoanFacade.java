package com.myapp.presentation; 

import com.myapp.business.LoanService; 
import com.myapp.data.InMemoryMediaRepository; 

public class LoanFacade { 
    private final LoanService service;
    
    public LoanFacade(InMemoryMediaRepository repository) {
        this.service = new LoanService(repository);
    }

    public double submitLoan(LoanRequestDTO dto) { 
        dto.validate(); 
        return service.processLoan( 
            dto.getTitle(), dto.getType(), dto.getDays(), dto.isMember(), dto.isInsurance() 
        ); 
    } 
}