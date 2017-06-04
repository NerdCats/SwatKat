package co.gobd.tracker.ui.activity;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ExpandableListView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.google.android.gms.maps.model.LatLng;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import co.gobd.tracker.R;
import co.gobd.tracker.adapter.Job_expandable_list_adapter;
import co.gobd.tracker.adapter.OnCallClickListener;
import co.gobd.tracker.application.GoAssetApplication;
import co.gobd.tracker.controller.RealmController;
import co.gobd.tracker.model.TagModel;
import co.gobd.tracker.model.TaskStatusv2;
import co.gobd.tracker.model.job.JobModel;
import co.gobd.tracker.model.tracker.LocationModel;
import co.gobd.tracker.presenter.TasksPresenter;
import co.gobd.tracker.ui.service.LocationService;
import co.gobd.tracker.ui.service.LocationServiceEvent;
import co.gobd.tracker.ui.view.TasksView;
import io.realm.Realm;
import io.realm.RealmQuery;
import io.realm.RealmResults;

public class TasksActivity extends AppCompatActivity implements TasksView,OnCallClickListener{
    @Inject
    TasksPresenter tasksPresenter;
    @Inject
    Context context;
    ProgressDialog progressDialog;
ArrayList<RealmResults<TaskStatusv2>> taskStatusArrayList=new ArrayList<>();
    @BindView(R.id.simple_expandable_listview)
    ExpandableListView jobView;
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    RadioGroup radioGroup;
    List<JobModel> jobModelsingle;
    Job_expandable_list_adapter job_expandable_list_adapter;
    private Unbinder unbinder;
    String TaskType, JobId,TaskId,TaskId2,TaskState,Status;
    RadioButton rd=null;
    TagModel tm;
    int position;
     ProgressDialog progress;
    TaskStatusv2 taskStatus;
    LatLng goBD;
    private Realm realm;
    String[]Pickup={ "COMPLETED"};
    private EventBus bus = EventBus.getDefault();
    String[]Delivery={ "COMPLETED","FAILED","RETURNED"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tasks);
        unbinder = ButterKnife.bind(this);
        ((GoAssetApplication) getApplication()).getComponent().inject(this);
        //  overViewPresenter.initialise(this);
        bus.register(this);
        TaskType=getIntent().getStringExtra("TaskType");
        this.realm = RealmController.with(this).getRealm();

        setupToolbar();
        job_expandable_list_adapter = new Job_expandable_list_adapter(context,TaskType);
        tasksPresenter.initialise(this);
        tasksPresenter.setInheritedTasktype(TaskType);
        tasksPresenter.loadAdapterData();



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
                tm= (TagModel)v.getTag();

                if(childPosition==1)
                {
                    onCallHQClick();
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

    public String getStatus() {
        return Status;
    }

    public void setStatus(String status) {
        Status = status;
    }

    @Override
    public void showServerLayout(String taskType) {



        AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(this);
        LayoutInflater inflater = this.getLayoutInflater();
        final View dialogView = inflater.inflate(R.layout.send_status, null);

        dialogBuilder.setView(dialogView);
        LinearLayout checkboxholderlayout=(LinearLayout)dialogView.findViewById(R.id.checkboxholder);
        final LinearLayout lower=(LinearLayout)dialogView.findViewById(R.id.lowerlayout);


            radioGroup=new RadioGroup(context);
        if(TaskType.equals("PackagePickUp")) {
            for (int i = 0; i < Pickup.length; i++) {

                RadioButton checkBox = new RadioButton(context);

                checkBox.setTextColor(getResources().getColor(R.color.material_white));
                checkBox.setText(Pickup[i]);
                radioGroup.addView(checkBox, i);

            }
        }
        else
        {
            taskStatus=RealmController.getInstance().getOneStatus(tm.getJobid());
            Boolean yes=  taskStatus.getState();
            if(yes.equals(false))Delivery  = new String[]{"COMPLETED", "FAILED"};
            for (int i = 0; i < Delivery.length; i++) {

                RadioButton checkBox = new RadioButton(context);

                checkBox.setTextColor(getResources().getColor(R.color.material_white));

                 checkBox.setText(Delivery[i]);
                radioGroup.addView(checkBox, i);

            }
        }
        checkboxholderlayout.addView(radioGroup);
        dialogBuilder.setPositiveButton("Done", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int whichButton) {
                //do something with edt.getText().toString();
                if(rd==null)
                {
                    Toast.makeText(context,"Select status first",Toast.LENGTH_SHORT).show();
                }
                else {
                    startLocationService();

                    position=tm.getPosition();
                   jobModelsingle=job_expandable_list_adapter.getAdapterData();
                    JobId=tm.getJobid();

                    String serverstring=getStatus();

                    if(serverstring.equals("RETURNED"))
                    {
                        RealmController.getInstance().Updaterow(tm.getJobid());
                    }

                }

            }
        });

