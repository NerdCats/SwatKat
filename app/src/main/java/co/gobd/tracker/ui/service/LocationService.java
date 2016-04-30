package co.gobd.tracker.ui.service;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.location.Location;
import android.os.Bundle;
import android.os.IBinder;
import android.os.SystemClock;
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
import co.gobd.tracker.utility.SessionManager;


public class LocationService extends Service implements GoogleApiClient.ConnectionCallbacks,
        GoogleApiClient.OnConnectionFailedListener, LocationListener {
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
    private Location mCurrentLocation;


    public LocationService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }

    //FIXME : Need to fix this. A better solution perhaps
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
    }

    @Override
    public void onCreate() {
        super.onCreate();

        // Injects the dependency
        ((GoAssetApplication) getApplication()).getComponent().inject(this);

        buildGoogleApiClient();

    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        mGoogleApiClient.connect();
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mGoogleApiClient.disconnect();
        String message = "Location service stopped";
        Log.i(LOG_TAG, message);
        Toast.makeText(getApplicationContext(), message, Toast.LENGTH_SHORT).show();
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
        LocationServices.FusedLocationApi.requestLocationUpdates(mGoogleApiClient, mLocationRequest, this);
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
