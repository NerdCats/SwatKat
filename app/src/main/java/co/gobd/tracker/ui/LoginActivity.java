package co.gobd.tracker.ui;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import android.app.ProgressDialog;

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


    }


    @Override
    public void onLoginSuccess() {

        String bearer = SessionManager.getBearer(context);
        TokenService tokenService = new TokenService(this);
        tokenService.getAssetId(bearer, context);

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
        loginService.login(userName, password, context);
        loadingCircle = new ProgressDialog(view.getContext());
        loadingCircle.setCancelable(true);
        loadingCircle.setMessage(Constant.message);
        loadingCircle.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        loadingCircle.show();
    }

    @Override
    public void onTokenSucces() {

        loadingCircle.dismiss();
        Toast.makeText(getApplicationContext(), "Login Successful!", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();

    }

    @Override
    public void onTokenFailure() {

    }
}
