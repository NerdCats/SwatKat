package co.gobd.tracker.model.job;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by fahad on 5/17/16.
 */
public class Profile{

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

