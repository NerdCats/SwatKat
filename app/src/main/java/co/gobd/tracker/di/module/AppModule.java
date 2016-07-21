package co.gobd.tracker.di.module;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;

import javax.inject.Singleton;

import co.gobd.tracker.presenter.MainPresenter;
import co.gobd.tracker.service.job.JobService;
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
    public SessionManager providesSessionManager(SharedPreferences sharedPreferences) {
        return new SessionManagerImpl(sharedPreferences);
    }


}
