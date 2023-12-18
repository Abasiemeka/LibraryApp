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
        this.requestedBooksList.add(book);
        Librarian.receiveBookRequest(this);
    }

    public void receiveBook(Book book) {
        this.borrowedBooksLocker.add(book);
    }

    public User(String name, Designation designation) {
        this.name = name;
        this.designation = designation;
        Library.addToUserList(this);
    }

    @Override
    public int compareTo(User user) {
        return this.designation.getPriority().compareTo(user.designation.getPriority());
    }
}