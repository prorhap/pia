package net.irhapsody.pia;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.Calendar;
import java.util.Date;

import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class PendingOrderTest {

    @Mock
    private RestaurantRepository restaurantRepository;

    private PendingOrder pendingOrder;

    private Address goodDeliveryAddress;
    private Date goodDeliveryTime;

    @Before
    public void setUp() {
        pendingOrder = new PendingOrder();
        goodDeliveryAddress = RestaurantTestData.getADDRESS1();
        goodDeliveryTime = RestaurantTestData.makeGoodDeliveryTime();
    }

    @Test
    public void updateDeliveryOrderInfoGood() throws Exception {

        when( restaurantRepository.isRestaurantAvailable(goodDeliveryAddress, goodDeliveryTime) ).thenReturn(true);

        boolean result = pendingOrder.updateDeliveryInfo(restaurantRepository, goodDeliveryAddress, goodDeliveryTime);

        assertTrue(result);
        assertSame(goodDeliveryAddress, pendingOrder.getDeliveryAddress());
        assertSame(goodDeliveryTime, pendingOrder.getDeliveryTime());
    }
}
