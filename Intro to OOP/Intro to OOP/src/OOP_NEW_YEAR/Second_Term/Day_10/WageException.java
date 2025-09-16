package OOP_NEW_YEAR.Second_Term.Day_10;

public class WageException extends RuntimeException {
    @Override
    public String getMessage() {
        return "The wage cannot be 0 or less.";
    }
}
