package OOP_NEW_YEAR.Second_Term.Day_11;

public class User implements ValidatePhone{
    private String username;
    private String password;
    private String phoneNumber;

    public User(String password, String phoneNumber, String username){
        this.password = password;
        this.phoneNumber = phoneNumber;
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }



}
