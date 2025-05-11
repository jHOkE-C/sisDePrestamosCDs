public class StandardPricingStrategy implements PricingStrategy {
    @Override
    public double calculate(MediaItem item, int days) {
        return item.getPricePerDay() * days;
    }
}