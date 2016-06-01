package co.gobd.tracker.service.account;

import co.gobd.tracker.callback.ConnectionCallback;

/**
 * Created by fahad on 29-Mar-16.
 */
public interface LoginCallback extends ConnectionCallback {

    void onLoginSuccess(String accessToken, String refreshToken, String bearer);
    void onLoginFailure();

}
