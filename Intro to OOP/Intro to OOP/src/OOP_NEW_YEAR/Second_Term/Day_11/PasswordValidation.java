package OOP_NEW_YEAR.Second_Term.Day_11;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PasswordValidation {
    private static final Pattern passwordPattern = Pattern.compile("^[a-zA-Z]{11,}$");

    public static boolean validatePassword(String password){
        Matcher matcher = passwordPattern.matcher(password);
        return matcher.find();
    }
}
