package co.gobd.tracker.callback;

import co.gobd.tracker.model.login.AccessToken;

/**
 * Created by fahad on 29-Mar-16.
 */
public interface LoginCallback {

    void onLoginSuccess(String clientId);
    void onLoginFailure();

}
