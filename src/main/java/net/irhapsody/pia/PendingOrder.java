package net.irhapsody.pia;

import java.util.Calendar;
import java.util.Date;

public class PendingOrder {
    
    private Address deliveryAddress;
    private Date deliveryTime;


    public boolean updateDeliveryInfo(RestaurantRepository restaurantRepository, Address deliveryAddress, Date deliveryTime) {
        
        if ( !validate(deliveryTime) ) return false;

        //TODO: do it !
//        restaurantRepository = null;
        
        if (restaurantRepository.isRestaurantAvailable(deliveryAddress, deliveryTime))    {

            this.deliveryAddress = deliveryAddress;
            this.deliveryTime = deliveryTime;
            return true;
        }

        return false;
    }
    
    private boolean validate(Date deliveryTime) {

        Calendar earliestDeliveryTime = Calendar.getInstance();
        earliestDeliveryTime.add(Calendar.HOUR, 1);

        if (deliveryTime.before(earliestDeliveryTime.getTime())) {
            return false;
        }
        
        return true;
    }

    public Address getDeliveryAddress() {
        return this.deliveryAddress;
    }

    public Date getDeliveryTime() {
        return this.deliveryTime;
    }
}
