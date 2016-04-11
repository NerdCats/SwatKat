package co.gobd.tracker.service;

import android.content.Context;
import android.util.Log;

import co.gobd.tracker.callback.LoginCallback;
import co.gobd.tracker.config.ApiEndpoint;
import co.gobd.tracker.model.login.AccessToken;
import co.gobd.tracker.model.user.User;
import co.gobd.tracker.network.AuthApi;
import co.gobd.tracker.network.AuthClient;
import co.gobd.tracker.utility.Constant;
import co.gobd.tracker.utility.SessionManager;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


/**
 * Created by fahad on 28-Mar-16.
 */

public class LoginService {

    private static final String TAG = "LoginService";
    LoginCallback loginCallback;


    public LoginService(LoginCallback loginCallback) {

        this.loginCallback = loginCallback;
    }

    public void login(String uname, String pass) {

        final AuthApi authApi = new AuthClient().getApi(ApiEndpoint.PATH_LOGIN_BASE_URL,
                AuthApi.class);

        Call<AccessToken> call = authApi.login(uname, pass, Constant.grantType, Constant.clientId,
                Constant.clientSecret);
        call.enqueue(new Callback<AccessToken>() {
            @Override
            public void onResponse(Call<AccessToken> call, Response<AccessToken> response) {
                if (response.isSuccess()) {
                    try {
                        String accessToken = response.body().getAccessToken();
                        String bearer = "bearer "+accessToken;
                        String refreshToken = response.body().getRefreshToken();

                        loginCallback.onLoginSuccess(accessToken, refreshToken, bearer);

                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                } else {
                    loginCallback.onLoginFailure();
                }
            }
            @Override
            public void onFailure(Call<AccessToken> call, Throwable t) {

            }
        });

    }


}
