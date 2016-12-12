package service;

import adapter.TaxiServiceAdapter;
import constants.Place;
import constants.TaxiConstants;
import model.Customer;
import model.Taxi;
import org.junit.After;
import org.junit.Assert;
import org.junit.Test;
import service.serviceImpl.CustomerServiceImpl;
import singleton.TaxiSingleton;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class CustomerServiceImplTest {

    @Test
    public void shouldReturnNotFoundIfTaxiIsNotAvailable() {
        init();
        String result = new CustomerServiceImpl().availTaxiToCustomer(new Customer(false, 10, 20, 30, 40));

        Assert.assertNotNull(result);
        Assert.assertEquals(TaxiConstants.NOT_AVAILABLE, result);
    }

    @Test
    public void shouldReturnFairForThePinkCustomer() {
        init();
        String result = new CustomerServiceImpl().availTaxiToCustomer(new Customer(true, 100, 500, 104, 503));

        Assert.assertNotNull(result);
        Assert.assertEquals(String.format(TaxiConstants.FINAL_PRICE, 20), result);
    }

    @Test
    public void shouldReturnFairForOtherCustomer() {
        init();
        String result = new CustomerServiceImpl().availTaxiToCustomer(new Customer(false, 100, 500, 104, 503));

        Assert.assertNotNull(result);
        Assert.assertEquals(String.format(TaxiConstants.FINAL_PRICE, 10), result);
    }

    @After
    public void reset() {
        TaxiSingleton.getInstance().setTaxiPlaceMap(new HashMap<Place, List<Taxi>>());
    }

    private void init() {
        List<Taxi> taxiList = new ArrayList<>();
        taxiList.add(new Taxi().setLatitude(100).setLongitude(500).setPink(true));
        taxiList.add(new Taxi().setLatitude(120).setLongitude(520));
        taxiList.add(new Taxi().setLatitude(160).setLongitude(560).setPink(true));
        taxiList.add(new Taxi().setLatitude(200).setLongitude(600));
        new TaxiServiceAdapter().processData(taxiList);
    }
}
