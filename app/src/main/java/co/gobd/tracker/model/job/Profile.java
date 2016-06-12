package co.gobd.tracker.model.job;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by fahad on 5/17/16.
 */
public class Profile implements Parcelable {

    @SerializedName("FirstName")
    @Expose
    private String FirstName;

    @SerializedName("LastName")
    @Expose
    private String LastName;

    @SerializedName("Age")
    @Expose
    private Integer Age;

    @SerializedName("Gender")
    @Expose
    private String Gender;

    @SerializedName("InterestedLocalities")
    @Expose
    private String InterestedLocalities;

    @SerializedName("Address")
    @Expose
    private String Address;

    @SerializedName("PicUri")
    @Expose
    private String PicUri;


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {

        dest.writeString(FirstName);
        dest.writeString(LastName);
        dest.writeInt(Age);
        dest.writeString(Gender);
        dest.writeString(InterestedLocalities);
        dest.writeString(Address);
        dest.writeString(PicUri);
    }

    public static final Parcelable.Creator<Profile> CREATOR
            = new Parcelable.Creator<Profile>() {

        @Override
        public Profile createFromParcel(Parcel source) {
            return new Profile(source);
        }

        @Override
        public Profile[] newArray(int size) {
            return new Profile[size];
        }
    };

    private Profile(Parcel in) {
        FirstName = in.readString();
        LastName = in.readString();
        Age = in.readInt();
        Gender = in.readString();
        InterestedLocalities = in.readString();
        Address = in.readString();
        PicUri = in.readString();
    }


    public Profile(String firstName, String lastName, Integer age, String gender, String interestedLocalities,
                   String address, String picUri) {

        FirstName = firstName;
        LastName = lastName;
        Age = age;
        Gender = gender;
        InterestedLocalities = interestedLocalities;
        Address = address;
        PicUri = picUri;
    }

    /**
     * @return The FirstName
     */
    public String getFirstName() {
        return FirstName;
    }

    /**
     * @param FirstName The FirstName
     */
    public void setFirstName(String FirstName) {
        this.FirstName = FirstName;
    }

    /**
     * @return The LastName
     */
    public String getLastName() {
        return LastName;
    }

    /**
     * @param LastName The LastName
     */
    public void setLastName(String LastName) {
        this.LastName = LastName;
    }

    /**
     * @return The Age
     */
    public Integer getAge() {
        return Age;
    }

    /**
     * @param Age The Age
     */
    public void setAge(Integer Age) {
        this.Age = Age;
    }

    /**
     * @return The Gender
     */
    public String getGender() {
        return Gender;
    }

    /**
     * @param Gender The Gender
     */
    public void setGender(String Gender) {
        this.Gender = Gender;
    }

    public String getInterestedLocalities() {
        return InterestedLocalities;
    }

    public void setInterestedLocalities(String interestedLocalities) {
        InterestedLocalities = interestedLocalities;
    }

    /**
     * @return The Address
     */
    public String getAddress() {
        return Address;
    }

    /**
     * @param Address The Address
     */
    public void setAddress(String Address) {
        this.Address = Address;
    }

    /**
     * @return The PicUri
     */
    public String getPicUri() {
        return PicUri;
    }

    /**
     * @param PicUri The PicUri
     */
    public void setPicUri(String PicUri) {
        this.PicUri = PicUri;
    }

}

