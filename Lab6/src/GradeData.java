/*
 * Name: Izan Khan	
 * Date: 26 October 2018
 * Course: CSC211
 * Program: LabCh6  GradeData
 * 
 * This program reads the grades for a Augustana College CSC 211 student
 * and calculates their final percentile and letter grade.
 */

import java.io.*; 
import java.util.*;

public class GradeData {

	public static void main(String[] args)
			throws FileNotFoundException {
		
		Scanner fileInput = new Scanner(new File("gradedata.txt"));
		PrintStream outputFile = new PrintStream (new File("outputFile.txt"));
		 double sum = 0;
		 
			System.out.printf("CSC 211 Grade\n\n"); 
			outputFile.printf("CSC 211 Grade\n\n"); 
		 
		 
		while (fileInput.hasNext()) {
		String assessment = fileInput.next();
		double grade = fileInput.nextDouble();	

		sum += grade;
		
		switch(assessment) {
		case "R":
			System.out.printf("%10s %9s", "Routine Assignments:", grade);
			 System.out.println();
			 outputFile.printf("%10s %9s", "Routine Assignments:", grade);
			 outputFile.println();
			break;
		case "Q":
			System.out.printf("%5s %21s", "Quizzes:", grade);
			System.out.println();
			outputFile.printf("%5s %21s", "Quizzes:", grade);
			outputFile.println();
			
			break;
		case "L":
			System.out.printf("%5s %24s", "Labs:", grade);
			System.out.println();
			outputFile.printf("%5s %24s", "Labs:", grade);
			outputFile.println();
			
			break;
		case "P":
			System.out.printf("%5s %6s", "Programming Assignments:", grade);
			System.out.println();
			outputFile.printf("%5s %6s", "Programming Assignments:", grade);
			outputFile.println();
			
			break;
		case "1":
			System.out.printf("%5s %18s", "1st Midterm:", grade);
			System.out.println();
			outputFile.printf("%5s %18s", "1st Midterm:", grade);
			outputFile.println();
			break;
		case "2":
			System.out.printf("%5s %18.2f", "2nd Midterm:", grade);
			System.out.println();
			System.out.println();
			outputFile.printf("%5s %18.2f", "2nd Midterm:", grade);
			outputFile.println();
			outputFile.println();
			break;
		default:
				
		}
		//System.out.println(assessment+ " " + grade);
		
			
		 }
		
		double grade = (sum/75);
		double grade0 = (sum/100);
		double grade1 = ((sum+25)/100);
		
		
		
		if (grade >= 0.93) {
			System.out.printf("Total:%5.2f (A)", grade);
			System.out.println();
			outputFile.printf("Total:%5.2f (A)", grade);
			outputFile.println();
		} else if (grade >= 0.90) {
			System.out.printf("Total:%5.2f (A-)", grade);
			System.out.println();
			outputFile.printf("Total:%5.2f (A-)", grade);
			outputFile.println();
		} else if (grade >= 0.87) {
			System.out.printf("Total:%5.2f (B+)", grade);
			System.out.println();
			outputFile.printf("Total:%5.2f (B+)", grade);
			outputFile.println();
		} else if (grade >= 0.83) {
			System.out.printf("Total:%5.2f (B)", grade);
			System.out.println();
			outputFile.printf("Total:%5.2f (B)", grade);
			outputFile.println();
		} else if (grade >= 0.80) {
			System.out.printf("Total:%5.2f (B-)", grade);
			System.out.println();
			outputFile.printf("Total:%5.2f (B-)", grade);
			outputFile.println();
		} else if (grade >= 0.77) {
			System.out.printf("Total:%5.2f (C+)", grade);
			System.out.println();
			outputFile.printf("Total:%5.2f (C+)", grade);
			outputFile.println();
		} else if (grade >= 0.73) {
			System.out.printf("Total:%5.2f (C)",grade);
			System.out.println();
			outputFile.printf("Total:%5.2f (C)",grade);
			outputFile.println();
		} else if (grade >= 0.67) {
			System.out.printf("Total:%5.2f (C-)", grade);
			System.out.println();
			outputFile.printf("Total:%5.2f (C-)", grade);
			outputFile.println();
		} else if (grade >= 0.60) {
			System.out.printf("Total:%5.2f (D)", grade);
			System.out.println();
			outputFile.printf("Total:%5.2f (D)", grade);
			outputFile.println();
		} else {
			System.out.printf("Total:%5.2f (F)", grade);
			System.out.println();
			outputFile.printf("Total:%5.2f (F)", grade);
			outputFile.println();
		}
		 
		if (grade0 >= 0.93) {
			System.out.printf("Total (with 0 on final):%5.2f (A)", grade0);
			System.out.println();
			outputFile.printf("Total (with 0 on final):%5.2f (A)", grade0);
			outputFile.println();
		} else if (grade0 >= 0.90) {
			System.out.printf("Total (with 0 on final):%5.2f (A-)", grade0);
			System.out.println();
			outputFile.printf("Total (with 0 on final):%5.2f (A-)", grade0);
			outputFile.println();
		} else if (grade0 >= 0.87) {
			System.out.printf("Total (with 0 on final):%5.2f (B+)", grade0);
			System.out.println();
			outputFile.printf("Total (with 0 on final):%5.2f (B+)", grade0);
			outputFile.println();
		} else if (grade0 >= 0.83) {
			System.out.printf("Total (with 0 on final):%5.2f (B)", grade0);
			System.out.println();
			outputFile.printf("Total (with 0 on final):%5.2f (B)", grade0);
			outputFile.println();
		} else if (grade0 >= 0.80) {
			System.out.printf("Total (with 0 on final):%5.2f (B-)", grade0);
			System.out.println();
			outputFile.printf("Total (with 0 on final):%5.2f (B-)", grade0);
			outputFile.println();
		} else if (grade0 >= 0.77) {
			System.out.printf("Total (with 0 on final):%5.2f (C+)", grade0);
			System.out.println();
			outputFile.printf("Total (with 0 on final):%5.2f (C+)", grade0);
			outputFile.println();
		} else if (grade0 >= 0.73) {
			System.out.printf("Total (with 0 on final):%5.2f (C)",grade0);
			System.out.println();
			outputFile.printf("Total (with 0 on final):%5.2f (C)",grade0);
			outputFile.println();
		} else if (grade0 >= 0.67) {
			System.out.printf("Total (with 0 on final):%5.2f (C-)", grade0);
			System.out.println();
			outputFile.printf("Total (with 0 on final):%5.2f (C-)", grade0);
			outputFile.println();
		} else if (grade0 >= 0.60) {
			System.out.printf("Total (with 0 on final):%5.2f (D)", grade0);
			System.out.println();
			outputFile.printf("Total (with 0 on final):%5.2f (D)", grade0);
			outputFile.println();
		} else {
			System.out.printf("Total (with 0 on final):%5.2f (F)", grade0);
			System.out.println();
			outputFile.printf("Total (with 0 on final):%5.2f (F)", grade0);
			outputFile.println();
		}
		if (grade1 >= 0.93) {
			System.out.printf("Total (with 100 on final):%5.2f (A)", grade1);
			System.out.println();
			outputFile.printf("Total (with 100 on final):%5.2f (A)", grade1);
			outputFile.println();
		} else if (grade1 >= 0.90) {
			System.out.printf("Total (with 100 on final):%5.2f (A-)", grade1);
			System.out.println();
			outputFile.printf("Total (with 100 on final):%5.2f (A-)", grade1);
			outputFile.println();
		} else if (grade1 >= 0.87) {
			System.out.printf("Total (with 100 on final):%5.2f (B+)", grade1);
			System.out.println();
			outputFile.printf("Total (with 100 on final):%5.2f (B+)", grade1);
			outputFile.println();
		} else if (grade1 >= 0.83) {
			System.out.printf("Total (with 100 on final):%5.2f (B)", grade1);
			System.out.println();
			outputFile.printf("Total (with 100 on final):%5.2f (B)", grade1);
			outputFile.println();
		} else if (grade1 >= 0.80) {
			System.out.printf("Total (with 100 on final):%5.2f (B-)", grade1);
			System.out.println();
			outputFile.printf("Total (with 100 on final):%5.2f (B-)", grade1);
			outputFile.println();
		} else if (grade1 >= 0.77) {
			System.out.printf("Total (with 100 on final):%5.2f (C+)", grade1);
			System.out.println();
			outputFile.printf("Total (with 100 on final):%5.2f (C+)", grade1);
			outputFile.println();
		} else if (grade1 >= 0.73) {
			System.out.printf("Total (with 100 on final):%5.2f (C)",grade1);
			System.out.println();
			outputFile.printf("Total (with 100 on final):%5.2f (C)",grade1);
			outputFile.println();
		} else if (grade1 >= 0.67) {
			System.out.printf("Total (with 100 on final):%5.2f (C-)", grade1);
			System.out.println();
			outputFile.printf("Total (with 100 on final):%5.2f (C-)", grade1);
			outputFile.println();
		} else if (grade1 >= 0.60) {
			System.out.printf("Total (with 100 on final):%5.2f (D)", grade1);
			System.out.println();
			outputFile.printf("Total (with 100 on final):%5.2f (D)", grade1);
			outputFile.println();
		} else {
			System.out.printf("Total (with 100 on final):%5.2f (F)", grade1);
			System.out.println();
			outputFile.printf("Total (with 100 on final):%5.2f (F)", grade1);
			outputFile.println();
		}


}
}
