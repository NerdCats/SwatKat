package co.gobd.tracker.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.TextView;

import java.util.List;

import co.gobd.tracker.R;
import co.gobd.tracker.model.job.JobModel;

/**
 * Created by fahad on 4/28/16.
 */
public class JobAdapter extends RecyclerView.Adapter<JobAdapter.JobViewHolder> {

    private List<JobModel> jobModelList;
    private AdapterView.OnItemClickListener onItemClickListener;

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
                    onItemClickListener.on
                }
            }
        }
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
