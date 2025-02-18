package OOP_NEW_YEAR.First_Term.Day_09;

public class Book extends Product{
    private String author;
    private String title;

    public Book(String inventoryNumber, double price, Provider provider, int quantity, String author, String title) {
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
        return this.getPrice() * 0.5;
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
