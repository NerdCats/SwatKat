package co.gobd.tracker.model.job;

/**
 * Created by fahad on 4/25/16.
 */
public class Location {

    private Point Point;
    private String Address;

    public Location(co.gobd.tracker.model.job.Point point, String address) {
        Point = point;
        Address = address;
    }

    public co.gobd.tracker.model.job.Point getPoint() {
        return Point;
    }

    public void setPoint(co.gobd.tracker.model.job.Point point) {
        Point = point;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }
}
