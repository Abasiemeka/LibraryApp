package org.abasiemeka.Entities;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;

public class Library {

    private static HashMap<Book, ArrayList<?>> catalog = new HashMap<>();
    private static HashMap<Book, User> currentlyBorrowed = new HashMap<>();

    public static HashMap<Book, ArrayList<?>> getCatalog(){
        return catalog;
    }

    public static void addToCatalog(Book book) {
        catalog.put(book, book.bookDataArrayList());
    }
    public static void removeFromCatalog(Book book) { catalog.remove(book); }

    public static void displayCatalog() {
        for (ArrayList<?> bookData : catalog.values()) {
            int sn = 1;
            System.out.printf("%nsn: %s", String.valueOf(bookData));
            ++sn;
        }
    }
    public static void searchByAuthor(String author) {
        System.out.println("\nThe following books by " + author + " are available in our catalog:");
        for (Book book : catalog.keySet()
             ) {
            if (book.getAuthor().equalsIgnoreCase(author)) {
                System.out.println("\n" + book.getTitle());
            }
        }
    }
    public static void searchByCategory(String category) {
        System.out.println("\nThe following books in " + category + " category are available in our catalog:");
        for (Book book : catalog.keySet()
             ) {
            if (book.getCategory().equalsIgnoreCase(category)) {
                System.out.println("\n" + book.getTitle());
            }
        }
    }
    public static void searchByBookID(Integer bookID) {
        for (Book book : catalog.keySet())
            if (Objects.equals(book.getBookID(), bookID)) {
                System.out.printf("%nFound in Catalog:%nBook ID: %s%nBook Title: %s%nAuthor: %s%nCategory: %s%nCopies Available: %s%n",
                        book.getBookID(), book.getTitle(), book.getAuthor(), book.getCategory(), book.getNumberOfLendableCopies());
            }
    }
    public static void searchByBookTitle(String bookTitle) {
        for (Book book : catalog.keySet())
            if (book.getTitle().equalsIgnoreCase(bookTitle)) {
                System.out.printf("%nFound in Catalog:%nBook ID: %s%nBook Title: %s%nAuthor: %s%nCategory: %s%nCopies Available: %s%n",
                        book.getBookID(), book.getTitle(), book.getAuthor(), book.getCategory(), book.getNumberOfLendableCopies());
            }
    }

    public void giveBook(Book book, User borrower) {
        book.setNumberOfLendableCopies(book.getNumberOfLendableCopies() - 1);
        currentlyBorrowed.put(book, borrower);
    }

    public void receiveBook(Book book, User borrower) {
        book.setNumberOfLendableCopies(book.getNumberOfLendableCopies() + 1);
        currentlyBorrowed.remove(book);
    }
}