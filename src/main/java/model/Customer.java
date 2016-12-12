package model;

public class Customer {
    private boolean isPinkPrefered;
    private long currentLatitude;
    private long currentLongitude;
    private long destinationLatitude;
    private long destinationLongitude;

    public Customer(boolean isPinkPrefered, long currentLatitude, long currentLongitude,
                    long destinationLatitude, long destinationLongitude) {

        this.isPinkPrefered = isPinkPrefered;
        this.currentLatitude = currentLatitude;
        this.currentLongitude = currentLongitude;
        this.destinationLatitude = destinationLatitude;
        this.destinationLongitude = destinationLongitude;
    }

    public boolean isPinkPrefered() {
        return isPinkPrefered;
    }

    public void setPinkPrefered(boolean pinkPrefered) {
        isPinkPrefered = pinkPrefered;
    }

    public long getCurrentLatitude() {
        return currentLatitude;
    }

    public void setCurrentLatitude(long currentLatitude) {
        this.currentLatitude = currentLatitude;
    }

    public long getCurrentLongitude() {
        return currentLongitude;
    }

    public void setCurrentLongitude(long currentLongitude) {
        this.currentLongitude = currentLongitude;
    }

    public long getDestinationLatitude() {
        return destinationLatitude;
    }

    public void setDestinationLatitude(long destinationLatitude) {
        this.destinationLatitude = destinationLatitude;
    }

    public long getDestinationLongitude() {
        return destinationLongitude;
    }

    public void setDestinationLongitude(long destinationLongitude) {
        this.destinationLongitude = destinationLongitude;
    }
}
