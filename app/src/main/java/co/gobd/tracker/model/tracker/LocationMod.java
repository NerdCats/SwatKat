package co.gobd.tracker.model.tracker;

import java.util.List;

import io.realm.RealmObject;
import io.realm.annotations.Index;
import io.realm.annotations.Required;

public class LocationMod extends RealmObject{
    @Index
    private String lat;
    @Index
    private  String lon;

    public LocationMod() {
    }

    public String getLat() {
        return lat;
    }

    public LocationMod(String lat, String lon) {
        this.lat = lat;
        this.lon = lon;
    }

    public void setLat(String lat) {
        this.lat = lat;
    }

    public String getLon() {
        return lon;
    }

    public void setLon(String lon) {
        this.lon = lon;
    }
}
