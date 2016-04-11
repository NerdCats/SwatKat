package co.gobd.tracker.application;

import android.app.Application;

import co.gobd.tracker.di.component.AppComponent;
import co.gobd.tracker.di.component.DaggerAppComponent;
import co.gobd.tracker.di.module.ApiModule;
import co.gobd.tracker.di.module.AppModule;

/**
 * Created by tonmoy on 11-Apr-16.
 */
public class GoAssetApplication extends Application {

    private AppComponent component;

    @Override
    public void onCreate() {
        super.onCreate();

        component = DaggerAppComponent.builder()
                .appModule(new AppModule(this))
                .apiModule(new ApiModule())
                .build();

    }

    public AppComponent getComponent() {
        return component;
    }
}
