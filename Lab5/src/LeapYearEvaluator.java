
/*
 * Name: Izan Khan	
 * Date: 15 October 2018
 * Course: CSC 211
 * Program: Lab Ch5
 *
 * Description:  This program evaluates whether the years entered
 * 				 by the user are leap years.
 */
import java.util.*;

public class LeapYearEvaluator {

	public static final int MIN_YEAR = 1752;

	public static void main(String[] args) {
		Scanner console = new Scanner(System.in);
		giveIntro();

		System.out.print("Do you want to enter a year? (\"no\" to quit) ");
		String response = console.nextLine();

		while (!response.equals("no")) {
			

			int year = getYear();
			if (isLeapYear(year) == true) {
				System.out.println(year + " is a leap year.");
			} else {
				System.out.println(year + " is not a leap year.");

			}
			System.out.print("Do you want to enter a year? (\"no\" to quit) ");
			response = console.nextLine();
		}

		System.out.println("Thank you for using Leap Year Evaluator.");
	}

	/**
	 * Introduces the program
	 */
	public static void giveIntro() {
		System.out.println("Welcome to Leap year advisor.");
		System.out.println("Enter a year and I'll tell if it is a leap year.\n");
	}

	/**
	 * getYear prompts the user to enter a year until a year it is MIN_YEAR or later
	 * 
	 * @param console--a Scanner to facilitate user input
	 * @return the year valid year
	 */

	public static int getYear() {
		Scanner scan = new Scanner(System.in);
		System.out.print("Enter a year: ");
		int year = scan.nextInt();
		while (!(year >= MIN_YEAR)) {
			System.out.println("Invalid year. Year must be 1752 or later.");
			System.out.print("Enter a year: ");
			year = scan.nextInt();

		}
		return year;
	}

	/**
	 * isLeapYear determines if a year is a leap year or not
	 * 
	 * @param year--the year which will be evaluated
	 * @return true if the year is a leap year, false otherwise
	 */

	public static boolean isLeapYear(int year) {
		return (((year % 4 == 0) && (year % 100 != 0)) || (year % 400 == 0));

	}

}
