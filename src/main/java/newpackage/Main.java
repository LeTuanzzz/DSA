package newpackage;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        Mylist studentList = new Mylist();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nMenu:");
            System.out.println("1. Add Student");
            System.out.println("2. Edit Student");
            System.out.println("3. Delete Student");
            System.out.println("4. Display Students");
            System.out.println("5. Sort Students by Marks (Bubble Sort)");
            System.out.println("6. Sort Students by Marks (Selection Sort)");
            System.out.println("7. Search Student by ID");
            System.out.println("8. Exit");
            System.out.print("Choose an option: ");

            try {
                int choice = scanner.nextInt();
                scanner.nextLine(); // Consume newline

                switch (choice) {
                    case 1 -> {
                        String id = getValidStudentID(scanner);
                        String fullName = getValidStudentName(scanner);
                        System.out.print("Enter marks (0-10): ");
                        try {
                            double marks = getValidMarks(scanner); // Added method for valid marks
                            studentList.addStudent(new Student(id, fullName, marks));
                            System.out.println("Student added successfully.");
                        } catch (InputMismatchException e) {
                            System.out.println("Invalid input for marks. Please enter a numeric value.");
                            scanner.nextLine(); // Consume invalid input
                        }
                    }
                    case 2 -> {
                        System.out.print("Enter ID to edit: ");
                        String id = scanner.nextLine();
                        String fullName = getValidStudentName(scanner);
                        System.out.print("Enter new marks (0-10): ");
                        try {
                            double marks = getValidMarks(scanner); // Added method for valid marks
                            studentList.editStudent(id, fullName, marks);
                        } catch (InputMismatchException e) {
                            System.out.println("Invalid input for marks. Please enter a numeric value.");
                            scanner.nextLine(); // Consume invalid input
                        }
                    }
                    case 3 -> {
                        System.out.print("Enter ID to delete: ");
                        String id = scanner.nextLine();
                        studentList.deleteStudent(id);
                    }
                    case 4 -> studentList.displayStudents();
                    case 5 -> {
                        studentList.sortStudents(); // Bubble Sort
                        System.out.println("Students sorted by marks using Bubble Sort.");
                    }
                    case 6 -> {
                        studentList.selectionSortStudents(); // Selection Sort
                        System.out.println("Students sorted by marks using Selection Sort.");
                    }
                    case 7 -> {
                        System.out.print("Enter ID to search: ");
                        String id = scanner.nextLine();
                        Student foundStudent = studentList.searchStudent(id);
                        if (foundStudent != null) {
                            System.out.println("Found: " + foundStudent);
                        } else {
                            System.out.println("Student not found.");
                        }
                    }
                    case 8 -> {
                        System.out.println("Exiting...");
                        scanner.close();
                        return;
                    }
                    default -> System.out.println("Invalid choice. Try again.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a number between 1 and 8.");
                scanner.nextLine(); // Consume invalid input
            }
        }
    }

    // Function to get a valid student ID (only digits)
    private static String getValidStudentID(Scanner scanner) {
        String id;
        while (true) {
            System.out.print("Enter ID: ");
            id = scanner.nextLine();
            if (id.matches("\\d+")) { // Checks if ID contains only digits
                return id;
            } else {
                System.out.println("Invalid ID. Please enter only numeric values.");
            }
        }
    }

    // Function to get a valid student name (no digits or special characters)
    private static String getValidStudentName(Scanner scanner) {
        String fullName;
        while (true) {
            System.out.print("Enter full name: ");
            fullName = scanner.nextLine();
            if (fullName.matches("[a-zA-Z\\s]+")) { // Only letters and spaces
                return fullName;
            } else {
                System.out.println("Invalid name. Name should contain only letters and spaces.");
            }
        }
    }

    // Function to get valid marks (must be between 1 and 10)
    private static double getValidMarks(Scanner scanner) {
        double marks;
        while (true) {
            marks = scanner.nextDouble();
            scanner.nextLine(); // Consume newline
            if (marks >= 0 && marks <= 10) {
                return marks;
            } else {
                System.out.println("Invalid marks. Marks must be between 1 and 10. Please try again.");
            }
        }
    }
}
