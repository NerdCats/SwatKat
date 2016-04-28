package co.gobd.tracker.ui.activity;

import android.app.ActivityManager;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.location.LocationManager;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import co.gobd.tracker.R;
import co.gobd.tracker.adapter.JobAdapter;
import co.gobd.tracker.application.GoAssetApplication;
import co.gobd.tracker.model.job.JobModel;
import co.gobd.tracker.service.job.JobService;
import co.gobd.tracker.ui.service.LocationService;
import co.gobd.tracker.ui.view.OnItemClickListener;
import co.gobd.tracker.utility.ServiceUtility;
import co.gobd.tracker.utility.SessionManager;

public class MainActivity extends AppCompatActivity{

    @Inject
    SessionManager sessionManager;

    @Inject
    JobService jobService;

    private static final String LOG_TAG = MainActivity.class.getSimpleName();

    ImageButton ibToggleStartStop;
    private List<JobModel> jobModelList = new ArrayList<>();
    private RecyclerView recyclerView;
    private JobAdapter jobAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ((GoAssetApplication) getApplication()).getComponent().inject(this);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        recyclerView = (RecyclerView) findViewById(R.id.rv_joblist);

        jobAdapter = new JobAdapter(jobModelList);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(jobAdapter);

        //jobAdapter.setOnItemClickListener((OnItemClickListener) this);


        if (ServiceUtility.checkGooglePlayServices(getApplicationContext(), this)) {
            checkLocationStatus();
        }

        TextView tvAssetName = (TextView) findViewById(R.id.tvAssetName);
        String assetName = sessionManager.getUsername();
        tvAssetName.setText("Logged in as "+assetName);

        ibToggleStartStop = (ImageButton) findViewById(R.id.ib_toggle_location);


        ibToggleStartStop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isLocationServiceRunning(LocationService.class)){
                    stopLocationService();
                    ibToggleStartStop.setImageResource(R.drawable.ic_play_circle_filled_green_24dp);
                }
                else{
                    startLocationService();
                    ibToggleStartStop.setImageResource(R.drawable.ic_pause_circle_filled_red_24dp);
                }

            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (isLocationServiceRunning(LocationService.class)){
            ibToggleStartStop.setImageResource(R.drawable.ic_pause_circle_filled_red_24dp);
        }
        else{
            ibToggleStartStop.setImageResource(R.drawable.ic_play_circle_filled_green_24dp);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    /**
     * Checks if GPS is enabled or not.
     */
    public void checkLocationStatus() {
        Log.i(LOG_TAG, "Checking GPS Status");
        LocationManager locationManager = (LocationManager) getSystemService(LOCATION_SERVICE);
        if (locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER)) {
            Toast.makeText(this, "Location is enabled", Toast.LENGTH_SHORT).show();
        } else {
            showGPSDisabledAlertToUser();
        }
    }

    /**
     * Alert Dialog to enable GPS
     */

    public void showGPSDisabledAlertToUser() {
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
        alertDialogBuilder.setMessage("Location is disabled in your device. Would you like to enable it?")
                .setCancelable(false)
                .setPositiveButton("Enable",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                Intent callGPSSettingIntent = new Intent(
                                        android.provider.Settings.ACTION_LOCATION_SOURCE_SETTINGS);
                                startActivity(callGPSSettingIntent);
                            }
                        });
        alertDialogBuilder.setNegativeButton("Cancel",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        //dialog.cancel();
                        MainActivity.this.finish();
                    }
                });
        AlertDialog alert = alertDialogBuilder.create();
        alert.show();
    }

    /**
     * Checks if the service is running or not
     *
     * @param serviceClass
     * @return
     */

    private boolean isLocationServiceRunning(Class<?> serviceClass) {
        ActivityManager manager = (ActivityManager) getSystemService(Context.ACTIVITY_SERVICE);
        for (ActivityManager.RunningServiceInfo service : manager.getRunningServices(Integer.MAX_VALUE)) {
            if (serviceClass.getName().equals(service.service.getClassName())) {
                return true;
            }
        }
        return false;
    }


    /**
     * Starts the location service that enables Google location update
     */
    public void startLocationService() {
        Intent intent = new Intent(this, LocationService.class);
        startService(intent);
    }

    public void stopLocationService() {
        Intent intent = new Intent(this, LocationService.class);
        stopService(intent);
    }

    public void onGetJobButtonClick(View view){
        Intent intent = new Intent(this, JobActivity.class);
        startActivity(intent);
        finish();
    }

    public void onSignOutButtonClick(View view){
        stopLocationService();
        sessionManager.clearAll();
        Intent intent = new Intent(this, LoginActivity.class);
        startActivity(intent);
        finish();
    }

}
