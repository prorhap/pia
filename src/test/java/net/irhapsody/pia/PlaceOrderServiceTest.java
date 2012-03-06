package net.irhapsody.pia;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.Date;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class PlaceOrderServiceTest {

    @Mock
    private PlaceOrderService service;

    @Mock
    private RestaurantRepository restaurantRepository;

    @Mock
    private PendingOrderRepository pendingOrderRepository;

    @Mock
    private PendingOrder pendingOrder;
    
    private Restaurant restaurant;

    @Before
    public void setUp(){
        MockitoAnnotations.initMocks(service);
        service = new PlaceOrderServiceImpl(restaurantRepository, pendingOrderRepository);
    }

    @Test
    public void updateRestaurantGood() throws Exception {

        String restaurantId = "restaurantId";
        String pendingOrderId = "";

        when( restaurantRepository.findRestaurants(restaurantId)).thenReturn(restaurant);

        PlaceOrderServiceResult result = service.updateRestaurant(pendingOrderId, restaurantId);
    }

    @Test
    public void updateDeliveryInfoValid() throws Exception {
        String pendingOrderId = null;
        Address deliveryAddress = RestaurantTestData.getBAD_ADDRESS();
        Date deliveryTime = RestaurantTestData.makeGoodDeliveryTime();
        

        when( pendingOrderRepository.findOrCreatePendingOrder(pendingOrderId) ).thenReturn(pendingOrder);
        when( pendingOrder.updateDeliveryInfo(restaurantRepository, deliveryAddress, deliveryTime)).thenReturn(true);
        when( pendingOrder.getDeliveryAddress() ).thenReturn(deliveryAddress);
        when( pendingOrder.getDeliveryTime() ).thenReturn(deliveryTime);


        PlaceOrderServiceResult result = service.updateDeliveryInfo(pendingOrderId, deliveryAddress, deliveryTime);
        PendingOrder pendingOrder = result.getPendingOrder();

        assertTrue(result.isSuccess());
        assertEquals(deliveryAddress, pendingOrder.getDeliveryAddress());
        assertEquals(deliveryTime, pendingOrder.getDeliveryTime());
    }

}
