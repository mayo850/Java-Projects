
/**
 * @author Izan Khan
 * @assign CSC212-Program 8
 * @version (April 4, 2019)
 *  
 * Description: Provides a menu with 6 option to analyze baby name data from
 * 1900 to 2000 by decade in a variety of ways.
 * 
 * 
 * Citations of assistance (who and what): Jack (Option 6 and 7 were producing more than 
 * expected outputs, an "=" sign was needed)
 * 
 
 */
import java.io.*;
import java.util.*;

import javax.swing.JOptionPane;

public class BabyNameProcessor {

	public static final int MIN_DECADE = 1900;
	public static final int NUM_DECADES = 11;
	public static final int MAX_DECADE = MIN_DECADE + (NUM_DECADES - 1) * 10;

	// constants for menu choices
	public static final int SEARCH = 1;
	public static final int ONE_NAME = 2;
	public static final int TOP_RANKED = 3;
	public static final int APPEAR_ALWAYS = 4;
	public static final int MORE_POPULAR = 5;
	public static final int LESS_POPULAR = 6;

	public static final int QUIT = 7;

	public static void main(String[] args) throws FileNotFoundException {
		NameRecord[] nameList = getData();

		// for (int i=0;i<nameList.length;i++)
		// System.out.println(nameList[i].getName());

		intro();

		Scanner console = new Scanner(System.in);

		// int year = getDecade(console);
		int choice;
		do {
			displayMenu();
			choice = getMenuChoice(console);
			System.out.println();
			if (choice == SEARCH) {
				search(nameList, console);
			} else if (choice == ONE_NAME) {
				oneName(nameList, console);
			} else if (choice == TOP_RANKED) {
				topRanked(nameList, console);
			} else if (choice == APPEAR_ALWAYS) {
				appearAlways(nameList);
			} else if (choice == MORE_POPULAR) {
				morePopular(nameList);
			} else if (choice == LESS_POPULAR) {
				lessPopular(nameList);
			} else {
				System.out.println("\n\nGoodbye.");
			}
			System.out.println();

		} while (choice != QUIT);

	}

	// These are the six methods that you need to complete in this program.
	/**
	 * Prints out the data of names which contain the string entered by the user.
	 * 
	 * @param nameList - Represents the array of names and ranking data by decade.
	 * @param console  - Allows the user to enter partial name as a String.
	 */
	public static void search(NameRecord[] nameList, Scanner console) {

		String name = "";
		System.out.print("Enter a partial name: ");
		name = console.next();
		System.out.println();
		System.out.println("The matches containing " + name + " with their highest decade are:");
		for (int i = 0; i < nameList.length; i++) {
			if (nameList[i].getName().contains(name.toLowerCase()) || nameList[i].getName().equalsIgnoreCase(name)
					|| nameList[i].getName().toLowerCase().startsWith(name)) {

				System.out.println(nameList[i].getName() + " " + nameList[i].getBestDecade());
			}

		}

	}

	/**
	 * Returns the ranking of the name entered by the user, if the name is not
	 * ranked "was not ranked" is returned.
	 * 
	 * @param nameList - Represents the array of names and ranking data by decade.
	 * @param console  - Allows the user to enter a name.
	 */
	public static void oneName(NameRecord[] nameList, Scanner console) {
		String name;
		boolean flag = false;
		System.out.print("Enter a name: ");
		name = console.next();
		System.out.println();
		for (int i = 0; i < nameList.length; i++) {

			if (nameList[i].getName().equals(name)) {
				System.out.println(nameList[i].recordInfoByDecade());
				flag = true;
			}

		}
		if (flag == false)
			System.out.println(name + " was not ranked in any decade.");
	}

	/**
	 * Outputs most popular girl/boys name(s) for the decade entered.
	 * 
	 * @param nameList - Represents the array of names and ranking data by decade.
	 * @param console  - Prompts the user to enter a decade (int).
	 */
	public static void topRanked(NameRecord[] nameList, Scanner console) {
		int year = getDecade(console);
		String name = "";
		for (int i = 0; i < nameList.length; i++) {
			if (nameList[i].getDecadeRank(year) == 1) {
				name += nameList[i].getName() + " and ";
			}
		}
		System.out.println();
		System.out.println("The most popular names in " + year + " were " + name);
	}

	/**
	 * Output all the names that have been ranked in the top 1000 in all the
	 * decades, also counts how many names and gives a output of that too.
	 * 
	 * @param nameList - Represents the array of names and ranking data by decade.
	 */
	public static void appearAlways(NameRecord[] nameList) {

		System.out.println();
		int count = 0;
		for (int i = 0; i < nameList.length; i++) {
			if (nameList[i].isRankedEachDecade()) {
				System.out.println(nameList[i].getName());
				count++;
			}
		}

		System.out.println(count + " names appeared every decade.");
	}

