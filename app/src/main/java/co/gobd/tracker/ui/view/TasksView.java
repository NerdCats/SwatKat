package co.gobd.tracker.ui.view;

import java.util.List;

import co.gobd.tracker.model.job.JobModel;

/**
 * Created by Israt on 7/21/16.
 */

public interface TasksView {
    void setJobModelList(List<JobModel> jobModelList);
   /* void startProgress();
    void stopProgress();

    void stopSwipRefresh();*/

    void showTaskUpdateSuccessfulMsg();

    void showTaskUpdateError();
   void showServerLayout(String task);
    void showConnectionError();
}
