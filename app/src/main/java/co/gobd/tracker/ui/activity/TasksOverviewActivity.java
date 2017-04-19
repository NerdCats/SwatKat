package co.gobd.tracker.ui.activity;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import co.gobd.tracker.R;
import co.gobd.tracker.adapter.JobAdapter;
import co.gobd.tracker.application.GoAssetApplication;
import co.gobd.tracker.ui.view.TasksoverView;
import co.gobd.tracker.utility.SessionManager;

/**
 * Created by Mr. Maps on 4/17/2017.
 */

public class TasksOverviewActivity extends AppCompatActivity implements TasksoverView, NavigationView.OnNavigationItemSelectedListener {

    @Inject
    Context context;
    @Inject
    SessionManager sessionManager;

    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.drawer_layout)
    DrawerLayout drawerLayout;
    @BindView(R.id.pickuplayout)
    LinearLayout PickUp;
    @BindView(R.id.deliverylayout)
    LinearLayout Delivery;
    @BindView(R.id.expresslayout)
    LinearLayout Express;
    @BindView(R.id.navigation_view)
    NavigationView navigationView;


    private ActionBarDrawerToggle drawerToggle;
    private Unbinder unbinder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        unbinder = ButterKnife.bind(this);
        ((GoAssetApplication) getApplication()).getComponent().inject(this);
       //  overViewPresenter.initialise(this);
        setupToolbar();

        setupNavigationDrawer();


        setupNavigationHeaderView(sessionManager.getUsername());
        navigationView.setNavigationItemSelectedListener(this);
    }
    private void setupNavigationHeaderView(String assetName) {
        View headerLayout = navigationView.getHeaderView(0);
        TextView tvAssetName = ButterKnife.findById(headerLayout, R.id.nav_header_asset_name);
        tvAssetName.setText(assetName);
    }
   @OnClick({R.id.pickuplayout, R.id.deliverylayout,R.id.expresslayout})
    public void onClick(View v){
        switch (v.getId()){
            case R.id.pickuplayout:
                startTaskActivity("PackagePickUp");
                //Toast.makeText(this,"Pick",Toast.LENGTH_SHORT).show();
                break;
            case R.id.deliverylayout:
                startTaskActivity("Delivery");

                break;
            case R.id.expresslayout:
                Toast.makeText(this,"Express",Toast.LENGTH_SHORT).show();
                break;
        }
    }
    private void setupToolbar() {
        setSupportActionBar(toolbar);
       if(getSupportActionBar()!=null) {
           getSupportActionBar().setDisplayHomeAsUpEnabled(true);
           getSupportActionBar().setHomeButtonEnabled(true);
           getSupportActionBar().setTitle("GO! Asset App");
            }
       }
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {

        if (item.isChecked()) {
            item.setChecked(false);
        } else {
            item.setChecked(true);
        }

        setTitle(item.getTitle());
        drawerLayout.closeDrawers();

        switch (item.getItemId()) {
            case R.id.nav_logout:
                logout();
                break;
            /*case R.id.nav_about:
                //TODO: Use About Libraries for hassle free about page
                // https://github.com/mikepenz/AboutLibraries
                break;*/
        }


        return true;
    }

    private void logout() {

        sessionManager.clearAll();
        startLoginActivity();
    }
    private void startLoginActivity() {
        Intent intent = new Intent(this, LoginActivity.class);
        startActivity(intent);
        finish();
    }
    private void setupNavigationDrawer() {
        drawerToggle = setupDrawerToggle();
        // Tie DrawerLayout events to the ActionBarToggle
        drawerLayout.addDrawerListener(drawerToggle);
    }
    private ActionBarDrawerToggle setupDrawerToggle() {
        return new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.drawer_open,
                R.string.drawer_close);
    }









    @Override
    public void startTaskActivity(String task) {

        Intent intent = new Intent(this, TasksActivity.class);
        intent.putExtra("TaskType",task);
        startActivity(intent);
        //finish();
    }
}