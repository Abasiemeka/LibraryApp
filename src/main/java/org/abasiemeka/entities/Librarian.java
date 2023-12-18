package org.abasiemeka.entities;

import org.abasiemeka.interfaces.Issuer;

import java.util.ArrayList;
import java.util.LinkedList;

public final class Librarian {
    private static LinkedList<User> borrowRequestsList = new LinkedList<>();
    private static ArrayList<User> borrowRequestsSorted = new ArrayList<>();


    public static void receiveBookRequest(User user) {
        if (!borrowRequestsList.contains(user)) {
            if (!borrowRequestsList.offer(user))
                System.out.printf("\n%s's book request not accepted.", user.getName());
            else
                System.out.printf("\n%s's book request received by Librarian.", user.getName());
        }
        else System.out.printf("\n%s's book request received by Librarian.", user.getName());

        System.out.println("\n\nBorrow requests list now contains:\n");
        borrowRequestsList.forEach(requester->System.out.printf("%n%s (no. of books: %s),",requester.getName(), requester.getRequestedBooksList().size()));
    }

    public static Issuer issueBooksByFifo = () -> {
        System.out.println("\nAttending to borrow requests in the following order: \n");
        borrowRequestsList.forEach(requester->System.out.println(requester.getName() + ","));
        while (!borrowRequestsList.isEmpty()) {
            User requester = borrowRequestsList.poll();
            requester.getRequestedBooksList().forEach(book -> Library.giveBook(book,requester));    //FIXME: Refactored from above commented out code for sprint 4 task
            System.out.printf("\nAll %s's book requests have been treated.", requester.getName());
        }
        System.out.println("\nAll book requests have been treated in first-come first-served order.");
    };

//    public static void issueBooksByFIFO() {
//        System.out.println("\nAttending to borrow requests in the following order: \n");
//        borrowRequestsList.forEach(requester->System.out.println(requester.getName() + ","));
//            while (!borrowRequestsList.isEmpty()) {
//                User requester = borrowRequestsList.poll();
//
///*                for (Book book : requester.getRequestedBooksList()) {
//                    Library.giveBook(Objects.requireNonNull(book), requester);
//                }
//*/
//                //FIXME: Refactored from above commented out code for sprint 4 task
//                requester.getRequestedBooksList().forEach(book -> Library.giveBook(book,requester));
//                System.out.printf("\nAll %s's book requests have been treated.", requester.getName());
//            }
//            System.out.println("\nAll book requests have been treated in first-come first-served order.");
//    }

//    public static void issueBooksByPriority() {
//        borrowRequestsSorted.addAll(borrowRequestsList);
//        borrowRequestsSorted.sort(User::compareTo);
//        System.out.println("\n\nAttending to borrow requests in the following order: \n");
//        borrowRequestsSorted.forEach(requester->System.out.println(requester.getName() + ","));
//
//        for (User requester : borrowRequestsSorted) {
//            while (!requester.getRequestedBooksList().isEmpty()) {
//                Library.giveBook(Objects.requireNonNull(requester.getRequestedBooksList().poll()), requester);
//            }
//            System.out.printf("\nAll %s's book requests have been treated.", requester.getName());
//        }
//        borrowRequestsSorted.clear();
//        System.out.println("\n\nAll requests have been treated by designation priority.");
//    }
    public static void Issuer issueBooksByPriority() = ()
}