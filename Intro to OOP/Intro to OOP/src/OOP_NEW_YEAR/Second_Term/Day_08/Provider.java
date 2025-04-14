package OOP_NEW_YEAR.Second_Term.Day_08;

public class Provider {
    private String name;
    private String phoneNumber;

    public Provider(String name, String phoneNumber) throws WrongPhoneNumberException{
        ValidatePhone.validatePhoneNumber(phoneNumber);
        this.name = name;
        this.phoneNumber = phoneNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) throws WrongPhoneNumberException{
        ValidatePhone.validatePhoneNumber(phoneNumber);
        this.phoneNumber = phoneNumber;
    }
}
