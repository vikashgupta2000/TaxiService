package constants;

public enum Place {
    BANGALORE("BANGALORE");

    private String placeName;
    private Place(String placeName) {
        this.placeName = placeName;
    }

    public String getPlaceName() {
        return this.placeName;
    }
}
