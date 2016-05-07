package co.gobd.tracker.model.job.task;

import android.os.Parcel;
import android.os.Parcelable;

import co.gobd.tracker.model.job.Location;

/**
 * Created by fahad on 4/25/16.
 */
public class PackagePickupTask extends JobTask {

    private String JobTaskStateString;
    private String State;
    private Location From;

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

    public PackagePickupTask(String jobTaskStateString, String state, Location from) {
        super(JobTaskTypes.PACKAGE_PICKUP, "Picking Up Package");
        JobTaskStateString = jobTaskStateString;
        State = state;
        From = from;
    }

    public PackagePickupTask(Parcel source){
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

    public Location getLocation() { return From; }

    public static final Parcelable.Creator<PackagePickupTask> CREATOR = new Parcelable.Creator<PackagePickupTask>(){
        public PackagePickupTask createFromParcel(Parcel in){
            return new PackagePickupTask(in);
        }

        public PackagePickupTask[] newArray(int size){
            return new PackagePickupTask[size];
        }
    };

    @Override
    public String toString() {
        return "PackagePickupTask{" +
                "JobTaskStateString='" + JobTaskStateString + '\'' +
                ", State='" + State + '\'' +
                ", From=" + From +
                '}';
    }
}
