
/**
 * @author Izan Khan
 * @assignment CSC212-Lab7B
 * @version (March 13, 2019)
 * 
 * This program computes statistics for a basketball 
 *  team using a two-dimensional array of points scored by the 
 *  players. Each row represents the points scored by 1 player 
 *  in all of the games. Each column holds the points scored by 
 *  all the players for 1 game. The program first reads the data 
 *  from a file and displays the table of points.  It then computes 
 *  and displays the team's average score per game.  Next the 
 *  program displays a 2-column table where column 1 contains the 
 *  game number and column 2 contains the total points scored in 
 *  that game. Finally the user enters a player number and that 
 *  player's average points per game is displayed.
 */
import java.io.*;
import java.text.*;
import java.util.*;

public class Points {

	public static void main(String[] args) throws FileNotFoundException {
		Scanner console = new Scanner(System.in);
		DecimalFormat df = new DecimalFormat("#.0");
		int[][] points = getData();
		displayTable(points);

		double averageScore = teamAverage(points);
		System.out.println("This team averaged " + df.format(averageScore) + " points per game.");
		System.out.println("");
		System.out.println("");
		System.out.println("Game Number\tGame Total");

		for (int g = 0; g < points[0].length; g++) {
			System.out.println("     " + g + "\t\t     " + gameTotal(points, g));
		}

		System.out.print("\nEnter a player number between 0 and " + (points.length - 1) + " inclusive: ");
		int playerNum = console.nextInt();

		if (playerNum >= 0 && playerNum <= (points.length - 1)) {
			System.out.printf("The average for player %d is %.1f points per game.", playerNum,
					playerAverage(points, playerNum));
		} else {
			System.out.print("Invalid player number.");
		}

	}

	/**
	 * This method creates and loads a 2-dimensional array of points scored in the
	 * given number of basketball games by the given number of players. It reads the
	 * data from a file and sends back a table where each row represents the points
	 * scored by each player and where each column represents the points scored in
	 * each game.
	 * 
	 * @return 2D array of basketball points
	 * @throws FileNotFoundException when the data file is not in the project
	 *         folder.
	 */
	public static int[][] getData() throws FileNotFoundException {
		Scanner input = new Scanner(new File("data2.txt"));
		int numberPlayers = input.nextInt();
		int numberGames = input.nextInt();
		int[][] table = new int[numberPlayers][numberGames];

		for (int row = 0; row < table.length; row++) {
			for (int col = 0; col < table[row].length; col++) {
				table[row][col] = input.nextInt();
			}
		}
		return table;
	}

	/**
	 * This method displays the 2D table of points with row and column headings.
	 * 
	 * @param table stores the points for a basketball team where each row is a
	 *              player and each column is a game.
	 */
	public static void displayTable(int[][] table) {
		System.out.print("           ");
		for (int col = 0; col < table[0].length; col++) {
			System.out.print("    Game " + col);
		}
		System.out.println();
		for (int row = 0; row < table.length; row++) {
			System.out.print("Player " + row + " ");
			for (int col = 0; col < table[row].length; col++) {
				if (table[row][col] < 10) {
					System.out.print("         " + table[row][col]);
				} else {
					System.out.print("        " + table[row][col]);
				}
			}
			System.out.println();
		}
		System.out.println();
	}

	/**
	 * Compute and return the team’s average number of points scored per game, which
	 * is the sum of the all the point values in the entire 2D array divided by the
	 * number of games.
	 * 
	 * @param array - Two dimensional int array of points.
	 * @return - Team average number of points in double value.
	 */
	public static double teamAverage(int[][] array) {
		int sum = 0;
		for (int row = 0; row < array.length; row++) {
			for (int col = 0; col < array[0].length; col++) {
				sum = sum + array[row][col];
			}

		}
		return (double) sum / array[0].length;

	}

	/**
	 * Compute and return the total points scored by the team for a given game.
	 * 
	 * @param array - Array of Points.
	 * @param game  - Game number for which total is being found.
	 * @return - int value that represents the total of one column in the array.
	 */
	public static int gameTotal(int[][] array, int game) {

		int score = 0;
		for (int i = 0; i < array.length; i++) {
			score += array[i][game];
		}

		return score;

	}

	/**
	 * Compute and return the average points per game for a given player
	 * 
	 * @param array  - Array of Points
	 * @param player - Number of the player for which the average is being found.
	 * @return - Return, as a double value, the average of the values in one row of
	 *         the array.
	 */
	public static double playerAverage(int[][] array, int player) {
		int totalScore = 0;
		for (int i = 0; i < array[0].length; i++) {
			totalScore = totalScore + array[player][i];
		}
		return (double) totalScore / (array[player].length);
	}
}
