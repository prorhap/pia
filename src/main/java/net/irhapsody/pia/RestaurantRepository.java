package net.irhapsody.pia;


import java.util.Date;
import java.util.List;

public interface RestaurantRepository {

    List findAvailableRestaurants(Address deliveryAddress, Date deliveryTime);
    Restaurant findRestaurants(String restaurantId);

}
