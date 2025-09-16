package OOP_NEW_YEAR.Second_Term.Day_09;

public class Product implements Buyable{
    private int id;
    private int quantity;
    private String name;

    public Product(int id, String name, int quantity) throws InvalidNumberException{
        if (id > 0 && quantity >= 0) {
            this.id = id;
            this.name = name;
            this.quantity = quantity;
        } else if (id <= 0) {
            throw new InvalidNumberException("The id cannot be a number that is less than 1.");
        } else if (quantity < 0) {
            throw new InvalidNumberException("The quantity of a product cannot be less than 0.");
        }
    }

    public int getId() {
        return id;
    }

    public void setId(int id) throws InvalidNumberException{
        if (id <= 0) {
            throw new InvalidNumberException("The id cannot be a number that is less than 1.");
        } else {
            this.id = id;
        }
    }

    public String getName() {
        return name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        if (quantity < 0) {
            throw new InvalidNumberException("The quantity of a product cannot be less than 0.");
        } else {
            this.quantity = quantity;
        }
    }

    @Override
    public int buy(int quantity) {
        if (quantity <= 0 || this.quantity - quantity < 0){
            return -1;
        } else {
            this.quantity = this.quantity - quantity;
            return this.id;
        }
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", quantity=" + quantity +
                ", name='" + name + '\'' +
                '}';
    }
}
