package co.gobd.tracker.service.tracker;

import co.gobd.tracker.callback.ConnectionCallback;

/**
 * Created by tonmoy on 11-Apr-16.
 */
public interface TrackerCallback extends ConnectionCallback {
    void onLocationSendSuccess();

    void onLocationSendFailure();
}
