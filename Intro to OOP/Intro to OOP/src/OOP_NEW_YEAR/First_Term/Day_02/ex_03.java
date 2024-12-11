package OOP_NEW_YEAR.First_Term.Day_02;

import java.util.Scanner;

public class ex_03 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        float a = s.nextFloat();
        float b = s.nextFloat();
        float c = s.nextFloat();

        if (a > 0 && b > 0 && c > 0){
            System.out.println("+");
        } else if (a == 0 || b == 0 || c == 0) {
            System.out.println(0);
        } else if (a > 0 && b < 0 && c < 0) {
            System.out.println("+");
        } else if (a < 0 && b < 0 && c > 0) {
            System.out.println("+");
        } else if (a < 0 && b > 0 && c < 0) {
            System.out.println("+");
        } else {
            System.out.println("-");
        }
    }
}
