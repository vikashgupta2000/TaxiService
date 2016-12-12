package handler;

import constants.Place;
import constants.RangeLimit;

public class PlaceHandler {

    public static Place getPlaceForLocation(long latitude, long longitude) {
        for(RangeLimit rangeLimit : RangeLimit.values()) {
            if(inBetween(latitude, rangeLimit.getMinLatitude(), rangeLimit.getMaxLatitude())
                    && inBetween(longitude, rangeLimit.getMinLongitude(), rangeLimit.getMaxLongitude())) {
                return rangeLimit.getPlace();
            }
        }
        return null;
    }

    private static boolean inBetween(long value, long minPermissibleRange, long maxPermissibleRange) {
        return value>=minPermissibleRange && value<=maxPermissibleRange;
    }
}
