package co.gobd.tracker.network;

import co.gobd.tracker.config.ApiEndpoint;
import co.gobd.tracker.model.login.AccessToken;
import co.gobd.tracker.model.user.User;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;

/**
 * Created by fahad on 28-Mar-16.
 */
public interface LoginApi {

    @FormUrlEncoded
    @POST(ApiEndpoint.PATH_LOGIN)
    Call<AccessToken> login(@Field("userName") String userName, @Field("password") String password,
                            @Field("grant_type") String grantType, @Field("client_Id") String clientId,
                            @Field("client_secret") String clientSecret);

    @GET(ApiEndpoint.PATH_ACCESS_TOKEN)
    Call<User> sendToken(@Header("Authorization") String token);

}