import java.util.ArrayList;
import java.util.Scanner;

class Home1Student {
    private String id;
    private String name;
    private String email;
    public Home1Student(String id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public String getEmail() {
        return email;
    }
    @Override
    public String toString() {
        return "ID: " + id + ", Name: " + name + ", Email: " + email;
    }
}
public class home1 {
    public static Scanner sc = new Scanner(System.in);
    public static final ArrayList<Home1Student> students = new ArrayList<>();
    public static void main(String[] args) {
        int op = 0;
        do {
            System.out.println("------------- Student Management System ---------------");
            System.out.println("1. Add Student");
            System.out.println("2. List Students");
            System.out.println("3. Search Student");
            System.out.println("4. Remove Student");
            System.out.println("5. Exit");
            System.out.print("Choose option (1-5): ");
            op = sc.nextInt();
            sc.nextLine(); 

            switch (op) {
                case 1:
                    AddStudent();
                    break;
                case 2:
                    ListStudents();
                    break;
                case 3:
                    SearchStudent();
                    break;
                case 4:
                    RemoveStudent();
                    break;
                case 5:
                    System.out.println("Exiting system. Goodbye!");
                    return;
                default:
                    System.out.println("Invalid input. Please try again.");
            }
        } while (op < 5);
    }
    private static void AddStudent() {
        System.out.println("======== Add Student ========");
        System.out.print("Enter student ID: ");
        String id = sc.nextLine();
        System.out.print("Enter student name: ");
        String name = sc.nextLine();
        System.out.print("Enter student email: ");
        String email = sc.nextLine();
        Home1Student student = new Home1Student(id, name, email);
        students.add(student);
        System.out.println("Student added successfully!");
    }
    private static void ListStudents() {
        if (students.isEmpty()) {
            System.out.println("No students found.");
        } else {
            System.out.println("======== List of Students ========");
            for (Home1Student student : students) {
                System.out.println(student);
            }
        }
    }
    private static void SearchStudent() {
        System.out.println("======== Search Student ========");
        System.out.print("Enter student ID to search: ");
        String id = sc.nextLine();
        boolean found = false;
        for (Home1Student student : students) {
            if (student.getId().equals(id)) {
                System.out.println("Student found: " + student);
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("Student not found.");
        }
    }
    private static void RemoveStudent() {
        System.out.println("======== Remove Student ========");
        System.out.print("Enter student ID to remove: ");
        String id = sc.nextLine();
        boolean removed = false;
        for (Home1Student student : students) {
            if (student.getId().equals(id)) {
                students.remove(student);
                System.out.println("Student removed successfully!");
                removed = true;
                break;
            }
        }
        if (!removed) {
            System.out.println("Student not found.");
        }
    }
}