package OOP_NEW_YEAR.Second_Term.Day_04;

public class SpeedException extends RuntimeException {

    @Override
    public String getMessage() {
        return "Invalid speed";
    }
}
