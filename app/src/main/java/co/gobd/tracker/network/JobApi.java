package co.gobd.tracker.network;

import co.gobd.tracker.config.BackendUrl;
import co.gobd.tracker.model.job.AssignedJob;
import co.gobd.tracker.model.job.UpdateTaskState;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.PATCH;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by fahad on 4/25/16.
 */
public interface JobApi {

    @GET(BackendUrl.TaskCat.GET_ASSIGNED_JOBS)
    Call<AssignedJob>getAssignedJobsOdata(@Header("Authorization") String bearer,
                                           @Query("$filter") String jobStateUpto);
    Call<AssignedJob> getAssignedJobs(@Header("Authorization") String bearer,
                                      @Path("userId") String userId, @Query("jobStateUpto") String jobStateUpto);

    @PATCH(BackendUrl.TaskCat.PATCH_TASK_STATE)
    Call<Void> patchTaskState(@Header("Authorization") String bearer,@Header("Latitude") double lat,@Header("Longitude") double lon, @Path("jobId") String jobId,
                              @Path("taskId") String taskId,
                              @Body UpdateTaskState[] updateTaskState);
}
