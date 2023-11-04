package org.abasiemeka.Entities;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import org.abasiemeka.Enums.Designation;
import org.jetbrains.annotations.NotNull;

public class User implements Comparable<User> {
    private static ArrayList<User> userList = new ArrayList<>();
    private static AtomicInteger userIDSeed = new AtomicInteger(1000);
    private Integer userID;
    private String name;
    private String email;
    private String address;
    private Designation designation;
    private HashMap<Integer, Book> borrowedBooksLocker = new HashMap<>();
    private ArrayList<Book> requestedBooksList = new ArrayList<>();

    public static ArrayList<User> getUserList() {
        return userList;
    }

    public String getName() {
        return this.name;
    }
    public Designation getDesignation() { return this.designation;}

    public void borrowBook(Book book) {
        requestedBooksList.add(book);
        Librarian.addToBookRequestsFIFO(this);
        System.out.println("request created for " + book.getTitle() + " by " + this.name);
    }

    public void returnBook (Book book) {

    }

    public User(String name, String email, String address, Designation designation) {
        this.userID = Integer.valueOf(userIDSeed.getAndIncrement());
        this.name = name;
        this.email = email;
        this.address = address;
        this.designation = designation;
        userList.add(this);
        System.out.println(this.name + " has been registered with designation " + this.designation);
    }

    @Override
    public int compareTo(@NotNull User user) {
        return this.designation.getPriority().compareTo(user.designation.getPriority());
    }
}