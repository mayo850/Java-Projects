
/**
 * Name(s): Izan & Joshua
 * Date: September 9, 2020
 * CSC 370
 * Lab 1--ArrayIntStack
 * An array implementation of a stack data structure
 */

import java.util.Arrays;
import java.util.NoSuchElementException;

public class ArrayIntStack implements StackIntADT {

	// data fields
	private int[] elementData; // list of values
	private int size; // current number of elements in the stack

	public static final int DEFAULT_CAPACITY = 4;

	/**
	 * constructs a stack with DEFAULT_CAPACITY
	 */

	public ArrayIntStack() {
		this(DEFAULT_CAPACITY);

	}

	/**
	 * constructs a stack with the desired capacity
	 * 
	 * @param capacity - the desired initial capacity
	 * @throws IllegalArgumentException when capacity is negative
	 */
	public ArrayIntStack(int capacity) {
		if (capacity < 0) {
			throw new IllegalArgumentException();
		}

		elementData = new int[capacity];
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
	public void push(int item) {
		ensureCapacity(size + 1);
		size++;
		elementData[size - 1] = item;
	}

	@Override
	public int pop() throws NoSuchElementException {
		if (size <= 0) {
			throw new NoSuchElementException("Size must be greater then 0, Sorry!");
		}
		int value = elementData[size - 1];
		elementData[size - 1] = 0;
		size--;
		return value;
	}

	@Override
	public int peek() throws NoSuchElementException {
		if (size <= 0) {
			throw new NoSuchElementException("Size must be greater then Zero!!");
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
			elementData[i] = 0;
			size--;
		}
	}

}
