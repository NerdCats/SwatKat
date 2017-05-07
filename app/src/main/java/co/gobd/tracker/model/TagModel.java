package co.gobd.tracker.model;

/**
 * Created by Mr. Maps on 5/7/2017.
 */

public class TagModel {
    private int position;
    private String Task;
    private String jobid;

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public String getTask() {
        return Task;
    }

    public void setTask(String task) {
        Task = task;
    }

    public TagModel(int position, String task,String Job) {
        this.position = position;
        Task = task;
        jobid=Job;
    }

    public String getJobid() {
        return jobid;
    }

    public void setJobid(String jobid) {
        this.jobid = jobid;
    }
}
