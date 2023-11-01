package org.abasiemeka;

import org.abasiemeka.Entities.Book;
import org.abasiemeka.Entities.Library;
import org.abasiemeka.Enums.Designation;

import javax.management.relation.Role;

public class Main {
    public static String chosenImplementation;

    public static void main(String[] args) {
        Book bible = new Book("The Holy Bible", "Inspiration", "Religion", 10);
        Library.searchByBookTitle("The Holy Bible");
    }
}