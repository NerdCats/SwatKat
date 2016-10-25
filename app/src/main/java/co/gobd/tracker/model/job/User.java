package co.gobd.tracker.model.job;

import android.os.Parcel;

/**
 * Created by fahad on 5/16/16.
 */
public class User{

    private String UserName;
    private Profile Profile;
    private String Id;
    private String Type;
    private String PhoneNumber;
    private String Email;

    private User(Parcel in) {
        UserName = in.readString();
        Profile = in.readParcelable(Profile.class.getClassLoader());
        Id = in.readString();
        Type = in.readString();
        PhoneNumber = in.readString();
        Email = in.readString();
    }

    public User(String userName, Profile profile, String id, String type, String phoneNumber, String email) {
        UserName = userName;
        Profile = profile;
        Id = id;
        Type = type;
        PhoneNumber = phoneNumber;
        Email = email;
    }

    /**
     * @return The UserName
     */
    public String getUserName() {
        return UserName;
    }

    /**
     * @param UserName The UserName
     */
    public void setUserName(String UserName) {
        this.UserName = UserName;
    }

    /**
     * @return The Profile
     */
    public Profile getProfile() {
        return Profile;
    }

    /**
     * @param Profile The Profile
     */
    public void setProfile(Profile Profile) {
        this.Profile = Profile;
    }

    /**
     * @return The Id
     */
    public String getId() {
        return Id;
    }

    /**
     * @param Id The Id
     */
    public void setId(String Id) {
        this.Id = Id;
    }

    /**
     * @return The Type
     */
    public String getType() {
        return Type;
    }

    /**
     * @param Type The Type
     */
    public void setType(String Type) {
        this.Type = Type;
    }

    /**
     * @return The PhoneNumber
     */
    public String getPhoneNumber() {
        return PhoneNumber;
    }

    /**
     * @param PhoneNumber The PhoneNumber
     */
    public void setPhoneNumber(String PhoneNumber) {
        this.PhoneNumber = PhoneNumber;
    }

    /**
     * @return The Email
     */
    public String getEmail() {
        return Email;
    }

    /**
     * @param Email The Email
     */
    public void setEmail(String Email) {
        this.Email = Email;
    }

}
