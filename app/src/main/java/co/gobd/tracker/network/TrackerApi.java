package co.gobd.tracker.network;


import co.gobd.tracker.config.ApiEndpoint;
import co.gobd.tracker.model.tracker.TrackerLocation;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;


/**
 * Created by tonmoy on 27-Dec-15.
 */
public interface TrackerApi {
    @POST(ApiEndpoint.PATH_TRACKER_LOCATION)
    Call<Void> sendLocation(@Body TrackerLocation trackerLocation);
}
