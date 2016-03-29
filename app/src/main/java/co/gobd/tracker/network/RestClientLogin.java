package co.gobd.tracker.network;

import co.gobd.tracker.config.ApiEndpoint;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by fahad on 29-Mar-16.
 */
public class RestClientLogin {

    private LoginApi loginApi;

    public RestClientLogin() {
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

        OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
        httpClient.addInterceptor(interceptor);

        Retrofit client = new Retrofit.Builder()
                .baseUrl(ApiEndpoint.PATH_LOGIN_BASE_URL)
                .client(httpClient.build())
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        loginApi = client.create(LoginApi.class);
    }

    public LoginApi getLoginApi() { return loginApi; }
}
