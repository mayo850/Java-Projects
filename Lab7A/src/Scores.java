
/**
 * @author Izan Khan
 * @assignment CSC212-Lab7A
 * @version (March 8, 2019)
 * 
 * This program allows a user to enter a series
 * of quiz scores, outputs the list of scores, calculates
 * the average with and without the high and low scores,
 * allows the user to enter a number of points to add to
 * each score (maximum score is 100), and finally outputs
 * the adjusted scores and corresponding averages.
 */

import java.util.*;
import java.text.*;

public class Scores {

	public static final int MAX_SCORE = 100;

	public static void main(String[] args) {
		DecimalFormat df = new DecimalFormat("#.00");
		Scanner console = new Scanner(System.in);
		double averageScore;
		int[] scores = inputScores(console);

		System.out.println("\nThe scores entered were:");
		printArray(scores);

		averageScore = average(scores);
		System.out.println("\nThe average is " + df.format(averageScore));

		averageScore = averageWithoutHighLow(scores);
		System.out.println("The average without the high and low scores is " + df.format(averageScore));

		addPoints(console, scores);
		printArray(scores);

		averageScore = average(scores);
		System.out.println("\nThe average is " + df.format(averageScore));

		averageScore = averageWithoutHighLow(scores);
		System.out.println("The average without the high and low scores is " + df.format(averageScore));

	}

	/**
	 * This method prompts the user to enter the number of scores that will be
	 * entered and prompts the use to enter each score.
	 * 
	 * @param console--a Scanner to facilitate keyboard input
	 * @return an array with the entered scores
	 */
	public static int[] inputScores(Scanner console) {

		System.out.print("How many scores? ");
		int numScore = console.nextInt();
		int[] scores = new int[numScore];

		for (int i = 0; i < numScore; i++) {
			System.out.print("Score " + (i + 1) + ": ");
			int score = console.nextInt();
			scores[i] = score;
		}

		return scores;
	}

	/**
	 * Prints out the Array in the output console
	 * 
	 * @param array (This array stores scores)
	 */
	public static void printArray(int[] array) {
		for (int i = 0; i < array.length; i++) {
			System.out.println("[" + i + "] " + array[i]);
		}

	}

	/**
	 * This method computes the average of the elements of an int array.
	 * 
	 * @param array - the array of scores
	 * @return the average of the array or 0 if the array has no elements.
	 */
	public static double average(int[] array) {
		if (array.length == 0) {
			return 0;
		}
		int sum = 0;
		for (int scores : array) {
			sum = sum + scores;
		}
		return (double) sum / array.length;
	}

	/**
	 * This method finds and removes the highest and lowest scores from the array
	 * scores.
	 * 
	 * @param - scores the array of scores
	 * @return - average of the array without the highest and lowest scores. Or
	 *         returns 0 if there are less than 3 scores in the array.
	 */
	public static double averageWithoutHighLow(int[] scores) {
		if (scores.length < 3) {
			System.out.println("Minimum of 3 scores needed to disregard the high and low scores");
			return 0;
		}

		else {
			int total = scores[0];
			int highest = scores[0];
			int lowest = scores[0];

			for (int i = 1; i < scores.length; i++) {
				total = total + scores[i];

				if (highest < scores[i]) {
					highest = scores[i];
				}

				if (lowest > scores[i]) {
					lowest = scores[i];
				}

			}
			total = total - highest - lowest;
			return (double) (total) / (scores.length - 2);

		}
	}

	/**
	 * prompts user to add points to the scores in array.
	 * 
	 * @param console for user to input a number for the program to add to the
	 *                scores.
	 * @param array   - the array of scores
	 */
	public static void addPoints(Scanner console, int[] array) {
		System.out.println("");
		System.out.print("How many points to add? ");
		int points = console.nextInt();

		for (int i = 0; i < array.length; i++) {

			array[i] = array[i] + points;
			if (array[i] > 100) {
				array[i] = 100;
			}
		}

	}
}
