package co.gobd.tracker.service.authentication;

import co.gobd.tracker.callback.ProfileCallback;
import co.gobd.tracker.model.login.AccessToken;
import co.gobd.tracker.model.user.User;
import co.gobd.tracker.network.AuthenticationApi;
import co.gobd.tracker.utility.Constant;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by tonmoy on 12-Apr-16.
 */
public class AuthenticationServiceImpl implements AuthenticationService {

    // Constructed by Dagger
    private AuthenticationApi authenticationApi;

    public AuthenticationServiceImpl(AuthenticationApi api) {
        this.authenticationApi = api;
    }

    /**
     * Logs an asset in taskCat
     */
    @Override
    public void login(String userName, String password, final AuthenticationCallback callback) {

        Call<AccessToken> call = authenticationApi.login(userName, password,
                Constant.Login.grantType,
                Constant.Login.clientId,
                Constant.Login.clientSecret);

        call.enqueue(new Callback<AccessToken>() {
            @Override
            public void onResponse(Call<AccessToken> call, Response<AccessToken> response) {
                if (response.isSuccess()) {
                    try {
                        String accessToken = response.body().getAccessToken();

                        // Authorization header for the request
                        String bearer = "bearer " + accessToken;

                        String refreshToken = response.body().getRefreshToken();
                        callback.onLoginSuccess(accessToken, refreshToken, bearer);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                } else {
                    callback.onLoginFailure();
                }
            }

            @Override
            public void onFailure(Call<AccessToken> call, Throwable t) {
                callback.onConnectionError();
            }
        });
    }

    @Override
    public void getAssetProfile(String bearer, final ProfileCallback callback) {
        Call<User> call = authenticationApi.getUserProfile(bearer);
        call.enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                if (response.isSuccess()) {
                    try {
                        String assetId = response.body().getId();
                        if (assetId != null) {
                            callback.onLoadProfileSuccess(assetId);
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                } else {
                    callback.onLoadProfileFailure();
                }
            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {
                callback.onConnectionError();
            }
        });

    }
}
