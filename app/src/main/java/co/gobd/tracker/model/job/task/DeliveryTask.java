package co.gobd.tracker.model.job.task;

import android.os.Parcel;
import android.os.Parcelable;

import co.gobd.tracker.model.job.Location;

/**
 * Created by fahad on 4/25/16.
 */
public class DeliveryTask extends JobTask implements Parcelable{

    private String JobTaskStateString;
    private String State;
    private Location To;

    public DeliveryTask(String jobTaskStateString, String state, Location to) {
        super(JobTaskTypes.DELIVERY, "Delivering Package");
        JobTaskStateString = jobTaskStateString;
        State = state;
        To = to;
        setType(JobTaskTypes.DELIVERY);
    }

    public DeliveryTask(Parcel in){
        super(in);
        JobTaskStateString = in.readString();
        State = in.readString();
        To = in.readParcelable(Location.class.getClassLoader());
    }

    public static final Parcelable.Creator<DeliveryTask> CREATOR
            = new Parcelable.Creator<DeliveryTask>() {
        @Override
        public DeliveryTask createFromParcel(Parcel source) {
            return new DeliveryTask(source);
        }

        @Override
        public DeliveryTask[] newArray(int size) {
            return new DeliveryTask[size];
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

    public Location getLocation(){return To;}


    @Override
    public String toString() {
        return "DeliveryTask{" +
                "JobTaskStateString='" + JobTaskStateString + '\'' +
                ", State='" + State + '\'' +
                ", To=" + To +
                '}';
    }

    @Override
    public int describeContents() {
        return super.describeContents();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(CLASS_TYPE_DELIVERY_TASK);
        super.writeToParcel(dest, flags);
        dest.writeString(JobTaskStateString);
        dest.writeString(State);
        dest.writeParcelable(To, flags);
    }
}
