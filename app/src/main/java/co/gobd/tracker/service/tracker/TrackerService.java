package co.gobd.tracker.service.tracker;

import co.gobd.tracker.service.tracker.TrackerCallback;

/**
 * Created by tonmoy on 11-Apr-16.
 */
public interface TrackerService {
    void sendLocation(double latitude, double longitude, String assetId, TrackerCallback callback);

}
