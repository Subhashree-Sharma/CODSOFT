import java.util.ArrayList;
import java.util.List;

public class StudentManagementSystem {
    private List<Student> students;

    // Constructor
    public StudentManagementSystem() {
        students = new ArrayList<>();
    }

    // Method to add a student
    public void addStudent(Student student) {
        students.add(student);
    }

    // Method to remove a student
    public void removeStudent(int rollNumber) {
        students.removeIf(student -> student.getRollNumber() == rollNumber);
    }

    // Method to search for a student by roll number
    public Student searchStudent(int rollNumber) {
        for (Student student : students) {
            if (student.getRollNumber() == rollNumber) {
                return student;
            }
        }
        return null; // Student not found
    }

    // Method to display all students
    public void displayAllStudents() {
        if (students.isEmpty()) {
            System.out.println("No students in the system.");
        } else {
            System.out.println("List of Students:");
            for (Student student : students) {
                System.out.println(student);
            }
        }
    }
}
