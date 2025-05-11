public class BluRayFactory extends MediaFactory {
    @Override
    public MediaItem createMedia(String title) {
        return new BluRay(title);
    }
}