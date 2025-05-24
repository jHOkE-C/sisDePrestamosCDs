// MediaItem.java
// Patrón Creacional: Factory Method (definición de la interfaz de producto)
public abstract class MediaItem {
    protected String title;
    public MediaItem(String title) { this.title = title; }
    public String getTitle() { return title; }
    // Cada subtipo define su precio por día
    public abstract double getPricePerDay();
}