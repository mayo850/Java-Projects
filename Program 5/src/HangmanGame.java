
/**
 * Name: Izan Khan
 * Date: 7 December 2020
 * CSC 371
 * Program Project 5--HangmanGame
 *
 * Description: A HangMan game, where the computer picks a word that the user is supposed to guess.
 * The user guesses letters until the word is guessed or number of guesses are less than 1.
 * The computer delays choosing a word for the user to guess until it is forced to do so.
 * The computer is always considering a set of words that could be the answer. 
 * In order to fool the user into thinking it is playing fairly, the computer only considers 
 * words with the same letter pattern.
 * 
 * Cite Assistance (who and what): Anas explained how to test all the methods in main method. 
 * 								  
 * 
 */
import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class HangmanGame {
	private int guessesLeft;
	private String currentPattern;
	private TreeSet<String> considerations;
	private TreeSet<Character> guessed;
	private TreeMap<String, TreeSet<String>> myMap;

	public static void main(String[] args) throws FileNotFoundException {
		// open the dictionary file and read dictionary into an ArrayList
		Scanner input = new Scanner(new File("dictionary2.txt"));
		List<String> dictionary = new ArrayList<String>();
		while (input.hasNext()) {
			dictionary.add(input.next().toLowerCase());
		}
		HangmanGame game = new HangmanGame(dictionary, 4, 10);
		game.getGuessedLetters();

		System.out.println("Intial Pattern " + game.getCurrentPattern());

		System.out.println("Set of Pattern at Start " + game.getWordsLeft().toString());

		System.out.println("Guesses left = " + game.getNumWrongGuessesLeft());
		System.out.println();

		char guess = 'e';
		game.createMap(guess);

		System.out.println(game.myMap.toString());
		System.out.println("Patern with most possibilities " + game.updateConsiderations());
		System.out.println();

		int occurences = game.processGuess(guess);

		System.out.println("Number of Guesses Left =  " + game.getNumWrongGuessesLeft());
		System.out.println("Guessed Letters = " + game.getGuessedLetters().toString());
		System.out.println("New Considerations = " + game.considerations.toString());
		System.out.println("Current Pattern = " + game.getCurrentPattern());
		System.out.println("Occurences of the Letter Guessed =  " + occurences);
		System.out.println();

		guess = 'o';
		game.createMap(guess);

		System.out.println(game.myMap.toString());
		System.out.println("Patern with most possibilities " + game.updateConsiderations());
		System.out.println();

		occurences = game.processGuess(guess);

		System.out.println("Number of Guesses Left =  " + game.getNumWrongGuessesLeft());
		System.out.println("Guessed Letters = " + game.getGuessedLetters().toString());
		System.out.println("New Considerations = " + game.considerations.toString());
		System.out.println("Current Pattern = " + game.getCurrentPattern());
		System.out.println("Occurences of the Letter Guessed =  " + occurences);
		System.out.println();

		guess = 'g';
		game.createMap(guess);

		System.out.println(game.myMap.toString());
		System.out.println("Patern with most possibilities " + game.updateConsiderations());
		System.out.println();

		occurences = game.processGuess(guess);

		System.out.println("Number of Guesses Left =  " + game.getNumWrongGuessesLeft());
		System.out.println("Guessed Letters = " + game.getGuessedLetters().toString());
		System.out.println("New Considerations = " + game.considerations.toString());
		System.out.println("Current Pattern = " + game.getCurrentPattern());
		System.out.println("Occurences of the Letter Guessed =  " + occurences);
		System.out.println();

		guess = 'c';
		game.createMap(guess);

		System.out.println(game.myMap.toString());
		System.out.println("Patern with most possibilities " + game.updateConsiderations());
		System.out.println();

		occurences = game.processGuess(guess);

		System.out.println("Number of Guesses Left =  " + game.getNumWrongGuessesLeft());
		System.out.println("Guessed Letters = " + game.getGuessedLetters().toString());
		System.out.println("New Considerations = " + game.considerations.toString());
		System.out.println("Current Pattern = " + game.getCurrentPattern());
		System.out.println("Occurences of the Letter Guessed =  " + occurences);
		System.out.println();

		guess = 'l';
		game.createMap(guess);

		System.out.println(game.myMap.toString());
		System.out.println("Patern with most possibilities " + game.updateConsiderations());
		System.out.println();

		occurences = game.processGuess(guess);

		System.out.println("Number of Guesses Left =  " + game.getNumWrongGuessesLeft());
		System.out.println("Guessed Letters = " + game.getGuessedLetters().toString());
		System.out.println("New Considerations = " + game.considerations.toString());
		System.out.println("Current Pattern = " + game.getCurrentPattern());
		System.out.println("Occurences of the Letter Guessed =  " + occurences);
		System.out.println();

		System.out.println("Number of 'c' in current display " + game.numOccurence('c'));
		System.out.println("Number of 'o' in current display " + game.numOccurence('o'));
		System.out.println("Number of 'l' in current display " + game.numOccurence('l'));
		System.out.println("Number of 'a' in current display " + game.numOccurence('a'));
		System.out.println();
		
		String name = "izan";
		guess = 'a';
		System.out.println("New Pattern = " + game.createPattern(name, guess));
		

		input.close();

	}

	/**
	 * constructor method which starts the game. It initiates the state of the game
	 * by setting words of a given length, maximum number of guesses and also a
	 * TreeSet for the guessed letters.
	 * 
	 * @throws IllegalArgumentException - if the target length is less than 1 or if
	 *                                  the maximum number of wrong guesses is less
	 *                                  than 0.
	 * 
	 * @param dictionary - list of words at the start before taking length into
	 *                   account.
	 * @param length     - target length of a word needed to be guessed.
	 * @param maximum    - number of guesses allowed.
	 */
	public HangmanGame(List<String> dictionary, int length, int maximum) {
		if (length < 1 || maximum < 0) {
			throw new IllegalArgumentException();
		}

		guessesLeft = maximum;
		currentPattern = "- ";
		considerations = new TreeSet<String>();
		guessed = new TreeSet<Character>();
		myMap = new TreeMap<String, TreeSet<String>>();

		for (int i = 0; i < length - 1; i++) {
			currentPattern += "- ";
		}

		Iterator<String> itr = dictionary.iterator();

		while (itr.hasNext()) {
			String word = itr.next();

			if (word.length() == length) {
				considerations.add(word);
			}
		}

	}

	/**
	 * 
	 * @return - set of words considered by HangMan game as choices.
	 */
	public Set<String> getWordsLeft() {
		return considerations;
	}

	/**
	 * 
	 * @return - number of guesses the user is left with.
	 */
	public int getNumWrongGuessesLeft() {
		return guessesLeft;
	}

	/**
	 * 
	 * @return - set of letters already been guessed by the user.
	 */
	public Set<Character> getGuessedLetters() {
		return guessed;
	}

	/**
	 * @throws - IllegalStateException if set of words is empty.
	 * 
	 * @return - current pattern to be displayed for HangMan game.,
	 */
	public String getCurrentPattern() {
		if (considerations.isEmpty()) {
			throw new IllegalStateException();
		}

		return currentPattern;

	}

	/**
	 * 
	 * Using guess, method decides what set of words to use as it moves on. The
	 * method updates the number of wrong guesses left, if appropriate. or if the
	 * list of words remaining for consideration is empty.
	 * 
	 * @throws IllegalArgumentException - if the letter being guessed was previously
	 *                                  guessed.
	 * @throws IllegalStateException    - if the number of guesses is less than 1
	 * @param guess - character/letter guessed by user
	 * @return - number of times the letter occurs in the chosen pattern.
	 */
	public int processGuess(char guess) {

		if (guessesLeft < 1 || considerations.isEmpty())
			throw new IllegalStateException();

		if (guessed.contains(guess))
			throw new IllegalArgumentException();

		// Add the guess character to set of guessed characters
		guessed.add(guess);
		createMap(guess);
		updateConsiderations();
		return numOccurence(guess);
	}

	/**
	 * updates the set of considerations by comparing their size i.e the set with
	 * most words in the map gets preference.
	 * 
	 * @return - largest set from the map.
	 */
	private String updateConsiderations() {
		int size = 0;

		Iterator<String> keys = myMap.keySet().iterator();
		while (keys.hasNext()) {

			String pattern = keys.next();
			Set<String> word = myMap.get(pattern);

			if (word.size() > size) {
				considerations.clear();
				considerations.addAll(word);
				currentPattern = pattern;
				size = word.size();

			}

		}
		return currentPattern;

	}

	/**
	 * Initiates the map, at first the map is cleared and then if the the value i.e
	 * words to be considered are mapped to keys i.e the pattern.
	 * 
	 * @param guess - character/letter guessed by user.
	 */
	private void createMap(char guess) {
		// Iterate the considerations and set the map according to patterns
		Iterator<String> itr = considerations.iterator();
		// Clear the map to get new considerations
		myMap.clear();

		while (itr.hasNext()) {
			String word = itr.next();
			String newPattern = createPattern(word, guess);

			if (myMap.containsKey(newPattern)) {
				TreeSet<String> set = (TreeSet<String>) myMap.get(newPattern);
				set.add(word);
				myMap.replace(newPattern, set);
			} else {
				TreeSet<String> set = new TreeSet<String>();
				set.add(word);
				myMap.put(newPattern, set);
			}
		}
	}

	/**
	 * Creates a new pattern with the letter guessed if found in the word that is to
	 * be considered.
	 * 
	 * @param word  - a word from the set of considerations.
	 * @param guess - character/letter guessed by user.
	 * @return return a string of new pattern created after looking for letters in
	 *         the considered word.
	 */
	private String createPattern(String word, char guess) {
		char[] patternArray = currentPattern.toCharArray();

		// Create pattern
		for (int i = 0; i < word.length(); i++) {
			if (word.charAt(i) == guess) {
				patternArray[i * 2] = guess;
			}
		}

		String newPattern = new String(patternArray);

		return newPattern;
	}

	/**
	 * returns the number of time the letter guessed by the user occurs in the word
	 * that is to be considered.
	 * 
	 * @param guess - letter/character that the user guesses
	 * @return - int number of times the letter guessed by user occurs.
	 */
	private int numOccurence(char guess) {
		// Check if the guess letter exists in the new considerations
		int index = currentPattern.indexOf(guess);
		int count = 0;

		if (index == -1)
			this.guessesLeft--;
		else {
			for (int i = 0; i < currentPattern.length(); i++) {
				if (currentPattern.charAt(i) == guess)
					count++;
			}
		}

		return count;
	}
}
