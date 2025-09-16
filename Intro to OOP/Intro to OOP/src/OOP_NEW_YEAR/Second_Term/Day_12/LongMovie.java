package OOP_NEW_YEAR.Second_Term.Day_12;

import java.io.FileInputStream;

public class LongMovie extends Movie{
    public LongMovie(int length, String name, FileInputStream trailer) {
        super(length, name, trailer);
        if (length < 10800) new MovieLengthException("The length of a long movie must be at least 10800 seconds.");
    }

}
