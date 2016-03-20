package co.gobd.tracker.network;

import co.gobd.tracker.config.ApiEndpoint;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by tonmoy on 27-Dec-15.
 */
public class RestClient {
    private TrackerApi trackerApi;

    public RestClient() {

        // To check request log
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BASIC);

        OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
        httpClient.addInterceptor(interceptor);

        Retrofit client = new Retrofit.Builder()
                .baseUrl(ApiEndpoint.BASE_URL)
                .client(httpClient.build())
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        trackerApi = client.create(TrackerApi.class);
    }


    public TrackerApi getTrackerApi() {
        return trackerApi;
    }
}
