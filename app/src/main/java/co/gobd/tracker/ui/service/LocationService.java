package co.gobd.tracker.ui.service;

import android.app.Notification;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.location.Location;
import android.os.Bundle;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;
import android.widget.Toast;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.location.LocationListener;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationServices;

import javax.inject.Inject;

import co.gobd.tracker.R;
import co.gobd.tracker.application.GoAssetApplication;
import co.gobd.tracker.service.tracker.TrackerCallback;
import co.gobd.tracker.service.tracker.TrackerService;
import co.gobd.tracker.ui.activity.MainActivity;
import co.gobd.tracker.utility.SessionManager;


public class LocationService extends Service implements
        GoogleApiClient.ConnectionCallbacks,
        GoogleApiClient.OnConnectionFailedListener,
        LocationListener {
    public static final long UPDATE_INTERVAL_IN_MILLISECONDS = 10000;

    public static final long FASTEST_UPDATE_INTERVAL_IN_MILLISECONDS =
            UPDATE_INTERVAL_IN_MILLISECONDS / 2;

    private static final String LOG_TAG = LocationService.class.getSimpleName();

    @Inject
    TrackerService trackerService;

    @Inject
    Context context;

    @Inject
    SessionManager sessionManager;

    private GoogleApiClient mGoogleApiClient;
    private LocationRequest mLocationRequest;
    public static Location mCurrentLocation;


    /*//FIXME : Need to fix this. A better solution perhaps
    //http://stackoverflow.com/a/20678640
    @Override
    public void onTaskRemoved(Intent rootIntent) {
        Intent restartService = new Intent(getApplicationContext(), this.getClass());
        restartService.setPackage(getPackageName());
        PendingIntent restartServicePI = PendingIntent.getService(getApplicationContext(),1,
                restartService,PendingIntent.FLAG_ONE_SHOT);
        AlarmManager alarmService = (AlarmManager)getApplicationContext().
                getSystemService(Context.ALARM_SERVICE);
        alarmService.set(AlarmManager.ELAPSED_REALTIME, SystemClock.elapsedRealtime() +1000,
                restartServicePI);
    }*/

    @Override
    public void onCreate() {
        // Injects the dependency
        ((GoAssetApplication) getApplication()).getComponent().inject(this);

        buildGoogleApiClient();
        mGoogleApiClient.connect();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        return Service.START_STICKY;
    }

    @Override
    public void onDestroy() {
        mGoogleApiClient.disconnect();
        String message = "Location service stopped";
        Log.i(LOG_TAG, message);
        Toast.makeText(getApplicationContext(), message, Toast.LENGTH_SHORT).show();
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    protected synchronized void buildGoogleApiClient() {
        Log.i(LOG_TAG, "Building GoogleApiClient");
        mGoogleApiClient = new GoogleApiClient.Builder(getApplicationContext())
                .addConnectionCallbacks(this)
                .addOnConnectionFailedListener(this)
                .addApi(LocationServices.API)
                .build();
        createLocationRequest();
    }

    private void createLocationRequest() {
        mLocationRequest = new LocationRequest();
        mLocationRequest.setInterval(UPDATE_INTERVAL_IN_MILLISECONDS);
        mLocationRequest.setFastestInterval(FASTEST_UPDATE_INTERVAL_IN_MILLISECONDS);
        mLocationRequest.setPriority(LocationRequest.PRIORITY_HIGH_ACCURACY);
    }

    protected void startLocationUpdates() {

        startServiceAsForeground();

        LocationServices.FusedLocationApi.requestLocationUpdates(mGoogleApiClient, mLocationRequest, this);
    }

    private void startServiceAsForeground() {

        // Requires a notification to run a service as foreground
        int NOTIFICATION_ID = 1;

        // Create an Intent that will open the main Activity
        // if the notification is clicked.
        Intent intent = new Intent(this, MainActivity.class);
        PendingIntent pendingIntent = PendingIntent.getActivity(this, 1, intent, 0);

        // Set the Notification UI parameters
        Notification notification = null;
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.JELLY_BEAN) {
            notification = new Notification.Builder(context)
                    .setContentTitle("GO! Asset")
                    .setContentText("Location tracking running...")
                    .setContentIntent(pendingIntent)
                    .build();
            // Set the Notification as ongoing
            notification.flags = notification.flags |
                    Notification.FLAG_ONGOING_EVENT;

            // Move the Service to the Foreground
            startForeground(NOTIFICATION_ID, notification);
        }
        // FIXME add support for device < JELLY_BEAN

    }


    @Override
    public void onConnected(Bundle bundle) {

        Log.i(LOG_TAG, "GoogleApi connected");

        if (mCurrentLocation == null) {
            mCurrentLocation = LocationServices.FusedLocationApi.getLastLocation(mGoogleApiClient);
        }

        startLocationUpdates();


    }

    @Override
    public void onConnectionSuspended(int i) {

    }

    @Override
    public void onConnectionFailed(ConnectionResult connectionResult) {

    }

    @Override
    public void onLocationChanged(Location location) {

        mCurrentLocation = location;

        String assetId = sessionManager.getAssetId();
        String name = sessionManager.getUsername();
        trackerService.sendLocation(mCurrentLocation.getLatitude(),
                mCurrentLocation.getLongitude(), assetId, name, new TrackerCallback() {
                    @Override
                    public void onLocationSendSuccess() {
                        Toast.makeText(context, R.string.location_sent_successful,
                                Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onLocationSendFailure() {

                    }
                });


    }

}
