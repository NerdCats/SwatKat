package co.gobd.tracker.service;

import co.gobd.tracker.callback.LoginCallback;
import co.gobd.tracker.callback.ProfileCallback;

/**
 * Created by tonmoy on 12-Apr-16.
 */
public interface AuthenticationService {
    void login(String userName, String password, LoginCallback callback);
    void getAssetProfile(String bearer, ProfileCallback callback);
}
