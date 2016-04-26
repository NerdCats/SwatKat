package co.gobd.tracker.network;

import co.gobd.tracker.config.BackendUrl;
import co.gobd.tracker.model.register.Register;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.POST;

/**
 * Created by fahad on 4/26/16.
 */
public interface RegisterApi {
    @POST(BackendUrl.TaskCat.GET_REGISTER)
    Call<Register> registerAsset(@Body Register register);
}