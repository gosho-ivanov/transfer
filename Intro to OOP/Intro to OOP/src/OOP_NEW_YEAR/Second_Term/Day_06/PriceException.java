package OOP_NEW_YEAR.Second_Term.Day_06;

public class PriceException extends RuntimeException {
    @Override
    public String getMessage() {
        return "The price of a product cannot be a negative number.";
    }
}
