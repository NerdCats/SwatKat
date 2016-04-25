package co.gobd.tracker.service.job;

/**
 * Created by fahad on 4/25/16.
 */
public interface JobService {

    void getAssignedJobList(String bearer, String assetId, final JobCallback callback);
}
