package org.abasiemeka.Entities;

import org.abasiemeka.Enums.Designation;
import org.abasiemeka.Main;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class Librarian {
    private static ArrayList<User> bookRequestsFIFO = new ArrayList<>();
    private static ArrayList<User> bookRequestsSorted = new ArrayList<>();

    private static Boolean authorizedToBorrow(User user) {
        for (Designation designation : Designation.values())
            if (designation == user.getDesignation())
                return true;
        return false;
    }

    private static void sortBookRequests() {
        bookRequestsSorted = (ArrayList<User>) bookRequestsFIFO.stream().sorted(User::compareTo).collect(Collectors.toList());
    }

    public static void receiveBookRequest(User user) {
        bookRequestsFIFO.add(user);
    }

    public static void retrieveBook(ArrayList<Book> books, User borrower) {
        for (Book book : books) {
            Library.receiveBook(book, borrower);
        }
    }

    private static void decideAndIssueBooks() {
        boolean sorted = Main.chosenImplementation.equalsIgnoreCase("sorted");
        if (!sorted) {
            issueFromArrayList(bookRequestsFIFO);
        } else {
            issueFromArrayList(bookRequestsSorted);
        }
    }

    private static void issueFromArrayList(ArrayList<User> bookRequestArrayList) {
        for (User user : bookRequestArrayList) {
            if (!authorizedToBorrow(user)) {
                System.out.printf("%n%s is not authorized to borrow from the library.", user.getName());
                return;
            } else {
                for (Book book : user.getRequestedBooksList()) {
                    Library.giveBook(book, user);
                    user.receiveBook(book);
                    Librarian.bookRequestsFIFO.remove(user);
                    sortBookRequests();
                }
            }
        }
    }

    //TODO: only for testing. Delete after use.
    public static void printBookRequestsFIFO() {
        bookRequestsFIFO.forEach(user -> System.out.println(user.getName()));
    }
    public static void printBookRequestsSorted() {
            bookRequestsSorted.forEach(user -> System.out.println(user.getName()));
    }
}