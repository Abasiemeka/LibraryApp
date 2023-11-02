package org.abasiemeka;

import org.abasiemeka.Entities.Book;
import org.abasiemeka.Entities.Librarian;
import org.abasiemeka.Entities.Library;
import org.abasiemeka.Entities.User;
import org.abasiemeka.Enums.Designation;

import javax.management.relation.Role;

public class Main {
    public static String chosenImplementation = "sorted";

    public static void main(String[] args) {
        Book bible = new Book("The Holy Bible", "Inspiration", "Religion", 10);
        Library.searchByBookTitle("The Holy Bible");

        User andrew = new User("Andrew","hghgffk","dhfjgkjhhsagfdg",Designation.TEACHER);
        System.out.println(Librarian.getBookRequestsFIFO());
        System.out.println(Librarian.getBookRequestsSorted());
        andrew.borrowBook(bible);
        System.out.println(Librarian.getBookRequestsFIFO());
        System.out.println(Librarian.getBookRequestsSorted());

        User jose = new User("Jose","hghgffk","dhfjgkjhhsagfdg",Designation.STUDENT_GRADE_1);
        System.out.println(Librarian.getBookRequestsFIFO());
        System.out.println(Librarian.getBookRequestsSorted());
        jose.borrowBook(bible);
        System.out.println(Librarian.getBookRequestsFIFO());
        System.out.println(Librarian.getBookRequestsSorted());

        User peter = new User("Peter","hghgffk","dhfjgkjhhsagfdg",Designation.STUDENT_GRADE_2);
        System.out.println(Librarian.getBookRequestsFIFO());
        System.out.println(Librarian.getBookRequestsSorted());
        peter.borrowBook(bible);
        System.out.println(Librarian.getBookRequestsFIFO());
        System.out.println(Librarian.getBookRequestsSorted());

        User lara = new User("Lara","hghgffk","dhfjgkjhhsagfdg",Designation.STUDENT_GRADE_3);
        System.out.println(Librarian.getBookRequestsFIFO());
        System.out.println(Librarian.getBookRequestsSorted());
        lara.borrowBook(bible);
        System.out.println(Librarian.getBookRequestsFIFO());
        System.out.println(Librarian.getBookRequestsSorted());

        User paul = new User("Paul","hghgffk","dhfjgkjhhsagfdg",Designation.STUDENT_GRADE_2);
        System.out.println(Librarian.getBookRequestsFIFO());
        System.out.println(Librarian.getBookRequestsSorted());
        paul.borrowBook(bible);
        System.out.println(Librarian.getBookRequestsFIFO());
        System.out.println(Librarian.getBookRequestsSorted());

        User smalls = new User("Smalls","hghgffk","dhfjgkjhhsagfdg",Designation.STUDENT_GRADE_2);
        System.out.println(Librarian.getBookRequestsFIFO());
        System.out.println(Librarian.getBookRequestsSorted());
        smalls.borrowBook(bible);
        System.out.println(Librarian.getBookRequestsFIFO());
        System.out.println(Librarian.getBookRequestsSorted());
    }
}