
/**
 * @author Izan Khan
 * @assignment CSC212-Lab10
 * @version (May 05, 2019)
 * 
 * This program reads a text file, replaces 4-letter 
 * words with "****", and prints an alphabetical list of the 
 * replaced words.
 */
import java.util.*;
import java.io.*;

public class Bleep {
	public static void main(String[] args) throws FileNotFoundException {
		Scanner input = new Scanner(new File("hamlet.txt"));

		ArrayList<String> list = getWords(input);

		ArrayList<String> bleepedWords = replace4LetterWords(list);

		System.out.println("The edited list:  " + list);

		Collections.sort(bleepedWords);
		removeDuplicates(bleepedWords);

		System.out.println("\nList of bleeped words:");
		for (String word : bleepedWords) {
			System.out.println("\t" + word);
		}

		removeInRange(bleepedWords, "'a", "zz");

		System.out.println("\nList of bleeped words after range removal:");
		for (String word : bleepedWords) {
			System.out.println("\t" + word);
		}
	}

	public static ArrayList<String> getWords(Scanner input) {
		input.useDelimiter("[^a-zA-Z']+");
		ArrayList<String> words = new ArrayList<String>();
		while (input.hasNext()) {
			String word = input.next().toLowerCase();
			words.add(word);
		}
		return words;
	}

	public static ArrayList<String> replace4LetterWords(ArrayList<String> list) {
		ArrayList<String> newList = new ArrayList<String>();
		for (int i = 0; i <= list.size() - 1; i++) {
			if (list.get(i).length() == 4) {
				newList.add(list.get(i));
				list.set(i, "****");
			}
		}
		return newList;
	}

	public static void removeDuplicates(ArrayList<String> bleepedWords) {
		for (int i = bleepedWords.size() - 1; i > 0; i--) {
			if (bleepedWords.get(i).compareTo(bleepedWords.get(i - 1)) == 0) {
				bleepedWords.remove(i);
			}
		}
	}

	public static void removeInRange(ArrayList<String> bleepedWords, String string, String string1) {
		for (int i = bleepedWords.size() - 1; i >= 0; i--) {
			if (string.compareTo(bleepedWords.get(i)) < 0 && string1.compareTo(bleepedWords.get(i)) > 0) {
				bleepedWords.remove(i);
			}
		}
	}

}
