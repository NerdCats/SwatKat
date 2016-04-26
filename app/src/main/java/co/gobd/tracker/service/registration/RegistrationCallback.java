package co.gobd.tracker.service.registration;

import co.gobd.tracker.callback.ConnectionCallback;

/**
 * Created by fahad on 4/26/16.
 */
public interface RegistrationCallback extends ConnectionCallback{

    public void onRegistrationSuccess();
    public void onRegistrationFailure();
}