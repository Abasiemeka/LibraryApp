package org.abasiemeka;

import org.abasiemeka.entities.*;
import org.abasiemeka.enums.Designation;

/**
 * Sprint 3 Assignment.
 * <p>
 * BOOK LIBRARY
 * <p>
 * Problem Description
 * A book library where a student, teacher borrow books. When the copy of the book is no longer in the
 * library. The library should return ‘book taken’. They can be multiple copies of the same book in the
 * library.
 * <p>
 * Implementation 1:
 * The books are given by the Librarian on a first come, first served basis, however, when a teacher is
 * requesting for the same book a student is asking for, the teacher comes first, When a junior student
 * is asking for the same book a senior student is asking for, the senior student comes first.
 * <p>
 * Implementation 2:
 * The books are given by the Librarian on a first come, first served basis, whether you are a teacher,
 * a junior or a senior student.
 */

public class Main {
cd users
        
    public static void main(String[] args) {
        Book bible = new Book("The Holy Bible", "Numerous", "Religion", 4);
        Book mathsbook = new Book("New General Mathematics", "Osemeka", "Mathematics", 2);
        Library.displayCatalog();

        User andrew = new User("Andrew Teach",Designation.TEACHER);
        System.out.println("User list contains:"); Library.getUserList().forEach(user -> System.out.println(user.getName()));
        andrew.requestBook(bible);

        User jose = new User("Jose Senior",Designation.SENIOR_STUDENT);
        System.out.println("User list contains:"); Library.getUserList().forEach(user -> System.out.println(user.getName()));
        jose.requestBook(bible);
        jose.requestBook(mathsbook);

        User peter = new User("Peter Junior",Designation.JUNIOR_STUDENT);
        System.out.println("User list contains:"); Library.getUserList().forEach(user -> System.out.println(user.getName()));
        peter.requestBook(bible);

        User lara = new User("Lara Senior",Designation.SENIOR_STUDENT);
        System.out.println("User list contains:"); Library.getUserList().forEach(user -> System.out.println(user.getName()));
        lara.requestBook(bible);

        User paul = new User("Paul Junior",Designation.JUNIOR_STUDENT);
        System.out.println("User list contains:"); Library.getUserList().forEach(user -> System.out.println(user.getName()));
        paul.requestBook(bible);

        User smalls = new User("Smalls Senior",Designation.SENIOR_STUDENT);
        System.out.println("User list contains:"); Library.getUserList().forEach(user -> System.out.println(user.getName()));
        smalls.requestBook(bible);

//        Librarian.issueBooksByFIFO();
        Librarian.issueBooksByPriority();
    }
}