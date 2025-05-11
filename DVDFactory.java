public class DVDFactory extends MediaFactory {
    @Override
    public MediaItem createMedia(String title) {
        return new DVD(title);
    }
}