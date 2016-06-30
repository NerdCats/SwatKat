package co.gobd.tracker.service.account;

import co.gobd.tracker.model.login.AccessToken;
import co.gobd.tracker.model.register.Register;
import co.gobd.tracker.model.user.User;
import co.gobd.tracker.network.AccountApi;
import co.gobd.tracker.utility.Constant;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by tonmoy on 12-Apr-16.
 */
public class AccountServiceImpl implements AccountService {

    // Constructed by Dagger
    private AccountApi accountApi;

    public AccountServiceImpl(AccountApi api) {
        this.accountApi = api;
    }

    @Override
    public void getRegistered(String userName, String password, String confirmPassword,
                              String email, String phoneNumber,
                              final RegistrationCallback registrationCallback) {

        // Creates POJO
        Register register = this.createRegisterModel(userName, password, confirmPassword, email, phoneNumber);

        Call<Void> call = accountApi.registerAsset(register);

        call.enqueue(new Callback<Void>() {
            @Override
            public void onResponse(Call<Void> call, Response<Void> response) {
                if (response.isSuccess()) {
                    registrationCallback.onRegistrationSuccess();
                } else {
                    registrationCallback.onRegistrationFailure();
                }
            }

            @Override
            public void onFailure(Call<Void> call, Throwable t) {
                registrationCallback.onConnectionError();
            }
        });

    }

    /**
     * Logs an asset in taskCat
     */
    @Override
    public void login(String userName, String password, final LoginCallback callback) {

        Call<AccessToken> call = accountApi.login(userName, password,
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
        Call<User> call = accountApi.getUserProfile(bearer);
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

    private Register createRegisterModel(String userName, String password,
                                         String confirmPassword,
                                         String email, String phoneNumber) {

        Register register = new Register(userName, password, confirmPassword, email, phoneNumber);

        return register;

    }
}
