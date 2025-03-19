package OOP_NEW_YEAR.Second_Term.Day_04;

public class Car extends Vehicle implements IsLandVehicle{
    private int enginePower;


    public Car(int maxSpeed, String model, double price, int enginePower) {
        super(maxSpeed, model, price);
        this.enginePower = enginePower;
    }

    @Override
    public double checkPromo() {
        return this.getPrice() * (1 - 0.2);
    }

    @Override
    public void enterLand() {
        System.out.println("The car is on land.");
    }
}
