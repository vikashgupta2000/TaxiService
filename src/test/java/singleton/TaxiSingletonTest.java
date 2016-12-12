package singleton;

import adapter.TaxiServiceAdapter;
import constants.Place;
import model.Taxi;
import org.junit.After;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class TaxiSingletonTest {

    @Test
    public void shouldReturnTheSameInstanceIfCalledMultipleTimes() {
        TaxiSingleton taxiSingleton1 = TaxiSingleton.getInstance();
        TaxiSingleton taxiSingleton2 = TaxiSingleton.getInstance();

        Assert.assertNotNull(taxiSingleton1);
        Assert.assertNotNull(taxiSingleton2);
        Assert.assertEquals(taxiSingleton1, taxiSingleton2);
    }

    @Test
    public void shouldReturnTheSameTaxiListOnceSaved() {
        Taxi taxi = new Taxi();
        TaxiSingleton taxiSingleton = TaxiSingleton.getInstance();
        taxiSingleton.addTaxiForPlace(Place.BANGALORE, taxi);

        Assert.assertNotNull(taxiSingleton.getTaxiPlaceMap());
        Assert.assertEquals(1, taxiSingleton.getTaxiPlaceMap().get(Place.BANGALORE).size());
        Assert.assertEquals(taxi, taxiSingleton.getTaxiPlaceMap().get(Place.BANGALORE).get(0));
    }

    @Test
    public void shouldReturnAllEmptyTaxisWithoutPinkRiderCondition() {
        init();
        List<Taxi> taxiList = TaxiSingleton.getInstance().getAllEmptyTaxi(Place.BANGALORE, false);

        Assert.assertNotNull(taxiList);
        Assert.assertEquals(2, taxiList.size());
    }

    @Test
    public void shouldReturnAllEmptyTaxisWithPinkRiderCondition() {
        init();
        List<Taxi> taxiList = TaxiSingleton.getInstance().getAllEmptyTaxi(Place.BANGALORE, true);

        Assert.assertNotNull(taxiList);
        Assert.assertEquals(1, taxiList.size());
    }

    @After
    public void reset() {
        TaxiSingleton.getInstance().setTaxiPlaceMap(new HashMap<Place, List<Taxi>>());
    }

    private void init() {
        List<Taxi> taxiList = new ArrayList<>();
        taxiList.add(new Taxi().setLatitude(100).setLongitude(500).setPink(true));
        taxiList.add(new Taxi().setLatitude(110).setLongitude(510));
        taxiList.add(new Taxi().setLatitude(200).setLongitude(600).setPink(true).setOccupied(true));
        taxiList.add(new Taxi().setLatitude(200).setLongitude(610).setOccupied(true));
        new TaxiServiceAdapter().processData(taxiList);
    }
}
