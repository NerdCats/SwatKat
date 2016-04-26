package co.gobd.tracker.service.registration;

import co.gobd.tracker.model.register.Register;
import co.gobd.tracker.network.RegisterApi;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by fahad on 4/26/16.
 */
public class RegistrationServiceImpl implements RegistrationService {

    private RegisterApi registerApi;

    //Constructed by Dagger
    public RegistrationServiceImpl(RegisterApi registerApi){
        this.registerApi = registerApi;
    }

    @Override
    public void getRegistered(String userName, String password, String confirmPassword,
                              String email, String phoneNumber,
                              final RegistrationCallback registrationCallback) {

        // Creates POJO
        Register register = this.createRegisterModel(userName, password, confirmPassword, email, phoneNumber);

        Call<Void> call = registerApi.registerAsset(register);

        call.enqueue(new Callback<Void>() {
            @Override
            public void onResponse(Call<Void> call, Response<Void> response) {
                if (response.isSuccess()){
                    registrationCallback.onRegistrationSuccess();
                } else {
                    registrationCallback.onRegistrationFailure();
                }
            }

            @Override
            public void onFailure(Call<Void> call, Throwable t) {

            }
        });

    }

    private Register createRegisterModel(String userName, String password,
                                         String confirmPassword,
                                         String email, String phoneNumber){

        Register register = new Register(userName, password, confirmPassword, email, phoneNumber);

        return register;

    }
}
