package net.irhapsody.pia.temp;

/**
 * Created by IntelliJ IDEA.
 * User: rhapsody
 * Date: 3/6/12
 * Time: 12:31 AM
 * To change this template use File | Settings | File Templates.
 */
public class MyObject {

    public boolean isPropertySet() {
        String property = getProperty();
        boolean result = true;
        if (property.equals("some runtime property")) {
            result = false;
        }
        return result;
    }

    String getProperty() {
        return FancyFrameworkUtil.getProperty();
    }
}
