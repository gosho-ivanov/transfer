package OOP_NEW_YEAR.Day_07.ex_02;

public abstract class Products {
    private double price;
    private int productID;

    public Products(double price, int productID) {
        this.price = price;
        this.productID = productID;
    }

    public double getPrice() {
        return price;
    }

    public int getProductID() {
        return productID;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setProductID(int productID) {
        this.productID = productID;
    }

    public abstract double checkPromo(int percent);
}
