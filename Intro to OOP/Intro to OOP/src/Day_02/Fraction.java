package Day_02;

import java.util.Scanner;

public class Fraction {
    Scanner s = new Scanner(System.in);
    private int nom;
    private int denom;

    public Fraction() {
        this.nom = 0;
        this.denom = 1;
    }

    public Fraction(int whole){
        this.nom = whole;
        this.denom = 1;
    }

    public Fraction(int new_nom, int new_denom){
        this.nom = new_nom;
        while (new_denom == 0){
            System.out.println("ValueError: denominator cannot be 0!");
            System.out.print("Enter new value for denominator: ");
            new_denom = s.nextInt();
        }
        this.denom = new_denom;
    }

    public void showFraction(){
        System.out.println(this.nom + "/" + this.denom);
    }

    public void showFractionAsDecimal(){
        double result = (double) this.nom / this.denom;
        System.out.println(result);
    }

    private int euclidAlgo(int a, int b){
        if (b == 0){
            return a;
        } else {
            return euclidAlgo(b, a % b);
        }
    }

    public void checkNOD(int nom, int denom){
        int nod = euclidAlgo(nom, denom);
        if (nod != 1){
            this.nom = this.nom / nod;
            this.denom = this.denom / nod;
        }
    }


}
