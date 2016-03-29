package co.gobd.tracker.service;

import android.util.Log;

import co.gobd.tracker.callback.LoginCallback;
import co.gobd.tracker.model.login.Login;
import co.gobd.tracker.network.LoginApi;
import co.gobd.tracker.network.RestClientLogin;
import co.gobd.tracker.utility.Constant;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


/**
 * Created by fahad on 28-Mar-16.
 */
public class LoginService {

    LoginCallback loginCallback;

    public LoginService(LoginCallback loginCallback) {

        this.loginCallback = loginCallback;
    }

    public void login(String uname, String pass) {

        LoginApi loginApi = new RestClientLogin().getLoginApi();

        Call<Login> call = loginApi.login(uname, pass, Constant.grantType, Constant.clientId, Constant.clientSecret);
        call.enqueue(new Callback<Login>() {
            @Override
            public void onResponse(Call<Login> call, Response<Login> response) {
                if(response.isSuccess()) {
                    Log.i("TOKEN", response.body().toString());
                }
            }

            @Override
            public void onFailure(Call<Login> call, Throwable t) {

            }
        });

    }


}
