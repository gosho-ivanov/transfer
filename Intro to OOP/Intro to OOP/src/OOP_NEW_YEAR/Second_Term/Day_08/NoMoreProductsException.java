package OOP_NEW_YEAR.Second_Term.Day_08;

public class NoMoreProductsException extends RuntimeException {
    public NoMoreProductsException() {
    }

    @Override
    public String getMessage() {
        return "There is no stock of this product.";
    }
}
