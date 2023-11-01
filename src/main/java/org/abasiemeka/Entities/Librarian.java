package org.abasiemeka.Entities;

import org.abasiemeka.Main;

import java.util.Hashtable;
import java.util.Map;

public class Librarian {
    private static Hashtable<Book, User> bookRequestsFIFO = new Hashtable<>();
    private static Hashtable<Book, User> bookRequestsSorted = new Hashtable<>();

    public static void addToBookRequestsFIFO(Book book, User user) {
        bookRequestsFIFO.put(book, user);
        bookRequestsSorted = sortByDesignationPriority(bookRequestsFIFO);
    }

    public static Boolean authorizedToBorrow(User user) {
        return Boolean.TRUE; //FIXME: implement properly
    }

    private static Hashtable<Book, User> sortByDesignationPriority(Hashtable<Book, User> bookRequestsFIFO) {
        //todo: change borrowedbooks vollection to linkedhashmap or linkedhashset to maintain the order of entries

        return null; //FIXME: implement properly
    }

    public static void issueBook(Book book, User user) {
        if (!authorizedToBorrow(user)) {
            System.out.printf("%n%s is not authorized to borrow from the library.", user.getName());
            return;
        }

        //Use the provided implementation option to decide method of issuance.
        boolean sorted = Main.chosenImplementation.equalsIgnoreCase("sorted");
        if (!sorted) {
            //Do FIFO
        } else {
            //Do Sort by designation priority
        }
    }
}