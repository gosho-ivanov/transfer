package OOP_NEW_YEAR.Second_Term.Day_12;
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        try {
            Movie[] movies = new Movie[3];

            movies[0] = new Movie(4000, "Movie A", new FileInputStream("trailer1.mp4"));
            movies[1] = new LongMovie(11000, "Movie B", new FileInputStream("trailer2.mp4"));
            movies[2] = new Movie(4000, "Movie C", new FileInputStream("trailer1.mp4")); // duplicate trailer

            System.out.println("Movies with the exact same trailer:");
            for (int i = 0; i < movies.length; i++) {
                for (int j = i + 1; j < movies.length; j++) {
                    FileInputStream t1 = new FileInputStream("trailer" + (i + 1) + ".mp4");
                    FileInputStream t2 = new FileInputStream("trailer" + (j + 1) + ".mp4");
                    /*if (Movie.equalTrailers(t1, t2)) {
                        System.out.println(movies[i].getName() + " <-> " + movies[j].getName());
                    }*/
                }
            }

            Arrays.sort(movies, (m1, m2) -> {
                int cmp = Integer.compare(m2.getLength(), m1.getLength());
                if (cmp == 0) {
                    return m1.getName().compareTo(m2.getName());
                }
                return cmp;
            });


            for (Movie movie : movies) {
                System.out.println(movie.getName() + " (" + movie.getLength() + " сек.)");
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

