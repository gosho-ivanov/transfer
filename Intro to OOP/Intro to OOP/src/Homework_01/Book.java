package Homework_01;

import java.util.Scanner;

public class Book {
    private String author;
    private String bookName;
    private String typeCover;
    private int pageCount;
    private String review;

    Scanner s = new Scanner(System.in);

    public Book(){}

    public Book(String newBookName, String AuthorName, int pages){
        this.bookName = newBookName;
        this.author = AuthorName;
        this.pageCount = pages;
    }


    public void setAuthor(String authorName){
        this.author = authorName;
    }
    public void setAuthor(){
        this.author = s.next();
    }
    public void setBookName(String newBookName){
        this.bookName = newBookName;
    }
    public void setCover(String cover){
        this.typeCover = cover;
    }
    public void setPageCount(int pages){
        this.pageCount = pages;
    }
    public void setReview(String newReview){
        this.review = newReview;
    }

    public String getAuthor(){
        return this.author;
    }
    public String getBookName(){
        return this.bookName;
    }
    public String getTypeCover(){
        return this.typeCover;
    }

    public int getPageCount() {
        return pageCount;
    }
    public String getReview(){
        return this.review;
    }
}
