package OOP_NEW_YEAR.First_Term.Day_02;

import java.util.Scanner;

public class ex_04 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        int n = s.nextInt();
        if (n < 0) {
            System.out.println("Invalid number");
        } else {
            for (int i = 1; i <= n; i ++){
                if (i % 3 != 0 && i % 7 != 0){
                    System.out.print(i + " ");
                }
            }
        }
    }
}
