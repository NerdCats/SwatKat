package co.gobd.tracker.service.job;

import android.util.Log;

import co.gobd.tracker.model.job.AssignedJob;
import co.gobd.tracker.model.job.UpdateTaskState;
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
    public void getAssignedJobList(String bearer, String assetId, String jobStateUpto, final JobCallback callback) {

        String appended="(Tasks/any(task: task/State eq 'IN_PROGRESS' and Task/Type eq 'PackagePickUp' and task/AssetRef eq '"+assetId+"'))&pageSize=50&page=0&sortDirection=Desc";
       // Call<AssignedJob> call = jobApi.getAssignedJobs(bearer, assetId, appended);
        Call<AssignedJob> call = jobApi.getAssignedJobsOdata(bearer, appended);
        call.enqueue(new Callback<AssignedJob>() {
            @Override
            public void onResponse(Call<AssignedJob> call, Response<AssignedJob> response) {
                if (response.isSuccess()) {
                    Log.i(TAG, response.body().toString());
                    callback.onGetJobSuccess(response.body());
                } else {
                    callback.onGetJobFailure();
                }
            }

            @Override
            public void onFailure(Call<AssignedJob> call, Throwable t) {
                Log.getStackTraceString(t);
                callback.onConnectionError();
            }
        });

    }

    @Override
    public void updateTaskState(String bearer, String jobId, String taskId, UpdateTaskState[] updateTaskState,
                                final PatchCallback callback) {

        Call<Void> call = jobApi.patchTaskState(bearer, jobId, taskId, updateTaskState);

        call.enqueue(new Callback<Void>() {
            @Override
            public void onResponse(Call<Void> call, Response<Void> response) {
                if (response.isSuccess()){
                    callback.onPatchSuccess();
                } else {
                    callback.onPatchFailure();
                }
            }

            @Override
            public void onFailure(Call<Void> call, Throwable t) {
                callback.onConnectionError();
            }
        });

    }


}