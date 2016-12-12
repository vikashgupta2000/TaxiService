package constants;

/**
 * Assuming that the latitude and longitude of Bangalore is
 * between 100 - 200 latitude and 500 - 600 longitude
 */
public enum RangeLimit {
    BANGALORE(Place.BANGALORE, 100, 200, 500, 600);

    private RangeLimit(Place place, long minLatitude, long maxLatitude, long minLongitude, long maxLongitude) {
        this.place = place;
        this.minLatitude = minLatitude;
        this.maxLatitude = maxLatitude;
        this.minLongitude = minLongitude;
        this.maxLongitude = maxLongitude;
    }
    private Place place;
    private long minLatitude;
    private long maxLatitude;
    private long minLongitude;
    private long maxLongitude;

    public Place getPlace() { return this.place; }
    public long getMinLatitude() { return this.minLatitude; }
    public long getMaxLatitude() { return this.maxLatitude; }
    public long getMinLongitude() { return this.minLongitude; }
    public long getMaxLongitude() { return this.maxLongitude; }
}
