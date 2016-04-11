package co.gobd.tracker.service;

import android.content.Context;

import co.gobd.tracker.callback.TokenCallback;
import co.gobd.tracker.config.ApiEndpoint;
import co.gobd.tracker.model.user.User;
import co.gobd.tracker.network.AuthApi;
import co.gobd.tracker.network.AuthClient;
import co.gobd.tracker.utility.SessionManager;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by fahad on 10-Apr-16.
 */
public class TokenService {

    TokenCallback tokenCallback;

    public TokenService(TokenCallback tokenCallback){
        this.tokenCallback = tokenCallback;
    }

    public void getAssetId(String bearer){
        final AuthApi authApi = AuthClient.getApi(ApiEndpoint.PATH_LOGIN_BASE_URL, AuthApi.class);

        Call<User> call = authApi.sendToken(bearer);
        call.enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                if (response.isSuccess()){
                    try{

                        String assetId = response.body().getId();
                        if (assetId!= null) {
                            tokenCallback.onTokenSucces(assetId);
                        }



                    }catch(Exception e) {
                        e.printStackTrace();
                    }
                }
            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {

            }
        });
    }


}
