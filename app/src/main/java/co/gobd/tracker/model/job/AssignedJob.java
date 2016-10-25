package co.gobd.tracker.model.job;

import java.util.List;

/**
 * Created by fahad on 4/25/16.
 */
public class AssignedJob {

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

}