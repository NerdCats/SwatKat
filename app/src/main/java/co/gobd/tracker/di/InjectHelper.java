package co.gobd.tracker.di;

import co.gobd.tracker.di.componenet.ApiComponent;
import co.gobd.tracker.di.componenet.DaggerApiComponent;

/**
 * Created by tonmoy on 07-Apr-16.
 */
public class InjectHelper {

    private static ApiComponent sApiComponent;

    static {
        initModules();
    }

    private static void initModules() {
        sApiComponent = getApiComponentBuilder().build();
    }

    public static DaggerApiComponent.Builder getApiComponentBuilder() {
        return DaggerApiComponent.builder();
    }

    public static ApiComponent getApiComponent() {
        if (sApiComponent == null) {
            initModules();
        }
        return sApiComponent;
    }
}
