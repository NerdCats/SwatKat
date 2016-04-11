package co.gobd.tracker.service;

import java.util.ArrayList;
import java.util.List;

import co.gobd.tracker.callback.LocationCallback;
import co.gobd.tracker.model.tracker.Location;
import co.gobd.tracker.model.tracker.TrackerLocation;
import co.gobd.tracker.network.TrackerApi;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;


/**
 * Created by tonmoy on 23-Feb-16.
 */
public class TrackerServiceImpl implements TrackerService {

    private Retrofit retrofit;

    // Constructed by Dagger
    public TrackerServiceImpl(Retrofit retrofit) {
        this.retrofit = retrofit;
    }

    @Override
    public void sendLocation(double latitude, double longitude, String assetId, final LocationCallback callback) {

        // Creates the POJO
        TrackerLocation trackerLocation = this.createLocationModel(latitude, longitude, assetId);

        // trackerLocation is sent as request Body
        Call<Void> call = retrofit.create(TrackerApi.class).ping(trackerLocation);

        call.enqueue(new Callback<Void>() {
            @Override
            public void onResponse(Call<Void> call, Response<Void> response) {
                if (response.isSuccess()) {
                    callback.onLocationSendSuccess();
                } else {
                    callback.onLocationSendFailure();
                }
            }

            @Override
            public void onFailure(Call<Void> call, Throwable t) {

            }
        });
    }


    // TODO Create unit test
    private TrackerLocation createLocationModel(double lat, double lng, String assetId) {

        List<Double> coordinates = new ArrayList<>();
        coordinates.add(lng);
        coordinates.add(lat);
        Location point = new Location("Point", coordinates);

        return new TrackerLocation(point, assetId);

    }
}
