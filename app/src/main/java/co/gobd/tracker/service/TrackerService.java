package co.gobd.tracker.service;

import android.content.Context;
import android.widget.Toast;

import co.gobd.tracker.model.tracker.Location;
import co.gobd.tracker.model.tracker.TrackerLocation;
import co.gobd.tracker.network.RestClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


/**
 * Created by tonmoy on 23-Feb-16.
 */
public class TrackerService {

    public static void sendLocation(android.location.Location location, final Context context) {

        double lat = location.getLatitude();
        double lng = location.getLongitude();

        String name = "GO-FETCH-ASSET";
        String userId = "ASS001";
        final String message = "Location updated";

        Location locationModel = new Location(lat, lng);
        TrackerLocation trackerLocation = new TrackerLocation(locationModel, name, userId);

        Call<Void> call = new RestClient().getTrackerApi().sendLocation(trackerLocation);
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
