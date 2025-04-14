package OOP_NEW_YEAR.Second_Term.Day_08;

public class WrongPhoneNumberException extends RuntimeException {
    public WrongPhoneNumberException() {
    }

    @Override
    public String getMessage() {
        return "The phone number you have entered is incorrect.";
    }
}
