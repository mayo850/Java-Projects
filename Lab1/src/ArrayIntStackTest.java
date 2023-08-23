/*
 * Program to test the implementation of your ArrayStack class
 */

import java.util.*;

public class ArrayIntStackTest {

	public static void main(String[] args) {
		StackIntADT stack  = null;
		
		// Testing default constructor
		try {
			System.out.println("Testing default constructor.");
			stack = new ArrayIntStack();
			System.out.println("...passed");
		} catch (Exception e) {
			System.out.println("...failed");
			System.out.println("        threw exception: " + e);
			int line = e.getStackTrace()[0].getLineNumber();
			System.out.println("        in ArrayIntStack line#" + line);
			System.exit(1);
		}
		
		// Testing constructor with one parameter
		StackIntADT stack2 = null;
		try {
			System.out.println("\nTesting constructor with parameter.");
			stack2 = new ArrayIntStack(6);
			System.out.println("...passed");
		} catch (Exception e) {
			System.out.println("...failed");
			System.out.println("        threw exception: " + e);
			int line = e.getStackTrace()[0].getLineNumber();
			System.out.println("        in ArrayIntStack line#" + line);
			System.exit(1);
		}
		
				
		// Testing constructor with invalid parameter
		try {
			System.out.println("\nTesting constructor invalid parameter.");
			StackIntADT stack3 = new ArrayIntStack(-2);
			System.out.println("...failed");
			System.out.println("Capacity can not be passed as negative");
			System.exit(1);
		} catch (IllegalArgumentException e) {
			System.out.println("...passed");
			System.out.println("   threw exception: " + e);
		}
		
		// pushing three elements
		try {
			stack.push(1);
			stack.push(2);
			stack.push(3);
			System.out.println("\nAfter 1, 2, 3 pushed.");
			if (stack.toString().equals("[1, 2, 3]") ) {
				System.out.println("...passed");
			} else {
				System.out.println("push or toString failed");
				System.out.println("    correct stack: [1, 2, 3]");
				System.out.println("    your stack: " + stack);
				System.exit(1);
			}
		} catch (Exception e) {
			System.out.println("...failed");
			System.out.println("        threw exception: " + e);
			int line = e.getStackTrace()[0].getLineNumber();
			System.out.println("        in ArrayIntStack line#" + line);
			System.exit(1);
		}
		
		// push 1 more element, should be at maximum capacity
				try {
					stack.push(4);
					System.out.println("\nAfter 4 pushed.");
					if (stack.toString().equals("[1, 2, 3, 4]") ) {
						System.out.println("...passed");
					} else {
						System.out.println("push or toString");
						System.out.println("    correct stack: [1, 2, 3, 4]");
						System.out.println("    your stack: " + stack);
						System.exit(1);
					}
				} catch (Exception e) {
					System.out.println("...failed");
					System.out.println("        threw exception: " + e);
					int line = e.getStackTrace()[0].getLineNumber();
					System.out.println("        in ArrayIntStack line#" + line);
					System.exit(1);
				}
		
		// push 2 more element, should increase capacity
		try {
			stack.push(5);
			System.out.println("\nAfter 5 pushed.");
			if (stack.toString().equals("[1, 2, 3, 4, 5]") ) {
				System.out.println("...passed");
			} else {
				System.out.println("push, toString, or ensureCapacity failed");
				System.out.println("    correct stack: [1, 2, 3, 4, 5]");
				System.out.println("    your stack: " + stack);
				System.exit(1);
			}
		} catch (Exception e) {
			System.out.println("...failed");
			System.out.println("        threw exception: " + e);
			int line = e.getStackTrace()[0].getLineNumber();
			System.out.println("        in ArrayIntStack line#" + line);
			System.exit(1);
		}
		
		// testing peek	
		try {	
			int top = stack.peek();
			if (top == 5 & stack.size() == 5 && stack.toString().equals("[1, 2, 3, 4, 5]")) {
				System.out.println("\nPeek was correct." );
			} else {
				System.out.println("\nPeek was incorrect." );
				System.out.println("    correct peek element: 5");
				System.out.println("    your peek element: " + top );
				System.out.println("    correct stack: [1, 2, 3, 4, 5]");
				System.out.println("    your stack: " + stack);
				System.exit(1);
			}
		} catch (Exception e) {
			System.out.println("...failed");
			System.out.println("        threw exception: " + e);
			int line = e.getStackTrace()[0].getLineNumber();
			System.out.println("        in ArrayIntStack line#" + line);
			System.exit(1);
		}
		
		// testing pop
		try {
			System.out.println("\nTesting pop.");
			int top = stack.pop();
			if (top == 5 && stack.size() == 4 && stack.toString().equals("[1, 2, 3, 4]")) {
				System.out.println("...passed");
			} else {
				System.out.println("pop, size, or toString failed");
				System.out.println("    correct popped element: 5");
				System.out.println("    your popped element: " + top);
				System.out.println("    correct size: 4");
				System.out.println("    your size: " + stack.size());
				System.out.println("    correct stack: [1, 2, 3, 4]");
				System.out.println("    your stack: " + stack);
				System.exit(1);
			}
		} catch (Exception e) {
			System.out.println("...failed");
			System.out.println("        threw exception: " + e);
			int line = e.getStackTrace()[0].getLineNumber();
			System.out.println("        in ArrayIntStack line#" + line);
			System.exit(1);
		}

		// testing pop
		try {
			System.out.println("\nTesting pop.");
			int top = stack.pop();
			if (top == 4 && stack.size() == 3 && stack.toString().equals("[1, 2, 3]") ) {
				System.out.println("...passed");
			} else {
				System.out.println("pop, size, or toString failed");
				System.out.println("    correct popped element: 4");
				System.out.println("    your popped element: " + top);
				System.out.println("    correct size: 3");
				System.out.println("    your size: " + stack.size());
				System.out.println("    correct stack: [1, 2, 3]");
				System.out.println("    your stack: " + stack);
				System.exit(1);
			}
		} catch (Exception e) {
			System.out.println("...failed");
			System.out.println("        threw exception: " + e);
			int line = e.getStackTrace()[0].getLineNumber();
			System.out.println("        in ArrayIntStack line#" + line);
			System.exit(1);
		}

		// testing clear
		try {
			System.out.println("\nTesting clear.");
			stack.clear();
			int size = stack.size();
			if (stack.size() == 0 && stack.toString().equals("[]") ) {
				System.out.println("...passed");
			} else {
				System.out.println("clear, size,  or toString failed");
				System.out.println("    correct size: 0");
				System.out.println("    size of your stack: " + size);
				System.out.println("    correct stack: []");
				System.out.println("    your stack: " + stack);
				System.exit(1);
			}
		} catch (Exception e) {
			System.out.println("...failed");
			System.out.println("        threw exception: " + e);
			int line = e.getStackTrace()[0].getLineNumber();
			System.out.println("        in ArrayIntStack line#" + line);
			System.exit(1);
		}

		// Testing popping from an empty stack
		System.out.println("\nTesting popping an empty stack.");
		try {
			stack.pop();
			System.out.println("If the stack prints, this is an error.");
			System.out.println("Stack bottom to top: " + stack);
			System.exit(1);
		} catch (NoSuchElementException e) {
			System.out.println("The stack should throw an exception. Can't pop an empty stack.");
			System.out.println("Threw NoSuchElementException: " + e.getMessage());
		}
		
		// Testing peeking from an empty stack
		System.out.println("\nTesting peeking an empty stack.");
		try {
			int number = stack.peek();
			System.out.println("If the element prints, this is an error.");
			System.out.println("The element at the top of the stack is " + number);
			System.exit(1);
		} catch (NoSuchElementException e) {
			System.out.println("The stack should throw an exception. Can't peek an empty stack.");
			System.out.println("Threw NoSuchElementException: " + e.getMessage());
		}

		//Testing isEmpty
		System.out.println("\nTesting isEmpty.");
		if (stack.isEmpty()) {
			System.out.println("This is the correct output: The stack is empty.");
		} else {
			System.out.println("This is incorrect output: The stack is not empty.");
			System.exit(1);
		}

		System.out.println("\n\nPassed all tests");
	}
}
