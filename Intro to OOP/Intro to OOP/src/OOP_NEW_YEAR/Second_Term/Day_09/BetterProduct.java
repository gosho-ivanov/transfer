package OOP_NEW_YEAR.Second_Term.Day_09;

public class BetterProduct extends Product implements Buyable{
    public BetterProduct(int id, String name, int quantity) throws InvalidNumberException {
        super(id, name, quantity);
    }

    @Override
    public int buy(int quantity) {
        if (quantity <= 0){
            throw new RuntimeException("The quantity cannot be 0 or less.");
        } else if (this.getQuantity() - quantity < 0) {
            throw new RuntimeException("There is not enough quantity of the product you are trying to buy.");
        } else {
            this.setQuantity(this.getQuantity() - quantity);
            return this.getId();
        }
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
