/*
 * Name: Izan Khan
 * Date: 5 October 2018
 * Course: CSC211
 * Program: Lab4 Grade Calculator
 * 
 * The user will enter a student's name, the student's test scores, and
 * the student's term project score. Based on these scores, the student
 * will either pass the course or receive no credit for the course.
 * 
 */
import java.util.*;

public class GradeCalculator {

	public static void main(String[] args) {
		Scanner scan = new Scanner (System.in);
		introduction();
		System.out.print("Enter student name: ");
		String name = scan.nextLine();
		System.out.print("Enter the term project grade (A, B, C, D, F): ");
		String grade = scan.next();
		System.out.println();
		System.out.print("Enter number of test scores: ");
		int count = scan.nextInt();
		int sum = 0;
		int lowest = Integer.MAX_VALUE;
		for(int i = 1; i <=count; i++) {
			System.out.print("Enter test score (0-100): ");
			int testScore = scan.nextInt();
			sum += testScore;
			if(testScore< lowest) {
				lowest = testScore;
			}
		}
		
		double average = (double) sum/ count;
		reportStatus(name, grade, average, lowest);			

	}

	/**
	 * introduction tells the user what values must be entered and what the
	 * program accomplishes.
	 */
	public static void introduction() {
		System.out.println("You will enter a student's name, followed by the");
		System.out.println("student's term project grade and test scores.");
		System.out.println("Based on these scores, the student will either pass");
		System.out.println("the course or earn no credit for the course.");
		System.out.println();
	}
	
/* Method gives out report of students
 * 
 * Strings name, grade, average, lowest
 * prints out the name of student, the project grade
 * of student, the test average of students
 * and the lowest test scores
 * respectively
 */
	public static void reportStatus (String name, String grade, double average, int lowest) {
		System.out.printf("Test average: "+"%.2f\n" , average);
		System.out.println("Lowest test score: " + lowest);
		System.out.println("Term project grade: " + grade);
		System.out.println();
		if ((average >= 75 && lowest >= 65 && (grade.equalsIgnoreCase("A")
				|| grade.equalsIgnoreCase("B") || grade.equalsIgnoreCase("C")
				|| grade.equalsIgnoreCase("D")) || average >= 65 && lowest >=50
				&& (grade.equalsIgnoreCase("A")|| grade.equalsIgnoreCase("B")))) {
			System.out.print(name + " passed this course");
		} else {
			System.out.print(name + " earned no credit for this course.");
			
		}
			
			
	}
	

}
