package co.gobd.tracker.network;

import co.gobd.tracker.config.ApiEndpoint;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by fahad on 29-Mar-16.
 */
public class AuthClient {

    public static <T> T getApi(String baseUrl, final Class<T> apiClass) {

        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

        OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
        httpClient.addInterceptor(interceptor);

        Retrofit client = new Retrofit.Builder()
                .baseUrl(baseUrl)
                .client(httpClient.build())
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        T api = client.create(apiClass);

        return api;
    }
}
