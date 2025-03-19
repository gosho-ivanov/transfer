package OOP_NEW_YEAR.Second_Term.Day_06;

public abstract class Stocks {
    private double price;
    private int serialNumber;

    public Stocks(double price, int serialNumber) throws PriceException{
        if (price > 0) {
            this.price = price;
            this.serialNumber = serialNumber;
        } else throw new PriceException();
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) throws PriceException{
        if (price >= 0) {
            this.price = price;
        } else throw new PriceException();
    }

    public int getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(int serialNumber) {
        this.serialNumber = serialNumber;
    }

    public abstract double checkPromo();

}


