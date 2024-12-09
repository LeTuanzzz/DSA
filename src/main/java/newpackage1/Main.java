package newpackage1;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        MyStack studentStack = new MyStack();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Menu:");
            System.out.println("1. Add Student");
            System.out.println("2. Remove Student");
            System.out.println("3. Display Students");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");

            if (!scanner.hasNextInt()) {
                System.out.println("Invalid input. Please enter a number between 1 and 4.");
                scanner.next(); // Consume invalid input
                continue;
            }

            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (choice) {
                case 1 -> {
                    System.out.print("Enter ID: ");
                    String id = scanner.nextLine();
                    System.out.print("Enter full name: ");
                    String fullName = scanner.nextLine();
                    System.out.print("Enter marks: ");
                    if (!scanner.hasNextDouble()) {
                        System.out.println("Invalid input for marks. Please enter a numeric value.");
                        scanner.next(); // Consume invalid input
                        continue;
                    }
                    double marks = scanner.nextDouble();
                    scanner.nextLine(); // consume newline
                    studentStack.push(new Student(id, fullName, marks));
                }
                case 2 -> {
                    Student removedStudent = studentStack.pop();
                    if (removedStudent != null) {
                        System.out.println("Removed: " + removedStudent);
                    }
                }
                case 3 -> studentStack.displayStack();
                case 4 -> {
                    System.out.println("Exiting...");
                    scanner.close();
                    return;
                }
                default -> System.out.println("Invalid choice. Please enter a number between 1 and 4.");
            }
        }
    }
}
