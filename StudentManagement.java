import java.util.Scanner;

public class StudentManagement {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);   // reads user input

        String[] students = new String[100];        // array that stores student names
        int count = 0;                              // how many students are stored now
        int choice = 0;                             // menu choice

        while (choice != 4) {
            // Show menu
            System.out.println("\nStudent Management System");
            System.out.println("1. Add Student");
            System.out.println("2. View Students");
            System.out.println("3. Delete Student");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine();                     // clear the line after the number

            if (choice == 1) {
                // ADD: put the name in the first free place
                if (count == students.length) {
                    System.out.println("Array is full.");
                } else {
                    System.out.print("Enter student name: ");
                    students[count] = scanner.nextLine();
                    count++;
                    System.out.println("Student added successfully.");
                }

            } else if (choice == 2) {
                if (count == 0) {
                    System.out.println("The student list is empty.");
                } else {
                // VIEW: print all students
                System.out.println("Student List:");
                for (int i = 0; i < count; i++) {
                    System.out.println((i + 1) + ". " + students[i]);
                }
            }

            } else if (choice == 3) {
                // DELETE: shift all next elements one step to the left
                System.out.print("Enter student number to delete: ");
                int number = scanner.nextInt();
                scanner.nextLine();

                if (number < 1 || number > count) {
                    System.out.println("Invalid number.");
                } else {
                    for (int i = number - 1; i < count - 1; i++) {
                        students[i] = students[i + 1];
                    }
                    students[count - 1] = null;     // last place becomes empty
                    count--;
                    System.out.println("Student deleted successfully.");
                }

            } else if (choice == 4) {
                System.out.println("Goodbye!");
            } else {
                System.out.println("Wrong choice.");
            }
        }

        scanner.close();
    }
}