package co.gobd.tracker.service;

import android.content.Context;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import co.gobd.tracker.model.tracker.Location;
import co.gobd.tracker.model.tracker.TrackerLocation;
import co.gobd.tracker.network.RestClientPing;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


/**
 * Created by tonmoy on 23-Feb-16.
 */
public class TrackerService {

    public static void sendLocation(android.location.Location location, final Context context, String clientId) {

        double lat = location.getLatitude();
        double lng = location.getLongitude();
        List<Double> coordinates = new ArrayList<>();
        coordinates.add(lng);
        coordinates.add(lat);
        String userId = clientId;
        final String message = "Location updated";

        Location point = new Location("Point", coordinates);
        TrackerLocation trackerLocation = new TrackerLocation(point, userId);

        Call<Void> call = new RestClientPing().getTrackerApi().sendLocation(trackerLocation);
        call.enqueue(new Callback<Void>() {
            @Override
            public void onResponse(Call<Void> call, Response<Void> response) {
                if (response.isSuccess()) {
                    Toast.makeText(context, message, Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<Void> call, Throwable t) {

            }
        });
    }
}
