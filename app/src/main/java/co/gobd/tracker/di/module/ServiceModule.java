package co.gobd.tracker.di.module;

import javax.inject.Singleton;

import co.gobd.tracker.network.AccountApi;
import co.gobd.tracker.network.JobApi;
import co.gobd.tracker.network.TrackerApi;
import co.gobd.tracker.service.account.AccountService;
import co.gobd.tracker.service.account.AccountServiceImpl;
import co.gobd.tracker.service.job.JobService;
import co.gobd.tracker.service.job.JobServiceImpl;
import co.gobd.tracker.service.tracker.TrackerService;
import co.gobd.tracker.service.tracker.TrackerServiceImpl;
import dagger.Module;
import dagger.Provides;

/**
 * Created by fahad on 5/29/2016.
 */

@Module
public class ServiceModule {

    @Provides
    @Singleton
    public TrackerService providesTrackerService(TrackerApi trackerApi) {
        return new TrackerServiceImpl(trackerApi);
    }

    @Provides
    @Singleton
    public AccountService providesAuthenticationService(AccountApi accountApi) {
        return new AccountServiceImpl(accountApi);
    }

    @Provides
    @Singleton
    public JobService providesJobService(JobApi jobApi) {
        return new JobServiceImpl(jobApi);
    }
}
