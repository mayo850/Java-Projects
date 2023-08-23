import java.util.Stack;
import java.util.Queue;
import java.util.LinkedList;
import java.util.NoSuchElementException;

public class Exam {

	// Queue<Integer> name = new LinkedList<Integer>();
	Stack<Integer> stackA = new Stack<Integer>();

	public static int findMin(Stack<Integer> myStack) {
		if(myStack == null || myStack.size() == 0) {
			throw new NoSuchElementException();
		}
		
		Queue<Integer> myQueue = new LinkedList<Integer>();
		
		int min = Integer.MAX_VALUE;
		
		
		while(!myStack.isEmpty()) {
			if(myStack.peek() < min) {
				min = myStack.peek();
			} 
			myQueue.add(myStack.pop());
		}
		
		while(!myQueue.isEmpty()) {
			myStack.push(myQueue.remove());
		}
		
		while(!myStack.isEmpty()) {
			myQueue.add(myStack.pop());
		}
		
		while(!myQueue.isEmpty()) {
			myStack.push(myQueue.remove());
		}
		
		return min;
		
		
	}

	public static void moveTopToBottom(Stack<String> myStack) {
		int size = myStack.size();

		Stack<String> tempStack = new Stack<String>();

		if (size != 0) {

			String top = myStack.pop();

			while (!myStack.isEmpty()) {
				tempStack.push(myStack.pop());
			}

			myStack.push(top);

			while (!tempStack.isEmpty()) {
				myStack.push(tempStack.pop());
			}

		}
		

	}
	
	

	public static void separate(Queue<Integer> myQueue) {

		Stack<Integer> tempStack = new Stack<Integer>();

		int size = myQueue.size();

		for (int i = 0; i < size; i++) {
			if (myQueue.peek() < 0) {
				myQueue.add(myQueue.remove());
			} else {
				tempStack.push(myQueue.remove());
			}
		}

		while (!tempStack.isEmpty()) {
			myQueue.add(tempStack.pop());

		}

		for (int i = 0; i < size; i++) {
			if (myQueue.peek() < 0) {
				myQueue.add(myQueue.remove());
			} else {
				tempStack.push(myQueue.remove());
			}
		}

		while (!tempStack.isEmpty()) {
			myQueue.add(tempStack.pop());

		}

	}

	public static void rearrange(Queue<Integer> myQueue) {
		Stack<Integer> tempStack = new Stack<Integer>();

		int size = myQueue.size();
		int half = size / 2;

		for (int i = 0; i < half; i++) {
			myQueue.add(myQueue.remove());
		}
		if (size % 2 != 0) {
			myQueue.add(myQueue.remove());
		}

		for (int i = 0; i < half; i++) {
			tempStack.push(myQueue.remove());
		}

		for (int i = 0; i < size; i++) {
			if (i % 2 != 1) {
				myQueue.add(myQueue.remove());
			} else {
				myQueue.add(tempStack.pop());
			}
		}

	}

	public static boolean compareWithBackspace(String str1, String str2) {

		char backSpace = '#';

		Stack<Character> string1 = new Stack<Character>();
		Stack<Character> string2 = new Stack<Character>();

		int size1 = str1.length();
		int size2 = str2.length();

		for (int i = 0; i < size1; i++) {
			if (str1.charAt(i) == backSpace) {
				if (!string1.isEmpty()) {
					string1.pop();
				}

			} else {
				string1.push(str1.charAt(i));
			}
		}

		for (int i = 0; i < size2; i++) {
			if (str2.charAt(i) == backSpace) {
				if (!string2.isEmpty()) {
					string2.pop();
				}

			} else {
				string2.push(str2.charAt(i));
			}
		}

		int size = string1.size();

		if (string2.size() == size) {
			int count = 0;

			for (int i = 0; i < size; i++) {
				if (string1.pop() == string2.pop()) {
					count++;
				}
			}

				if (count == size) {
					return true;
				} else {
					return false;
				}

			

		} else {
			return false;
		}

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Queue<String> words = new LinkedList<String>();
		
		
		
		words.add("alpha");
		words.add("beta");
		words.add("gamma");
		words.add("delta"); 
		words.remove();
		String myWord = words.peek(); 
		words.add("epsilon"); 
		words.add(words.remove());
		words.remove(); 
		words.add(myWord);
		
		System.out.println(words);

//		stackA.push(10);
//		stackA.push(2);
//		stackA.push(-4);
//		stackA.push(6);
//		stackA.push(9);
//
//		Stack<String> stackB = new Stack<String>();
//
//		stackB.push("to");
//		stackB.push("be");
//		stackB.push("or");
//		stackB.push("not");
//		stackB.push("to");
//		stackB.push("be");
//
//		Queue<Integer> queueA = new LinkedList<Integer>();
//
//		queueA.add(1);
//		queueA.add(2);
//		queueA.add(3);
//		queueA.add(4);
//		queueA.add(5);
//		queueA.add(6);
//
//		System.out.println("Before:" + stackA);
//		System.out.println("Min: " + findMin(stackA));
//		System.out.println("After:" + stackA);

//		System.out.println("Before: bottom " + stackB + " top");
//		moveTopToBottom(stackB);
//		System.out.println("After: bottom " + stackB + " top");

//		System.out.println("Before:" + queueA);
//		separate(queueA);
//		System.out.println("After:" + queueA);

//		System.out.println("Before:" + queueA);
//		rearrange(queueA);
//		System.out.println("After:" + queueA);
		
//		System.out.println(compareWithBackspace("ab#c", "ad#c"));
//		System.out.println(compareWithBackspace("XYZ##A", "###XBYZ##"));


	}

}
