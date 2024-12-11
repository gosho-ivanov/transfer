package OOP_NEW_YEAR.First_Term.Day_02;

import java.util.Scanner;

public class ex_05 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        int n = s.nextInt();
        if (n < 0) {
            System.out.println("Invalid number");
        } else {
            for (int i = 1; i <= n; i ++){
                System.out.print(i + " ");
            }
            for (int j = n - 1; j > 0 ; j--) {
                System.out.print(j + " ");
            }
        }
    }
}
