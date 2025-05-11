public class DVD extends MediaItem {
    public DVD(String title) { super(title); }
    @Override
    public double getPricePerDay() { return 1.5; }
}