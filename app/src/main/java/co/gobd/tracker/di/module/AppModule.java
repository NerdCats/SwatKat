package co.gobd.tracker.di.module;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import javax.inject.Named;
import javax.inject.Singleton;

import co.gobd.tracker.service.TrackerService;
import co.gobd.tracker.service.TrackerServiceImpl;
import co.gobd.tracker.utility.Constant;
import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;

/**
 * Created by tonmoy on 11-Apr-16.
 */
@Module
public class AppModule {

    private Application application;

    public AppModule(Application application) {
        this.application = application;
    }

    @Provides
    @Singleton
    public Context providesContext() {
        return application;
    }

    @Provides
    @Singleton
    public SharedPreferences providesSharedPreferences(Context context) {
        return PreferenceManager.getDefaultSharedPreferences(context);
    }

    @Provides
    @Singleton
    public TrackerService providesTrackerService(@Named(Constant.BackendName.SHADOW_CAT) Retrofit retrofit) {
        return new TrackerServiceImpl(retrofit);
    }


}
