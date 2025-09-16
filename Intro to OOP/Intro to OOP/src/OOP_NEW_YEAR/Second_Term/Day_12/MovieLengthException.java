package OOP_NEW_YEAR.Second_Term.Day_12;

public class MovieLengthException extends RuntimeException {
    private String message;
    public MovieLengthException(String message) {
        this.message = message;
    }

    public String getMessage() {
        return this.message;
    }
}
