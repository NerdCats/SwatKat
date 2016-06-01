package co.gobd.tracker.utility.deserializer;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import co.gobd.tracker.model.job.Location;
import co.gobd.tracker.model.job.Point;

/**
 * Created by fahad on 5/16/16.
 */
public class LocationDeserializer {

    public static Location getLocation(JsonObject jsonObject) {

        String address = jsonObject.get("Address").getAsString();
        JsonObject jsonPoint = jsonObject.get("Point").getAsJsonObject();
        String type = jsonPoint.get("type").getAsString();
        JsonArray jsonCoord = jsonPoint.getAsJsonArray("coordinates");
        String[] coord = new String[2];
        for (int i = 0; i < jsonCoord.size(); i++) {
            coord[i] = jsonCoord.get(i).getAsString();
        }

        Point point = new Point(type, coord);

        Location location = new Location(point, address);

        return location;
    }
}
