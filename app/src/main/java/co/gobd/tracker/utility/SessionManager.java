package co.gobd.tracker.utility;

/**
 * Created by fahad on 18-Apr-16.
 */
public interface SessionManager {

    String getUsername();

    void setUsername(String input);

    String getPassword();

    void setPassword(String input);

    String getToken();

    void setToken(String input);

    String getBearer();

    void setBearer(String input);

    String getRefreshToken();

    void setRefreshToken(String input);

    String getAssetId();

    void setAssetId(String input);

    void clearAll();
}
