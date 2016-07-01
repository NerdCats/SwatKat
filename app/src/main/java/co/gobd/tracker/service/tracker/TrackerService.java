package co.gobd.tracker.service.tracker;

/**
 * Created by tonmoy on 11-Apr-16.
 */
public interface TrackerService {
    void sendLocation(double latitude, double longitude, String assetId, String name, TrackerCallback callback);

}
