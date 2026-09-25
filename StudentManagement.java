import java.util.*;

class Student {
    int id;
    String name;
    int marks;

    Student(int id, String name, int marks) {
        this.id = id;
        this.name = name;
        this.marks = marks;
    }

    public String toString() {
        return "ID: " + id + " | Name: " + name + " | Marks: " + marks;
    }
}

public class StudentManagement {
    static ArrayList<Student> students = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("\n--- Student Management ---");
            System.out.println("1. Add Student");
            System.out.println("2. View All");
            System.out.println("3. Search by ID");
            System.out.println("4. Delete by ID");
            System.out.println("5. Exit");
            System.out.print("Choose: ");
            int choice = sc.nextInt();

            if (choice == 1) addStudent();
            else if (choice == 2) viewAll();
            else if (choice == 3) search();
            else if (choice == 4) delete();
            else if (choice == 5) break;
        }
    }

    static void addStudent() {
        System.out.print("Enter ID: "); int id = sc.nextInt();
        sc.nextLine();
        System.out.print("Enter Name: "); String name = sc.nextLine();
        System.out.print("Enter Marks: "); int marks = sc.nextInt();
        students.add(new Student(id, name, marks));
        System.out.println("Student Added!");
    }

    static void viewAll() {
        if (students.isEmpty()) System.out.println("No records");
        else for (Student s : students) System.out.println(s);
    }

    static void search() {
        System.out.print("Enter ID to search: "); int id = sc.nextInt();
        for (Student s : students) {
            if (s.id == id) { System.out.println("Found: " + s); return; }
        }
        System.out.println("Not Found");
    }

    static void delete() {
        System.out.print("Enter ID to delete: "); int id = sc.nextInt();
        students.removeIf(s -> s.id == id);
        System.out.println("Deleted if existed");
    }
}