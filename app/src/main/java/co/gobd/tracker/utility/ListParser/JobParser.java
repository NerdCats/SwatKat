package co.gobd.tracker.utility.ListParser;

import java.util.List;

import co.gobd.tracker.model.job.JobModel;
import co.gobd.tracker.model.job.Location;
import co.gobd.tracker.model.job.order.PackageList;
import co.gobd.tracker.model.job.task.JobTask;
import co.gobd.tracker.model.job.task.JobTaskTypes;

/**
 * Created by fahad on 5/7/16.
 */
public class JobParser {

    private JobModel jobModel;

    public JobParser(JobModel jobModel) {
        this.jobModel = jobModel;
    }

    public List<JobTask> getTaskList() {
        return jobModel.getTasks();
    }

    public Location getPickupLocation() {
        List<JobTask> jobTasks = getTaskList();
        Location location = null;
        for (int i = 0; i < jobTasks.size(); i++) {
            JobTask jobTask = jobModel.getTasks().get(i);
            if (JobTaskTypes.PACKAGE_PICKUP.equals(jobTask.getType())) {
                try {
                    location = jobTask.getLocation();
                    //PackagePickupTask packagePickupTask = (PackagePickupTask) jobTask;
                    //location = packagePickupTask.getLocation();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        return location;
    }

    public String getTaskId(String taskType) {
        List<JobTask> jobTasks = getTaskList();
        String taskId = null;
        for (int i = 0; i < jobTasks.size(); i++) {
            JobTask jobTask = jobModel.getTasks().get(i);
            if (taskType.equals(jobTask.getType())) {
                taskId = jobTask.getId();
            }
        }

        return taskId;
    }

    public Location getDeliveryLocation() {
        List<JobTask> jobTasks = getTaskList();
        Location location = null;
        for (int i = 0; i < jobTasks.size(); i++) {
            JobTask jobTask = jobModel.getTasks().get(i);
            if (JobTaskTypes.DELIVERY.equals(jobTask.getType())) {
                try {
                    //DeliveryTask deliveryTask = (DeliveryTask) jobTask;
                    location = jobTask.getLocation();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        return location;
    }


    public List<PackageList> getPackageList() {
        return jobModel.getOrder().getOrderCart().getListofPackageList();
    }


    public String getNoteToDeliveryMan() {
        return jobModel.getOrder().getNoteToDeliveryMan();
    }


}
