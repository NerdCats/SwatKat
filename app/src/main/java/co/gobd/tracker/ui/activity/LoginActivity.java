package co.gobd.tracker.ui.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import javax.inject.Inject;

import co.gobd.tracker.R;
import co.gobd.tracker.application.GoAssetApplication;
import co.gobd.tracker.presenter.LoginPresenter;
import co.gobd.tracker.utility.ServiceUtility;
import co.gobd.tracker.utility.SessionManager;

public class LoginActivity extends AppCompatActivity {

    @Inject
    Context context;

    @Inject
    SessionManager sessionManager;

    @Inject
    LoginPresenter loginPresenter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ((GoAssetApplication) getApplication()).getComponent().inject(this);
        ServiceUtility.checkGooglePlayServices(context, this);

        // Toolbar setup
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(false);
        }

    }

}
