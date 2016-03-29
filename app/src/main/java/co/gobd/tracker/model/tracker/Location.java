package co.gobd.tracker.model.tracker;

import java.util.List;

/**
 * Created by tonmoy on 23-Feb-16.
 */
public class Location {

    private String type;
    private List<Double> coordinates;

    public Location(String type, List<Double> coordinates) {
        this.type = type;
        this.coordinates = coordinates;
    }
}