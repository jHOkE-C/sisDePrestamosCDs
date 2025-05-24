package com.myapp.data; 

import java.util.List;
import java.util.Optional;

public interface MediaRepository { 
    Optional<MediaStock> findStock(String title);
    void decrementStock(String title, String mediaType);
    void saveLoanRecord(String title, String mediaType, int days, boolean withInsurance, double cost);
    List<MediaStock> getInventory(); // Nuevo método para obtener todo el inventario
}