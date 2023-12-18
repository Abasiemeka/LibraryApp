package org.abasiemeka.entities;

import java.util.*;

public final class Library {
    private static ArrayList<User> userList = new ArrayList<>();
    private static HashMap<Book, Integer> catalog = new HashMap<>();
    private static HashMap<User, ArrayList<Book>> currentlyBorrowed = new HashMap<>();


    public static void addToUserList(User user) {
        userList.add(user);
    }

    public static void addToCatalog(Book book, int totalNumberOfCopies) {
        catalog.put(book, totalNumberOfCopies);
    }

    public static void removeFromCatalog(Book book) {
        catalog.remove(book);
    }

    public static void displayCatalog() {
    
//        for (Map.Entry<Book, Integer> entry : catalog.entrySet()) {
//            System.out.printf("%n" + ": %s (Copies available: %s).", entry.getKey().getTitle(), entry.getValue());
//        }
        
        //FIXME: Refactored from above commented out code for sprint 4 task
        catalog.forEach((key, value) -> System.out.printf("%n" + ": %s (Copies available: %s).", key.getTitle(), value));
    }

    public static void giveBook(Book book, User borrower) {
        if (catalog.get(book) == 0)
            System.out.printf("\nInsufficient copies of %s in catalog to lend to %s (Book taken)", book.getTitle(), borrower.getName());
        else {
            catalog.replace(book, catalog.get(book)-1);
            System.out.printf("\nNumber of available copies of %s in catalog has been updated to %s.", book.getTitle(), catalog.get(book));
            ArrayList<Book> books;
            if (currentlyBorrowed.containsKey(borrower)) {
                books = currentlyBorrowed.get(borrower);
                books.add(book);
                currentlyBorrowed.replace(borrower, books);
            }
            else {
                currentlyBorrowed.put(borrower, new ArrayList<>(List.of(book)));
            }
            System.out.printf("\n%s has been issued to %s.",book.getTitle(), borrower.getName());
            borrower.receiveBook(book);
        }
    }

    public static ArrayList<User> getUserList() {
        return userList;
    }
}