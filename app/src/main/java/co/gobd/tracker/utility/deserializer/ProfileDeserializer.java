package co.gobd.tracker.utility.deserializer;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;

import java.lang.reflect.Type;

import co.gobd.tracker.model.job.Profile;

/**
 * Created by fahad on 5/17/16.
 */
public class ProfileDeserializer implements JsonDeserializer<Profile> {

    Profile Profile;

    @Override
    public Profile deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {

        final JsonObject jsonObject = json.getAsJsonObject();

        String FirstName = jsonObject.get("FirstName").isJsonNull() ?
                null : jsonObject.get("FirstName").getAsString();
        String LastName = jsonObject.get("LastName").isJsonNull() ?
                null : jsonObject.get("LastName").getAsString();
        Integer Age = jsonObject.get("Age").isJsonNull() ?
                null : jsonObject.get("Age").getAsInt();
        String Gender = jsonObject.get("Gender").isJsonNull() ?
                null : jsonObject.get("Gender").getAsString();
        String InterestedLocalities = jsonObject.get("InterestedLocalities").isJsonNull() ?
                null : jsonObject.get("InterestedLocalities").getAsString();
        String Address = jsonObject.get("Address").isJsonNull() ?
                null : jsonObject.get("Address").getAsString();
        String PicUri = jsonObject.get("PicUri").isJsonNull() ?
                null : jsonObject.get("PicUri").getAsString();

        Profile = new Profile(FirstName, LastName, Age, Gender, InterestedLocalities, Address, PicUri);

        return Profile;
    }
}
