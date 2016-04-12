package co.gobd.tracker.ui;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import co.gobd.tracker.R;
import co.gobd.tracker.callback.LoginCallback;
import co.gobd.tracker.callback.TokenCallback;
import co.gobd.tracker.service.LoginService;
import co.gobd.tracker.service.TokenService;
import co.gobd.tracker.utility.Constant;
import co.gobd.tracker.utility.SessionManager;

public class LoginActivity extends AppCompatActivity implements LoginCallback, TokenCallback {

    private EditText unameText;
    private EditText upassText;
    ProgressDialog loadingCircle = null;

    Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        context = getApplicationContext();

        String assetId = SessionManager.getAssetId(context);
        if(assetId!="default_asset_id"){
            Intent intent = new Intent(LoginActivity.this, MainActivity.class);
            startActivity(intent);
            finish();
        }
    }


    @Override
    public void onLoginSuccess(String accessToken, String refreshToken, String bearer) {

        unameText = (EditText) findViewById(R.id.etUsername);
        String userName = unameText.getText().toString();

        upassText = (EditText) findViewById(R.id.etPassword);
        String password = upassText.getText().toString();

        SessionManager.setUsername(context, userName);
        SessionManager.setPassword(context, password);
        SessionManager.setToken(context, accessToken);
        SessionManager.setBearer(context, bearer);
        SessionManager.setRefreshToken(context, refreshToken);

        TokenService tokenService = new TokenService(this);
        tokenService.getAssetId(bearer);

    }

    @Override
    public void onLoginFailure() {

        Toast.makeText(getApplicationContext(), "Login Failed!", Toast.LENGTH_SHORT).show();

    }

    public void onLoginButtonClick(View view) {

        unameText = (EditText) findViewById(R.id.etUsername);
        String userName = unameText.getText().toString();

        upassText = (EditText) findViewById(R.id.etPassword);
        String password = upassText.getText().toString();

        LoginService loginService = new LoginService(this);
        loginService.login(userName, password);
        loadingCircle = new ProgressDialog(view.getContext());
        loadingCircle.setCancelable(true);
        loadingCircle.setMessage(Constant.message);
        loadingCircle.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        loadingCircle.show();
    }

    @Override
    public void onTokenSucces(String assetId) {

        loadingCircle.dismiss();
        Toast.makeText(getApplicationContext(), "Login Successful!", Toast.LENGTH_SHORT).show();
        SessionManager.setAssetId(context, assetId);
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();

    }

    @Override
    public void onTokenFailure() {

        Toast.makeText(getApplicationContext(), "Login Failed!", Toast.LENGTH_SHORT).show();

    }
}
