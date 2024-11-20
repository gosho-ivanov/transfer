package lecture;

public class Product {
    private int stock;
    private String brand;
    private String type;
    private double minPrice;

    public Product(String brand, String type, double minPrice, int stock){
        this.brand = brand;
        this.type = type;
        this.minPrice = minPrice;
        this.stock = stock;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public double getMinPrice() {
        return minPrice;
    }

    public void setMinPrice(double minPrice) {
        this.minPrice = minPrice;
    }


}
