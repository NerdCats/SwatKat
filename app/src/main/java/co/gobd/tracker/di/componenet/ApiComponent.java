package co.gobd.tracker.di.componenet;

import javax.inject.Singleton;

import co.gobd.tracker.di.module.ApiModule;
import co.gobd.tracker.service.TrackerService;
import dagger.Component;

/**
 * Created by tonmoy on 07-Apr-16.
 */

@Singleton
@Component(modules = {ApiModule.class})
public interface ApiComponent {
    void inject(TrackerService target);
}
