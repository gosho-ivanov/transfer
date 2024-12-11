package OOP_NEW_YEAR.First_Term.Day_02;

import java.util.Scanner;

public class ex_02 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        int points = s.nextInt();
        if (points <= 0 || points > 9){
            System.out.println("Invalid result");
        } else if (points <= 3) {
            points = points * 10;
            System.out.println(points);
        } else if (points <= 6){
            points *= 100;
            System.out.println(points);
        } else {
            points *= 1000;
            System.out.println(points);
        }
    }
}
