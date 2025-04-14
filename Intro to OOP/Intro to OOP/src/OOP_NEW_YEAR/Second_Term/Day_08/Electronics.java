package OOP_NEW_YEAR.Second_Term.Day_08;

public class Electronics extends Product{
    private String manufacturer;
    private String model;

    public Electronics(int inventoryNumber, double price, Provider provider, int quantity, String model, String manufacturer) {
        super(inventoryNumber, price, provider, quantity);
        this.model = model;
        this.manufacturer = manufacturer;
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
    public boolean sellProduct(int piece) throws NoMoreProductsException{
        if (this.getQuantity() > 0) {
            if (this.getQuantity() - piece >= 0) {
                this.setQuantity(this.getQuantity() - piece);
                double total = piece * this.getPrice();
                System.out.println("Total: "+ total);
                return true;
            } else {
                System.out.println("There aren't enough pieces of the product you want to buy.");
                return false;
            }
        } else {
            throw new NoMoreProductsException();
        }
    }

    @Override
    public double getPromotionalPrice() {
        return this.getPrice() * (1 - 0.1);
    }


}
