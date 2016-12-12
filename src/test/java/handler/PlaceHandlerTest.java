package handler;

import constants.Place;
import org.junit.Assert;
import org.junit.Test;

public class PlaceHandlerTest {

    @Test
    public void shouldReturnTheAppropriatePlaceForTheProvidedLocation() {
        Place place = PlaceHandler.getPlaceForLocation(200, 600);

        Assert.assertNotNull(place);
        Assert.assertEquals(Place.BANGALORE, place);
    }

    @Test
    public void shouldReturnNullIfServiceIsNotProvidedInTheLocation() {
        Place place = PlaceHandler.getPlaceForLocation(300, 700);

        Assert.assertNull(place);
    }
}
