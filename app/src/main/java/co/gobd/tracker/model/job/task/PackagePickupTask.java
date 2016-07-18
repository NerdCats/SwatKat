package co.gobd.tracker.model.job.task;

import android.os.Parcel;
import android.os.Parcelable;

import co.gobd.tracker.model.job.Location;

/**
 * Created by fahad on 4/25/16.
 */
public class PackagePickupTask extends JobTask implements Parcelable {

    public static final Parcelable.Creator<PackagePickupTask> CREATOR
            = new Parcelable.Creator<PackagePickupTask>() {
        @Override
        public PackagePickupTask createFromParcel(Parcel source) {
            return new PackagePickupTask(source);
        }

        @Override
        public PackagePickupTask[] newArray(int size) {
            return new PackagePickupTask[size];
        }
    };
    private String JobTaskStateString;
    private String State;
    private Location From;
    private String Id;

    public PackagePickupTask(String jobTaskStateString, String state, Location from, String Id) {
        super(JobTaskTypes.PACKAGE_PICKUP, "Picking Up Package");
        JobTaskStateString = jobTaskStateString;
        State = state;
        From = from;
        this.Id = Id;
        setType(JobTaskTypes.PACKAGE_PICKUP);
    }

    public PackagePickupTask(Parcel in) {
        super(in);
        JobTaskStateString = in.readString();
        State = in.readString();
        From = in.readParcelable(Location.class.getClassLoader());
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
        return From;
    }


    @Override
    public String toString() {
        return "PackagePickupTask{" +
                "JobTaskStateString='" + JobTaskStateString + '\'' +
                ", State='" + State + '\'' +
                ", From=" + From +
                '}';
    }

    @Override
    public int describeContents() {
        return super.describeContents();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(CLASS_TYPE_PACKAGE_PICKUP_TASK);
        super.writeToParcel(dest, flags);
        dest.writeString(JobTaskStateString);
        dest.writeString(State);
        dest.writeParcelable(From, flags);
        dest.writeString(Id);
    }

}
