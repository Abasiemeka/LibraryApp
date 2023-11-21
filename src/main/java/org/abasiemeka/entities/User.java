package org.abasiemeka.entities;

import org.abasiemeka.enums.Designation;

import java.util.*;

public class User implements Comparable<User> {
    private final String name;
    private final Designation designation;
    private ArrayList<Book> borrowedBooksLocker = new ArrayList<>();
    private LinkedList<Book> requestedBooksList = new LinkedList<>();

    public String getName() {
        return this.name;
    }
    public LinkedList<Book> getRequestedBooksList() {
        return this.requestedBooksList;
    }

    public void requestBook(Book book) {
        System.out.println("\nrequest created for " + book.getTitle() + " by " + this.name);
        this.requestedBooksList.add(book);
        Librarian.receiveBookRequest(this);
    }

    public void receiveBook(Book book) {
        this.borrowedBooksLocker.add(book);
        System.out.printf("%n%s has been received by %s.", book.getTitle(), this.name);
    }

    public User(String name, Designation designation) {
        this.name = name;
        this.designation = designation;
        Library.addToUserList(this);
        System.out.println("\n"+this.name + " has been registered with designation " + this.designation);
    }

    @Override
    public int compareTo(User user) {
        return this.designation.getPriority().compareTo(user.designation.getPriority());
    }
}