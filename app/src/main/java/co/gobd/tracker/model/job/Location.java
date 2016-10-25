package co.gobd.tracker.model.job;

/**
 * Created by fahad on 4/25/16.
 */
public class Location{

    private Point Point;
    private String Address;
    private String Locality;

    public Location(Point point, String address, String locality) {
        this.Point = point;
        Address = address;
        this.Locality = locality;
    }

    public co.gobd.tracker.model.job.Point getPoint() {
        return Point;
    }

    public void setPoint(co.gobd.tracker.model.job.Point point) {
        this.Point = point;
    }

    public String getAddress() {
        return Address;
    }

    public String getLocality(){
        return Locality;
    }

    public void setLocality(String locality){
        this.Locality = locality;
    }

    public void setAddress(String address) {
        Address = address;
    }

    @Override
    public String toString() {
        return "Location{" +
                "point=" + Point +
                ", Address='" + Address + '\'' +
                '}';
    }
}
