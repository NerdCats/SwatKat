package co.gobd.tracker.utility.deserializer;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;

import java.lang.reflect.Type;

import co.gobd.tracker.model.job.order.SellerInfo;

/**
 * Created by fahad on 10/26/16.
 */

public class SellerInfoDeserializer implements JsonDeserializer<SellerInfo> {

    private SellerInfo sellerInfo;

    @Override
    public SellerInfo deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context)
            throws JsonParseException {
        final JsonObject jsonObject = json.getAsJsonObject();

        String Name = jsonObject.get("Name").getAsString();
        String PhoneNumber = (jsonObject.get("PhoneNumber").isJsonNull()) ? null : jsonObject.get("PhoneNumber").getAsString() ;

        sellerInfo = new SellerInfo(Name, PhoneNumber);

        return sellerInfo;
    }
}
