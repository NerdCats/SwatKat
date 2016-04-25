package co.gobd.tracker.ui.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import javax.inject.Inject;

import co.gobd.tracker.R;
import co.gobd.tracker.application.GoAssetApplication;
import co.gobd.tracker.model.job.AssignedJob;
import co.gobd.tracker.service.job.JobCallback;
import co.gobd.tracker.service.job.JobService;
import co.gobd.tracker.utility.SessionManager;

public class JobActivity extends AppCompatActivity {

    @Inject
    JobService jobService;

    @Inject
    SessionManager sessionManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_job);

        ((GoAssetApplication) getApplication()).getComponent().inject(this);

        String bearer = sessionManager.getBearer();
        String assetId = sessionManager.getAssetId();
        jobService.getAssignedJobList(bearer, assetId, new JobCallback() {
            @Override
            public void onConnectionError() {

            }

            @Override
            public void onGetJobSuccess(AssignedJob assignedJob) {

            }

            @Override
            public void onGetJobFailure() {

            }
        });
    }

}
