package OOP_NEW_YEAR.First_Term.Day_09;

public abstract class Product {
    private String inventoryNumber;
    private double price;
    private Provider provider;
    private int quantity;

    public Product(String inventoryNumber, double price, Provider provider, int quantity) {
        this.inventoryNumber = inventoryNumber;
        this.price = price;
        this.provider = provider;
        this.quantity = quantity;
    }

    public String getInventoryNumber() {
        return inventoryNumber;
    }

    public void setInventoryNumber(String inventoryNumber) {
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
    public abstract boolean sellProduct(int quantity);
}
