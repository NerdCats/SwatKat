package co.gobd.tracker.model.job.task;

import co.gobd.tracker.model.job.Location;

/**
 * Created by fahad on 4/25/16.
 */
public class PackagePickupTask extends JobTask {

    private String JobTaskStateString;
    private String State;
    private Location From;
    private String Id;
    private String AssetRefId;

    public PackagePickupTask(String jobTaskStateString, String state, Location from, String Id,String assetRefId) {
        super(JobTaskTypes.PACKAGE_PICKUP, "Picking Up Package");
        JobTaskStateString = jobTaskStateString;
        State = state;
        From = from;
        this.Id = Id;
        this.AssetRefId=assetRefId;
        setType(JobTaskTypes.PACKAGE_PICKUP);
    }

    public String getAssetRefId() {
        return AssetRefId;
    }

    public void setAssetRefId(String assetRefId) {
        AssetRefId = assetRefId;
    }

    public String getId(){
        return Id;
    }

    public void setId(String Id){
        this.Id = Id;
    }

    public String getJobTaskStateString() {
        return JobTaskStateString;
    }

    public String getState() {
        return State;
    }

    public void setState(String State) {
        this.State = State;
    }

    public Location getLocation() {
        return From;
    }


    @Override
    public String toString() {
        return "PackagePickupTask{" +
                "JobTaskStateString='" + JobTaskStateString + '\'' +
                ", State='" + State + '\'' +
                ", Asset='" + AssetRefId + '\'' +
                ", From=" + From +
                '}';
    }

}
