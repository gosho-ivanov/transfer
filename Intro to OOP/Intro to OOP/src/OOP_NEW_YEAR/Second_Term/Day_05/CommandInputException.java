package OOP_NEW_YEAR.Second_Term.Day_05;

public class CommandInputException extends RuntimeException {
  @Override
  public String getMessage() {
    return "There is no such command";
  }
}
