package co.gobd.tracker.config;

/**
 * Created by tonmoy on 11-Apr-16.
 */
public class BackendUrl {
    private BackendUrl() {
    }

    // Tracking server of go fetch
    public static final class ShadowCat {
        public static final String BASE = "http://gofetch.cloudapp.net:1337/";
        public static final String PING = "api/ping";
    }

    // Main backend of go fetch
    public static final class TaskCat {
        public static final String BASE = "http://gofetch.cloudapp.net:80/";
        // Path
        public static final String LOGIN = "token";
        public static final String GET_PROFILE = "api/Account/Profile";

    }

}
