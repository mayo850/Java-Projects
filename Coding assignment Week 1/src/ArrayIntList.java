/**
 * ArrayIntList is a data type for a resizing list of integers
 * 
 * @author dianemueller
 *
 */

import java.util.*;

public class ArrayIntList {
	private int[] elementData; // list of integers
	private int size; // current number of elements in the list

	public static final int DEFAULT_CAPACITY = 10;

	/**
	 * Constructs an empty list of default capacity
	 */
	public ArrayIntList() {
		this(DEFAULT_CAPACITY);
	}
	
	/**
	 * Constructs an empty list with the given capacity
	 * @param capacity - the number of elements to initially allow
	 * @throw IllegalArgumentException for invalid capacity
	 */
	public ArrayIntList(int capacity) {
		if (capacity < 0){
			throw new IllegalArgumentException();
		}
		elementData = new int[capacity];
		size = 0;
	}
	
	/**
	 * Appends the given value to the end of the list
	 * 
	 * @param value- the value to be appended to the list
	 */
	public void add(int value) {
		ensureCapacity(size + 1);
		elementData[size] = value;
		size++;
	}

	/**
	 *Inserts the given value at the given index, 
	 *        shifting subsequent values right
	 * 
	 * @param index
	 *            - the position where the value is added
	 * @param value
	 *            - the integer to be added to this list at the given index
	 * @throws IndexOutOfBoundsException for invalid index
	 */
	public void add(int index, int value) {
		ensureCapacity(size + 1);
		if (index < 0 || index > size) {
			throw new IndexOutOfBoundsException("index: " + index);
		}
		for (int i = size; i > index; i--) {
			elementData[i] = elementData[i - 1];
		}
		elementData[index] = value;
		size++;
	}

	/**
	 * returns the element at the given index
	 * @param index
	 *            - the position of the element returned
	 * @return the element at the given index in this list
	 * @throws IndexOutOfBoundsException for invalid index
	 */
	public int get(int index) {
		checkIndex(index);
		return elementData[index];
	}
	
	/**
	 * replaces the element in the list at the given index with the given value
	 * 
	 * @param index
	 *            - the position of the element returned
	 * @param value - the integer to replace this list's element at the given position
	 * @throws IndexOutOfBoundsException for invalid index
	 */
	public void set(int index, int value) {
		checkIndex(index);
		elementData[index] = value;
	}

	/**
	 * Determines the number of elements in this list
	 * @return the number of elements in this list
	 */
	public int size() {
		return size;
	}
	
	
	/**
	 * Determines if the list is empty or not
	 * @return true if this list has no elements, false otherwise
	 */
	public boolean isEmpty(){
		return (size == 0);
	}
	
	/**
	 * Finds and returns the first index of value in the list or -1 if not found
	 * @param value
	 *            - the integer to search for in the list
	 * @return the position of the first occurrence of the given value (-1 if
	 *         not found)
	 */
	public int indexOf(int value) {
		for (int i = 0; i < size; i ++){
			if (elementData[i] == value){
				return i;
			}
		}
		return -1;
	}
	
	/**
	 * Determines if value if in the list
	 * @param value
	 *            - the integer to search for in the list
	 * @return true if the value is in this list, false otherwise
	 */
	public boolean contains(int value) {
		return (indexOf(value)!= -1);
	}

	/**
	 * Removes the value at the given index shifting the elements to the left 
	 * @param index
	 *            - the position of the element to remove from this list
	 * @throws IndexOutOfBoundsException for invalid index
	 */
	public void remove(int index) {
		checkIndex(index);
		for (int i = index; i < size; i++) {
			elementData[i] = elementData[i + 1];
		}
		size--;
	}
	
	/**
	 * @return a comma-separated, bracketed version of this list
	 */
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
	
	/**
	 * increases the capacity to insure that it can hold
	 * at least the number of elements specified by the
	 * minimum capacity arguement.
	 * 
	 * @param minCapacity - minimum number of elements desired
	 */
	public void ensureCapacity(int minCapacity) {
	    if (minCapacity > elementData.length) {
	        int newCapacity = elementData.length * 2 + 1;
	        if (minCapacity > newCapacity) {
	            newCapacity = minCapacity;
	        }

	        // copy elements to larger list
	        elementData = Arrays.copyOf(elementData, newCapacity);
	    }
	 }
	
	// throws an exception if the index is invalid
	private void checkIndex(int index){
		if (index < 0 || index >= size) {
			throw new IndexOutOfBoundsException("index: " + index);
		}
	}
	
}