        AlertDialog b = dialogBuilder.create();
        b.show();
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                                                  @Override
                                                  public void onCheckedChanged(RadioGroup group, int checkedId)
                                                  {
                                                      rd = (RadioButton) radioGroup.findViewById(checkedId);
                                                      setStatus(String.valueOf(rd.getText()));
                                                /*      if(rd.getText().equals("FAILED")||rd.getText().equals("RETURNED"))
                                                      {
                                                          lower.setVisibility(View.VISIBLE);
                                                      }
                                                      else lower.setVisibility(View.GONE);*/
                                                  }
                                              }
        );

    }
    private void startLocationService() {
        progress = new ProgressDialog(TasksActivity.this, R.style.AppTheme_Dark_Dialog);
        progress.setIndeterminate(true);
        progress.setMessage("Fetching Location... ");
        progress.show();
        Intent intent = new Intent(this, LocationServiceEvent.class);
        startService(intent);
    }

    private void stopLocationService() {
        progress.dismiss();
        Intent intent = new Intent(this, LocationServiceEvent.class);
        stopService(intent);
    }
    @Subscribe
    public void onEvent(LocationModel event){
         goBD=new LatLng(event.getLat(),event.getLon());
        //  CameraUpdate cameraUpdate = CameraUpdateFactory.newLatLngZoom(goBD, 16);
        //  mMap.addMarker(new MarkerOptions().position(goBD).title("Marker in GoBD"));
        Log.d("Location: ", "Latitude: " + event.getLat() + "Longitude:" + event.getLon());

      //  Toast.makeText(TasksActivity.this,"Location:  56Latitude: " + event.getLat() + "Longitude:" + event.getLon(),Toast.LENGTH_SHORT).show();
        stopLocationService();

        //mMap.animateCamera(cameraUpdate);
        tasksPresenter.updateTaskStateToCompleted(JobId,goBD.latitude,goBD.longitude,tm.getTask(), getStatus());
    }
    public void AdddatatoStatus(List<JobModel>jobModelList)
    {
        ArrayList<TaskStatusv2>taskStatuses=new ArrayList<>();
        //int currentSize=RealmController.getInstance().getAllStatus().size();
        //int finalSize=currentSize+jobModelList.size();
        for( int i=0;i<jobModelList.size();i++)
        {
            TaskStatusv2 taskStatus=new TaskStatusv2();
            if(RealmController.getInstance().checkIfExists(jobModelList.get(i).getId()))continue;
           else taskStatus.setTaskId(jobModelList.get(i).getId());//storing common job id

            taskStatuses.add(taskStatus);
        }


        for ( TaskStatusv2 taskStatus1: taskStatuses) {// Persist your data easily
            realm.beginTransaction();



    realm.copyToRealmOrUpdate(taskStatus1);

            realm.commitTransaction();
        }

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
    public void showTaskUpdateSuccessfulMsg() {
        Toast.makeText(context, R.string.msg_task_update_successful, Toast.LENGTH_SHORT).show();

    }
    @Override
    public void setJobModelList(List<JobModel> jobModelList) {
        job_expandable_list_adapter.setAdapterData(jobModelList);
        if(jobModelList.size()!=0)
        {
            if(!TaskType.equals("PackagePickUp"))
            {
                AdddatatoStatus(jobModelList);
            }

          setupRecyclerView(job_expandable_list_adapter);

        }
        else {
            showEmpty();
        }
    }

    @Override
    public void showConnectionError() {
Toast.makeText(getApplicationContext(),"Please try again",Toast.LENGTH_SHORT
).show();
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
    public void startProgress() {
        progressDialog = new ProgressDialog(TasksActivity.this, R.style.AppTheme_Dark_Dialog);
        progressDialog.setIndeterminate(true);
        progressDialog.setMessage("Downloading Jobs... ");
        progressDialog.show();
    }
    @Override
    public void stopProgress() {
        progressDialog.dismiss();

    }
    @Override
    public void showEmpty() {
       Toast.makeText(getApplicationContext(),"No jobs available for you this time!",Toast.LENGTH_SHORT).show();
    }
    @Override
    public void stopProgresswithmessage() {
        progressDialog.dismiss();
        Toast.makeText(getApplicationContext(),"Please try again",Toast.LENGTH_SHORT).show();
    }
    @Override
    public void onCallHQClick() {
        Intent intent = new Intent(Intent.ACTION_DIAL);
        intent.setData(Uri.parse("tel:01735952047"));
        startActivity(intent);
    }
    @Override
    public void showTaskUpdateError() {
        Toast.makeText(context, R.string.msg_task_update_error, Toast.LENGTH_SHORT).show();
    }

}