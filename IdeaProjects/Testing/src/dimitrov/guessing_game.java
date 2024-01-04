package dimitrov;

import java.util.Random;
import java.util.Scanner;

public class guessing_game {
    public static void main(String[] args) {
        try (Scanner s = new Scanner(System.in)) {
            Random r = new Random();
            int num = r.nextInt(1, 101);
            int guess = s.nextInt();
            while (guess!=num){
                if (num>guess){
                    System.out.println("Entered number is lower than the game's.");
                } else {
                    System.out.println("Entered number is higher than the game's.");
                }
                System.out.print("Enter new number: ");
                guess = s.nextInt();
            }
        }
        System.out.println("You guessed the number!");
    }
}
