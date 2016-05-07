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
import android.widget.Toast;

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

        Bundle bundleOne = getIntent().getExtras();

        JobModel jobModel = bundleOne.getParcelable("jobModel");
        JobParser jobParser = new JobParser(jobModel);

        //Toast.makeText(context, jobModel.getName(), Toast.LENGTH_SHORT).show();

        String[] pickupCoordinates = jobParser.getPickupLocation().getPoint().getCoordinates();
        String[] deliveryCoordinats = jobParser.getPickupLocation().getPoint().getCoordinates();

        // Fixme Replace this with getIntentData method
        //Bundle bundle = new Bundle();
        //bundle.putDouble(Constant.Job.PICKUP_LAT, 23.7945337167046);
        //bundle.putDouble(Constant.Job.PICKUP_LNG, 90.4143771529198);
        //bundle.putString(Constant.Job.PICKUP_ADDRESS, "Pickup address");

        //bundle.putDouble(Constant.Job.DELIVERY_LAT, 23.7943766467649);
        //bundle.putDouble(Constant.Job.DELIVERY_LNG, 90.4011592268944);
        //bundle.putString(Constant.Job.DELIVERY_ADDRESS, "Delivery address");

        bundleOne.putDouble(Constant.Job.PICKUP_LAT, Double.parseDouble(pickupCoordinates[1]));
        bundleOne.putDouble(Constant.Job.PICKUP_LNG, Double.parseDouble(pickupCoordinates[0]));
        bundleOne.putString(Constant.Job.PICKUP_ADDRESS, jobParser.getPickupLocation().getAddress());

        bundleOne.putDouble(Constant.Job.DELIVERY_LAT, Double.parseDouble(deliveryCoordinats[1]));
        bundleOne.putDouble(Constant.Job.DELIVERY_LNG, Double.parseDouble(deliveryCoordinats[0]));
        bundleOne.putString(Constant.Job.DELIVERY_ADDRESS, jobParser.getPickupLocation().getAddress());

        // Fragment initialization
        mapFragment = new MapFragment();
        mapFragment.setArguments(bundleOne);

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