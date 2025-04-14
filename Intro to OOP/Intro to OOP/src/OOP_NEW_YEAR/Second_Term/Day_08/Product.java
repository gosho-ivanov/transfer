package OOP_NEW_YEAR.Second_Term.Day_08;

public abstract class Product {
    private int inventoryNumber;
    private double price;
    private int quantity;
    private Provider provider;

    public Product(int inventoryNumber, double price, Provider provider, int quantity) {
        this.inventoryNumber = inventoryNumber;
        this.price = price;
        this.provider = provider;
        this.quantity = quantity;
    }

    public int getInventoryNumber() {
        return inventoryNumber;
    }

    public void setInventoryNumber(int inventoryNumber) {
        this.inventoryNumber = inventoryNumber;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Provider getProvider() {
        return provider;
    }

    public void setProvider(Provider provider) {
        this.provider = provider;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public abstract double getPromotionalPrice();
    public abstract boolean sellProduct(int piece) throws NoMoreProductsException;
}
