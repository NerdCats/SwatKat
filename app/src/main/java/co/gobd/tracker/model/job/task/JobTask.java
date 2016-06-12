package co.gobd.tracker.model.job.task;

import android.os.Parcel;
import android.os.Parcelable;

import co.gobd.tracker.model.job.Location;

/**
 * Created by fahad on 4/25/16.
 */
public abstract class JobTask implements Parcelable {

    public static final int CLASS_TYPE_FETCH_DELIVERY_MAN_TASK = 1;
    public static final int CLASS_TYPE_PACKAGE_PICKUP_TASK = 2;
    public static final int CLASS_TYPE_DELIVERY_TASK = 3;

    private String Type;
    private String Name;

    public JobTask(String type, String name) {
        Name = name;
        Type = type;
    }

    public JobTask(Parcel in){
        Type = in.readString();
        Name = in.readString();
    }

    public String getType() {
        return Type;
    }

    public void setType(String Type){
        this.Type = Type;
    }

    public String getName() {
        return Name;
    }

    public abstract Location getLocation();

    @Override
    public String toString() {
        return "JobTask{" +
                "Type='" + Type + '\'' +
                ", Name='" + Name + '\'' +
                '}';
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(Type);
        dest.writeString(Name);
    }

    public static final Parcelable.Creator<JobTask> CREATOR
            = new Parcelable.Creator<JobTask>(){
        @Override
        public JobTask createFromParcel(Parcel source) {
            return JobTask.getConcreteClass(source);
        }

        @Override
        public JobTask[] newArray(int size) {
            return new JobTask[size];
        }
    };

    public static JobTask getConcreteClass(Parcel source){
        switch (source.readInt()){
            case CLASS_TYPE_FETCH_DELIVERY_MAN_TASK:
                return new FetchDeliveryManTask(source);
            case CLASS_TYPE_PACKAGE_PICKUP_TASK:
                return new PackagePickupTask(source);
            case CLASS_TYPE_DELIVERY_TASK:
                return new DeliveryTask(source);
            default: return null;
        }
    }
}
