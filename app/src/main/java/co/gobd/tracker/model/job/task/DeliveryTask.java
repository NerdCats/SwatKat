package co.gobd.tracker.model.job.task;

import android.os.Parcel;
import android.os.Parcelable;

import co.gobd.tracker.model.job.Location;

/**
 * Created by fahad on 4/25/16.
 */
public class DeliveryTask extends JobTask implements Parcelable {

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
    private String JobTaskStateString;
    private String State;
    private Location To;
    private String Id;

    public DeliveryTask(String jobTaskStateString, String state, Location to, String Id) {
        super(JobTaskTypes.DELIVERY, "Delivering Package");
        JobTaskStateString = jobTaskStateString;
        State = state;
        To = to;
        this.Id = Id;
        setType(JobTaskTypes.DELIVERY);
    }

    public DeliveryTask(Parcel in) {
        super(in);
        JobTaskStateString = in.readString();
        State = in.readString();
        To = in.readParcelable(Location.class.getClassLoader());
        Id = in.readString();
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
        dest.writeString(Id);
    }
}
