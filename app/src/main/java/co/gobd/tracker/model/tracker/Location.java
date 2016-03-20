package co.gobd.tracker.model.tracker;

/**
 * Created by tonmoy on 23-Feb-16.
 */
public class Location {
    private double lat;
    private double lon;

    public Location(double lat, double lon) {
        this.lat = lat;
        this.lon = lon;
    }

    @Override
    public String toString() {
        return "Location [lon = " + lon + ", lat = " + lat + "]";
    }
}