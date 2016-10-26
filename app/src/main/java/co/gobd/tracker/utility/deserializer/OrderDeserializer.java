package co.gobd.tracker.utility.deserializer;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;

import java.lang.reflect.Type;

import co.gobd.tracker.model.job.Location;
import co.gobd.tracker.model.job.Point;
import co.gobd.tracker.model.job.order.Order;
import co.gobd.tracker.model.job.order.OrderCart;
import co.gobd.tracker.utility.CheckJson;

/**
 * Created by fahad on 5/16/16.
 */
public class OrderDeserializer implements JsonDeserializer<Order> {

    private Order order;

    @Override
    public Order deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {

        final JsonObject jsonObject = json.getAsJsonObject();

        Location From = getLocation(jsonObject.get("From").getAsJsonObject());
        Location To = getLocation(jsonObject.get("To").getAsJsonObject());

        boolean desExists = CheckJson.checkJsonKey(jsonObject, "Description");

        String Description = null;
        if(desExists) {
            Description = (jsonObject.get("Description").isJsonNull()) ?
                    null : jsonObject.get("Description").getAsString();
        }

        boolean noteExists = CheckJson.checkJsonKey(jsonObject, "NoteToDeliveryMan");

        String NoteToDeliveryMan = null;

        if(noteExists){
           NoteToDeliveryMan = (jsonObject.get("NoteToDeliveryMan").isJsonNull()) ?
                    null : jsonObject.get("NoteToDeliveryMan").getAsString();
        }

        OrderCart orderCart = context.deserialize(jsonObject.get("OrderCart").getAsJsonObject(), OrderCart.class);
        String Type = jsonObject.get("Type").getAsString();
        String Variant = jsonObject.get("Variant").getAsString();
        String UserId = jsonObject.get("UserId").getAsString();

        Double RequiredChangeFor = (jsonObject.get("RequiredChangeFor").isJsonNull()) ?
                null : jsonObject.get("RequiredChangeFor").getAsDouble();

        String PaymentMethod = jsonObject.get("PaymentMethod").getAsString();

        order = new Order(From, To, Description, orderCart,
                NoteToDeliveryMan, Type, Variant, UserId,
                RequiredChangeFor, PaymentMethod);

        return order;
    }

    public Location getLocation(JsonObject jsonObject) {

        String address = jsonObject.get("Address").getAsString();
        JsonObject jsonPoint = jsonObject.get("Point").getAsJsonObject();

        String type = jsonPoint.get("type").getAsString();

        String locality = null;
        boolean locExists = CheckJson.checkJsonKey(jsonObject, "Locality");

        if(locExists) {
            locality = (jsonObject.get("Locality").isJsonNull()) ?
                    null : jsonObject.get("Locality").getAsString();
        }
        /*JsonElement testObj = (jsonPoint.get("coordinates").isJsonNull()) ?
                null : jsonPoint.get("coordinates").getAsJsonArray();

        if(testObj != null) {
            JsonArray jsonCoord = jsonPoint.get("coordinates").getAsJsonArray();
            String[] coord = new String[2];
            for (int i = 0; i < jsonCoord.size(); i++) {
                coord[i] = jsonCoord.get(i).getAsString();
            }

            Point point = new Point(type, coord);

            Location location = new Location(point, address, locality);

            return location;
        }*/

        Point point = new Point(type, null);
        Location location = new Location(point, address, locality);

        return location;


    }
}
