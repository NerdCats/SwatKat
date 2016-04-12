package co.gobd.tracker.callback;

/**
 * Created by fahad on 29-Mar-16.
 */
public interface LoginCallback {

    void onLoginSuccess(String accessToken, String refreshToken, String bearer);
    void onLoginFailure();

}
