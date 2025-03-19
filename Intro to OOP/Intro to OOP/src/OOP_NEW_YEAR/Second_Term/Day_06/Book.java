package OOP_NEW_YEAR.Second_Term.Day_06;

public class Book extends Stocks{
    private String author;
    private String title;

    public Book(double price, int serialNumber, String author, String title) {
        super(price, serialNumber);
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
    public double checkPromo() {
        return this.getPrice() * 0.85;
    }
}
