public class MemberPricingStrategy implements PricingStrategy {
    @Override
    public double calculate(MediaItem item, int days) {
        // 10% de descuento para socios
        return item.getPricePerDay() * days * 0.9;
    }
}