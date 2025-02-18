package OOP_NEW_YEAR.Tomov_Lectures.Exceptions;

public class OverFillGasTankException extends Exception{
    @Override
    public String getMessage() {
        return "Invalid exception: the gas tank is being overfilled.";
    }
}
