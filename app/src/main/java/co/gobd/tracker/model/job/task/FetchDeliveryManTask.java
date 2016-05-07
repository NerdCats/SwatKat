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

    @Override
    public int describeContents(){
        return this.hashCode();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags){
        dest.writeString(getType());
        super.writeToParcel(dest, flags);
        dest.writeString(getState());
    }

    public FetchDeliveryManTask(String jobTaskStateString, String state) {
        super(JobTaskTypes.FETCH_DELIVERYMAN, "Fetching Delivery Guy");
        JobTaskStateString = jobTaskStateString;
        State = state;
    }

    public FetchDeliveryManTask(Parcel source){
        super(source);
        this.State = source.readString();
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

    public static final Parcelable.Creator<FetchDeliveryManTask> CREATOR = new Parcelable.Creator<FetchDeliveryManTask>(){
        public FetchDeliveryManTask createFromParcel(Parcel in){
            return new FetchDeliveryManTask(in);
        }

        public FetchDeliveryManTask[] newArray(int size){
            return new FetchDeliveryManTask[size];
        }
    };

    @Override
    public String toString() {
        return "FetchDeliveryManTask{" +
                "JobTaskStateString='" + JobTaskStateString + '\'' +
                ", State='" + State + '\'' +
                '}';
    }
}
