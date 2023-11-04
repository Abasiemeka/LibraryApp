package org.abasiemeka;

import org.abasiemeka.Entities.Book;
import org.abasiemeka.Entities.Librarian;
import org.abasiemeka.Entities.Library;
import org.abasiemeka.Entities.User;
import org.abasiemeka.Enums.Designation;

public class Main {
    public static String chosenImplementation = "sorted";

    public static void main(String[] args) {
        Book bible = new Book("The Holy Bible", "Inspiration", "Religion", 10);
        Library.searchByBookTitle("The Holy Bible");

        User andrew = new User("Andrew Teach","hghgffk","dhfjgkjhhsagfdg",Designation.TEACHER);

        System.out.println("User list contains:"); User.getUserList().forEach(user -> System.out.println(user.getName()));
        printCollections();

        andrew.borrowBook(bible);
        printCollections();

        User jose = new User("Jose Three","hghgffk","dhfjgkjhhsagfdg",Designation.STUDENT_GRADE_3);

        System.out.println("User list contains:"); User.getUserList().forEach(user -> System.out.println(user.getName()));
        printCollections();

        jose.borrowBook(bible);
        printCollections();

        User peter = new User("Peter One","hghgffk","dhfjgkjhhsagfdg",Designation.STUDENT_GRADE_1);

        System.out.println("User list contains:"); User.getUserList().forEach(user -> System.out.println(user.getName()));
        printCollections();

        peter.borrowBook(bible);
        printCollections();

        User lara = new User("Lara Three","hghgffk","dhfjgkjhhsagfdg",Designation.STUDENT_GRADE_3);

        System.out.println("User list contains:"); User.getUserList().forEach(user -> System.out.println(user.getName()));
        printCollections();

        lara.borrowBook(bible);
        printCollections();

        User paul = new User("Paul Two","hghgffk","dhfjgkjhhsagfdg",Designation.STUDENT_GRADE_2);

        System.out.println("User list contains:"); User.getUserList().forEach(user -> System.out.println(user.getName()));
        printCollections();

        paul.borrowBook(bible);
        printCollections();

        User smalls = new User("Smalls Two","hghgffk","dhfjgkjhhsagfdg",Designation.STUDENT_GRADE_2);

        System.out.println("User list contains:"); User.getUserList().forEach(user -> System.out.println(user.getName()));
        printCollections();

        smalls.borrowBook(bible);
        printCollections();


        System.out.println(paul.compareTo(peter));
        System.out.println(paul.compareTo(lara));
    }

    public static void printCollections() {
        System.out.println("Book requests array contains: "); Librarian.printBookRequestsFIFO();
        System.out.println("Sorted book requests tree set contains: "); Librarian.printBookRequestsSorted();
    }
}