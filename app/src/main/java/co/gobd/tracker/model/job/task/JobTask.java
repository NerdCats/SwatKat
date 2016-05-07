package co.gobd.tracker.model.job.task;

import android.os.Parcel;
import android.os.Parcelable;

import co.gobd.tracker.model.job.Location;

/**
 * Created by fahad on 4/25/16.
 */
public abstract class JobTask implements Parcelable {

    private String Type;
    private String Name;

    public JobTask(String type, String name) {
        super();
        Name = name;
        Type = type;
    }

    protected JobTask(Parcel in) {
        Name = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(getName());
    }





    public static final Creator<JobTask> CREATOR = new Creator<JobTask>() {
        @Override
        public JobTask createFromParcel(Parcel in) {
            String jobTaskType = in.readString();

            JobTask jobTask = null;

            if(jobTaskType.equals(JobTaskTypes.FETCH_DELIVERYMAN))
                jobTask = (JobTask) new FetchDeliveryManTask(in);
            if(jobTaskType.equals(JobTaskTypes.PACKAGE_PICKUP))
                jobTask = (JobTask) new PackagePickupTask(in);
            if(jobTaskType.equals(JobTaskTypes.DELIVERY))
                jobTask = (JobTask) new DeliveryTask(in);

            return jobTask;
        }

        @Override
        public JobTask[] newArray(int size) {
            return new JobTask[size];
        }
    };

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
}
