public final class MediaSimpleFactory {

    // Evita instanciar la clase
    private MediaSimpleFactory() {}

    public static MediaItem create(String type, String title) {
        switch (type.toUpperCase()) {
            case "DVD":    return new DVD(title);
            case "BLURAY": return new BluRay(title);
            // si mañana añades otro formato…
            // case "UHD4K": return new Uhd4k(title);
            default:
                throw new IllegalArgumentException(
                        "Tipo de medio no soportado: " + type);
        }
    }
}
