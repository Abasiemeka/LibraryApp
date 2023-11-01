package org.abasiemeka.Entities;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.concurrent.atomic.AtomicInteger;
import org.abasiemeka.Enums.Designation;

public abstract class User {
    private static Hashtable<Integer, User> userList = new Hashtable<>();
    private static AtomicInteger userIDSeed = new AtomicInteger(1000);
    private Integer userID;
    private String name;
    private String email;
    private String address;
    private Designation designation;
    private HashMap<Integer, Book> bookLocker = new HashMap<>();

    public String getName() {
        return this.name;
    }

    public void borrowBook(Book book) {
        Librarian.addToBookRequestsFIFO(book, this);
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
}