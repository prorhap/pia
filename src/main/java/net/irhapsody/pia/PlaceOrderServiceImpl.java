package net.irhapsody.pia;

import java.util.Date;


public class PlaceOrderServiceImpl implements PlaceOrderService {

    private PendingOrderRepository pendingOrderRepository;
    private RestaurantRepository repository;

    public PlaceOrderServiceImpl(RestaurantRepository repository, PendingOrderRepository pendingOrderRepository) {
        this.pendingOrderRepository = pendingOrderRepository;
        this.repository = repository;
    }

    public PlaceOrderServiceResult updateDeliveryInfo(String pendingOrderId, Address deliveryAddress, Date deleveryTime) {

        PendingOrder pendingOrder = pendingOrderRepository.findOrCreatePendingOrder(pendingOrderId);

        boolean success = pendingOrder.updateDeliveryOrder(deliveryAddress, deleveryTime);

        return new PlaceOrderServiceResult(success, pendingOrder);
    }

    public PlaceOrderServiceResult updateRestaurant(String pendingOrderId, String restaurantId) {
        return null;
    }


}
