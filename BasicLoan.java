// Implementación básica de préstamo usando una estrategia
public class BasicLoan implements ILoan {
    private MediaItem item;
    private int days;
    private PricingStrategy strategy;
    public BasicLoan(MediaItem item, int days, PricingStrategy strategy) {
        this.item = item;
        this.days = days;
        this.strategy = strategy;
    }
    @Override
    public double calculateCost() {
        return strategy.calculate(item, days);
    }
}