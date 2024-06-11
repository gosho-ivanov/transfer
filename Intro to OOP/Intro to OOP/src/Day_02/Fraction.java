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
        checkNOD(Math.abs(this.nom), Math.abs(this.denom));
    }

    public void showFraction(){
        if (this.nom>0 && this.denom > 0) {
            System.out.println(this.nom + "/" + this.denom);
        } else {
            System.out.println("-"+ Math.abs(this.nom)+"/"+Math.abs(this.denom));
        }
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


    public Fraction addFractions(Fraction fr2){
        int nom1 = this.nom;
        int nom2 = fr2.nom;

        int denom1 = this.denom;
        int denom2 = fr2.denom;

        int new_nom = (nom1*denom2) + (nom2*denom1);
        int new_denom = denom1*denom2;
        return new Fraction(new_nom, new_denom);
    }

    public Fraction substractFraction(Fraction fr2){
        int nom1 = this.nom;
        int nom2 = fr2.nom;

        int denom1 = this.denom;
        int denom2 = fr2.denom;

        int new_denom = denom1 * denom2;
        int new_nom = nom1 - nom2;
        return new Fraction(new_nom, new_denom);
    }

    public Fraction reciprocalFraction(){
        int temp = this.nom;
        int nom = this.denom;
        int denom = temp;
        return new Fraction(nom, denom);
    }

    public Fraction fractionPower(int power) {
        int nom = this.nom;
        int denom = this.denom;
        int new_nom = 1;
        int new_denom = 1;
        for (int i = 0; i < power; i++) {
            new_nom *= nom;
            new_denom *= denom;
        }

        return new Fraction(new_nom, new_denom);
    }
}
