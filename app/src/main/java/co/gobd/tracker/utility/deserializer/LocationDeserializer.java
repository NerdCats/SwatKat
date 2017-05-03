package co.gobd.tracker.utility.deserializer;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import co.gobd.tracker.model.job.Location;
import co.gobd.tracker.model.job.Point;

/**
 * Created by fahad on 5/16/16.
 */
public class LocationDeserializer {

    public Location getLocation(JsonObject jsonObject) {

        String address = jsonObject.get("Address").getAsString();
        JsonObject jsonPoint = jsonObject.get("Point").getAsJsonObject();

        String type = jsonPoint.get("type").getAsString();
        String locality = (jsonObject.get("Locality").isJsonNull()) ?
                null : jsonObject.get("Locality").getAsString();

        JsonElement testObj = (jsonPoint.get("coordinates").isJsonNull()) ?
                null : jsonPoint.get("coordinates").getAsJsonArray();

        if(testObj != null) {
            JsonArray jsonCoord = jsonPoint.get("coordinates").getAsJsonArray();
            String[] coord = new String[2];
            for (int i = 0; i < jsonCoord.size(); i++) {
                coord[i] = jsonCoord.get(i).getAsString();
            }

            Point point = new Point(type, coord);

            Location location = new Location( address, locality);//Location location = new Location(point, address, locality); point is being removed

            return location;
        }

        Point point = new Point(type, null);
        Location location = new Location( address, locality);

        return location;


    }
}
