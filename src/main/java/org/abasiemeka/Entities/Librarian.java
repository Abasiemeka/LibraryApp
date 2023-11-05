package org.abasiemeka.Entities;

import org.abasiemeka.Main;

import java.util.*;
import java.util.stream.Collectors;

public class Librarian {
    private static ArrayList<User> bookRequestsFIFO = new ArrayList<>();
    private static ArrayList<User> bookRequestsSorted = new ArrayList<>();

    public static void addToBookRequestsFIFO(User user) {
        bookRequestsFIFO.add(user);
        bookRequestsSorted = sortByDesignationPriority(bookRequestsFIFO);
    }

    public static Boolean authorizedToBorrow(User user) {
        return Boolean.TRUE; //FIXME: implement properly
    }

    private static ArrayList<User> sortByDesignationPriority(ArrayList<User> bookRequestsFIFO) {
        return (ArrayList<User>) bookRequestsFIFO.stream().sorted(User::compareTo).collect(Collectors.toList());
    }

    public static void issueBooks() {
        boolean sorted = Main.chosenImplementation.equalsIgnoreCase("sorted");
        if (!sorted) {
            //Issue by FIFO
            for (User user : bookRequestsFIFO) {
                if (!authorizedToBorrow(user)) {
                    System.out.printf("%n%s is not authorized to borrow from the library.", user.getName());
                    return;
                } else {
                    for (Book book : user.getRequestedBooksList()) {
                        Library.giveBook(book, user);
                        user.receiveBook(book);
                    }
                }
            }
        } else {
            //Issue by designation priority
            for (User user : bookRequestsSorted){
                if (!authorizedToBorrow(user)) {
                    System.out.printf("%n%s is not authorized to borrow from the library.", user.getName());
                    return;
                } else {
                    for (Book book : user.getRequestedBooksList()) {
                        Library.giveBook(book, user);
                        user.receiveBook(book);
                    }
                }
            }
        }
    }

    //FIXME: only for testing. Delete after use.

    public static void printBookRequestsFIFO() {
        bookRequestsFIFO.forEach(user -> System.out.println(user.getName()));
    }
    public static void printBookRequestsSorted() {
            bookRequestsSorted.forEach(user -> System.out.println(user.getName()));
    }
    public static ArrayList<User> getBookRequestsFIFO() {
        return bookRequestsFIFO;
    }
    public static ArrayList<User> getBookRequestsSorted() {
        return bookRequestsSorted;
    }
}