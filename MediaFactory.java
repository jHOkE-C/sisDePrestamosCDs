// Patrón Factory Method (fábricas concretas definen creación)
public abstract class MediaFactory {
    public abstract MediaItem createMedia(String title);
}