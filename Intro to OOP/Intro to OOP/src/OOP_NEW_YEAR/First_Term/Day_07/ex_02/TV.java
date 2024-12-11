package OOP_NEW_YEAR.First_Term.Day_07.ex_02;

public class TV extends Products{
    private String maker;
    private String model;
    private int power;

    public TV(double price, int productID, String maker, String model, int power) {
        super(price, productID);
        this.maker = maker;
        this.model = model;
        this.power = power;
    }

    public String getMaker() {
        return maker;
    }

    public void setMaker(String maker) {
        this.maker = maker;
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

    public void setPower(int power) {
        this.power = power;
    }

    @Override
    public double checkPromo(int percentage){
        return this.getPrice() * ((100-percentage)/100);
    }
}
