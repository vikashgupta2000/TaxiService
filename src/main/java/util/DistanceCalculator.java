package util;

import model.Taxi;

public class DistanceCalculator {

    public static long calculateDistanceFromTaxi(Taxi taxi, long latitude, long longitude) {
        return calculate(taxi.getLatitude(), taxi.getLongitude(), latitude, longitude);
    }

    private static long calculate(long taxiLatitude, long taxiLongitude, long personLatitude, long personLongitude) {
        long latitude = Math.abs(taxiLatitude - personLatitude);
        long longitude = Math.abs(taxiLongitude - personLongitude);
        return (long) Math.sqrt(Math.pow(latitude, 2) + Math.pow(longitude, 2));
    }
}
