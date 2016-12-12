package adapter;

import constants.Place;
import junit.framework.Assert;
import model.Taxi;
import org.junit.After;
import org.junit.Test;
import singleton.TaxiSingleton;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class TaxiServiceAdapterTest {

    @Test
    public void shouldPutOnlyTaxiThatOnlyBelongToBangaloreRange() {
        List<Taxi> taxiList = new ArrayList<>();
        taxiList.add(new Taxi().setLatitude(100).setLongitude(500));
        taxiList.add(new Taxi().setLatitude(110).setLongitude(510));
        taxiList.add(new Taxi().setLatitude(200).setLongitude(600));
        taxiList.add(new Taxi().setLatitude(200).setLongitude(610));
        new TaxiServiceAdapter().processData(taxiList);

        Assert.assertNotNull(TaxiSingleton.getInstance().getTaxiPlaceMap());
        Assert.assertEquals(1, TaxiSingleton.getInstance().getTaxiPlaceMap().size());
        Assert.assertTrue(TaxiSingleton.getInstance().getTaxiPlaceMap().containsKey(Place.BANGALORE));
        Assert.assertNotNull(TaxiSingleton.getInstance().getTaxiPlaceMap().get(Place.BANGALORE));
        Assert.assertEquals(3, TaxiSingleton.getInstance().getTaxiPlaceMap().get(Place.BANGALORE).size());
    }

    @Test
    public void shouldNotPutAnyTaxiOutsideBangaloreRange() {
        List<Taxi> taxiList = new ArrayList<>();
        taxiList.add(new Taxi().setLatitude(300).setLongitude(700));
        taxiList.add(new Taxi().setLatitude(400).setLongitude(800));
        taxiList.add(new Taxi().setLatitude(500).setLongitude(900));
        new TaxiServiceAdapter().processData(taxiList);

        Assert.assertNotNull(TaxiSingleton.getInstance().getTaxiPlaceMap());
        Assert.assertEquals(0, TaxiSingleton.getInstance().getTaxiPlaceMap().size());
        Assert.assertFalse(TaxiSingleton.getInstance().getTaxiPlaceMap().containsKey(Place.BANGALORE));
        Assert.assertNull(TaxiSingleton.getInstance().getTaxiPlaceMap().get(Place.BANGALORE));
    }

    @After
    public void reset() {
        TaxiSingleton.getInstance().setTaxiPlaceMap(new HashMap<Place, List<Taxi>>());
    }
}
