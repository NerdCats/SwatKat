package co.gobd.tracker.service.job;

import co.gobd.tracker.model.job.UpdateTaskState;

/**
 * Created by fahad on 4/25/16.
 */
public interface JobService {

    void getAssignedJobList(String bearer, String assetId, String jobStateUpto,
                            final JobCallback callback);

    void updateTaskState(String bearer, String jobId, String taskId, UpdateTaskState updateTaskState,
                         final PatchCallback callback);
}
