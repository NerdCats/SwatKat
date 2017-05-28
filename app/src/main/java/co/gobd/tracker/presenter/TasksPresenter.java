package co.gobd.tracker.presenter;

import android.util.Log;
import android.widget.Toast;

import java.lang.ref.WeakReference;
import java.util.List;

import javax.inject.Inject;

import co.gobd.tracker.model.job.AssignedJob;
import co.gobd.tracker.model.job.JobModel;
import co.gobd.tracker.model.job.Location;
import co.gobd.tracker.model.job.UpdateTaskState;
import co.gobd.tracker.service.job.JobCallback;
import co.gobd.tracker.service.job.JobService;
import co.gobd.tracker.service.job.PatchCallback;
import co.gobd.tracker.ui.view.MainView;
import co.gobd.tracker.ui.view.TasksView;
import co.gobd.tracker.ui.view.TasksoverView;
import co.gobd.tracker.utility.Constant;
import co.gobd.tracker.utility.SessionManager;

/**
 * Created by fahadwajed on 7/21/16.
 */

public class TasksPresenter {

    @Inject
    SessionManager sessionManager;
    private JobService jobService;
    private TasksView tasksView;
    private WeakReference<TasksView> tasksViewWeakReference;
    private List<JobModel> jobModelList;
    String InheritedTasktype;

    @Inject
    public TasksPresenter(JobService jobService) {
        this.jobService = jobService;
    }

    public String getInheritedTasktype() {
        return InheritedTasktype;
    }

    public void setInheritedTasktype(String inheritedTasktype) {
        InheritedTasktype = inheritedTasktype;
    }

    public void initialise(TasksView view) {
        this.tasksViewWeakReference = new WeakReference<>(view);
        tasksView = this.tasksViewWeakReference.get();
    }


    public void loadAdapterData() {
        tasksView.startProgress();

        jobService.getAssignedJobList(sessionManager.getBearer(),
                sessionManager.getAssetId(),Constant.JobTaskState.IN_PROGRESS,getInheritedTasktype(), new JobCallback() {


                    @Override
                    public void onGetJobSuccess(AssignedJob assignedJob) {
                        if (assignedJob != null) {
                            tasksView.stopProgress();
                            jobModelList = assignedJob.getJobModelList();
                            tasksView.setJobModelList(jobModelList);

                        }

                    }

                    @Override
                    public void onGetJobFailure() {
                        tasksView.stopProgresswithmessage();
                    }

                    @Override
                    public void onConnectionError() {
                        tasksView.stopProgresswithmessage();

                        Log.d("err","connectionerror");
                    }
                });
    }

    public List<JobModel> getInProgressedJob() {
        return jobModelList;
    }

    public void onDestroy() {
        tasksViewWeakReference = null;
    }

  public void updateTaskStateToCompleted(String jobId,double lat,double lon, String taskId,String status) {


        UpdateTaskState[] state = {new UpdateTaskState("replace", "State", status)};

        jobService.updateTaskState(sessionManager.getBearer(),lat,lon,jobId, taskId,
                state, new PatchCallback() {
                    @Override
                    public void onPatchSuccess() {
                        loadAdapterData();
                        tasksView.showTaskUpdateSuccessfulMsg();
                    }

                    @Override
                    public void onPatchFailure() {
                        tasksView.showTaskUpdateError();
                    }

                    @Override
                    public void onConnectionError() {

                        tasksView.showConnectionError();
                    }
                });
    }

}
