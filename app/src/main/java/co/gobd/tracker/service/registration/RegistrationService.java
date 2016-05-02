package co.gobd.tracker.service.registration;

/**
 * Created by fahad on 4/26/16.
 */
public interface RegistrationService {
    void getRegistered(String userName, String password, String confirmPassword, String email,
                       String phoneNumber, final RegistrationCallback registrationCallback);
}
