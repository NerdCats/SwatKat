package co.gobd.tracker.utility.deserializer;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;

import java.lang.reflect.Type;

import co.gobd.tracker.model.job.Location;
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

        Location From = LocationDeserializer.getLocation(jsonObject.get("From").getAsJsonObject());
        Location To = LocationDeserializer.getLocation(jsonObject.get("To").getAsJsonObject());
        String PackageDescription = jsonObject.get("PackageDescription").getAsString();

        OrderCart orderCart = context.deserialize(jsonObject.get("OrderCart").getAsJsonObject(),OrderCart.class);

        String NoteToDeliveryMan = jsonObject.get("NoteToDeliveryMan").getAsString();
        String Name = jsonObject.get("Name").getAsString();
        String Type = jsonObject.get("Type").getAsString();
        String PayloadType = jsonObject.get("PayloadType").getAsString();
        String UserId = jsonObject.get("UserId").getAsString();
        Location OrderLocation = LocationDeserializer.getLocation(jsonObject.get("OrderLocation").getAsJsonObject());
        String ETA = jsonObject.get("ETA").getAsString();
        Double ETAMinutes = jsonObject.get("ETAMinutes").getAsDouble();
        String PaymentMethod = jsonObject.get("PaymentMethod").getAsString();

        order = new Order(From, To, PackageDescription, orderCart,
                NoteToDeliveryMan, Name, Type,
                PayloadType, UserId, OrderLocation,
                ETA, ETAMinutes, PaymentMethod);

        return order;
    }
}