	/**
	 * Output the names and their count which have been getting popular by every
	 * passing decade.
	 * 
	 * @param nameList - Represents the array of names and ranking data by decade.
	 */
	public static void morePopular(NameRecord[] nameList) {

		System.out.println();
		int count = 0;
		for (int i = 0; i < nameList.length; i++) {
			if (nameList[i].isGettingMorePopular() == true) {
				System.out.println(nameList[i].getName());
				count++;
			}
		}

		System.out.println(count + " names were always getting more popular.");

	}

	/**
	 * Output the names and their count which have been getting less popular by
	 * every passing decade.
	 * 
	 * @param nameList - Represents the array of names and ranking data by decade.
	 */
	public static void lessPopular(NameRecord[] nameList) {

		System.out.println();
		int count = 0;
		for (int i = 0; i < nameList.length; i++) {
			if (nameList[i].isGettingLessPopular() == true) {
				System.out.println(nameList[i].getName());
				count++;
			}
		}

		System.out.println(count + " names were always getting less popular.");
	}

	/**
	 * Displays program introduction and directions
	 */
	public static void intro() {
		System.out.println("Baby Name Rankings");
		System.out.println();
		System.out.println("Make a menu choice to get information about the popularity of ");
		System.out.println("the names given to children in the US at birth. Only names given");
		System.out.println("to at least 5 children in a given year are in the database.");
		System.out.println("");
	}

	/**
	 * Displays the menu of choices to the user
	 */
	public static void displayMenu() {
		System.out.println("\nOptions:");
		System.out.println("Enter " + SEARCH + " to search for names.");
		System.out.println("Enter " + ONE_NAME + " to display data for one name.");
		System.out.println("Enter " + TOP_RANKED + " to display the top ranked names in a particular decade.");
		System.out.println("Enter " + APPEAR_ALWAYS + " to display all names ranked in all decades.");
		System.out.println("Enter " + MORE_POPULAR + " to display all names that were always getting more popular.");
		System.out.println("Enter " + LESS_POPULAR + " to display all names that were always getting less popular.");
		System.out.println("Enter " + QUIT + " to quit.\n");
	}

	/**
	 * reads data from a file which stores a name and its rank for each decade
	 * beginning with MIN-DECADE.
	 * 
	 * @return an array of names and ranking data by decade
	 * @throws FileNotFoundException
	 */
	public static NameRecord[] getData() throws FileNotFoundException {
		Scanner input = new Scanner(new File("names.txt"));
		int numberNames = input.nextInt();
		NameRecord[] nameList = new NameRecord[numberNames];

		for (int i = 0; i < nameList.length; i++) {
			int[] ranksForOneName = new int[NUM_DECADES];
			String name = input.next();
			for (int decade = 0; decade < NUM_DECADES; decade++) {
				ranksForOneName[decade] = input.nextInt();
			}
			nameList[i] = new NameRecord(name, ranksForOneName);
		}
		input.close();

		return nameList;
	}

	/**
	 * get valid menu choice from the user
	 * 
	 * @param console - to facilitate keyboard input
	 * @return a valid menu choice that is >= SEARCH and <= QUIT
	 */
	private static int getMenuChoice(Scanner console) {

		boolean invalid = true;
		int choice = 0;
		while (invalid) {
			try {
				System.out.print("Enter choice: ");
				choice = console.nextInt();
				if (choice < SEARCH || choice > QUIT) {
					System.out.println("\n" + choice + " is not a valid menu choice");
				} else {
					invalid = false;
				}
			} catch (InputMismatchException e) {
				console.nextLine();
				System.out.println("\nError. Value must be an integer.");
			}
		}
		return choice;
	}

	/**
	 * get a valid decade choice from the user
	 * 
	 * @param console - to facilitate keyboard input
	 * @return the valid decade entered by the user
	 */
	private static int getDecade(Scanner console) {

		boolean invalid = true;
		int year = 0;
		while (invalid) {
			try {
				System.out.print("Enter decade: ");
				year = console.nextInt();
				if (year < MIN_DECADE || year > MAX_DECADE || (year % 10 != 0)) {
					System.out.println("\n" + year + " is not a valid decade.");
				} else {
					invalid = false;
				}
			} catch (InputMismatchException e) {
				console.nextLine();
				System.out.println("\nError. Value must be an integer.");
			}
		}
		return year;
	}

}
