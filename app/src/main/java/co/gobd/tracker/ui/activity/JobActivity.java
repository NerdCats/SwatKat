package co.gobd.tracker.ui.activity;

import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import co.gobd.tracker.R;
import co.gobd.tracker.application.GoAssetApplication;
import co.gobd.tracker.model.job.JobModel;
import co.gobd.tracker.service.job.JobService;
import co.gobd.tracker.ui.fragment.MapFragment;
import co.gobd.tracker.ui.fragment.TaskFragment;
import co.gobd.tracker.utility.Constant;
import co.gobd.tracker.utility.ListParser.JobParser;
import co.gobd.tracker.utility.SessionManager;

public class JobActivity extends AppCompatActivity {

    private static final String FRAGMENET_TAG_MAP = "MAP_FRAGMENT";

    @Inject
    JobService jobService;

    @Inject
    Context context;

    @Inject
    SessionManager sessionManager;

    private Toolbar toolbar;
    private TabLayout tabLayout;
    private ViewPager viewPager;

    private MapFragment mapFragment;
    private TaskFragment taskFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_job);
        ((GoAssetApplication) getApplication()).getComponent().inject(this);

        Bundle bundleFrom = getIntent().getExtras();
        JobModel jobModel = bundleFrom.getParcelable("JobModel");

        JobParser jobParser = new JobParser(jobModel);
        String jobName = jobModel.getName();
        String[] pickupCoordinates = jobParser.getPickupLocation().getPoint().getCoordinates();
        String[] deliveryCoordinates = jobParser.getDeliveryLocation().getPoint().getCoordinates();

        /*String jobName = bundleFrom.getString(Constant.Job.JOB_NAME);
        String pickupAddress = bundleFrom.getString(Constant.Job.PICKUP_ADDRESS);
        String deliveryAddress = bundleFrom.getString(Constant.Job.DELIVERY_ADDRESS);
        Double pickupLat = bundleFrom.getDouble(Constant.Job.PICKUP_LAT);
        Double pickupLng = bundleFrom.getDouble(Constant.Job.PICKUP_LNG);
        Double deliveryLat = bundleFrom.getDouble(Constant.Job.DELIVERY_LAT);
        Double deliveryLng = bundleFrom.getDouble(Constant.Job.DELIVERY_LNG);*/

        // Fixme Replace this with getIntentData method
        Bundle bundle = new Bundle();
        bundle.putString(Constant.Job.JOB_NAME, jobName);
        bundle.putDouble(Constant.Job.PICKUP_LAT, Double.parseDouble(pickupCoordinates[1]));
        bundle.putDouble(Constant.Job.PICKUP_LNG, Double.parseDouble(pickupCoordinates[0]));
        bundle.putString(Constant.Job.PICKUP_ADDRESS, jobParser.getPickupLocation().getAddress());

        bundle.putDouble(Constant.Job.DELIVERY_LAT, Double.parseDouble(deliveryCoordinates[1]));
        bundle.putDouble(Constant.Job.DELIVERY_LNG, Double.parseDouble(deliveryCoordinates[0]));
        bundle.putString(Constant.Job.DELIVERY_ADDRESS, jobParser.getDeliveryLocation().getAddress());

        /*bundleTo.putDouble(Constant.Job.PICKUP_LAT, pickupLat);
        bundleTo.putDouble(Constant.Job.PICKUP_LNG, pickupLng);
        bundleTo.putString(Constant.Job.PICKUP_ADDRESS, "Pickup : "+pickupAddress);

        bundleTo.putDouble(Constant.Job.DELIVERY_LAT, deliveryLat);
        bundleTo.putDouble(Constant.Job.DELIVERY_LNG, deliveryLng);
        bundleTo.putString(Constant.Job.DELIVERY_ADDRESS, "Delivery : "+deliveryAddress);*/

        // Fragment initialization
        mapFragment = new MapFragment();
        mapFragment.setArguments(bundle);

        taskFragment = new TaskFragment();

        // Toolbar setup
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }

        // Viewpager setup
        viewPager = (ViewPager) findViewById(R.id.view_pager);
        setupViewPager(viewPager);

        // TabLayout setup
        tabLayout = (TabLayout) findViewById(R.id.tabs);
        if (tabLayout != null) {
            tabLayout.setupWithViewPager(viewPager);
        }

        // Dagger injection
        ((GoAssetApplication) getApplication()).getComponent().inject(this);

    }

    private void setupViewPager(ViewPager viewPager) {
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        adapter.addFragment(mapFragment, getString(R.string.tab_name_map));
        adapter.addFragment(taskFragment, getString(R.string.tab_name_task));
        viewPager.setAdapter(adapter);
    }

    private static class ViewPagerAdapter extends FragmentPagerAdapter {
        private final List<Fragment> mFragmentList = new ArrayList<>();
        private final List<String> mFragmentTitleList = new ArrayList<>();

        public ViewPagerAdapter(FragmentManager manager) {
            super(manager);
        }

        @Override
        public Fragment getItem(int position) {
            return mFragmentList.get(position);
        }

        @Override
        public int getCount() {
            return mFragmentList.size();
        }

        public void addFragment(Fragment fragment, String title) {
            mFragmentList.add(fragment);
            mFragmentTitleList.add(title);
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return mFragmentTitleList.get(position);
        }
    }

}