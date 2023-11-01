package org.abasiemeka.Entities;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;

public class Book {

    private AtomicInteger bookIDSeed = new AtomicInteger(1000);
    private Integer bookID;
    private final String title;
    private final String author;
    private Integer totalNumberOfCopies;
    private Integer numberOfLendableCopies;
    private String category;

    public Book getBook() {
        return this;
    }

    public Integer getBookID() {
        return this.bookID;
    }

    public String getTitle() {
        return this.title;
    }

    public String getAuthor() {
        return this.author;
    }

    public Integer getTotalNumberOfCopies() {
        return this.totalNumberOfCopies;
    }

    public void setTotalNumberOfCopies(Integer totalNumberOfCopies) {
        this.totalNumberOfCopies = totalNumberOfCopies;
    }

    public Integer getNumberOfLendableCopies() {
        return this.numberOfLendableCopies;
    }

    public void setNumberOfLendableCopies(Integer numberOfLendableCopies) {
        this.numberOfLendableCopies = numberOfLendableCopies;
    }

    public String getCategory() { return this.category; }

    public ArrayList bookDataArrayList() {
        ArrayList bookDataArrayList = new ArrayList();
        bookDataArrayList.add(this.bookID);
        bookDataArrayList.add(this.title);
        bookDataArrayList.add(this.author);
        bookDataArrayList.add(this.category);
        bookDataArrayList.add(this.totalNumberOfCopies);
        return bookDataArrayList;
    }

    public Book(String title, String author, String category, Integer totalNumberOfCopies) {
        this.bookID = bookIDSeed.getAndIncrement();
        this.title = title;
        this.author = author;
        this.category = category;
        this.totalNumberOfCopies = totalNumberOfCopies;
        this.numberOfLendableCopies = totalNumberOfCopies;
        Library.addToCatalog(this);
        System.out.printf("%n%s copies of \"%s\" have been successfully added to the library catalog.%n", this.totalNumberOfCopies, this.title);
    }

    public void deleteBook(Book book) {
        Library.removeFromCatalog(book);
        System.out.printf("%n%s has been successfully removed from the library catalog.%n", book.title);
        book = null;
        System.gc();
    }
}