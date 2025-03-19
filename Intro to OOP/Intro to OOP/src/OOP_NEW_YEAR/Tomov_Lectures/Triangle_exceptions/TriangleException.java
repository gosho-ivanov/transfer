package OOP_NEW_YEAR.Tomov_Lectures.Triangle_exceptions;

public class TriangleException extends Exception{
    private String message;

    public TriangleException(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
