package co.gobd.tracker.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import co.gobd.tracker.R;
import co.gobd.tracker.callback.LoginCallback;
import co.gobd.tracker.service.LoginService;
import co.gobd.tracker.utility.Constant;

public class LoginActivity extends AppCompatActivity implements LoginCallback {

    private EditText unameText;
    private EditText upassText;
    Intent Save;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Save = new Intent(this, MainActivity.class);
    }


    @Override
    public void onLoginSuccess(String clientId) {

        Toast.makeText(getApplicationContext(), "Login Successful!", Toast.LENGTH_SHORT).show();
        Save.putExtra(Constant.KEY_CLIENT_ID, clientId);
        startActivity(Save);
        finish();

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
    }
}
