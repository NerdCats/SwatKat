package co.gobd.tracker.model.login;

/**
 * Created by fahad on 28-Mar-16.
 */
public class Login {

    private String userName;

    private String password;

    private final String grantType = "password";

    private final String clientId = "GoFetchWebApp";

    private final String clientSecret = "GoFetchDevDroidApp@gobd";

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserName() {
        return userName;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword() {
        return password;
    }


    public String getGrantType() {
        return grantType;
    }

    public String getClientId() {
        return clientId;
    }

    public String getClientSecret() {
        return clientSecret;
    }
}
