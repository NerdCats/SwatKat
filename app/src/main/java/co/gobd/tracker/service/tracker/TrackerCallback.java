package co.gobd.tracker.service.tracker;

/**
 * Created by tonmoy on 11-Apr-16.
 */
public interface TrackerCallback {
    void onLocationSendSuccess();
    void onLocationSendFailure();
}
