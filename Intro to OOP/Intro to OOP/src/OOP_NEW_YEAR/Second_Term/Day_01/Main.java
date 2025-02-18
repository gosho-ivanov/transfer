package OOP_NEW_YEAR.Second_Term.Day_01;

import java.util.Scanner;

public class Main {
    public static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        Films films = new Films();
        for (int i = 0; i < 5; i++) {
            films.addFilm(generateFilm());
        }
        Film checker = generateFilm();
        films.getFilmsByProducer("");
        System.out.println("the average budget of all films is: " + films.getAvgFilmBudgetByProducer(""));
        films.getFilmWithHighestBudget();
        films.checkForDoubles(checker);
    }

    public static Film generateFilm(){
        String name = scanner.next();
        String producer = scanner.next();
        int budget = scanner.nextInt();
        int yearOfRelease = scanner.nextInt();
        int id = scanner.nextInt();
        return new Film(budget, id, name, producer, yearOfRelease);
    }


}
