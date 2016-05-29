package co.gobd.tracker.di.component;

import javax.inject.Singleton;

import co.gobd.tracker.application.GoAssetApplication;
import co.gobd.tracker.di.module.ApiModule;
import co.gobd.tracker.di.module.AppModule;
import co.gobd.tracker.di.module.ServiceModule;
import co.gobd.tracker.ui.activity.JobActivity;
import co.gobd.tracker.ui.activity.MainActivity;
import co.gobd.tracker.ui.activity.SignUpActivity;
import co.gobd.tracker.ui.service.LocationService;
import co.gobd.tracker.ui.activity.LoginActivity;
import dagger.Component;

/**
 * Created by tonmoy on 07-Apr-16.
 */

@Singleton
@Component(modules = {ApiModule.class, AppModule.class, ServiceModule.class})
public interface AppComponent {
    void inject(GoAssetApplication target);
    void inject(LocationService target);
    void inject(LoginActivity target);
    void inject(JobActivity target);
    void inject(MainActivity target);
    void inject(SignUpActivity target);
}
