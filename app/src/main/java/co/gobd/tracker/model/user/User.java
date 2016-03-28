
package co.gobd.tracker.model.user;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class User {

    @SerializedName("IsUserAuthenticated")
    @Expose
    private Boolean IsUserAuthenticated;
    @SerializedName("AverageRating")
    @Expose
    private Integer AverageRating;
    @SerializedName("Id")
    @Expose
    private String Id;
    @SerializedName("Type")
    @Expose
    private String Type;
    @SerializedName("UserName")
    @Expose
    private Object UserName;
    @SerializedName("PhoneNumber")
    @Expose
    private String PhoneNumber;
    @SerializedName("PhoneNumberConfirmed")
    @Expose
    private Boolean PhoneNumberConfirmed;
    @SerializedName("Email")
    @Expose
    private String Email;
    @SerializedName("EmailConfirmed")
    @Expose
    private Boolean EmailConfirmed;
    @SerializedName("Profile")
    @Expose
    private Profile Profile;

    /**
     *
     * @return
     *     The IsUserAuthenticated
     */
    public Boolean getIsUserAuthenticated() {
        return IsUserAuthenticated;
    }

    /**
     *
     * @param IsUserAuthenticated
     *     The IsUserAuthenticated
     */
    public void setIsUserAuthenticated(Boolean IsUserAuthenticated) {
        this.IsUserAuthenticated = IsUserAuthenticated;
    }

    /**
     *
     * @return
     *     The AverageRating
     */
    public Integer getAverageRating() {
        return AverageRating;
    }

    /**
     *
     * @param AverageRating
     *     The AverageRating
     */
    public void setAverageRating(Integer AverageRating) {
        this.AverageRating = AverageRating;
    }

    /**
     *
     * @return
     *     The Id
     */
    public String getId() {
        return Id;
    }

    /**
     *
     * @param Id
     *     The Id
     */
    public void setId(String Id) {
        this.Id = Id;
    }

    /**
     *
     * @return
     *     The Type
     */
    public String getType() {
        return Type;
    }

    /**
     *
     * @param Type
     *     The Type
     */
    public void setType(String Type) {
        this.Type = Type;
    }

    /**
     *
     * @return
     *     The UserName
     */
    public Object getUserName() {
        return UserName;
    }

    /**
     *
     * @param UserName
     *     The UserName
     */
    public void setUserName(Object UserName) {
        this.UserName = UserName;
    }

    /**
     *
     * @return
     *     The PhoneNumber
     */
    public String getPhoneNumber() {
        return PhoneNumber;
    }

    /**
     *
     * @param PhoneNumber
     *     The PhoneNumber
     */
    public void setPhoneNumber(String PhoneNumber) {
        this.PhoneNumber = PhoneNumber;
    }

    /**
     *
     * @return
     *     The PhoneNumberConfirmed
     */
    public Boolean getPhoneNumberConfirmed() {
        return PhoneNumberConfirmed;
    }

    /**
     *
     * @param PhoneNumberConfirmed
     *     The PhoneNumberConfirmed
     */
    public void setPhoneNumberConfirmed(Boolean PhoneNumberConfirmed) {
        this.PhoneNumberConfirmed = PhoneNumberConfirmed;
    }

    /**
     *
     * @return
     *     The Email
     */
    public String getEmail() {
        return Email;
    }

    /**
     *
     * @param Email
     *     The Email
     */
    public void setEmail(String Email) {
        this.Email = Email;
    }

    /**
     *
     * @return
     *     The EmailConfirmed
     */
    public Boolean getEmailConfirmed() {
        return EmailConfirmed;
    }

    /**
     *
     * @param EmailConfirmed
     *     The EmailConfirmed
     */
    public void setEmailConfirmed(Boolean EmailConfirmed) {
        this.EmailConfirmed = EmailConfirmed;
    }

    /**
     *
     * @return
     *     The Profile
     */
    public Profile getProfile() {
        return Profile;
    }

    /**
     *
     * @param Profile
     *     The Profile
     */
    public void setProfile(Profile Profile) {
        this.Profile = Profile;
    }

}
