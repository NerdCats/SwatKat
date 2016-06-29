package co.gobd.tracker.ui.activity;

import android.app.ActivityManager;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Configuration;
import android.location.LocationManager;
import android.os.Bundle;
import android.provider.Settings;
import android.support.annotation.Nullable;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
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
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;
import butterknife.BindView;
import butterknife.ButterKnife;
import co.gobd.tracker.R;
import co.gobd.tracker.adapter.JobAdapter;
import co.gobd.tracker.application.GoAssetApplication;
import co.gobd.tracker.model.job.JobModel;
import co.gobd.tracker.service.job.JobService;
import co.gobd.tracker.ui.service.LocationService;
import co.gobd.tracker.ui.view.OnJobItemClickListener;
import co.gobd.tracker.utility.SessionManager;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;

public class MainActivity extends AppCompatActivity implements OnJobItemClickListener {

  private static final String LOG_TAG = MainActivity.class.getSimpleName();
  @Inject SessionManager sessionManager;
  @Inject JobService jobService;
  @Inject Context context;

  @BindView(R.id.toolbar) Toolbar toolbar;
  @BindView(R.id.drawer_layout) DrawerLayout drawerLayout;

  private ImageButton ibToggleStartStop;
  private Button btnMap;

  private List<JobModel> jobModelList = new ArrayList<>();
  private RecyclerView recyclerView;
  private JobAdapter jobAdapter;


  private NavigationView nvDrawer;
  private ActionBarDrawerToggle drawerToggle;

  @Override protected void onCreate(Bundle savedInstanceState) {

    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    ButterKnife.bind(this);
    ((GoAssetApplication) getApplication()).getComponent().inject(this);

    // Toolbar setup
    setSupportActionBar(toolbar);
    if (getSupportActionBar() != null) {
      getSupportActionBar().setDisplayShowHomeEnabled(true);
      getSupportActionBar().setDisplayHomeAsUpEnabled(false);
    }

    drawerToggle = setupDrawerToggle();
    nvDrawer = (NavigationView) findViewById(R.id.navigation_view);

    // Tie DrawerLayout events to the ActionBarToggle
    drawerLayout.addDrawerListener(drawerToggle);

    String assetId = sessionManager.getAssetId();
    String bearer = sessionManager.getBearer();

    recyclerView = (RecyclerView) findViewById(R.id.rv_joblist);

    jobAdapter = new JobAdapter(context, jobService, bearer, assetId);
    RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
    recyclerView.setLayoutManager(layoutManager);
    recyclerView.setItemAnimator(new DefaultItemAnimator());
    recyclerView.setAdapter(jobAdapter);

    jobAdapter.setOnJobItemClickListener(this);
    String assetName = sessionManager.getUsername();

    View headerLayout = nvDrawer.getHeaderView(0);
    TextView tvAssetName = (TextView) headerLayout.findViewById(R.id.nav_header_asset_name);
    tvAssetName.setText(assetName);

    ibToggleStartStop = (ImageButton) findViewById(R.id.ib_toggle_location);

    ibToggleStartStop.setOnClickListener(new View.OnClickListener() {
      @Override public void onClick(View v) {
        if (isLocationServiceRunning(LocationService.class)) {
          stopLocationService();
          ibToggleStartStop.setImageResource(R.drawable.ic_play_circle_filled_green_24dp);
        } else {
          startLocationService();
          ibToggleStartStop.setImageResource(R.drawable.ic_pause_circle_filled_red_24dp);
        }
      }
    });
  }

  private ActionBarDrawerToggle setupDrawerToggle() {
    return new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.drawer_open,
        R.string.drawer_close);
  }

  @Override protected void onResume() {
    super.onResume();
    checkLocationStatus();
    if (isLocationServiceRunning(LocationService.class)) {
      ibToggleStartStop.setImageResource(R.drawable.ic_pause_circle_filled_red_24dp);
    } else {
      ibToggleStartStop.setImageResource(R.drawable.ic_play_circle_filled_green_24dp);
    }
  }

  @Override public boolean onCreateOptionsMenu(Menu menu) {
    // Inflate the menu; this adds items to the action bar if it is present.
    getMenuInflater().inflate(R.menu.menu_main, menu);
    return true;
  }

  @Override protected void onPostCreate(@Nullable Bundle savedInstanceState) {
    super.onPostCreate(savedInstanceState);
    // Sync the toggle state after onRestoreInstanceState has occurred.
    drawerToggle.syncState();
  }

  @Override public void onConfigurationChanged(Configuration newConfig) {
    super.onConfigurationChanged(newConfig);
    // Pass any configuration change to the drawer toggles
    drawerToggle.onConfigurationChanged(newConfig);
  }

  @Override public boolean onOptionsItemSelected(MenuItem item) {
    // Handle action bar item clicks here. The action bar will
    // automatically handle clicks on the Home/Up button, so long
    // as you specify a parent activity in AndroidManifest.xml.
    if (drawerToggle.onOptionsItemSelected(item)) {
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
    alertDialogBuilder.setMessage(
        "Location is disabled in your device. Would you like to enable it?")
        .setCancelable(false)
        .setPositiveButton("Enable", new DialogInterface.OnClickListener() {
          public void onClick(DialogInterface dialog, int id) {
            Intent callGPSSettingIntent = new Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS);
            startActivity(callGPSSettingIntent);
          }
        });
    alertDialogBuilder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
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
   */

  private boolean isLocationServiceRunning(Class<?> serviceClass) {
    ActivityManager manager = (ActivityManager) getSystemService(Context.ACTIVITY_SERVICE);
    for (ActivityManager.RunningServiceInfo service : manager.getRunningServices(
        Integer.MAX_VALUE)) {
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

  public void onSignOutButtonClick(View view) {
    stopLocationService();
    sessionManager.clearAll();
    Intent intent = new Intent(this, LoginActivity.class);
    startActivity(intent);
    finish();
  }

  @Override public void onItemClick(View view, int position, JobModel jobModel) {

    Intent intent = new Intent(this, JobActivity.class);
    intent.putExtra("JobModel", jobModel);
    startActivity(intent);
  }
}
