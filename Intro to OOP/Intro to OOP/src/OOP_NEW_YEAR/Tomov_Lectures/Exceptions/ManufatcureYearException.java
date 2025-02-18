package OOP_NEW_YEAR.Tomov_Lectures.Exceptions;

public class ManufatcureYearException extends Exception{
    private String message;

    public ManufatcureYearException(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
