package OOP_NEW_YEAR.Tomov_Lectures.CoffeeMachine;

public class Coffee {
    private String name;
    private int coffeeNeeded;
    private int milkNeeded;
    private int waterNeeded;
    private double price;

    public Coffee(int coffeeNeeded, int milkNeeded, String name, double price, int waterNeeded) {
        this.coffeeNeeded = coffeeNeeded;
        this.milkNeeded = milkNeeded;
        this.name = name;
        this.price = price;
        this.waterNeeded = waterNeeded;
    }

    public int getCoffeeNeeded() {
        return coffeeNeeded;
    }

    public void setCoffeeNeeded(int coffeeNeeded) {
        this.coffeeNeeded = coffeeNeeded;
    }

    public int getMilkNeeded() {
        return milkNeeded;
    }

    public void setMilkNeeded(int milkNeeded) {
        this.milkNeeded = milkNeeded;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getWaterNeeded() {
        return waterNeeded;
    }

    public void setWaterNeeded(int waterNeeded) {
        this.waterNeeded = waterNeeded;
    }
}
