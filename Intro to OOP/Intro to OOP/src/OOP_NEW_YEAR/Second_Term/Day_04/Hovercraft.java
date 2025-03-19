package OOP_NEW_YEAR.Second_Term.Day_04;

public class Hovercraft extends Vehicle implements IsLandVehicle, IsSeaVessel {
    private int passengers;

    public Hovercraft(int maxSpeed, String model, double price, int passengers) {
        super(maxSpeed, model, price);
        this.passengers = passengers;
    }

    public int getPassengers() {
        return passengers;
    }

    public void setPassengers(int passengers) {
        this.passengers = passengers;
    }

    @Override
    public double checkPromo() {
        return this.getPrice() * (1 - 0.03);
    }

    @Override
    public void enterLand() {
        System.out.println("The hovercraft is on land.");
    }

    @Override
    public void enterSea() {
        System.out.println("The hovercraft is in the water.");
    }
}
