package OOP_NEW_YEAR.Second_Term.Day_12;

import java.io.FileInputStream;
import java.io.IOException;

public class Movie {
    private String name;
    private int length;
    private FileInputStream trailer;

    public Movie(int length, String name, FileInputStream trailer) {
        if (length >= 3600) {
            this.length = length;
            this.name = name;
            this.trailer = trailer;
        } else throw new MovieLengthException("The length of a movie must be atleast 3600 seconds.");
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public FileInputStream getTrailer() {
        return trailer;
    }

    public void setTrailer(FileInputStream trailer) {
        this.trailer = trailer;
    }
/*
    public static boolean equalTrailers(FileInputStream movie1, FileInputStream movie2) {
        try {
            int b1, b2;
            while ((b1 = movie1.read()) != -1 && (b2 = movie2.read()) != -1) {
                if (b1 != b2) return false;
            }
            return b1 == -1 && b2 == -1;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        } finally {
            try {
                movie1.close();
                movie2.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
*/
    public static int compareMovieLengths(Movie m1, Movie m2){
        if (m1.getLength() > m2.getLength()) return -1;
        else if (m1.getLength() == m2.getLength()) return 0;
        else return 1;
    }

    public int compareWith(Movie m){
        if (this.getLength() > m.getLength()) return -1;
        else if (this.getLength() == m.getLength()) return 0;
        else return 1;
    }
}
