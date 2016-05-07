package co.gobd.tracker.model.job;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.internal.bind.ArrayTypeAdapter;

import java.util.ArrayList;
import java.util.List;

import co.gobd.tracker.model.job.task.JobTask;

/**
 * Created by fahad on 4/25/16.
 */
public class JobModel implements Parcelable {
    private String Name;
    private String State;
    private List<JobTask> Tasks;

    public JobModel(String name, String state, List<JobTask> tasks) {
        super();
        Name = name;
        State = state;
        Tasks = tasks;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags){
        dest.writeString(getName());
        dest.writeTypedList(getTasks());
    }


    public String getName(){
        return Name;
    }

    public String getState(){
        return State;
    }

    public List<JobTask> getTasks(){
        return Tasks;
    }

    protected JobModel(Parcel in){
        super();
        this.Name = in.readString();
        this.setTasks(new ArrayList<JobTask>());
        in.readTypedList(getTasks(), JobTask.CREATOR);
    }

    public static final Parcelable.Creator<JobModel> CREATOR = new Parcelable.Creator<JobModel>(){

        @Override
        public JobModel createFromParcel(Parcel source) {
            return new JobModel(source);
        }

        @Override
        public JobModel[] newArray(int size) {
            return new JobModel[size];
        }
    };

    public void setTasks(List<JobTask> Tasks){
        this.Tasks = Tasks;
    }

    @Override
    public String toString() {
        return "JobModel{" +
                "Name='" + Name + '\'' +
                ", State='" + State + '\'' +
                ", Tasks=" + Tasks +
                '}';
    }

    @Override
    public int describeContents() {
        return this.hashCode();
    }

}
