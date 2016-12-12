package util;

import model.Taxi;
import org.junit.Assert;
import org.junit.Test;

public class DistanceCalculatorTest {

    @Test
    public void shouldCalculateDistanceFromTaxi() {
        Taxi taxi = new Taxi().setLatitude(100).setLongitude(150);
        DistanceCalculator calculator = new DistanceCalculator();
        long distance = calculator.calculateDistanceFromTaxi(taxi, 96, 147);
        Assert.assertNotNull(distance);
        Assert.assertEquals(5, distance);
    }


}
