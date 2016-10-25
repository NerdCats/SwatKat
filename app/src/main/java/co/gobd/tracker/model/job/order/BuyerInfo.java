package co.gobd.tracker.model.job.order;

import co.gobd.tracker.model.job.Location;

/**
 * Created by fahad on 10/25/16.
 */

public class BuyerInfo {

    private String Name;
    private String PhoneNumer;
    private Location Address;

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getPhoneNumer() {
        return PhoneNumer;
    }

    public void setPhoneNumer(String phoneNumer) {
        PhoneNumer = phoneNumer;
    }

    public Location getAddress() {
        return Address;
    }

    public void setAddress(Location address) {
        Address = address;
    }
}
