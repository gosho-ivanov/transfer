package OOP_NEW_YEAR.Second_Term.Day_04;

public class PriceException extends RuntimeException {

  @Override
  public String getMessage() {
    return "Invalid price!.";
  }
}
