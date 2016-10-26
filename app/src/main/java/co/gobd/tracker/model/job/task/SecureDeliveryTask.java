package co.gobd.tracker.model.job.task;

import co.gobd.tracker.model.job.Location;

/**
 * Created by fahad on 10/25/16.
 */
public class SecureDeliveryTask extends JobTask {

    private String Id;
    private String JobTaskStateString;
    private String State;

    public SecureDeliveryTask(String jobTaskStateString, String state, String Id) {
        super(JobTaskTypes.SECURE_DELIVERY, "Cash Delivery");
        JobTaskStateString = jobTaskStateString;
        State = state;
        this.Id = Id;
        setType(JobTaskTypes.SECURE_DELIVERY);
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

    public void setId(String Id){
        this.Id = Id;
    }

    public String getId(){
        return Id;
    }

    public Location getLocation(){
        return null;
    }
}
