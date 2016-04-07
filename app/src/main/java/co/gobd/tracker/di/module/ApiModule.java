package co.gobd.tracker.di.module;

import javax.inject.Singleton;

import co.gobd.tracker.config.ApiEndpoint;
import co.gobd.tracker.network.TrackerApi;
import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by tonmoy on 07-Apr-16.
 */
@Module
public class ApiModule {

    @Provides
    @Singleton
    public TrackerApi providesTrackerApi(Retrofit retrofit) {
        return retrofit.create(TrackerApi.class);
    }

    @Provides
    @Singleton
    public Retrofit providesRetrofit() {
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

        return client;
    }
}
