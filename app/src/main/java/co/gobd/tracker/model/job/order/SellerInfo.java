package co.gobd.tracker.model.job.order;

/**
 * Created by fahad on 10/25/16.
 */

public class SellerInfo {
    private String Name;
    private String PhoneNumber;
    //private Location Address;

    public SellerInfo(String name, String phoneNumber) {
        Name = name;
        PhoneNumber = phoneNumber;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getPhoneNumber() {
        return PhoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        PhoneNumber = phoneNumber;
    }
}
