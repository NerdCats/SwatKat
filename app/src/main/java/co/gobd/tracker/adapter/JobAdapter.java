package co.gobd.tracker.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import co.gobd.tracker.R;
import co.gobd.tracker.model.job.AssignedJob;
import co.gobd.tracker.model.job.JobModel;
import co.gobd.tracker.service.job.JobCallback;
import co.gobd.tracker.service.job.JobService;
import co.gobd.tracker.ui.view.OnItemClickListener;
import co.gobd.tracker.utility.SessionManager;

/**
 * Created by fahad on 4/28/16.
 */
public class JobAdapter extends RecyclerView.Adapter<JobAdapter.JobViewHolder> {


    private JobService jobService;
    private List<JobModel> jobModelList;
    private OnItemClickListener onItemClickListener;
    private Context context;

    public JobAdapter(Context context, JobService jobService, String bearer, String assetId){
        this.jobService = jobService;
        this.context = context;
        this.jobModelList = new ArrayList<>();


        jobService.getAssignedJobList(bearer, assetId, new JobCallback() {
            @Override
            public void onGetJobSuccess(AssignedJob assignedJob) {
                if(assignedJob != null){
                    jobModelList = assignedJob.getJobModelList();
                    notifyDataSetChanged();
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

    public class JobViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        TextView name, state;

        public JobViewHolder(View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);
            name = (TextView) itemView.findViewById(R.id.tv_jobname);
            state = (TextView) itemView.findViewById(R.id.tv_jobstate);


        }

        @Override
        public void onClick(View v) {
            int position = getLayoutPosition();
            if(jobModelList.isEmpty()){
                if(onItemClickListener != null){
                    onItemClickListener.onClick(v, position);
                }
            }
        }
    }

    public void setOnItemClickListener(final OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    public JobAdapter(List<JobModel> jobModelList){
        this.jobModelList = jobModelList;

    }

    @Override
    public JobViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater
                .from(parent.getContext())
                .inflate(R.layout.job_list_row,parent,false);

        return new JobViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(JobViewHolder holder, int position) {

        JobModel jobModel = jobModelList.get(position);
        holder.name.setText(jobModel.getName());
        holder.name.setText(jobModel.getState());
    }

    @Override
    public int getItemCount(){
        return jobModelList.size();
    }


}
