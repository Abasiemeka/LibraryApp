package org.abasiemeka.Entities;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import org.abasiemeka.Enums.Designation;
import org.jetbrains.annotations.NotNull;

public class User implements Comparable<User> {
    private static Hashtable<Integer, User> userList = new Hashtable<>();
    private static AtomicInteger userIDSeed = new AtomicInteger(1000);
    private Integer userID;
    private String name;
    private String email;
    private String address;
    private Designation designation;
    private HashMap<Integer, Book> borrowedBooksLocker = new HashMap<>();
    private ArrayList<Book> requestedBooksList = new ArrayList<>();

    public String getName() {
        return this.name;
    }

    public void borrowBook(Book book) {
        this.addToRequestedBooksList(book);
        Librarian.addToBookRequestsFIFO(this);
    }

    private void addToRequestedBooksList(Book book) {
        requestedBooksList.add(book);
    }

    public void returnBook (Book book) {

    }

    public User(String name, String email, String address, Designation designation) {
        this.userID = Integer.valueOf(userIDSeed.getAndIncrement());
        this.name = name;
        this.email = email;
        this.address = address;
        this.designation = designation;
        userList.put(this.userID, this);
    }

    @Override
    public int compareTo(@NotNull User user) {
        return this.designation.compareTo(user.designation);
    }
}