package Homework_01;

public class main {
    public static void main(String[] args) {
        Book myBook = new Book();
        Book Book2 = new Book("Fourth Wing", "Rebbeca Yarros", 540);

        myBook.setBookName("Dune");
        myBook.setAuthor("Frank Herbert");
        myBook.setCover("Hardcover");
        myBook.setPageCount(627);
        myBook.setReview("5/5");

        Book2.setCover("Hardcover");
        Book2.setReview("5/5");

        System.out.println(myBook.getBookName());
        System.out.println(myBook.getAuthor());
        System.out.println(myBook.getTypeCover());
        System.out.println(myBook.getPageCount());
        System.out.println(myBook.getReview());

        System.out.print("THe name of the book is: " + Book2.getBookName() + ".\nThe author of the book is " + Book2.getAuthor()
                + ".\nThe book is the " + Book2.getTypeCover() + " and has " + Book2.getPageCount() + "pages. I think the book is " + Book2.getReview() + ".");
    }
}
