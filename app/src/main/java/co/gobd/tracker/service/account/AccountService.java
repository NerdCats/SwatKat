package co.gobd.tracker.service.account;

/**
 * Created by tonmoy on 12-Apr-16.
 */
public interface AccountService {
    void getRegistered(String userName, String password, String confirmPassword, String email,
                       String phoneNumber, final RegistrationCallback registrationCallback);
    void login(String userName, String password, AuthenticationCallback callback);
    void getAssetProfile(String bearer, ProfileCallback callback);
}
