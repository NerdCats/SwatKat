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

    void showConnectionError();

    void showLoginError();

    void showPasswordLengthError();

    void showUserNameEmptyError();

    void showPasswordEmptyError();
}
