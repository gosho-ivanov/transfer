package OOP_NEW_YEAR.Second_Term.Day_11;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UsernameValidation {
    private static final Pattern usernamePattern = Pattern.compile("^[a-z0-9_-]{3,15}$");

    public static boolean validateUsername(String password){
        Matcher matcher = usernamePattern.matcher(password);
        return matcher.find();
    }
}
