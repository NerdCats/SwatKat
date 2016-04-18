package co.gobd.tracker.service.authentication;

import co.gobd.tracker.callback.ConnectionCallback;

/**
 * Created by fahad on 29-Mar-16.
 */
public interface AuthenticationCallback extends ConnectionCallback {

    void onLoginSuccess(String accessToken, String refreshToken, String bearer);
    void onLoginFailure();

}
