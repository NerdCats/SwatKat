package co.gobd.tracker.model.job.task;

import android.os.Parcel;
import android.os.Parcelable;

import co.gobd.tracker.model.job.Location;

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
        setType(JobTaskTypes.FETCH_DELIVERYMAN);
    }


    public String getJobTaskStateString() {
        return JobTaskStateString;
    }

    public String getState() {
        return State;
    }

    public void setState(String State){
        this.State = State;
    }

    public Location getLocation(){
        return null;
    }


    @Override
    public String toString() {
        return "FetchDeliveryManTask{" +
                "JobTaskStateString='" + JobTaskStateString + '\'' +
                ", State='" + State + '\'' +
                '}';
    }
}
