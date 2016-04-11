package co.gobd.tracker.network;


import co.gobd.tracker.config.BackendUrl;
import co.gobd.tracker.model.tracker.TrackerLocation;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;


/**
 * Created by tonmoy on 27-Dec-15.
 */
public interface TrackerApi {
    @POST(BackendUrl.ShadowCat.PING)
    Call<Void> ping(@Body TrackerLocation trackerLocation);
}
