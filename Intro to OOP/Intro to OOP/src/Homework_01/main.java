package Homework_01;

public class main {
    public static void main(String[] args) {
        Book myBook = new Book();

        myBook.setBookName("Dune");
        myBook.setAuthor("Frank Herbert");
        myBook.setCover("Hardcover");
        myBook.setPageCount(627);
        myBook.setReview("5/5");

        System.out.println(myBook.getBookName());
        System.out.println(myBook.getAuthor());
        System.out.println(myBook.getTypeCover());
        System.out.println(myBook.getPageCount());
        System.out.println(myBook.getReview());
    }
}
