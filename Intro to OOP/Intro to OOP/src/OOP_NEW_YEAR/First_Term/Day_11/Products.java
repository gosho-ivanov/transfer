package OOP_NEW_YEAR.First_Term.Day_11;

import java.util.Arrays;

public class Products {
    private String typeProduct;
    private String name;
    private double price;
    private String bestByDate;
    private Manufacturer[] manufacturers;
    private int stock;

    public Products(String bestByDate, Manufacturer[] manufacturers, String name, double price, String typeProduct, int stock) {
        this.bestByDate = bestByDate;
        this.manufacturers = manufacturers;
        this.name = name;
        this.price = price;
        this.typeProduct = typeProduct;
        this.stock = stock;
    }

    public String getBestByDate() {
        return bestByDate;
    }

    public void setBestByDate(String bestByDate) {
        this.bestByDate = bestByDate;
    }

    public Manufacturer[] getManufacturers() {
        return manufacturers;
    }

    public void setManufacturers(Manufacturer[] manufacturer) {
        this.manufacturers = manufacturer;
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

    public String getTypeProduct() {
        return typeProduct;
    }

    public void setTypeProduct(String typeProduct) {
        this.typeProduct = typeProduct;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    @Override
    public String toString() {
        return "Products{" +
                "bestByDate='" + bestByDate + '\'' +
                ", typeProduct='" + typeProduct + '\'' +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", manufacturers=" + Arrays.toString(manufacturers) +
                ", stock=" + stock +
                '}';
    }
}
