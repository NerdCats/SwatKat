package co.gobd.tracker.ui.activity;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import co.gobd.tracker.R;
import co.gobd.tracker.application.GoAssetApplication;
import co.gobd.tracker.presenter.LoginPresenter;
import co.gobd.tracker.ui.view.LoginView;
import co.gobd.tracker.utility.SessionManager;

public class LoginActivity extends AppCompatActivity implements LoginView {

    @Inject
    Context context;

    @Inject
    SessionManager sessionManager;

    @Inject
    LoginPresenter loginPresenter;

    @BindView(R.id.et_username)
    EditText etUserName;

    @BindView(R.id.et_password)
    EditText etPassword;

    @BindView(R.id.btn_sign_in)
    Button btnSignIn;

    @BindView(R.id.tv_signup)
    TextView tvSignUp;

    private Unbinder unbinder;

    ProgressDialog progressDialog;

    @Override
    protected void onDestroy(){
        super.onDestroy();
        loginPresenter.onDestroy();
        unbinder.unbind();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        unbinder = ButterKnife.bind(this);
        ((GoAssetApplication) getApplication()).getComponent().inject(this);
        loginPresenter.initialise(this);

        String assetId = sessionManager.getAssetId();
        if (assetId != "default_asset_id") {
            startMainActivity();
        }
    }

    @OnClick({R.id.btn_sign_in, R.id.tv_signup})
    public void onClick(View v){
        switch (v.getId()){
            case R.id.btn_sign_in:
                if(loginPresenter.isValidCredentials()){
                    loginPresenter.login();
                }
                break;
            case R.id.tv_signup:
                startSignUpActivity();
                break;
        }
    }

    @Override
    public String getUserName() {
        return etUserName.getText().toString();
    }

    @Override
    public String getPassword() {
        return etPassword.getText().toString();
    }

    @Override
    public void showUserNameError() {
        etUserName.setError("Username or Password didn't match");
    }

    @Override
    public void showPasswordError() {
        etPassword.setError("Username or Password didn't match");
    }

    @Override
    public void startProgress() {
        progressDialog = new ProgressDialog(this, R.style.AppTheme_Dark_Dialog);
        progressDialog.setIndeterminate(true);
        progressDialog.setMessage("Authenticating... ");
        progressDialog.show();
    }

    @Override
    public void stopProgress() {
        progressDialog.dismiss();
    }

    @Override
    public void startSignUpActivity() {
        Intent intent = new Intent(this, SignUpActivity.class);
        startActivity(intent);
    }

    @Override
    public void startMainActivity() {
        //Intent intent = new Intent(this, MainActivity.class);
        //startActivity(intent);
    }

    @Override
    public void showConnectionError() {
        Toast.makeText(context, "Can't connect to the server", Toast.LENGTH_SHORT).show();

    }

    @Override
    public void showLoginError() {
        Toast.makeText(context, "Can't log in, try again?", Toast.LENGTH_SHORT).show();

    }

    @Override
    public void showPasswordLengthError() {
        Toast.makeText(context,"Password must be at least 6 characters long",Toast.LENGTH_SHORT).show();

    }

    @Override
    public void showUserNameEmptyError() {
        Toast.makeText(context,"Username can't be empty",Toast.LENGTH_SHORT).show();

    }

    @Override
    public void showPasswordEmptyError() {
        Toast.makeText(context,"Password can't be empty",Toast.LENGTH_SHORT).show();

    }

    @Override
    public void saveAssetInformation(String assetId, String accessToken, String refreshToken, String bearer) {
        sessionManager.setAssetId(assetId);
        sessionManager.setToken(accessToken);
        sessionManager.setRefreshToken(refreshToken);
        sessionManager.setBearer(bearer);
    }

    @Override
    public void showProfileLoadError() {
        Toast.makeText(context,"Something went wrong, try again?",Toast.LENGTH_SHORT).show();
    }
}
