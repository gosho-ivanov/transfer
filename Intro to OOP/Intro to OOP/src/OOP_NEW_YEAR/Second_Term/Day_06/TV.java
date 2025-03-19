package OOP_NEW_YEAR.Second_Term.Day_06;

public class TV extends Stocks implements ElectricalAppliance{
    private String manufacturer;
    private String model;
    private int power;

    public TV(double price, int serialNumber, String manufacturer, String model, int power) throws Exception{
        super(price, serialNumber);
        if (power > 0) {
            this.manufacturer = manufacturer;
            this.model = model;
            this.power = power;
        } else throw new PowerException();
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

    public int getPower() {
        return power;
    }

    public void setPower(int power) throws PowerException{
        if (power >= 0) {
            this.power = power;
        } else throw new PowerException();
    }

    @Override
    public double checkPromo() {
        return this.getPrice() * 0.91;
    }

    @Override
    public double getPowerConsumption(int hours) {
        return this.power * hours;
    }
}
