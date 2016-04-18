package co.gobd.tracker.di.module;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import javax.inject.Singleton;

import co.gobd.tracker.network.AuthenticationApi;
import co.gobd.tracker.network.TrackerApi;
import co.gobd.tracker.service.AuthenticationService;
import co.gobd.tracker.service.AuthenticationServiceImpl;
import co.gobd.tracker.service.TrackerService;
import co.gobd.tracker.service.TrackerServiceImpl;
import co.gobd.tracker.utility.Constant;
import co.gobd.tracker.utility.SessionManager;
import co.gobd.tracker.utility.SessionManagerImpl;
import dagger.Module;
import dagger.Provides;

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
        return context.getSharedPreferences(Constant.SharedPrefs.KEY_PREFERENCE_NAME, Context.MODE_PRIVATE);
    }

    @Provides
    @Singleton
    public TrackerService providesTrackerService(TrackerApi trackerApi) {
        return new TrackerServiceImpl(trackerApi);
    }

    @Provides
    @Singleton
    public AuthenticationService providesAuthenticationService(AuthenticationApi authenticationApi) {
        return new AuthenticationServiceImpl(authenticationApi);
    }

    @Provides
    @Singleton
    public SessionManager providesSessionManager(Context context, SharedPreferences sharedPreferences){
        return new SessionManagerImpl(context, sharedPreferences);
    }


}
