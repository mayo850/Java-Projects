
/**
 Name(s): Izan & Joshua
 * Date: September 9, 2020
 * CSC 371
 * Lab 1--ArrayStack<E>
 * An array implementation of a stack data structure
 */

import java.util.Arrays;
import java.util.LinkedList;
import java.util.NoSuchElementException;
import java.util.Stack;

public class ArrayStack<E> implements StackADT<E> {

	// data fields
	private E[] elementData; // list of values
	private int size; // current number of elements in the stack

	public static final int DEFAULT_CAPACITY = 4;

	// Put the code from ArrayIntStack here.

	public ArrayStack() {
		this(DEFAULT_CAPACITY);

	}

	/**
	 * constructs a stack with the desired capacity
	 * 
	 * @param capacity - the desired initial capacity
	 * @throws IllegalArgumentException when capacity is negative
	 */
	public ArrayStack(int capacity) {
		if (capacity < 0) {
			throw new IllegalArgumentException();
		}

		elementData = (E[]) new Object[capacity];
		size = 0;

	}

	public String toString() {
		if (size == 0) {
			return "[]";
		} else {
			String result = "[" + elementData[0];
			for (int i = 1; i < size; i++) {
				result += ", " + elementData[i];
			}
			result += "]";
			return result;
		}
	}

	// post: ensures that the underlying array has the given capacity; if not,
	// the size is doubled (or more if given capacity is even larger)
	private void ensureCapacity(int capacity) {
		if (capacity > elementData.length) {
			int newCapacity = elementData.length * 2 + 1;
			if (capacity > newCapacity) {
				newCapacity = capacity;
			}
			elementData = Arrays.copyOf(elementData, newCapacity);
		}
	}

	@Override
	public void push(Object item) {
		ensureCapacity(size + 1);
		size++;
		elementData[size - 1] = (E) item;
	}

	@Override
	public E pop() throws NoSuchElementException {
		if (size <= 0) {
			throw new NoSuchElementException("Can't pop an empty stack.");
		}
		E value = elementData[size - 1];
		elementData[size - 1] = null;
		size--;
		return value;
	}

	@Override
	public E peek() throws NoSuchElementException {
		if (size <= 0) {
			throw new NoSuchElementException("Can't peek an empty stack.");
		}
		return elementData[size - 1];
	}

	public int size() {
		return size;
	}

	public boolean isEmpty() {
		return (size == 0);

	}

	public void clear() {
		for (int i = size - 1; i >= 0; i--) {
			elementData[i] = null;
			size--;
		}
	}
	
	//note to self --> remove Array before stack
	
	LinkedList<Integer> myQueue = new LinkedList<Integer>();
	Stack<Integer> myStack = new Stack<Integer>();
	
	public static int findMin(Stack<Integer>myStack) throws NoSuchElementException {
		if( myStack == null) {
			throw new NoSuchElementException("Empty"); 
		}
		LinkedList<Integer> myQueue = new LinkedList<Integer>();
		int min = myStack.pop();
		myQueue.add(min);
		
		while(!myStack.isEmpty()) {
			int min2= myStack.pop();
			if(min2<min) {
				min = min2;
				myQueue.add(min2);
			}
		}
		return min;
	}

}
