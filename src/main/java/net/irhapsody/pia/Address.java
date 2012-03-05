package net.irhapsody.pia;

/**
 * Created by IntelliJ IDEA.
 * User: rhapsody
 * Date: 2/27/12
 * Time: 11:20 PM
 * To change this template use File | Settings | File Templates.
 */
public class Address {

    private String address1;
    private Object address2;
    private String city;
    private String state;
    private String zip;


    public Address(String address1, Object address2, String city, String state, String zip) {
        this.address1 = address1;
        this.address2 = address2;
        this.city = city;
        this.state = state;
        this.zip = zip;

    }
}
