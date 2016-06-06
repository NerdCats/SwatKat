package co.gobd.tracker.model.job;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.List;

/**
 * Created by fahad on 4/25/16.
 */
public class AssignedJob implements Parcelable {
    List<JobModel> jobModelList;

    public AssignedJob(List<JobModel> jobModelList) {

        this.jobModelList = jobModelList;

    }

    @Override
    public String toString() {
        return "AssignedJob{" +
                "jobModelList=" + jobModelList +
                '}';
    }

    public List<JobModel> getJobModelList() {
        return jobModelList;
    }

    public void setJobModelList(List<JobModel> jobModelList) {
        this.jobModelList = jobModelList;
    }

    public static final Parcelable.Creator<AssignedJob> CREATOR
            = new Parcelable.Creator<AssignedJob>(){
        @Override
        public AssignedJob createFromParcel(Parcel source) {
            return new AssignedJob(source);
        }

        @Override
        public AssignedJob[] newArray(int size) {
            return new AssignedJob[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeTypedList(jobModelList);
    }

    private AssignedJob(Parcel in){
        in.readTypedList(jobModelList, JobModel.CREATOR);
    }
}