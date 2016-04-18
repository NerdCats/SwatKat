package co.gobd.tracker.di.component;

import javax.inject.Singleton;

import co.gobd.tracker.application.GoAssetApplication;
import co.gobd.tracker.di.module.ApiModule;
import co.gobd.tracker.di.module.AppModule;
import co.gobd.tracker.service.location.LocationService;
import co.gobd.tracker.ui.LoginActivity;
import dagger.Component;

/**
 * Created by tonmoy on 07-Apr-16.
 */

@Singleton
@Component(modules = {ApiModule.class, AppModule.class})
public interface AppComponent {
    void inject(GoAssetApplication target);
    void inject(LocationService target);
    void inject(LoginActivity target);
}
