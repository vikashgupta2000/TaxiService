package model;

public class Taxi {
    private boolean isOccupied;
    private boolean isPink;
    private long latitude;
    private long longitude;

    public boolean isOccupied() {
        return isOccupied;
    }

    public Taxi setOccupied(boolean occupied) {
        isOccupied = occupied;
        return this;
    }

    public long getLatitude() {
        return latitude;
    }

    public Taxi setLatitude(long latitude) {
        this.latitude = latitude;
        return this;
    }

    public long getLongitude() {
        return longitude;
    }

    public Taxi setLongitude(long longitude) {
        this.longitude = longitude;
        return this;
    }

    public boolean isPink() {
        return isPink;
    }

    public Taxi setPink(boolean pink) {
        isPink = pink;
        return this;
    }
}
