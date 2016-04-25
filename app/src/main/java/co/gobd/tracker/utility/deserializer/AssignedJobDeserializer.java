package co.gobd.tracker.utility.deserializer;

import com.google.gson.JsonArray;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import co.gobd.tracker.model.job.AssignedJob;
import co.gobd.tracker.model.job.JobModel;

/**
 * Created by fahad on 4/25/16.
 */
public class AssignedJobDeserializer implements JsonDeserializer<AssignedJob> {

    @Override
    public AssignedJob deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {

        List<JobModel> jobModelList = new ArrayList<>();

        final JsonObject jsonObject = json.getAsJsonObject();
        final JsonArray data = jsonObject.getAsJsonArray("data");
    }
}