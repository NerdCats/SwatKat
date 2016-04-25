package co.gobd.tracker.model.job.task;

import co.gobd.tracker.model.job.Location;

/**
 * Created by fahad on 4/25/16.
 */
public class PackagePickupTask extends JobTask {

    private String JobTaskStateString;
    private String State;
    private Location From;

    public PackagePickupTask(String jobTaskStateString, String state, Location from) {
        super(JobTaskTypes.PACKAGE_PICKUP, "Picking Up Package");
        JobTaskStateString = jobTaskStateString;
        State = state;
        From = from;
    }

    public String getJobTaskStateString() {
        return JobTaskStateString;
    }

    public String getState() {
        return State;
    }

    public Location getFrom() { return From; }

    @Override
    public String toString() {
        return "PackagePickupTask{" +
                "JobTaskStateString='" + JobTaskStateString + '\'' +
                ", State='" + State + '\'' +
                ", From=" + From +
                '}';
    }
}
