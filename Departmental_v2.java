import java.io.*;
import java.util.*;
import java.nio.file.*;
import java.nio.charset.*;

public class Departmental_v2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("=== Library Book Management System ===\n1. Add Book\n2. View All Books\n3. Search Books\n4. Exit");
        int num1;
        String bookID, title, author, genre, availability;

        do {
            System.out.print("Enter your choice: ");
            num1 = sc.nextInt();
            sc.nextLine();
            switch (num1) {
                case 1:
                    System.out.print("Enter Book ID: ");
                    bookID = sc.nextLine();

                    System.out.print("Enter Title: ");
                    title = sc.nextLine();

                    System.out.print("Enter Author: ");
                    author = sc.nextLine();

                    System.out.print("Enter Genre: ");
                    genre = sc.nextLine();

                    System.out.print("Enter Availability (Available/Check Out): ");
                    availability = sc.nextLine();

                    try (FileWriter fw = new FileWriter("library_books.txt", true)) {
                        fw.write("ID: " + bookID + " | Title: " + title + " | Author: " + author + " | Genre: " + genre + " | Status: " + availability + "\n");
                        System.out.println("Book added successfully!");
                    } catch (IOException e) {
                        System.out.println("An error occurred while adding the book.");
                        e.printStackTrace();
                    }
                    break;

                case 2:
                    try {
                        Files.lines(Paths.get("library_books.txt"), StandardCharsets.UTF_8)
                             .forEach(System.out::println);
                    } catch (IOException e) {
                        System.out.println("Error reading the file.");
                    }
                    break;

                default:
                    System.out.println("Exiting Program...");
                    break;
            }
        } while (num1 <= 2);
        sc.close();
    }
}