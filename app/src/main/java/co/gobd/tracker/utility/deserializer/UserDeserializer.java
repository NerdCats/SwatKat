package co.gobd.tracker.utility.deserializer;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;

import java.lang.reflect.Type;

import co.gobd.tracker.model.job.User;

/**
 * Created by fahad on 5/17/16.
 */
public class UserDeserializer implements JsonDeserializer<User> {

    private User User;

    @Override
    public User deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context)
            throws JsonParseException {

        final JsonObject jsonObject = json.getAsJsonObject();

        String UserName = jsonObject.get("UserName").getAsString();
        String Id = jsonObject.get("Id").getAsString();
        String Type = jsonObject.get("Type").getAsString();
        String PhoneNumber = (jsonObject.get("PhoneNumber").isJsonNull()) ? null : jsonObject.get("PhoneNumber").getAsString() ;
        String Email = jsonObject.get("Email").getAsString();

        User = new User(UserName, Id, Type, PhoneNumber, Email);
        return User;
    }
}
