 import java.util.Scanner;

public class UniqueGradeCalculator {
    public static void main(String[] args) {
        Scanner a = new Scanner(System.in);
        
        System.out.println("Welcome to the Grade Calculator!");
        System.out.print("Please enter the number of subjects you took this semester: ");
        int numSubjects = a.nextInt();
        
        int[] marks = new int[numSubjects];
        
        System.out.println("\nEnter marks obtained in each subject (out of 100):");
        for (int i = 0; i < numSubjects; i++) {
            System.out.print("Subject " + (i+1) + ": ");
            marks[i] = a.nextInt();
            if (marks[i] < 0 || marks[i] > 100) {
                System.out.println("Invalid input! Marks should be between 0 and 100. Please try again.");
                i--; 
            }
        }
        
        int totalMarks = 0;
        for (int mark : marks) {
            totalMarks += mark;
        }
        
        double averagePercentage = (double) totalMarks / numSubjects;
        
        char grade;
        if (averagePercentage >= 90) {
            grade = 'A';
        } else if (averagePercentage >= 80) {
            grade = 'B';
        } else if (averagePercentage >= 70) {
            grade = 'C';
        } else if (averagePercentage >= 60) {
            grade = 'D';
        } else {
            grade = 'F';
        }
        
        System.out.println("\nResults:");
        System.out.println("Total Marks: " + totalMarks);
        System.out.println("Average Percentage: " + String.format("%.2f", averagePercentage) + "%");
        System.out.println("Grade: " + grade);
        
        if (averagePercentage == 100) {
            System.out.println("\nCongratulations! You achieved a perfect score in all subjects!");
        }
        
        a.close();
    }
}
