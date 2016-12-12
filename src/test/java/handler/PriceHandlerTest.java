package handler;

import org.junit.Assert;
import org.junit.Test;

public class PriceHandlerTest {

    @Test
    public void shouldCalculatePriceAsPerBangaloreWithoutPinkRide() {
        long amount = PriceHandler.BANGALORE.calculatePrice(100, false);

        Assert.assertNotNull(amount);
        Assert.assertEquals(200, amount);
    }

    @Test
    public void shouldCalculatePriceAsPerBangaloreWithPinkRide() {
        long amount = PriceHandler.BANGALORE.calculatePrice(100, true);

        Assert.assertNotNull(amount);
        Assert.assertEquals(210, amount);
    }
}
