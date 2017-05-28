package co.gobd.tracker.model.tracker;

import io.realm.RealmObject;

/**
 * Created by Mr. Maps on 5/23/2017.
 */

public class LocationModel {
    private double lat;
    private  double lon;

    public double getLat() {
        return lat;
    }

    public LocationModel(double lat, double lon) {
        this.lat = lat;
        this.lon = lon;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    public double getLon() {
        return lon;
    }

    public void setLon(double lon) {
        this.lon = lon;
    }
}
