package co.gobd.tracker.ui.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import javax.inject.Inject;

import co.gobd.tracker.R;
import co.gobd.tracker.application.GoAssetApplication;
import co.gobd.tracker.model.job.AssignedJob;
import co.gobd.tracker.service.job.JobCallback;
import co.gobd.tracker.service.job.JobService;
import co.gobd.tracker.ui.fragment.MapFragment;
import co.gobd.tracker.utility.Constant;
import co.gobd.tracker.utility.SessionManager;

public class JobActivity extends AppCompatActivity {

    private static final String FRAGMENET_TAG_MAP = "MAP_FRAGMENT";

    @Inject
    JobService jobService;

    @Inject
    SessionManager sessionManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_job);


        Bundle bundle = new Bundle();
        bundle.putDouble(Constant.Job.PICKUP_LAT, 23.7945337167046);
        bundle.putDouble(Constant.Job.PICKUP_LNG, 90.4143771529198);
        bundle.putString(Constant.Job.PICKUP_ADDRESS, "Pickup address");

        bundle.putDouble(Constant.Job.DELIVERY_LAT, 23.7943766467649);
        bundle.putDouble(Constant.Job.DELIVERY_LNG, 90.4011592268944);
        bundle.putString(Constant.Job.DELIVERY_ADDRESS, "Delivery address");


        MapFragment mapFragment = new MapFragment();
        mapFragment.setArguments(bundle);

        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.activity_job, mapFragment, FRAGMENET_TAG_MAP)
                .commit();


        ((GoAssetApplication) getApplication()).getComponent().inject(this);

        String bearer = sessionManager.getBearer();
        String assetId = sessionManager.getAssetId();
        jobService.getAssignedJobList(bearer, assetId, new JobCallback() {
            @Override
            public void onGetJobSuccess(AssignedJob assignedJob) {

            }

            @Override
            public void onGetJobFailure() {

            }

            @Override
            public void onConnectionError() {

            }
        });
    }

}
