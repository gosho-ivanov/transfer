package OOP_NEW_YEAR.Second_Term.Day_06;

public class PowerException extends RuntimeException {
  @Override
  public String getMessage() {
    return "The power of an electrical appliance cannot be in the negative.";
  }
}
