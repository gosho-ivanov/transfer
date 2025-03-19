package OOP_NEW_YEAR.Second_Term.Day_05;

public class IndexException extends RuntimeException {
    @Override
    public String getMessage(){
        return "The index you are trying to access has no event in it.";
    }
}
