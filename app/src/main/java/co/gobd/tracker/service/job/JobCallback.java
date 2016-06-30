package co.gobd.tracker.service.job;

import co.gobd.tracker.callback.ConnectionCallback;
import co.gobd.tracker.model.job.AssignedJob;

/**
 * Created by fahad on 4/25/16.
 */
public interface JobCallback extends ConnectionCallback {
    void onGetJobSuccess(AssignedJob assignedJob);

    void onGetJobFailure();
}
