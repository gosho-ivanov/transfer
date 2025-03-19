package OOP_NEW_YEAR.Second_Term.Day_04;

public abstract class Vehicle {
    private int maxSpeed;
    private String model;
    private double price;


    public Vehicle(int maxSpeed, String model, double price) throws SpeedException, PriceException {
        if (maxSpeed <= 0){
            throw new SpeedException();
        }
        else if (price <= 0){
            throw new PriceException();
        } else {
            this.maxSpeed = maxSpeed;
            this.model = model;
            this.price = price;
        }
    }

    public int getMaxSpeed() {
        return maxSpeed;
    }

    public void setMaxSpeed(int maxSpeed) {
        this.maxSpeed = maxSpeed;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public abstract double checkPromo();
}
