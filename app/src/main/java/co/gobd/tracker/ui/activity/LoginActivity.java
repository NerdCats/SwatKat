package co.gobd.tracker.ui.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import javax.inject.Inject;

import co.gobd.tracker.R;
import co.gobd.tracker.application.GoAssetApplication;
import co.gobd.tracker.service.authentication.AuthenticationCallback;
import co.gobd.tracker.callback.ProfileCallback;
import co.gobd.tracker.service.authentication.AuthenticationService;
import co.gobd.tracker.utility.SessionManager;

public class LoginActivity extends AppCompatActivity {

    @Inject
    AuthenticationService authService;
    @Inject
    Context context;

    @Inject
    SessionManager sessionManager;

    private EditText userNameText;
    private EditText passwordText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        
        ((GoAssetApplication) getApplication()).getComponent().inject(this);

        setupUi();

        String assetId = sessionManager.getAssetId();
        if (assetId != "default_asset_id") {
            startMainActivity();
        }
    }

    private void setupUi() {
        userNameText = (EditText) findViewById(R.id.etUsername);
        passwordText = (EditText) findViewById(R.id.etPassword);
    }

    /**
     * Saves the asset's information in SharedPreference
     */
    private void saveSessionData(String accessToken, String refreshToken, String bearer,
                                 String userName, String password) {
        sessionManager.setUsername(userName);
        sessionManager.setPassword(password);
        sessionManager.setToken(accessToken);
        sessionManager.setBearer(bearer);
        sessionManager.setRefreshToken(refreshToken);
    }


    public void onLoginButtonClick(View view) {
        final String userName = userNameText.getText().toString();
        final String password = passwordText.getText().toString();


        authService.login(userName, password, new AuthenticationCallback() {
            @Override
            public void onLoginSuccess(String accessToken, String refreshToken, String bearer) {
                saveSessionData(accessToken, refreshToken, bearer, userName, password);

                // Asset needs to be authenticated to continue
                // If token is received, then asset is authenticated
                authService.getAssetProfile(bearer, new ProfileCallback() {
                    @Override
                    public void onLoadProfileSuccess(String assetId) {
                        // Saves the asset id into shared preference
                        sessionManager.setAssetId(assetId);
                        startMainActivity();
                    }

                    @Override
                    public void onLoadProfileFailure() {

                        Toast.makeText(context, R.string.message_profile_data_unavailable, Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onConnectionError() {

                        Toast.makeText(context, R.string.message_auth_failed, Toast.LENGTH_SHORT).show();
                    }
                });

            }

            @Override
            public void onLoginFailure() {

                Toast.makeText(context, R.string.message_auth_failed, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onConnectionError() {

                Toast.makeText(context, R.string.message_connection_error, Toast.LENGTH_SHORT).show();

            }
        });

    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    private void startMainActivity() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();
    }

}
