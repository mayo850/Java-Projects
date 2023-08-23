
/**
 * Name: Izan Khan
 * Date: 11/5/2020
 * CSC 371
 * Project 4--GuessingGameTree.java
 * 
 * Description: Client thinks of an object and the computer 
 * tries to guess it by asking a series of questions with y/n (yes/no) answers.
 * Eventually, the computer thinks it knows the object the client is thinking of.
 * Program will make a guess and if correct, it wins. If not, client wins. 
 * 
 * 
 * Cite Assistance (who and what): Discussed strategy with Anas, mainly play method.
 * 
 */

import java.io.*;
import java.util.Scanner; // for Scanner
import java.util.StringTokenizer;

public class GuessingGameTree {
	private TreeNode overallRoot; // overall root
	private Scanner console;
	private boolean computerWon;

	/**
	 * 
	 */
	public GuessingGameTree() {
		overallRoot = new TreeNode("computer");
		console = new Scanner(System.in);
		computerWon = false;
	}

	/**
	 * 
	 * @return - true if computer wins otherwise returns false.
	 */
	public boolean getWinner() {
		if (computerWon) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * Calls helper method.
	 * 
	 */
	public void play() {
		overallRoot = play(overallRoot);
	}

	/**
	 * The game is played, starting from the root node until a leaf node is reached.
	 * If leaf node is the answer, computer wins. If the answer is not correct the
	 * computer asks for the answer and the a question for which when answered 'y'
	 * or 'n' it leads to the aforementioned answer (leaf node).
	 * 
	 *
	 * @param root - overallRoot
	 * @return - root
	 */
	private TreeNode play(TreeNode root) {
		if (root.left == null && root.right == null) {

			if (yesTo("Would your object happen to be " + root.text + "?")) {
				System.out.println("I win!");
				computerWon = true;
			} else {

				System.out.print("I lose. What is your object? ");

				TreeNode object = new TreeNode(console.nextLine());
				System.out.print("Type a yes/no question to distinguish " + object.text + " from " + root.text + ": ");

				String question = console.nextLine();

				if (yesTo("And what is the answer to your question for a " + object.text + " ?")) {
					root = new TreeNode(question, object, root);
				} else { // if((!yesTo("And what is the answer to your question for a " + object.text + "
							// ?"))){

					root = new TreeNode(question, root, object);
				}
			}

		} else {

			if (yesTo(root.text)) {
				root.left = play(root.left);
			} else {

				root.right = play(root.right);
			}
		}
		return root;
	}

	/**
	 * calls helper method, throws IllegalArgumentException if output is null.
	 * 
	 * @param output - output file
	 */
	public void save(PrintStream output) {
		if (output == null) {
			throw new IllegalArgumentException();
		}
		save(overallRoot, output);
	}

	/**
	 * 
	 * Stores the current tree state to an output file represented by the given
	 * PrintStream. Each line will start with either, 'Q:' to indicate a question
	 * node or, 'A:' to indicate an answer node (a leaf node). Tree grows each time
	 * the user runs the program and add question.
	 * 
	 * 
	 * @param root   - overallRoot
	 * @param output - output file from public method
	 */
	private void save(TreeNode root, PrintStream output) {
		if (root.left == null && root.right == null) {
			output.println("A:" + root.text);
		} else {
			output.println("Q:" + root.text);
			save(root.left, output);
			save(root.right, output);
		}
	}

	/**
	 * overall root point to the tree that will be read from a file.
	 * 
	 * @param input - file to be read.
	 */
	public void load(Scanner input) {
		if (input == null) {
			throw new IllegalArgumentException();
		}

		overallRoot = load(overallRoot, input);
	}

	/**
	 * overall root point to the tree that will be read from a file, and read the
	 * lines from file. If 'Q' it is a branch node if 'A' it is a leaf node.
	 * 
	 * @param root
	 * @param input
	 * @return
	 */
	private TreeNode load(TreeNode root, Scanner input) {
		String current = input.nextLine();
		StringTokenizer tokenizer = new StringTokenizer(current, ":");

		String type = tokenizer.nextToken();
		String sentence = tokenizer.nextToken();

		root = new TreeNode(sentence);

		if (type.equals("Q")) {
			root.left = load(root, input);
			root.right = load(root, input);
		}
		return root;
	}

	/**
	 * prints the tree sideways including indenting and connecters between nodes
	 */
	public void printTree() {
		if (overallRoot == null) {
			return;
		}
		if (overallRoot.right != null) {
			printTree(overallRoot.right, true, "");
		}
		System.out.println(overallRoot.text);
		if (overallRoot.left != null) {
			printTree(overallRoot.left, false, "");
		}
	}

	// use string and not stringbuffer on purpose as we need to change the indent at
	// each recursion
	private void printTree(TreeNode root, boolean isRight, String indent) {
		if (root.right != null) {
			printTree(root.right, true, indent + (isRight ? "        " : " |      "));
		}
		System.out.print(indent);
		if (isRight) {
			System.out.print(" /");
		} else {
			System.out.print(" \\");
		}
		System.out.print("----- ");
		System.out.println(root.text);
		if (root.left != null) {
			printTree(root.left, false, indent + (isRight ? " |      " : "        "));
		}
	}

	// post: asks the user a question, forcing an answer of "y" or "n"
	// returns true if the answer is yes, returns false otherwise
	private boolean yesTo(String prompt) {
		System.out.print(prompt + " (y/n)? ");
		String response = console.nextLine().trim().toLowerCase();
		while (!response.equals("y") && !response.equals("n")) {
			System.out.println("Please answer y or n.");
			System.out.print(prompt + " (y/n)? ");
			response = console.nextLine().trim().toLowerCase();
		}
		return response.equals("y");
	}

	// A TreeNode object represents a single question/answer in the game tree.

	private class TreeNode {
		public String text; // question for branch, answer for leaf
		public TreeNode left; // for yes answers
		public TreeNode right; // for no answers

		public TreeNode(String text, TreeNode left, TreeNode right) {
			this.text = text;
			this.left = left;
			this.right = right;
		}

		public TreeNode(String text) {
			this.text = text;
			left = null;
			right = null;
		}

	}

}
