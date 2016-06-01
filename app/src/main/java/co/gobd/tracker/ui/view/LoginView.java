package co.gobd.tracker.ui.view;

/* Created by fahad on 5/29/2016.
*/
public interface LoginView {

    String getUserName();

    String getPassword();

    void showUserNameError();

    void showPasswordError();

    void startProgress();

    void stopProgress();

    void startSignUpActivity();

    void startMainActivity();

    void showConnectionError();

    void showLoginError();

    void showPasswordLengthError();

    void showUserNameEmptyError();

    void showPasswordEmptyError();

    void saveAssetInformation(String assetId, String accessToken, String refreshToken, String bearer);

    void showProfileLoadError();
}
