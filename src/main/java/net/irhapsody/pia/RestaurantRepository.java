package net.irhapsody.pia;


import java.util.Date;
import java.util.List;

public interface RestaurantRepository {

    public List findAvailableRestaurants(Address deliveryAddress, Date deliveryTime);
    public Restaurant findRestaurants(String restaurantId);

    public boolean isRestaurantAvailable(Address deliveryAddress, Date deliveryTime);
}
