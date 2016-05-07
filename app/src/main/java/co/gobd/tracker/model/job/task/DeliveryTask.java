package co.gobd.tracker.model.job.task;

import android.os.Parcel;
import android.os.Parcelable;

import co.gobd.tracker.model.job.Location;

/**
 * Created by fahad on 4/25/16.
 */
public class DeliveryTask extends JobTask{

    private String JobTaskStateString;
    private String State;
    private Location To;

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

    public DeliveryTask(String jobTaskStateString, String state, Location to) {
        super(JobTaskTypes.DELIVERY, "Delivering Package");
        JobTaskStateString = jobTaskStateString;
        State = state;
        To = to;
    }

    public DeliveryTask(Parcel source){
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

    public Location getLocation(){return To;}

    public static final Parcelable.Creator<DeliveryTask> CREATOR = new Parcelable.Creator<DeliveryTask>(){
        public DeliveryTask createFromParcel(Parcel in){
            return new DeliveryTask(in);
        }

        public DeliveryTask[] newArray(int size){
            return new DeliveryTask[size];
        }
    };

    @Override
    public String toString() {
        return "DeliveryTask{" +
                "JobTaskStateString='" + JobTaskStateString + '\'' +
                ", State='" + State + '\'' +
                ", To=" + To +
                '}';
    }
}
