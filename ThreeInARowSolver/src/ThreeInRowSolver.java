/**
 * Name: Izan Khan
 * Date: 10/20/2020
 * CSC 371
 * Project 3--ThreeInARow
 * 
 * Program Description:
 * 	Three In A Row puzzle, fill an N*N grid where N is always even with blue
 *  and white squares so that each row and column has the same number
 *  of each color and there are not three adjacent squares of the same color.
 *  This Program will be implementing BackTracking.
 * 
 * 
 * Cite assistance (who and what):
 *  Anas, we discussed how the isSafe method can be done by creating two other methods,
 *  and how it can be done like the sudoku board. Also, discussed strategy with Kirubel. 
 *  
 *  Did not share code.
 * 
 * 
 */

// I used this when debugging
import java.util.*;
import java.io.*;

public class ThreeInRowSolver {

	public static void main(String[] args) throws FileNotFoundException {

		Scanner console = new Scanner(System.in);
		Scanner fileIn = getFileScanner(console);
		char[][] board = read(fileIn);

		System.out.println("\nInitial Board: ");
		print(board);

		System.out.println("\n");
		System.out.println("Solution:");

		if (solveThreeInRow(board))
			print(board);
		else
			System.out.println("No solution");
	}

	/**
	 * Requires the user to enter a filename until the filename is valid
	 * 
	 * @param console - facilitates keyboard input
	 * @return Scanner connected to the input file
	 * @throws FileNotFoundException if the file is not found
	 */
	public static Scanner getFileScanner(Scanner console) throws FileNotFoundException {
		System.out.print("Enter the filename with the puzzle: ");
		String filename = console.nextLine();
		File inputFile = new File(filename);
		while (!inputFile.canRead()) {
			System.out.println("Error. File cannot be found or cannot be read.");
			System.out.print("Enter the filename with the puzzle: ");
			filename = console.nextLine();
			inputFile = new File(filename);
		}
		return new Scanner(inputFile);
	}

	/**
	 * Reads the baord from a file into a 2 dimesnsional array of Characters.
	 * 
	 * @param file - facilitates input from the keyboard
	 * @return - initial board created from the input file.
	 */

	public static char[][] read(Scanner file) {

		int lines = Integer.parseInt(file.nextLine());

		char[][] board = new char[lines][lines];

		for (int i = 0; i < board.length; i++) {
			String line = file.nextLine();
			for (int j = 0; j < board[i].length; j++) {
				board[i][j] = line.charAt(j);
			}
		}
		return board;
	}

	/**
	 * Prints a Three In A Row board. With one space between characters.
	 * 
	 * 
	 * @param board - the board that needs to be printed.
	 */
	public static void print(char[][] board) {
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[i].length; j++) {
				System.out.print(board[i][j] + " ");
			}
			System.out.print("\n");
		}
	}

	/**
	 * Finds the first blank cell (cell storing '-') in the puzzle.
	 * 
	 * @param board - the current board that needs to be solved.
	 * @return - the first blank cell number or -1 if no blank cells
	 */
	public static int findBlankCell(char[][] board) {
		for (int row = 0; row < board.length; row++) {
			for (int col = 0; col < board.length; col++) {
				if (board[row][col] == '-') {
					return row * board.length + col;
				}
			}
		}
		return -1; // means grid is full
	}

	/**
	 * Calls on to two helper methods.
	 * 
	 * @param board  - the puzzle board to be solved
	 * @param letter - the character i.e. Color, to be placed at cell row, col.
	 * @param row    - the row index of the cell in question
	 * @param col    - the col index of the cell in question
	 * @return true if placing num at cell row, col does not violate the rules of
	 *         the puzzle.
	 */
	private static boolean isSafe(char[][] board, char letter, int row, int col) {

		return colCheck(board, letter, row, col) && rowCheck(board, letter, row, col);

	}

	/**
	 * Check if letter can be placed in the board column.
	 * 
	 * @param board  - the puzzle board to be solved
	 * @param letter - the character to be placed at cell.
	 * @param row    - the row index of the cell in question
	 * @param col    - the column index of the cell in question
	 * @return true if placing letter at cell col does not violate the rules of the
	 *         puzzle.
	 */
	private static boolean colCheck(char[][] board, char letter, int row, int col) {
		int letterCount = 1;

		if (row < board.length - 2) {
			if (board[row + 1][col] == letter && board[row + 2][col] == letter) {
				return false;
			}

		}
		if (row >= 2) {
			if (board[row - 2][col] == letter && board[row - 1][col] == letter) {

				return false;
			}
		}
		if (row > 0 && row < board.length - 1) {
			if (board[row + 1][col] == letter && board[row - 1][col] == letter) {

				return false;
			}
		}

		for (int j = 0; j < board.length; j++) {
			if (board[j][col] == letter) {
				letterCount = letterCount + 1;
			}
		}
		if (letterCount != (board.length / 2) && letterCount > (board.length / 2)) {
			return false;
		}

		return true;

	}

	/**
	 * Check if letter can be placed in the board row.
	 * 
	 * @param board  - the puzzle board to be solved
	 * @param letter - the character to be placed at cell.
	 * @param row    - the row index of the cell in question
	 * @param col    - the column index of the cell in question
	 * @return true if placing letter at cell column does not violate the rules of
	 *         the puzzle.
	 */

	private static boolean rowCheck(char[][] board, char letter, int row, int col) {
		int letterCount = 1;

		if (col < board.length - 2) {
			if (board[row][col + 1] == letter && board[row][col + 2] == letter) {
				return false;
			}

		}
		if (col >= 2) {
			if (board[row][col - 2] == letter && board[row][col - 1] == letter) {

				return false;
			}
		}
		if (col > 0 && col < board.length - 1) {
			if (board[row][col + 1] == letter && board[row][col - 1] == letter) {

				return false;
			}
		}

		for (int i = 0; i < board.length; i++) {
			if (board[row][i] == letter) {
				letterCount = letterCount + 1;
			}
		}
		if (letterCount != (board.length / 2) && letterCount > (board.length / 2)) {
			return false;
		}

		return true;

	}

	/**
	 * Solves the three in a row puzzle using recursive backtracking.
	 * 
	 * @param board - the puzzle board where '-' indicates a blank cell
	 * @return true if the puzzle has been solved successfully false other wise.
	 */
	private static boolean solveThreeInRow(char[][] board) {
		int blankCell = findBlankCell(board);
		if (blankCell == -1) {
			// means no cells are blank and the puzzle is solved
			return true;
		}

		int row = blankCell / board.length;
		int col = blankCell % board.length;

		Character[] letter = new Character[2];

		letter[0] = 'W';
		letter[1] = 'B';

		// Can assign i to the cell or not?
		// The cell is board[row][col].
		if (isSafe(board, letter[0], row, col)) {
			board[row][col] = letter[0];
			// backtracking
			if (solveThreeInRow(board))
				return true;
			// If we can't proceed with this solution,
			// reassign the cell
			board[row][col] = '-';
		}
		if (isSafe(board, letter[1], row, col)) {
			board[row][col] = letter[1];
			// backtracking
			if (solveThreeInRow(board))
				return true;
			// If we can't proceed with this solution,
			// reassign the cell
			board[row][col] = '-';
		}

		return false;
	}

}
