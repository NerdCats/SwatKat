package co.gobd.tracker.model.job.task;

import co.gobd.tracker.model.job.Location;

/**
 * Created by fahad on 4/25/16.
 */
public class DeliveryTask extends JobTask{

    private String JobTaskStateString;
    private String State;
    private Location To;
    private String Id;
    private String AssetRefId;

    public DeliveryTask(String jobTaskStateString, String state, Location to, String Id,String assetRefId) {
        super(JobTaskTypes.DELIVERY, "Delivering Package");
        JobTaskStateString = jobTaskStateString;
        State = state;
        To = to;
        this.Id = Id;
        this.AssetRefId=assetRefId;
        setType(JobTaskTypes.DELIVERY);
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
        return To;
    }

    public String getAssetRefId() {
        return AssetRefId;
    }

    public void setAssetRefId(String assetRefId) {
        AssetRefId = assetRefId;
    }

    @Override
    public String toString() {
        return "DeliveryTask{" +
                "JobTaskStateString='" + JobTaskStateString + '\'' +
                ", State='" + State + '\'' +
                ", Asset='" + AssetRefId + '\'' +
                ", To=" + To +
                '}';
    }
}
