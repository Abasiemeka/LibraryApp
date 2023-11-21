package org.abasiemeka.entities;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;

public class Book {

    private AtomicInteger bookIDSeed = new AtomicInteger(1000);
    private Integer bookID;
    private final String title;
    private Integer totalNumberOfCopies;

    public Integer getBookID() {
        return this.bookID;
    }

    public String getTitle() {
        return this.title;
    }

    public Integer getTotalNumberOfCopies() {
        return this.totalNumberOfCopies;
    }

    public Book(String title, String author, String category, Integer totalNumberOfCopies) {
        this.bookID = bookIDSeed.getAndIncrement();
        this.title = title;
        this.totalNumberOfCopies = totalNumberOfCopies;
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