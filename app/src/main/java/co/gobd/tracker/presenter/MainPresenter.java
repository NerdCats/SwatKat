package co.gobd.tracker.presenter;

import java.lang.ref.WeakReference;
import java.util.List;

import javax.inject.Inject;

import co.gobd.tracker.model.job.AssignedJob;
import co.gobd.tracker.model.job.JobModel;
import co.gobd.tracker.service.job.JobCallback;
import co.gobd.tracker.service.job.JobService;
import co.gobd.tracker.ui.view.MainView;
import co.gobd.tracker.utility.Constant;
import co.gobd.tracker.utility.SessionManager;

/**
 * Created by fahadwajed on 7/21/16.
 */

public class MainPresenter {

    private JobService jobService;
    private MainView mainView;
    private WeakReference<MainView> mainViewWeakReference;
    private List<JobModel> jobModelList;

    @Inject
    SessionManager sessionManager;

    @Inject
    public MainPresenter(JobService jobService){
        this.jobService = jobService;
    }

    public void initialise(MainView view){
        this.mainViewWeakReference = new WeakReference<>(view);
        mainView = this.mainViewWeakReference.get();
    }

    public void setInProgressedJob(){
        jobService.getAssignedJobList(sessionManager.getBearer(),
                sessionManager.getAssetId(),
                Constant.JobTaskState.IN_PROGRESS, new JobCallback() {
                    @Override
                    public void onGetJobSuccess(AssignedJob assignedJob) {
                        if(assignedJob != null){
                            jobModelList = assignedJob.getJobModelList();
                            mainView.setJobModelList(jobModelList);
                        }
                    }

                    @Override
                    public void onGetJobFailure() {

                    }

                    @Override
                    public void onConnectionError() {

                    }
                });
    }

    public List<JobModel> getInProgressedJob(){
        return jobModelList;
    }
}
