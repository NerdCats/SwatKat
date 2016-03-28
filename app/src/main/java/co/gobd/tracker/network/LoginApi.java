package co.gobd.tracker.network;

import co.gobd.tracker.config.ApiEndpoint;
import co.gobd.tracker.model.login.Login;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * Created by fahad on 28-Mar-16.
 */
public interface LoginApi {

    @FormUrlEncoded
    @POST(ApiEndpoint.PATH_SIGNIN)
    Call<Login> login(@Body Login Login);
}
