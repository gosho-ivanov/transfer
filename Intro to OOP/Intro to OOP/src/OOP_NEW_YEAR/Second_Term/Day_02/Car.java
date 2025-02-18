package OOP_NEW_YEAR.Second_Term.Day_02;

public class Car {
    private String manufacturer;
    private String model;
    private double price;
    private int yearOfProduction;
    private String fuelType;
    private String vinNumber;

    public Car(String fuelType, String manufacturer, String model, double price, String vinNumber, int yearOfProduction) {
        this.fuelType = fuelType;
        this.manufacturer = manufacturer;
        this.model = model;
        this.price = price;
        this.vinNumber = vinNumber;
        this.yearOfProduction = yearOfProduction;
    }

    public String getFuelType() {
        return fuelType;
    }

    public void setFuelType(String fuelType) {
        this.fuelType = fuelType;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
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

    public String getVinNumber() {
        return vinNumber;
    }

    public void setVinNumber(String vinNumber) {
        this.vinNumber = vinNumber;
    }

    public int getYearOfProduction() {
        return yearOfProduction;
    }

    public void setYearOfProduction(int yearOfProduction) {
        this.yearOfProduction = yearOfProduction;
    }

    @Override
    public String toString() {
        return "Car{" +
                "fuelType='" + fuelType + '\'' +
                ", manufacturer='" + manufacturer + '\'' +
                ", model='" + model + '\'' +
                ", price=" + price +
                ", yearOfProduction=" + yearOfProduction +
                ", vinNumber='" + vinNumber + '\'' +
                '}';
    }
}
