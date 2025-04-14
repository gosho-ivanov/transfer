package OOP_NEW_YEAR.Second_Term.Day_07;

public class PriceException extends RuntimeException {
  @Override
  public String getMessage() {
    return "The price of an ad cannot be below zero.";
  }
}
