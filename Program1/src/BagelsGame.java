
/*
 * Author: Izan	Khan
 * Date: March 8, 2019
 * Program: CSC212-Bagel Game
 *
 * Description: the computer generates a random number that the user has to guess. 
 * The computer provides hints based on the value and position of the digits guessed. 
 * The solution will always be a number made up of digits 1-9 (no 0s). Its length is 
 * determined by a class constant and shared with the user in the introduction.
 *
 * Citations of Assistance (who and what):
 *
 *
 */
import java.util.*;

public class BagelsGame {

	// constants
	public static final int NUM_DIGITS = 4; // number digits to guess
	public static final String NONE_CORRECT = "bagels";
	public static final String CORRECT_DIGIT = "fermi";
	public static final String CORRECT_POSITION = "pico";

	public static void main(String[] args) {
		Scanner console = new Scanner(System.in);
		directions();

		do {
			playOneGame(console);
		} while (playAgain(console));

	}

	/**
	 * This method gives the directions for the Bagels Game.
	 */
	public static void directions() {
		System.out.println("Welcome to Bagels!\n");
		System.out.println("I'm thinking of a " + NUM_DIGITS + " digit number. Each digit is");
		System.out.println("between 1 and 9. Try to guess my number.\n");
		System.out.println("I'll say \"fermi\" for each correct digit in the correct position.");
		System.out.println("I'll say \"pico\" for each correct digit in the wrong position.");
		System.out.println("I'll say \"bagels\" if all of the digits are wrong.\n");
	}

	/**
	 * This method plays one round of the game from the first “Your guess?” line
	 * through blank line following “You got it in X guesses.”
	 * 
	 * @param console - Users guess
	 */
	public static void playOneGame(Scanner console) {
		// Firstly, generate an answer
		int[] answer = generateAnswer();
		int numGuesses = 0;
		// Create an array to store the user guess
		int[] guessArray = new int[NUM_DIGITS];
		// Repeat until the guess is equal to the answer
		while (true) {

			int guess = getUserGuess(console);
			// Increment the number of guesses
			numGuesses++;
			// Split the guessed int into array
			for (int i = NUM_DIGITS - 1; i >= 0; i--) {
				int rem = guess % 10;
				guess /= 10;
				// Store the extracted digit in the guess array
				guessArray[i] = rem;
			}
			// if the guess is equal to the answer, break
			boolean isEqual = true;
			for (int i = 0; i < NUM_DIGITS; i++) {
				// If any digit is not equal
				if (guessArray[i] != answer[i]) {
					// exit the loop
					isEqual = false;
					break;
				}
			}
			// If the guess is equal to the answer, exit out of the loop
			if (isEqual)
				break;
			// If not equal, get the hints and print them
			System.out.println(createHints(answer, guessArray));
		}

		System.out.println("You got it in " + numGuesses + " guesses.");
		System.out.println("");
	}

	/**
	 * 
	 * @param answerDigits - 4 number digit which is the answer
	 * @param guessDigits  - 4 number digit the user guesses
	 * @return hints such as bagel, pico and fermi
	 */
	public static String createHints(int[] answerDigits, int[] guessDigits) {
		String result = "";
		boolean processed[] = new boolean[NUM_DIGITS];

		for (int i = 0; i < NUM_DIGITS; i++) {
			processed[i] = false;
			if (answerDigits[i] == guessDigits[i]) {
				processed[i] = true;
				if (result.length() != 0)
					result += " ";
				result += CORRECT_DIGIT;
			}
		}
		for (int i = 0; i < NUM_DIGITS; i++) {
			for (int j = 0; j < NUM_DIGITS; j++) {
				// If this guess wasn't processed
				if (!processed[j] && guessDigits[i] == answerDigits[j]) {
					if (result.length() != 0)
						result += " ";
					result += CORRECT_POSITION;
					processed[j] = true;
					break;
				}
			}
		}

		if (result.length() == 0)
			result = NONE_CORRECT;
		return result;
	}

	/**
	 * This method asks the user if they want to play again and requires the user to
	 * enter “y” or “n” before returning true when the user entered “y” or “Y” and
	 * false when the user entered “n” or “N”.
	 * 
	 * @param console - users answer ; yes or no
	 * @return - true(Y) or false(N)
	 */
	public static boolean playAgain(Scanner console) {
		String input;
		while (true) {
			// Ask the user if they want to play again
			System.out.print("Do you want to play again (y/n)?: ");
			input = console.next();
			// If yes, return true
			if (input.equalsIgnoreCase("y"))

				return true;
			// If no, return false
			else if (input.equalsIgnoreCase("n"))
				return false;
			// Otherwise, print error and repeat
			else
				System.out.println("You must answer y or n. Try again.");
		}
	}

	/**
	 * Requires the user to continue to enter a guess until the guess is an integer
	 * with the correct number of digits
	 * 
	 * @param console - facilitates input from the console window
	 * @return the user's guess
	 */
	public static int getUserGuess(Scanner console) {
		int guess = 0;
		boolean invalidGuess = true;
		do {
			System.out.print("Your guess? ");
			try {
				guess = console.nextInt();
				if (guess < 0 || (int) Math.log10(guess) != NUM_DIGITS - 1) {
					System.out.println("You must enter a positive integer with " + NUM_DIGITS + " digits. Try again.");
				} else {
					invalidGuess = false;
				}
			} catch (InputMismatchException e) {
				System.out.println("You must enter an integer. Try again.");
			}
			console.nextLine();
		} while (invalidGuess);
		return guess;
	}

	public static int[] generateAnswer() {
		// create an array of size NUM_DIGITS
		int[] result = new int[NUM_DIGITS];
		Random random = new Random();
		for (int i = 0; i < NUM_DIGITS; i++) {
			// generate a number between 0 and 9 and store it in the array index i
			result[i] = random.nextInt(10);
		}
		return result;

	}
}
