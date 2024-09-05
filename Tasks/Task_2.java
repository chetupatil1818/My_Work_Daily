import java.util.Scanner;
//Student_Grade_Calculator
public class Task_2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Enter the number of subjects: ");
        int numSubjects = sc.nextInt();
        
        int[] marks = new int[numSubjects];
        int totalMarks = 0;
        for (int i = 0; i < numSubjects; i++) {
            System.out.print("Enter marks for subject " + (i + 1) + " (out of 100): ");
            marks[i] = sc.nextInt();
            totalMarks += marks[i];
        }

        double averagePercentage = (double) totalMarks / numSubjects;

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

        System.out.println("\n--- Results ---");
        System.out.println("Total Marks: " + totalMarks + " out of " + (numSubjects * 100));
        System.out.println("Average Percentage: " + averagePercentage + "%");
        System.out.println("Grade: " + grade);

        sc.close();
    }
}
