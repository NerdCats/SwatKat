package co.gobd.tracker.model.login;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class AccessToken {

    @SerializedName("access_token")
    @Expose
    private String accessToken;
    @SerializedName("token_type")
    @Expose
    private String tokenType;
    @SerializedName("expires_in")
    @Expose
    private Integer expiresIn;
    @SerializedName("refresh_token")
    @Expose
    private String refreshToken;
    @SerializedName("as:client_id")
    @Expose
    private String asClientId;
    @SerializedName("userName")
    @Expose
    private String userName;
    @SerializedName(".issued")
    @Expose
    private String Issued;
    @SerializedName(".expires")
    @Expose
    private String Expires;

    /**
     * @return The accessToken
     */
    public String getAccessToken() {
        return accessToken;
    }

    /**
     * @param accessToken The access_token
     */
    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    /**
     * @return The tokenType
     */
    public String getTokenType() {
        return tokenType;
    }

    /**
     * @param tokenType The token_type
     */
    public void setTokenType(String tokenType) {
        this.tokenType = tokenType;
    }

    /**
     * @return The expiresIn
     */
    public Integer getExpiresIn() {
        return expiresIn;
    }

    /**
     * @param expiresIn The expires_in
     */
    public void setExpiresIn(Integer expiresIn) {
        this.expiresIn = expiresIn;
    }

    /**
     * @return The refreshToken
     */
    public String getRefreshToken() {
        return refreshToken;
    }

    /**
     * @param refreshToken The refresh_token
     */
    public void setRefreshToken(String refreshToken) {
        this.refreshToken = refreshToken;
    }

    /**
     * @return The asClientId
     */
    public String getAsClientId() {
        return asClientId;
    }

    /**
     * @param asClientId The as:client_id
     */
    public void setAsClientId(String asClientId) {
        this.asClientId = asClientId;
    }

    /**
     * @return The userName
     */
    public String getUserName() {
        return userName;
    }

    /**
     * @param userName The userName
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }

    /**
     * @return The Issued
     */
    public String getIssued() {
        return Issued;
    }

    /**
     * @param Issued The .issued
     */
    public void setIssued(String Issued) {
        this.Issued = Issued;
    }

    /**
     * @return The Expires
     */
    public String getExpires() {
        return Expires;
    }

    /**
     * @param Expires The .expires
     */
    public void setExpires(String Expires) {
        this.Expires = Expires;
    }

}
