package co.gobd.tracker.model.job.task;

/**
 * Created by fahad on 4/25/16.
 */
public class FetchDeliveryManTask extends JobTask {

    private String JobTaskStateString;
    private String State;

    public FetchDeliveryManTask(String jobTaskStateString, String state) {
        super(JobTaskTypes.FETCH_DELIVERYMAN, "Fetching Delivery Guy");
        JobTaskStateString = jobTaskStateString;
        State = state;
    }

    public String getJobTaskStateString() {
        return JobTaskStateString;
    }

    public String getState() {
        return State;
    }
}
