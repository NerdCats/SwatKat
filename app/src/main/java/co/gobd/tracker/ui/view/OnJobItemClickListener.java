package co.gobd.tracker.ui.view;

import android.view.View;

import co.gobd.tracker.model.job.JobModel;

/**
 * Created by fahad on 4/28/16.
 */
public interface OnJobItemClickListener {
    void onItemClick(View view, int position, JobModel jobModel);
}
