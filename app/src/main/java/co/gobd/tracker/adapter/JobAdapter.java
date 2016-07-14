package co.gobd.tracker.adapter;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import co.gobd.tracker.R;
import co.gobd.tracker.model.job.AssignedJob;
import co.gobd.tracker.model.job.JobModel;
import co.gobd.tracker.model.job.JobState;
import co.gobd.tracker.service.job.JobCallback;
import co.gobd.tracker.service.job.JobService;
import co.gobd.tracker.ui.view.OnJobItemClickListener;

/**
 * Created by fahad on 4/28/16.
 */
public class JobAdapter extends RecyclerView.Adapter<JobAdapter.JobViewHolder> {

    @Inject
    Context context;

    @Inject
    JobService jobService;

    private List<JobModel> jobModelList;
    private OnJobItemClickListener onJobItemClickListener;

    public JobAdapter(final Context context, JobService jobService, String bearer, String assetId) {
        this.jobService = jobService;
        this.context = context;
        this.jobModelList = new ArrayList<>();


        jobService.getAssignedJobList(bearer, assetId, new JobCallback() {
            @Override
            public void onGetJobSuccess(AssignedJob assignedJob) {
                if (assignedJob != null) {
                    jobModelList = assignedJob.getJobModelList();
                    notifyDataSetChanged();
                }
            }

            @Override
            public void onGetJobFailure() {
                Toast.makeText(context, "Job load failure", Toast.LENGTH_SHORT).show();

            }

            @Override
            public void onConnectionError() {
                Toast.makeText(context, "Connection error", Toast.LENGTH_SHORT).show();

            }
        });
    }

    public void setOnJobItemClickListener(final OnJobItemClickListener onJobItemClickListener) {
        this.onJobItemClickListener = onJobItemClickListener;
    }

    @Override
    public JobViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater
                .from(parent.getContext())
                .inflate(R.layout.job_list_row, parent, false);

        return new JobViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(JobViewHolder holder, int position) {

        JobModel jobModel = jobModelList.get(position);
        holder.name.setText(jobModel.getName());
        holder.state.setText(jobModel.getState());
        holder.hrid.setText(jobModel.getHRID());
        holder.totalPrice.setText("BDT " + jobModel.getOrder().getOrderCart().getTotalToPay());

        switch (jobModel.getState()) {
            case JobState.COMPLETED:
                holder.jobState.setImageResource(R.drawable.ic_done_green_500_24dp);
                break;
            case JobState.ENQUEUED:
                holder.jobState.setImageResource(R.drawable.ic_hourglass_full_green_500_24dp);
                break;
            default:
                holder.jobState.setImageResource(R.drawable.ic_hourglass_full_green_500_24dp);
                break;
        }
    }

    @Override
    public int getItemCount() {
        return jobModelList.size();
    }

    public class JobViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        TextView name;
        TextView state;
        TextView hrid;
        TextView totalPrice;
        ImageView jobState;

        CardView cardView;

        public JobViewHolder(View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);
            cardView = (CardView) itemView.findViewById(R.id.cv_jobmodel);
            name = (TextView) itemView.findViewById(R.id.tv_jobname);
            state = (TextView) itemView.findViewById(R.id.tv_jobstate);
            hrid = (TextView) itemView.findViewById(R.id.tv_hrid);
            totalPrice = (TextView) itemView.findViewById(R.id.tv_total_price);
            jobState = (ImageView) itemView.findViewById(R.id.iv_job_state);


        }

        @Override
        public void onClick(View v) {
            int position = getLayoutPosition();
            if (!jobModelList.isEmpty()) {
                if (onJobItemClickListener != null) {
                    onJobItemClickListener.onItemClick(v, position, jobModelList.get(position));
                }
            }
        }
    }


}
