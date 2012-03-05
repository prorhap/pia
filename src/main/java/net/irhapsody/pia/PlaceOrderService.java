package net.irhapsody.pia;

import java.util.Date;

/**
 * Created by IntelliJ IDEA.
 * User: rhapsody
 * Date: 2/27/12
 * Time: 11:16 PM
 * To change this template use File | Settings | File Templates.
 */
public interface PlaceOrderService {

    PlaceOrderServiceResult updateDeliveryInfo(String pendingOrderId, Address deliveryAddress, Date deleveryTime);
    PlaceOrderServiceResult updateRestaurant(String pendingOrderId, String restaurantId);
}
