package adapter;

import constants.Place;
import handler.PlaceHandler;
import model.Customer;
import model.Taxi;
import service.serviceImpl.CustomerServiceImpl;
import singleton.TaxiSingleton;

import java.util.List;

public class TaxiServiceAdapter {

    public void processData(List<Taxi> taxiList) {
        putDataIntoSystem(taxiList);
    }

    public void displayData(Customer customer) {
        System.out.println(new CustomerServiceImpl().availTaxiToCustomer(customer));
    }

    private static void putDataIntoSystem(List<Taxi> taxiList) {
        for(Taxi taxi : taxiList) {
            Place place = PlaceHandler.getPlaceForLocation(taxi.getLatitude(), taxi.getLongitude());
            if(null != place) {
                TaxiSingleton.getInstance().addTaxiForPlace(place, taxi);
            }
        }
    }
}
