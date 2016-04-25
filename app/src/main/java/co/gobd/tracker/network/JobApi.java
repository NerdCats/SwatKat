package co.gobd.tracker.network;

import co.gobd.tracker.config.BackendUrl;
import co.gobd.tracker.model.job.AssignedJob;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Path;

/**
 * Created by fahad on 4/25/16.
 */
public interface JobApi {

    @GET(BackendUrl.TaskCat.GET_ASSIGNED_JOBS)
    Call<AssignedJob> getAssignedJobs(@Header("Authorization") String bearer,
                                      @Path("userId") String userId);
}
