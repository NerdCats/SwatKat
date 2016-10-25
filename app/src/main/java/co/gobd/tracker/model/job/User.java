package co.gobd.tracker.model.job;

/**
 * Created by fahad on 5/16/16.
 */
public class User{

    private String UserName;
    private String Id;
    private String Type;
    private String PhoneNumber;
    private String Email;

    public User(String userName, String id, String type, String phoneNumber, String email) {
        UserName = userName;
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
