package co.gobd.tracker.utility.deserializer;

import com.google.gson.JsonArray;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;

import org.json.JSONObject;

import java.lang.reflect.Type;

import co.gobd.tracker.model.job.Location;
import co.gobd.tracker.model.job.Point;
import co.gobd.tracker.model.job.order.Order;
import co.gobd.tracker.model.job.order.OrderCart;

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
        String Description = (jsonObject.get("Description").isJsonNull()) ?
                null : jsonObject.get("Description").getAsString();
        String NoteToDeliveryMan = jsonObject.get("NoteToDeliveryMan").getAsString();
        OrderCart orderCart = context.deserialize(jsonObject.get("OrderCart").getAsJsonObject(), OrderCart.class);


        String Name = (jsonObject.get("Name").isJsonNull()) ? null : jsonObject.get("Name").getAsString();
        String Type = jsonObject.get("Type").getAsString();
        String PayloadType = jsonObject.get("PayloadType").getAsString();
        String UserId = jsonObject.get("UserId").getAsString();

        Location OrderLocation = (jsonObject.get("OrderLocation").isJsonNull()) ?
                null : getLocation(jsonObject.get("OrderLocation").getAsJsonObject());

        String ETA = (jsonObject.get("ETA").isJsonNull()) ?
                null : jsonObject.get("ETA").getAsString();


        Double ETAMinutes = (jsonObject.get("ETAMinutes").isJsonNull()) ?
                null : jsonObject.get("ETAMinutes").getAsDouble();

        Double RequiredChangeFor = (jsonObject.get("RequiredChangeFor").isJsonNull()) ?
                null : jsonObject.get("RequiredChangeFor").getAsDouble();

        String PaymentMethod = jsonObject.get("PaymentMethod").getAsString();

        order = new Order(From, To, Description, orderCart,
                NoteToDeliveryMan, Name, Type,
                PayloadType, UserId, OrderLocation,
                ETA, ETAMinutes, RequiredChangeFor, PaymentMethod);

        return order;
    }

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

            Location location = new Location(point, address, locality);

            return location;
        }

        Point point = new Point(type, null);
        Location location = new Location(point, address, locality);

        return location;


    }
}
