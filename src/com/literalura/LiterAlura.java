package com.literalura;

import java.util.Scanner;

public class LiterAlura {
    public static void main(String[] args) {
        Database.createTable();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Choose an option:");
            System.out.println("1. Search books");
            System.out.println("2. View all books");
            System.out.println("3. Exit");

            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            switch (choice) {
                case 1:
                    System.out.println("Enter search term:");
                    String query = scanner.nextLine();
                    String response = BookAPI.getBooks(query);
                    BookParser.parseBooks(response);
                    break;
                case 2:
                    // Display all books from the database
                    break;
                case 3:
                    System.out.println("Goodbye!");
                    return;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }
}
