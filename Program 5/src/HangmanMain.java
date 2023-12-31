/**
 * Class HangmanMain is the driver program for the Hangman program.  It reads a
 * dictionary of words to be used during the game and then plays a game with
 * the user.  This is a cheating version of hangman that delays picking a word
 * to keep its options open.  You can change the setting for DEBUG to see
 * the words left after each letter guess.
 * 
 */

import java.util.*;
import java.io.*;

public class HangmanMain  {
    public static final String DICTIONARY_FILE = "dictionary2.txt";
    public static final boolean DEBUG = true;  // show words left

    public static void main(String[] args) throws FileNotFoundException {
        System.out.println("Welcome to Hangman.");
        System.out.println();

        // open the dictionary file and read dictionary into an ArrayList
        Scanner input = new Scanner(new File(DICTIONARY_FILE));
        List<String> dictionary = new ArrayList<String>();
        while (input.hasNext())
            dictionary.add(input.next().toLowerCase());

        // set basic parameters
        Scanner console = new Scanner(System.in);
        System.out.print("What length word do you want to use? ");
        int length = console.nextInt();
        System.out.print("How many wrong answers are allowed? ");
        int max = console.nextInt();
        System.out.println();

        // set up the HangmanManager and start the game
        List<String> dictionary2 = Collections.unmodifiableList(dictionary);
        HangmanGame hangman = new HangmanGame(dictionary2, length, max);
        if (hangman.getWordsLeft().isEmpty()) {
            System.out.println("No words of that length in the dictionary.");
        } else {
            playGame(console, hangman);
            showResults(hangman);
        }
    }

    // Plays one game with the user
    public static void playGame(Scanner console, HangmanGame hangman) {
        while (hangman.getNumWrongGuessesLeft() > 0 && hangman.getCurrentPattern().contains("-")) {
            System.out.println("wrong guesses left: " + hangman.getNumWrongGuessesLeft());
            if (DEBUG) {
                System.out.println("debugging help words left: " + hangman.getWordsLeft());          	
            }
            System.out.println("guessed letters   : " + hangman.getGuessedLetters());
            System.out.println("current : " + hangman.getCurrentPattern());
            System.out.print("Your guess? ");
            char ch = console.next().toLowerCase().charAt(0);
            if (hangman.getGuessedLetters().contains(ch)) {
                System.out.println("You already guessed that");
            } else {
                int count = hangman.processGuess(ch);
                if (count == 0) {
                    System.out.println("Sorry, there are no " + ch + "'s.");
                } else if (count == 1) {
                    System.out.println("Yes, there is one " + ch + ".");
                } else {
                    System.out.println("Yes, there are " + count + " " + ch +
                                       "'s.");
                }
            }
            System.out.println();
        }
    }

    // reports the results of the game, including showing the answer
    public static void showResults(HangmanGame hangman) {
        // if the game is over, the answer is the first word in the list
        // of words, so we use an iterator to get it
        String answer = hangman.getWordsLeft().iterator().next();
        System.out.println("answer = " + answer);
        if (hangman.getNumWrongGuessesLeft() > 0) {
            System.out.println("You beat me.");
        } else {
            System.out.println("Sorry, you lose.");
        }
    }
}
