package co.gobd.tracker.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import co.gobd.tracker.R;
import co.gobd.tracker.callback.LoginCallback;
import co.gobd.tracker.service.LoginService;

public class LoginActivity extends AppCompatActivity implements LoginCallback {

    private EditText unameText;
    private EditText upassText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }


    @Override
    public void onLoginSuccess(String accessToken) {

    }

    @Override
    public void onLoginFailure() {

    }

    public void onLoginButtonClick(View view){

        unameText = (EditText) findViewById(R.id.etUsername);
        String userName = unameText.getText().toString();

        upassText = (EditText) findViewById(R.id.etPassword);
        String password = upassText.getText().toString();

        LoginService loginService = new LoginService(this);
        loginService.login(userName, password);
    }
}
