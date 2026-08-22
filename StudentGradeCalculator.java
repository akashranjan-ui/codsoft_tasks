import java.util.Scanner;

public class StudentGradeCalculator {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Taking number of subjects
        System.out.print("Enter the number of subjects: ");
        int subjects = sc.nextInt();

        int totalMarks = 0;

        // Taking marks for each subject
        for (int i = 1; i <= subjects; i++) {

            System.out.print("Enter marks for Subject " + i + " (out of 100): ");
            int marks = sc.nextInt();

            // Checking whether marks are valid
            if (marks < 0 || marks > 100) {
                System.out.println("Invalid marks! Please enter marks between 0 and 100.");
                i--;
                continue;
            }

            totalMarks = totalMarks + marks;
        }

        // Calculating average percentage
        double averagePercentage = (double) totalMarks / subjects;

        // Calculating grade
        char grade;

        if (averagePercentage >= 90) {
            grade = 'A';
        }
        else if (averagePercentage >= 80) {
            grade = 'B';
        }
        else if (averagePercentage >= 70) {
            grade = 'C';
        }
        else if (averagePercentage >= 60) {
            grade = 'D';
        }
        else if (averagePercentage >= 50) {
            grade = 'E';
        }
        else {
            grade = 'F';
        }

        // Displaying result
        System.out.println("\n===== STUDENT RESULT =====");
        System.out.println("Total Marks: " + totalMarks + " / " + (subjects * 100));
        System.out.printf("Average Percentage: %.2f%%\n", averagePercentage);
        System.out.println("Grade: " + grade);

        sc.close();
    }
}
