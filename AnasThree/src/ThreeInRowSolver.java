
/**
 * Name: Anas Akkar
 * Date: 15/10/2020
 * CSC 371
 * Project 3--ThreeInARow
 * 
 * Program Description: Program outputs the steps to take to solve the 3-In-A-Row Japanese logic puzzle 
 * 
 * 
 * 
 * Cite assistance (who and what):
 * 
 * 
 * 
 */

import java.util.Arrays; // I used this when debugging
import java.util.*;
import java.io.*;

public class ThreeInRowSolver {

	public static void main(String[] args) throws FileNotFoundException {

		Scanner console = new Scanner(System.in);
		Scanner fileIn = getFileScanner(console);
		char[][] board = initialBoard(fileIn);
		System.out.println("Initial Board:");
		printBoard(board);

		System.out.println("Solution :");
		boolean solution = solveBoard(board);
		if (solution) {
			printBoard(board);
		} else {
			System.out.println("This puzzle doesn't have a solution");
		}

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
	 * 
	 * @param fileIn - file containing the info about the board
	 * @return 2D array containing the initial board
	 */
	public static char[][] initialBoard(Scanner fileIn) {
		int n = fileIn.nextInt();
		char[][] twoD = new char[n][n];
		fileIn.nextLine();
		for (int i = 0; i < n; i++) {
			String line = fileIn.nextLine();
			for (int j = 0; j < n; j++) {
				twoD[i][j] = line.charAt(j);
			}
		}
		return twoD;
	}

	public static void printBoard(char[][] board) {
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board.length; j++) {
				System.out.print(board[i][j] + " ");
			}
			System.out.println("");
		}
	}

	public static boolean solveBoard(char[][] board) {
		int blankCell = findBlankCell(board);
		if (blankCell == -1) {
			return true;
		}
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board.length; j++) {
				if (isAvailable(board, board[i][j], i, j)) {
					board[i][j] = 'W';

					if (solveBoard(board)) {
						return true;
					}
					board[i][j] = 'B';
					if (solveBoard(board)) {
						return true;
					}
					board[i][j] = '-';
				}
			}
		}

		return false;
	}

	/**
	 * Finds the first blank cell (ie. cell storing '-') in the puzzle.
	 * 
	 * @param board - the current board that needs
	 * to be solved.
	 * @return - the first blank cell number or -1 if no blank cells
	 */
	public static int findBlankCell(char[][] board) {
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board.length; j++) {
				if (board[i][j] == '-') {
					return i * board.length + j;
				}
			}
		}
		return -1;
	}

	
	public static boolean isAvailable(char[][] board, char cell, int row, int col) {
		int count1 = 0;
		int threeInRow1 = 0;
		int threeInRow2 = 0;
		int count2 = 0;
		for (int i = 0; i < board.length; i++) {
			// count cells with same value
			if (i > 0 && board[row][i] == board[row][i - 1]) {
				threeInRow1++;
				// checking row for 3 in row
				if (threeInRow1 == 3) {
					return false;
				}
				} else {
				threeInRow1 = 0;
			}
			if (board[row][i] == cell) {
				count1++;
			}
		}
		// checking column
		for (int i = 0; i < board.length; i++) {
			// count cells with same value
			if (i > 0 && board[i][col] == board[i - 1][col]) {
				threeInRow2++;
				// checking column for 3 in row
				if (threeInRow2 == 3) {
					return false;
				}
			} else {
				threeInRow2 = 0;
			}
			if (board[i][col] == cell) {
				count2++;
			}
		}
		if (count1 != count2) {
			return false;
		}

		return true;
	}
}
