// Patrón Strategy: encapsula algoritmo de cálculo de precio
public interface PricingStrategy {
    double calculate(MediaItem item, int days);
}