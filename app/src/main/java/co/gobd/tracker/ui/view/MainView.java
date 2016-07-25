package co.gobd.tracker.ui.view;

import java.util.List;

import co.gobd.tracker.model.job.JobModel;

/**
 * Created by fahadwajed on 7/21/16.
 */

public interface MainView {
    void setJobModelList(List<JobModel> jobModelList);
    void startProgress();
    void stopProgress();

    void showTaskUpdateSuccessfulMsg();

    void showTaskUpdateError();

    void showConnectionError();
}
