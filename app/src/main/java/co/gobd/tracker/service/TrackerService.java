package co.gobd.tracker.service;

import co.gobd.tracker.service.location.LocationCallback;

/**
 * Created by tonmoy on 11-Apr-16.
 */
public interface TrackerService {
    void sendLocation(double latitude, double longitude, String assetId, LocationCallback callback);

}
