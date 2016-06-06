package co.gobd.tracker.model.job;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by fahad on 5/16/16.
 */
public class User implements Parcelable {

    private String UserName;
    private Profile Profile;
    private String Id;
    private String Type;
    private String PhoneNumber;
    private String Email;

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {

        dest.writeString(UserName);
        dest.writeParcelable(Profile, flags);
        dest.writeString(Id);
        dest.writeString(Type);
        dest.writeString(PhoneNumber);
        dest.writeString(Email);

    }

    private User(Parcel in){
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

    public static final Parcelable.Creator<User> CREATOR
            = new Parcelable.Creator<User>(){

        @Override
        public User createFromParcel(Parcel source) {
            return new User(source);
        }

        @Override
        public User[] newArray(int size) {
            return new User[size];
        }
    };

    /**
     *
     * @return
     *     The UserName
     */
    public String getUserName() {
        return UserName;
    }

    /**
     *
     * @param UserName
     *     The UserName
     */
    public void setUserName(String UserName) {
        this.UserName = UserName;
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

}
