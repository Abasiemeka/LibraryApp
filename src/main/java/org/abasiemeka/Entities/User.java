package org.abasiemeka.Entities;

import org.abasiemeka.Enums.Designation;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;

public class User implements Comparable<User> {
    private static ArrayList<User> userList = new ArrayList<>();
    private static AtomicInteger userIDSeed = new AtomicInteger(1000);
    private final Integer userID;
    private final String name;
    private final String email;
    private final String address;
    private final Designation designation;
    private ArrayList<Book> borrowedBooksLocker = new ArrayList<>();
    private ArrayList<Book> requestedBooksList = new ArrayList<>();
    private ArrayList<Book> toReturn = new ArrayList<>();

    public static ArrayList<User> getUserList() {
        return userList;
    }

    public Integer getUserID() {
        return userID;
    }
    public String getName() {
        return this.name;
    }

    public Designation getDesignation() {
        return this.designation;
    }

    public ArrayList<Book> getRequestedBooksList() {
        return this.requestedBooksList;
    }

    public void requestBook(Book book) {
        requestedBooksList.add(book);
        Librarian.receiveBookRequest(this);
        System.out.println("request created for " + book.getTitle() + " by " + this.name);
    }

    public void receiveBook(Book book) {
        this.requestedBooksList.remove(book);
        this.borrowedBooksLocker.add(book);
    }

    public void returnBook (ArrayList<Book> toReturn) {
        Librarian.retrieveBook(toReturn, this);
        for (Book book : toReturn){
            this.borrowedBooksLocker.remove(book);
        }
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
    public int compareTo(User user) {
        return this.designation.getPriority().compareTo(user.designation.getPriority());
    }
}