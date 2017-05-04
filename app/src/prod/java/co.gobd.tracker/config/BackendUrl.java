package co.gobd.tracker.config;

/**
 * Created by tonmoy on 11-Apr-16.
 */
public class BackendUrl {
    private BackendUrl() {
    }

    // Tracking server of go fetch
    public static final class ShadowCat {
        public static final String BASE = "http://gofetch.cloudapp.net:1337";
        public static final String PING = "/api/ping";
    }

    // Main backend of go fetch
    public static final class TaskCat {
        // Dev
        public static final String BASE = "http://fetchprod.gobd.co";
        //public static final String BASE = "http://fetchdev.gobd.co";
        // Path5
        public static final String LOGIN = "/api/auth/token";
        public static final String GET_REGISTER = "/api/Account/Register";
        //  public static final String GET_ASSIGNED_JOBS = "/api/job/jobsbyasset/{userId}?envelope=true&page=0&pageSize=10";
        public static final String GET_PROFILE = "/api/Account/Profile";
        public static final String GET_ASSIGNED_JOBS = "/api/job/odata";

       // public static final String GET_ASSIGNED_JOBS = "/api/job/odata?$filter=(Tasks/any(task: task/State eq 'IN_PROGRESS' and Task/Type eq 'Delivery' and task/AssetRef eq '{userId}'))"+"?&pageSize=50&page=0&sortDirection=Desc";
        public static final String PATCH_TASK_STATE = "/api/Job/{jobId}/{taskId}";

    }
}
