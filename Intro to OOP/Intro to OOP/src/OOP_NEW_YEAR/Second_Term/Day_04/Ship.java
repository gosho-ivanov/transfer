package OOP_NEW_YEAR.Second_Term.Day_04;

public class Ship extends Vehicle implements IsSeaVessel{
    private double deadweight;

    public Ship(int maxSpeed, String model, double price, double deadweight) {
        super(maxSpeed, model, price);
        this.deadweight = deadweight;
    }

    public double getDeadweight() {
        return deadweight;
    }

    public void setDeadweight(double deadweight) {
        this.deadweight = deadweight;
    }

    @Override
    public double checkPromo() {
        return this.getPrice() * (1 - 0.003);
    }

    @Override
    public void enterSea() {
        System.out.println("The ship is in the sea.");
    }

}
