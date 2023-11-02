package org.abasiemeka.Entities;

import org.abasiemeka.Main;

import java.util.TreeSet;
import java.util.stream.Stream;

public class Librarian {
    private static TreeSet<User> bookRequestsFIFO = new TreeSet<>();
    private static TreeSet<User> bookRequestsSorted = new TreeSet<>();

    public static void addToBookRequestsFIFO(User user) {
        bookRequestsFIFO.add(user);
        bookRequestsSorted = sortByDesignationPriority(bookRequestsFIFO);
    }

    public static Boolean authorizedToBorrow(User user) {
        return Boolean.TRUE; //FIXME: implement properly
    }

    private static TreeSet<User> sortByDesignationPriority(TreeSet<User> bookRequestsFIFO) {
        //FIXME: Fix this method
        Stream<User> e = bookRequestsFIFO.stream().sorted();
        bookRequestsSorted.add();
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

    public static void printTreeSet(TreeSet<?> treeSet) {
        System.out.println(treeSet);
    }


    //FIXME: only for testing. Delete after use.
    public static TreeSet<User> getBookRequestsFIFO() {
        return bookRequestsFIFO;
    }
    public static TreeSet<User> getBookRequestsSorted() {
        return bookRequestsSorted;
    }
}