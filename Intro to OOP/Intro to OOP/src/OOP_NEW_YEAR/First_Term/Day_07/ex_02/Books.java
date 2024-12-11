package OOP_NEW_YEAR.First_Term.Day_07.ex_02;

public class Books extends Products{
    private String title;
    private String author;

    public Books(double price, int productID, String author, String title) {
        super(price, productID);
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
    public double checkPromo(int percent){
        return this.getPrice() * ((100-percent)/100);
    }
}
