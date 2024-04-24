package Branii;

public class Fractions {
    private int nom;
    private int denom;

    public Fractions(){
        this.nom = 0;
        this.denom = 1;
        print1();
        print2();
    }

    public Fractions(int whole){
        this.nom = whole;
        this.denom = 1;
        print1();
        print2();
    }

    public Fractions(int newNom, int newDenom){
        this.nom = newNom;
        this.denom = newDenom;
        Simplify();
        print1();
        print2();

        if(denom == 0){
            System.out.println("Demoninator can't be 0!");
        }
    }

    private void Simplify(){
        int nod = gcd(Math.abs(nom), Math.abs(denom));
        this.nom /= nod;
        this.denom /= nod;
    }

    private int gcd(int Nom, int Denom){
        while(Nom != Denom) {
            if (Nom > Denom) {
                Nom -= Denom;
            } else if (Denom > Nom) {
                Denom -= Nom;
            }
            return Nom;
        }

        return Nom;
    }

    public void print1(){
        System.out.println(this.nom + "/" + this.denom);
    }

    public void print2(){
        double result = (double) this.nom / this.denom;
        System.out.println(result);
    }

    public Fractions Add(Fractions fraction2){
        int wholeDenom = this.denom * fraction2.denom;
        int sumNom = this.nom * fraction2.denom + fraction2.nom * this.denom;
        this.nom = sumNom;
        this.denom = wholeDenom;
        return fraction2;
    }

    public Fractions Substract(Fractions fraction3) {
        int wholeDenom = this.denom * fraction3.denom;
        int sumNom = this.nom * fraction3.denom - fraction3.nom * this.denom;
        this.nom = sumNom;
        this.denom = wholeDenom;
        return fraction3;
    }
}
