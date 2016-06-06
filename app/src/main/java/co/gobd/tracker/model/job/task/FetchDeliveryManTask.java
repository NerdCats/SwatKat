package co.gobd.tracker.model.job.task;

import android.os.Parcel;
import android.os.Parcelable;

import co.gobd.tracker.model.job.Location;

/**
 * Created by fahad on 4/25/16.
 */
public class FetchDeliveryManTask extends JobTask implements Parcelable {

    private String JobTaskStateString;
    private String State;

    public FetchDeliveryManTask(String jobTaskStateString, String state) {
        super(JobTaskTypes.FETCH_DELIVERYMAN, "Fetching Delivery Guy");
        JobTaskStateString = jobTaskStateString;
        State = state;
        setType(JobTaskTypes.FETCH_DELIVERYMAN);
    }

    public FetchDeliveryManTask(Parcel in){
        super(in);
        JobTaskStateString = in.readString();
        State = in.readString();
    }

    public static final Parcelable.Creator<FetchDeliveryManTask> CREATOR
            = new Parcelable.Creator<FetchDeliveryManTask>(){
        @Override
        public FetchDeliveryManTask createFromParcel(Parcel source) {
            return new FetchDeliveryManTask(source);
        }

        @Override
        public FetchDeliveryManTask[] newArray(int size) {
            return new FetchDeliveryManTask[size];
        }
    };


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

    @Override
    public int describeContents() {
        return super.describeContents();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(CLASS_TYPE_FETCH_DELIVERY_MAN_TASK);
        super.writeToParcel(dest, flags);
        dest.writeString(JobTaskStateString);
        dest.writeString(State);
    }
}
