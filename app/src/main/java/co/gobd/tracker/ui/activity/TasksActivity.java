package co.gobd.tracker.ui.activity;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Handler;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ExpandableListView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import co.gobd.tracker.R;
import co.gobd.tracker.adapter.Job_expandable_list_adapter;
import co.gobd.tracker.adapter.OnCallClickListener;
import co.gobd.tracker.adapter.OnTaskUpdateClickListener;
import co.gobd.tracker.application.GoAssetApplication;
import co.gobd.tracker.model.job.JobModel;
import co.gobd.tracker.presenter.TasksPresenter;
import co.gobd.tracker.ui.view.OnJobItemClickListener;
import co.gobd.tracker.ui.view.TasksView;

public class TasksActivity extends AppCompatActivity implements TasksView,OnCallClickListener{
    @Inject
    TasksPresenter tasksPresenter;
    @Inject
    Context context;

    @BindView(R.id.simple_expandable_listview)
    ExpandableListView jobView;
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    RadioGroup radioGroup;
    Job_expandable_list_adapter job_expandable_list_adapter;
    private Unbinder unbinder;
    String TaskType;
    RadioButton rd;
    String[]Pickup={ "Done","Failed"};

    String[]Delivery={ "Done","Failed","Returned"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tasks);
        unbinder = ButterKnife.bind(this);
        ((GoAssetApplication) getApplication()).getComponent().inject(this);
        //  overViewPresenter.initialise(this);
        TaskType=getIntent().getStringExtra("TaskType");

        setupToolbar();
        job_expandable_list_adapter = new Job_expandable_list_adapter(context,TaskType);
        tasksPresenter.initialise(this);
        tasksPresenter.setInheritedTasktype(TaskType);
        tasksPresenter.loadAdapterData();

    //    jobAdapter.setOnJobItemClickListener(this);
    //    jobAdapter.setOnTaskUpdateClickListener(this);
     //   jobAdapter.setOnCallClickListener(this);

        jobView.setGroupIndicator(null);
        jobView.setChildIndicator(null);
        jobView.setChildDivider(getResources().getDrawable(R.color.material_blue_grey_50));
        jobView.setDivider(getResources().getDrawable(R.color.transparent));

     jobView.setDividerHeight(7);

        jobView.setOnGroupExpandListener(new ExpandableListView.OnGroupExpandListener() {

            int previousItem = -1;

            @Override
            public void onGroupExpand(int groupPosition) {

                jobView.smoothScrollToPosition(groupPosition);
                if(groupPosition != previousItem )

                    jobView.collapseGroup(previousItem );
                previousItem = groupPosition;
            }
        });

        jobView.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
            @Override
            public boolean onChildClick(ExpandableListView parent, View v, int groupPosition, int childPosition, long id) {


                if(childPosition==1)
                {
                    String call= String.valueOf(v.getTag());

                    boolean atleastOneAlpha = call.matches(".*[a-zA-Z]+.*");
                    if(atleastOneAlpha)Toast.makeText(context,"Phone number not found",Toast.LENGTH_SHORT).show();
                   else onCallClick(call);
                }
                if(childPosition==5)
                {
                    showServerLayout(TaskType);
                }
                return false;
            }
        });


        //  setupNavigationHeaderView(sessionManager.getUsername());

        //fabToggleTracking.setOnClickListener(this);
    }
    @Override
    public void showServerLayout(String taskType) {

        AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(this);
        LayoutInflater inflater = this.getLayoutInflater();
        final View dialogView = inflater.inflate(R.layout.send_status, null);

        dialogBuilder.setView(dialogView);
        LinearLayout checkboxholderlayout=(LinearLayout)dialogView.findViewById(R.id.checkboxholder);
        final LinearLayout lower=(LinearLayout)dialogView.findViewById(R.id.lowerlayout);

        if(TaskType.equals("PackagePickUp"))
            radioGroup=new RadioGroup(context);
            for(int i=0;i<Pickup.length;i++)
            {

                RadioButton checkBox=new RadioButton(context);

                checkBox.setTextColor(getResources().getColor(R.color.material_white));
                checkBox.setText(Pickup[i]);
             radioGroup.addView(checkBox,i);

            }
        checkboxholderlayout.addView(radioGroup);
        dialogBuilder.setPositiveButton("Done", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int whichButton) {
                //do something with edt.getText().toString();
            }
        });

        AlertDialog b = dialogBuilder.create();
        b.show();
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                                                  @Override
                                                  public void onCheckedChanged(RadioGroup group, int checkedId)
                                                  {
                                                      rd = (RadioButton) radioGroup.findViewById(checkedId);
                                                      if(rd.getText().equals("Failed"))
                                                      {
                                                          lower.setVisibility(View.VISIBLE);
                                                      }
                                                      else lower.setVisibility(View.GONE);
                                                  }
                                              }
        );
    }
    private void setupRecyclerView(Job_expandable_list_adapter jobAdapter) {

        jobView.setAdapter(jobAdapter);
    }
    private void setupToolbar() {
        setSupportActionBar(toolbar);
if(getSupportActionBar()!=null) {
    if (TaskType.equals("PackagePickUp")) getSupportActionBar().setTitle("পিক আপ");
    else getSupportActionBar().setTitle("ডেলিভারি");
}
    }
    @Override
    public void setJobModelList(List<JobModel> jobModelList) {
        job_expandable_list_adapter.setAdapterData(jobModelList);
        if(jobModelList.size()!=0)
        {  setupRecyclerView(job_expandable_list_adapter);

        }
    }

    @Override
    public void showConnectionError() {

    }
@Override
public void onBackPressed()
{
    super.onBackPressed();
}


    @Override
    public void onCallClick(String phoneNumber) {
        String totalp="tel:";
        totalp=totalp.concat(phoneNumber);
        Intent intent = new Intent(Intent.ACTION_DIAL);
        intent.setData(Uri.parse(totalp));
        startActivity(intent);
    }

    @Override
    public void onCallHQClick() {

    }
}