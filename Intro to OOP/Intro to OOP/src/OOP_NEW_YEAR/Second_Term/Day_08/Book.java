package OOP_NEW_YEAR.Second_Term.Day_08;

public class Book extends Product{
    private String author;
    private String title;

    public Book(int inventoryNumber, double price, Provider provider, int quantity, String author, String title) {
        super(inventoryNumber, price, provider, quantity);
        this.author = author;
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public double getPromotionalPrice() {
        return this.getPrice() * (1 - 0.5);
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
}
