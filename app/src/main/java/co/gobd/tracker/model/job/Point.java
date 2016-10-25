package co.gobd.tracker.model.job;

import java.util.Arrays;

/**
 * Created by fahad on 4/25/16.
 */
public class Point{

    private String type;
    private String[] coordinates = new String[2];

    public Point(String type, String[] coordinates) {
        this.type = type;
        this.coordinates = coordinates;
    }

    public String getType() {
        return type;
    }

    public String[] getCoordinates() {
        return coordinates;
    }

    public String getLongitude() {
        return coordinates[0];
    }

    public String getLatitude() {
        return coordinates[1];
    }

    @Override
    public String toString() {
        return "Point [type = " + type + ", coordinates = " + Arrays.toString(coordinates) + "]";
    }
}
