package co.gobd.tracker.model.job.order;

/**
 * Created by fahad on 10/25/16.
 */

public class BuyerInfo {

    private String Name;
    private String PhoneNumber;

    public BuyerInfo(String name, String phoneNumber) {
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
