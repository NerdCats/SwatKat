
package co.gobd.tracker.model.user;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Profile {

    @SerializedName("NationalId")
    @Expose
    private String NationalId;

    @SerializedName("DriversLicenseId")
    @Expose
    private String DriversLicenseId;

    @SerializedName("Vehicle")
    @Expose
    private String Vehicle;

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

    @SerializedName("Address")
    @Expose
    private String Address;

    @SerializedName("PicUri")
    @Expose
    private String PicUri;

    public Profile(String nationalId, String driversLicenseId, String vehicle, String firstName, String lastName, Integer age, String gender, String address, String picUri) {
        NationalId = nationalId;
        DriversLicenseId = driversLicenseId;
        Vehicle = vehicle;
        FirstName = firstName;
        LastName = lastName;
        Age = age;
        Gender = gender;
        Address = address;
        PicUri = picUri;
    }

    /**
     *
     * @return
     *     The NationalId
     */
    public String getNationalId() {
        return NationalId;
    }

    /**
     *
     * @param NationalId
     *     The NationalId
     */
    public void setNationalId(String NationalId) {
        this.NationalId = NationalId;
    }

    /**
     *
     * @return
     *     The DriversLicenseId
     */
    public String getDriversLicenseId() {
        return DriversLicenseId;
    }

    /**
     *
     * @param DriversLicenseId
     *     The DriversLicenseId
     */
    public void setDriversLicenseId(String DriversLicenseId) {
        this.DriversLicenseId = DriversLicenseId;
    }

    /**
     *
     * @return
     *     The Vehicle
     */
    public String getVehicle() {
        return Vehicle;
    }

    /**
     *
     * @param Vehicle
     *     The Vehicle
     */
    public void setVehicle(String Vehicle) {
        this.Vehicle = Vehicle;
    }

    /**
     *
     * @return
     *     The FirstName
     */
    public String getFirstName() {
        return FirstName;
    }

    /**
     *
     * @param FirstName
     *     The FirstName
     */
    public void setFirstName(String FirstName) {
        this.FirstName = FirstName;
    }

    /**
     *
     * @return
     *     The LastName
     */
    public String getLastName() {
        return LastName;
    }

    /**
     *
     * @param LastName
     *     The LastName
     */
    public void setLastName(String LastName) {
        this.LastName = LastName;
    }

    /**
     *
     * @return
     *     The Age
     */
    public Integer getAge() {
        return Age;
    }

    /**
     *
     * @param Age
     *     The Age
     */
    public void setAge(Integer Age) {
        this.Age = Age;
    }

    /**
     *
     * @return
     *     The Gender
     */
    public String getGender() {
        return Gender;
    }

    /**
     *
     * @param Gender
     *     The Gender
     */
    public void setGender(String Gender) {
        this.Gender = Gender;
    }

    /**
     *
     * @return
     *     The Address
     */
    public String getAddress() {
        return Address;
    }

    /**
     *
     * @param Address
     *     The Address
     */
    public void setAddress(String Address) {
        this.Address = Address;
    }

    /**
     *
     * @return
     *     The PicUri
     */
    public String getPicUri() {
        return PicUri;
    }

    /**
     *
     * @param PicUri
     *     The PicUri
     */
    public void setPicUri(String PicUri) {
        this.PicUri = PicUri;
    }

}
