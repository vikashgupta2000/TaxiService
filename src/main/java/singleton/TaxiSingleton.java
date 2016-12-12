package singleton;

import constants.Place;
import model.Taxi;
import org.apache.commons.collections4.CollectionUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class TaxiSingleton {
    private static TaxiSingleton taxiSingleton;
    private TaxiSingleton() {
        this.taxiPlaceMap = new HashMap<>();
    }

    private Map<Place, List<Taxi>> taxiPlaceMap;

    public static TaxiSingleton getInstance() {
        if(null == taxiSingleton) {
            synchronized (TaxiSingleton.class) {
                if(null == taxiSingleton) {
                    taxiSingleton = new TaxiSingleton();
                }
            }
        }
        return taxiSingleton;
    }

    public Map<Place, List<Taxi>> getTaxiPlaceMap() {
        return taxiPlaceMap;
    }

    public void setTaxiPlaceMap(Map<Place, List<Taxi>> taxiPlaceMap) {
        this.taxiPlaceMap = taxiPlaceMap;
    }

    public void addTaxiForPlace(Place place, Taxi taxi) {
        if(taxiPlaceMap.containsKey(place)) {
            taxiPlaceMap.get(place).add(taxi);
        } else {
            taxiPlaceMap.put(place, new ArrayList<Taxi>() {{add(taxi);}});
        }
    }

    public List<Taxi> getAllEmptyTaxi(Place place, boolean isPinkRequired) {
        List<Taxi> taxiList = taxiPlaceMap.get(place);
        if(CollectionUtils.isNotEmpty(taxiList)) {
            return taxiList.stream()
                    .filter(taxi -> !taxi.isOccupied())
                    .filter(taxi -> isPinkRequired ? taxi.isPink() : true)
                    .collect(Collectors.toList());
        }
        return null;
    }
}
