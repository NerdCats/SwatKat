package co.gobd.tracker.network;

import co.gobd.tracker.config.ApiEndpoint;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
//client_Id=  GoFetchDevDroidApp   &client_secret=   GoFetchDevDroidApp%40gobd

/**
 * Created by tonmoy on 27-Dec-15.
 */
public class RestClientPing {
    private TrackerApi trackerApi;

    public RestClientPing() {

        // To check request log
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

        OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
        httpClient.addInterceptor(interceptor);

        Retrofit client = new Retrofit.Builder()
                .baseUrl(ApiEndpoint.PATH_PING_BASE_URL)
                .client(httpClient.build())
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        trackerApi = client.create(TrackerApi.class);
    }


    public TrackerApi getTrackerApi() {
        return trackerApi;
    }
}
