package Branii;
import Branii.Fractions;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        Fractions fraction01 = new Fractions();
        System.out.print("Enter value for whole num: ");
        Fractions fraction02 = new Fractions(s.nextInt());
        System.out.println();

        System.out.print("Enter value for nominator: ");
        int new_nom = s.nextInt();

        System.out.print("Enter value for denominator: ");
        int new_denom = s.nextInt();

        Fractions fraction03 = new Fractions(new_nom, new_denom);

        Fractions fraction04 = fraction03.Add(fraction03);
        fraction04.print1();
        Fractions fraction05 = fraction04.Substract(fraction03);
        fraction05.print2();
    }
}
