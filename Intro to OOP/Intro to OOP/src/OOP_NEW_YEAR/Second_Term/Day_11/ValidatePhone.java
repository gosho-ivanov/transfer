package OOP_NEW_YEAR.Second_Term.Day_11;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public interface ValidatePhone {
    final static Pattern phoneNumberPattern = Pattern.compile("^08[0-9]{8}$");

    public static boolean validatePhoneNumber(String phoneNumber) throws WrongPhoneNumberException {
        Matcher matcher = phoneNumberPattern.matcher(phoneNumber);
        if (matcher.find()) {
            return true;
        } else {
            throw new WrongPhoneNumberException("The phone number you provided is invalid.");
        }
    }
}
