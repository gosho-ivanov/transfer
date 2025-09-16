package OOP_NEW_YEAR.Second_Term.Day_10;

public class HoursException extends RuntimeException {
    @Override
    public String getMessage() {
        return "The hours of work cannot be 0 or less.";
    }
}
