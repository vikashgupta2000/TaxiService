package service.serviceImpl;

import constants.Place;
import constants.TaxiConstants;
import handler.PlaceHandler;
import handler.PriceHandler;
import model.Customer;
import model.Taxi;
import org.apache.commons.collections4.CollectionUtils;
import service.CustomerService;
import singleton.TaxiSingleton;
import util.DistanceCalculator;

import java.util.List;

public class CustomerServiceImpl implements CustomerService {

    @Override
    public String availTaxiToCustomer(Customer customer) {
        long currentLatitude = customer.getCurrentLatitude();
        long currentLongitude = customer.getCurrentLongitude();
        Place place = PlaceHandler.getPlaceForLocation(currentLatitude, currentLongitude);
        if (null == place) {
            return TaxiConstants.NOT_AVAILABLE;
        }
        List<Taxi> taxiList = TaxiSingleton.getInstance().getAllEmptyTaxi(place, customer.isPinkPrefered());
        Taxi taxi = assignNearestTaxi(taxiList, currentLatitude, currentLongitude);
        setTaxiLocationToCurrentLocation(taxi, currentLatitude, currentLongitude);
        long amount = calculatePriceByDistanceTravelled(customer, taxi, place);
        return String.format(TaxiConstants.FINAL_PRICE, amount);
    }

    private Taxi assignNearestTaxi(List<Taxi> taxiList, long latitude, long longitude) {
        Taxi nearestTaxi = null;
        long nearestTaxiDistance = 1000000000l;
        if (CollectionUtils.isNotEmpty(taxiList)) {
            for (Taxi taxi : taxiList) {
                long distance = DistanceCalculator.calculateDistanceFromTaxi(taxi, latitude, longitude);
                if (distance < nearestTaxiDistance) {
                    nearestTaxi = taxi;
                    nearestTaxiDistance = distance;
                }
            }
        }
        return nearestTaxi;
    }

    private long calculatePriceByDistanceTravelled(Customer customer, Taxi taxi, Place place) {
        long distance = DistanceCalculator.calculateDistanceFromTaxi(taxi, customer.getDestinationLatitude(), customer.getDestinationLongitude());
        setTaxiLocationToCurrentLocation(taxi, customer.getDestinationLatitude(), customer.getDestinationLongitude());
        return Enum.valueOf(PriceHandler.class, place.getPlaceName()).calculatePrice(distance, customer.isPinkPrefered());
    }

    private Taxi setTaxiLocationToCurrentLocation(Taxi taxi, long latitude, long longitude) {
        taxi.setLatitude(latitude);
        taxi.setLongitude(longitude);
        return taxi;
    }


}
