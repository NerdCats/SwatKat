package co.gobd.tracker.utility;

/**
 * Created by fahad on 29-Mar-16.
 */
public class Constant {

    public final class BackendName {
        public static final String TASK_CAT = "TASK_CAT";
        public static final String SHADOW_CAT = "SHADOW_CAT";
    }

    public final class Login {

        public static final String grantType = "password";
        public static final String clientId = "GoFetchDevDroidAssetApp";
        public static final String clientSecret = "GoFetchDevDroidAssetApp@gobd";
    }

    public final class SharedPrefs{
        public static final String KEY_PREFERENCE_NAME = "GOFetchAsset";
        public static final String KEY_USERNAME = "username";
        public static final String KEY_PASSWORD = "password";
        public static final String KEY_TOKEN = "token";
        public static final String KEY_BEARER = "bearer";
        public static final String KEY_REFRESH_TOKEN = "refresh_token";
        public static final String KEY_ASSET_ID = "asset_id";
        public static final String VALUE_DEFAULT_USERNAME = "default_username";
        public static final String VALUE_DEFAULT_PASSWORD = "default_password";
        public static final String VALUE_DEFAULT_TOKEN = "default_token";
        public static final String VALUE_DEFAULT_BEARER = "default_bearer";
        public static final String VALUE_DEFAULT_ASSET_ID = "default_asset_id";
    }

}
