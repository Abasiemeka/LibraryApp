package org.abasiemeka;

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

//public class Main {
//	public static void main(String[] args) {
//		System.out.println("\nSetting up Library for demonstration.....\n");
//		Book bible = new Book("The Holy Bible", "Numerous", "Religion", 4);
//		Book mathsbook = new Book("New General Mathematics", "Osemeka", "Mathematics", 2);
//
//
//		Scanner scanner = new Scanner(System.in);
//
//        System.out.println("--------------Welcome to the Book Library!---------------\n");
//        System.out.println("Please enter number to proceed with corresponding action:\n");
//		System.out.println("1: Register library users.\n");
//        String name = scanner.nextLine();
//	}
//}