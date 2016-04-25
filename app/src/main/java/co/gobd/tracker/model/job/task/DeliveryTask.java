package co.gobd.tracker.model.job.task;

import co.gobd.tracker.model.job.Location;

/**
 * Created by fahad on 4/25/16.
 */
public class DeliveryTask extends JobTask{
    private String JobTaskStateString;
    private String State;
    private Location To;

    public DeliveryTask(String jobTaskStateString, String state, Location to) {
        super(JobTaskTypes.DELIVERY, "Delivering Package");
        JobTaskStateString = jobTaskStateString;
        State = state;
        To = to;
    }

    public String getJobTaskStateString() {
        return JobTaskStateString;
    }

    public String getState() {
        return State;
    }

    public Location getTo(){return To;}
}
