package co.gobd.tracker.service.authentication;

import co.gobd.tracker.callback.ProfileCallback;

/**
 * Created by tonmoy on 12-Apr-16.
 */
public interface AuthenticationService {
    void login(String userName, String password, AuthenticationCallback callback);
    void getAssetProfile(String bearer, ProfileCallback callback);
}
