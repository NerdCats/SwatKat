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

import co.gobd.tracker.model.job.JobModel;
import co.gobd.tracker.model.job.Location;
import co.gobd.tracker.model.job.Point;
import co.gobd.tracker.model.job.User;
import co.gobd.tracker.model.job.order.Order;
import co.gobd.tracker.model.job.task.DeliveryTask;
import co.gobd.tracker.model.job.task.FetchDeliveryManTask;
import co.gobd.tracker.model.job.task.JobTask;
import co.gobd.tracker.model.job.task.JobTaskTypes;
import co.gobd.tracker.model.job.task.PackagePickupTask;
import co.gobd.tracker.utility.CheckJson;

/**
 * Created by fahad on 4/25/16.
 */
public class JobModelDeserializer implements JsonDeserializer<JobModel> {

    private JobModel jobModel;

    //FIXME Write unit test
    @Override
    public JobModel deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context)
            throws JsonParseException {

        List<JobTask> jobTaskList = new ArrayList<>();
        final JsonObject jsonObject = json.getAsJsonObject();

        String Name = jsonObject.get("Name").getAsString();
        String State = jsonObject.get("State").getAsString();
        Order Order = context.deserialize(jsonObject.get("Order"), Order.class);
        User User = context.deserialize(jsonObject.get("User"), User.class);

        final JsonArray tasks = jsonObject.getAsJsonArray("Tasks");
        for (int i = 0; i < tasks.size(); i++) {
            final JsonObject task = tasks.get(i).getAsJsonObject();
            final String type = task.get("Type").getAsString();

            String jobTaskStateString;
            String state;
            String id;
            Location location;
            switch (type) {
                case JobTaskTypes.FETCH_DELIVERYMAN:
                    jobTaskStateString = "FETCH_DELIVERYMAN";//task.get("JobTaskStateString").getAsString();
                    state = task.get("State").getAsString();
                    id = task.get("id").getAsString();
                    jobTaskList.add(new FetchDeliveryManTask(jobTaskStateString, state, id));
                    break;

                case JobTaskTypes.PACKAGE_PICKUP:
                    jobTaskStateString = "PACKAGE_PICKUP"; //task.get("JobTaskStateString").getAsString();
                    state = task.get("State").getAsString();
                    id = task.get("id").getAsString();
                    location = getLocation(task.getAsJsonObject("PickupLocation"));

                    jobTaskList.add(new PackagePickupTask(jobTaskStateString, state, location, id));
                    break;

                case JobTaskTypes.DELIVERY:
                    jobTaskStateString = "DELIVERY";//task.get("JobTaskStateString").getAsString();
                    state = task.get("State").getAsString();
                    id = task.get("id").getAsString();
                    location = getLocation(task.getAsJsonObject("To"));

                    jobTaskList.add(new DeliveryTask(jobTaskStateString, state, location, id));
                    break;

                default:

                    break;
            }

        }

        String PaymentMethod = jsonObject.get("PaymentMethod").getAsString();
        String PaymentStatus = jsonObject.get("PaymentStatus").getAsString();
        String HRID = jsonObject.get("HRID").getAsString();
        String Id = jsonObject.get("Id").getAsString();


        jobModel = new JobModel(Name, State, Order,
                User, jobTaskList,
                PaymentMethod, PaymentStatus,
                HRID, Id);

        return jobModel;

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