package OOP_NEW_YEAR.Second_Term.Day_07;

import OOP_NEW_YEAR.Second_Term.Day_06.PriceException;

public class Automobile {
    private String brand;
    private String model;
    private double price;
    private int yearOfManufacture;
    private String fuelType;
    private String engineSerialNumber;

    public Automobile(String brand, String engineSerialNumber, String fuelType, String model, double price, int yearOfManufacture) throws PriceException {
        if (price >= 0) {
            this.brand = brand;
            this.engineSerialNumber = engineSerialNumber;
            this.fuelType = fuelType;
            this.model = model;
            this.price = price;
            this.yearOfManufacture = yearOfManufacture;
        } else throw new PriceException();
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getEngineSerialNumber() {
        return engineSerialNumber;
    }

    public void setEngineSerialNumber(String engineSerialNumber) {
        this.engineSerialNumber = engineSerialNumber;
    }

    public String getFuelType() {
        return fuelType;
    }

    public void setFuelType(String fuelType) {
        this.fuelType = fuelType;
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

    public void setPrice(double price) throws PriceException {
        if (price >= 0) this.price = price;
        else throw new PriceException();
    }

    public int getYearOfManufacture() {
        return yearOfManufacture;
    }

    public void setYearOfManufacture(int yearOfManufacture) {
        this.yearOfManufacture = yearOfManufacture;
    }

    @Override
    public String toString() {
        return "Automobile{" +
                "brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                ", price=" + price +
                ", yearOfManufacture=" + yearOfManufacture +
                ", fuelType='" + fuelType + '\'' +
                ", engineSerialNumber='" + engineSerialNumber + '\'' +
                '}';
    }

    public void getAutomobileInfo(){
        System.out.println(this.toString());
    }
}
