package com.myapp.data; 

import com.myapp.business.LoanRecord;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class InMemoryMediaRepository implements MediaRepository { 
    private final Map<String, MediaStock> stockMap = new HashMap<>();
    private final List<LoanRecord> loanHistory = new ArrayList<>();
    
    public InMemoryMediaRepository() {
        // Inicializar con algunos datos de ejemplo
        stockMap.put("Matrix", new MediaStock("Matrix", 2, 1));
        stockMap.put("Inception", new MediaStock("Inception", 3, 2));
        stockMap.put("Interstellar", new MediaStock("Interstellar", 1, 1));
    }
    
    @Override
    public Optional<MediaStock> findStock(String title) {
        return Optional.ofNullable(stockMap.get(title));
    }
    
    @Override
    public void decrementStock(String title, String mediaType) {
        MediaStock stock = stockMap.get(title);
        if (stock != null) {
            if (mediaType.equalsIgnoreCase("DVD")) {
                stock.decrementDVDCount();
            } else if (mediaType.equalsIgnoreCase("BluRay")) {
                stock.decrementBluRayCount();
            }
        }
    }
    
    @Override
    public void saveLoanRecord(String title, String mediaType, int days, boolean withInsurance, double cost) {
        LoanRecord record = new LoanRecord(title, mediaType, days, withInsurance, cost);
        loanHistory.add(record);
        System.out.println("Préstamo registrado: " + record);
    }
    
    // Añadir este método al final de la clase InMemoryMediaRepository
    
    @Override
    public List<MediaStock> getInventory() {
        return new ArrayList<>(stockMap.values());
    }
}