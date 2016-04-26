package co.gobd.tracker.service.job;

import android.util.Log;

import co.gobd.tracker.model.job.AssignedJob;
import co.gobd.tracker.network.JobApi;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by fahad on 4/25/16.
 */
public class JobServiceImpl implements JobService {

    private static final String TAG = JobServiceImpl.class.getSimpleName();
    private JobApi jobApi;

    public JobServiceImpl(JobApi jobApi) {

        this.jobApi = jobApi;
    }

    @Override
    public void getAssignedJobList(String bearer, String assetId, final JobCallback callback) {

        Call<AssignedJob> call = jobApi.getAssignedJobs(bearer, assetId);

        call.enqueue(new Callback<AssignedJob>() {
            @Override
            public void onResponse(Call<AssignedJob> call, Response<AssignedJob> response) {
                if(response.isSuccess()){
                    Log.i(TAG, response.body().toString());
                    callback.onGetJobSuccess(response.body());
                } else{
                    callback.onGetJobFailure();
                }
            }

            @Override
            public void onFailure(Call<AssignedJob> call, Throwable t) {
                callback.onConnectionError();
            }
        });

    }

}
