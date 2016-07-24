package co.gobd.tracker.adapter;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import co.gobd.tracker.R;
import co.gobd.tracker.model.job.JobModel;
import co.gobd.tracker.ui.view.OnJobItemClickListener;

/**
 * Created by fahad on 4/28/16.
 */
public class JobAdapter extends RecyclerView.Adapter<JobAdapter.JobViewHolder> {


    Context context;


    private List<JobModel> jobModelList;
    private OnJobItemClickListener onJobItemClickListener;

    private OnTaskUpdateClickListener onTaskUpdateClickListener;

    public JobAdapter(Context context) {
        jobModelList = new ArrayList<>();
        this.context = context;
    }


    public void setOnJobItemClickListener(final OnJobItemClickListener onJobItemClickListener) {
        this.onJobItemClickListener = onJobItemClickListener;
    }

    public void setAdapterData(List<JobModel> jobModelList) {
        this.jobModelList = jobModelList;
        notifyDataSetChanged();
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
        holder.name.setText(jobModel.getUser().getUserName());
        holder.state.setText(jobModel.getState());
        holder.hrid.setText(jobModel.getHRID());

        String totalPrice = context.getString(R.string.currency_bdt) +
                jobModel.getOrder().getOrderCart().getTotalToPay();
        holder.totalPrice.setText(totalPrice);

        String pickup = context.getString(R.string.text_job_pickup) +
                jobModel.getOrder().getFrom().getLocality();
        String delivery = context.getString(R.string.text_job_delivery) +
                jobModel.getOrder().getTo().getLocality();
        holder.pickupLocality.setText(pickup);
        holder.deliveryLocality.setText(delivery);

    }

    @Override
    public int getItemCount() {
        return jobModelList.size();
    }

    public void setOnTaskUpdateClickListener(OnTaskUpdateClickListener onTaskUpdateClickListener) {
        this.onTaskUpdateClickListener = onTaskUpdateClickListener;
    }

    public class JobViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        TextView name;
        TextView state;
        TextView hrid;
        TextView totalPrice;

        TextView pickupLocality;
        TextView deliveryLocality;
        Button taskUpdate;

        CardView cardView;

        public JobViewHolder(View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);
            cardView = (CardView) itemView.findViewById(R.id.cv_jobmodel);
            name = (TextView) itemView.findViewById(R.id.tv_job_user);
            state = (TextView) itemView.findViewById(R.id.tv_jobstate);
            hrid = (TextView) itemView.findViewById(R.id.tv_hrid);
            totalPrice = (TextView) itemView.findViewById(R.id.tv_total_price);
            pickupLocality = (TextView) itemView.findViewById(R.id.tv_locality_pickup);
            deliveryLocality = (TextView) itemView.findViewById(R.id.tv_locality_delivery);
            taskUpdate = (Button) itemView.findViewById(R.id.btn_task_update);

            taskUpdate.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int position = getAdapterPosition();
                    String jobId = jobModelList.get(position).getId();
                    int PACKAGE_PICKUP_TASK = 1;
                    int DELIVERY_TASK = 2;
                    String pickupTaskId = jobModelList.get(position).getTasks().get(PACKAGE_PICKUP_TASK).getId();
                    String deliveryTaskId = jobModelList.get(position).getTasks().get(DELIVERY_TASK).getId();
                    onTaskUpdateClickListener.onTaskUpdateClick(jobId, pickupTaskId, deliveryTaskId);
                }
            });
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
