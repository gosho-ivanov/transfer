package Day_02;

import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        Fraction fraction01 = new Fraction();
        System.out.print("Enter value for whole num: ");
        Fraction fraction02 = new Fraction(s.nextInt());
        System.out.println();

        System.out.print("Enter value fro nominator: ");
        int new_nom = s.nextInt();

        System.out.print("Enter value for denominator: ");
        int new_denom = s.nextInt();

        Fraction fraction03 = new Fraction(new_nom, new_denom);

        fraction01.showFraction();
        fraction03.showFractionAsDecimal();
    }
}
