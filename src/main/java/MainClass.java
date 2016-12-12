import adapter.TaxiServiceAdapter;
import model.Customer;
import model.Taxi;

import java.util.ArrayList;
import java.util.List;

public class MainClass {

    public static void main(String[] args) {
        TaxiServiceAdapter adapter = new TaxiServiceAdapter();
        adapter.processData(initializeTaxiServiceForBangalore());
        adapter.displayData(new Customer(false, 105, 500, 180, 540));
        adapter.displayData(new Customer(false, 115, 560, 200, 540));
    }

    /**
     * This is just a temporary way of initializing taxi during start-up.
     * Ideally should read data from file and create this initialization.
     *
     * My solution is based on few assumptions :
     * Bangalore Latitude range 100 - 200
     * Bangalore Longitude range 500 - 600
     */
    private static List<Taxi> initializeTaxiServiceForBangalore() {
        List<Taxi> taxiList = new ArrayList<>();
        taxiList.add(new Taxi().setLatitude(100).setLongitude(500).setPink(true));
        taxiList.add(new Taxi().setLatitude(110).setLongitude(510));
        taxiList.add(new Taxi().setLatitude(120).setLongitude(520));
        taxiList.add(new Taxi().setLatitude(130).setLongitude(530));
        taxiList.add(new Taxi().setLatitude(140).setLongitude(540).setPink(true));
        taxiList.add(new Taxi().setLatitude(150).setLongitude(550));
        taxiList.add(new Taxi().setLatitude(160).setLongitude(560));
        taxiList.add(new Taxi().setLatitude(170).setLongitude(570).setPink(true));
        taxiList.add(new Taxi().setLatitude(180).setLongitude(580));
        taxiList.add(new Taxi().setLatitude(190).setLongitude(590));
        taxiList.add(new Taxi().setLatitude(200).setLongitude(600).setPink(true));
        return taxiList;
    }

}
