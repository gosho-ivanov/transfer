package OOP_NEW_YEAR.First_Term.Day_09;

public class Electronics extends Product{
    private String manufacturer;
    private String model;

    public Electronics(String inventoryNumber, double price, Provider provider, int quantity, String manufacturer, String model) {
        super(inventoryNumber, price, provider, quantity);
        this.manufacturer = manufacturer;
        this.model = model;
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

    @Override
    public double getPromotionalPrice(){
        return this.getPrice() * 0.9;
    }

    @Override
    public boolean sellProduct(int quantity) {
        if (this.getQuantity() > 0){
            this.setQuantity(this.getQuantity() - quantity);
            return true;
        } else {
            return false;
        }
    }
}
