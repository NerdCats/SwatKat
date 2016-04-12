package co.gobd.tracker.callback;

/**
 * Created by fahad on 29-Mar-16.
 */
public interface LoginCallback extends ConnectionCallback {

    void onLoginSuccess(String accessToken, String refreshToken, String bearer);
    void onLoginFailure();

}
