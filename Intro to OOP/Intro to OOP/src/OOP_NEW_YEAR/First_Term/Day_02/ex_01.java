package OOP_NEW_YEAR.First_Term.Day_02;

import java.util.Scanner;

public class ex_01 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        double a = s.nextDouble();
        double b = s.nextDouble();

        if (a > b){
            double temp = a;
            a = b;
            b = temp;
        }
        System.out.println(a);
        System.out.println(b);

    }
}
