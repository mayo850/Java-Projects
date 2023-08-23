/**
 * An array implementation of a stack data structure
 */


import java.util.Arrays;
import java.util.NoSuchElementException;

public class ArrayStack<E> implements StackADT<E>{
	
	// data fields
    private E[] elementData; // list of values
    private int size;        // current number of elements in the stack
    
    public static final int DEFAULT_CAPACITY = 100;
    
    public ArrayStack() {
        elementData = (E[]) new Object[DEFAULT_CAPACITY];
        size = 0;
    }
	
	  /**
     * Add an item onto the stack
     * @param item the data item to add (of type E)
     */
    public void push(E item){
    	ensureCapacity(size + 1);
    	elementData[size] = item;
    	size++; 	
    }

    /**
     * Remove the top item from the stack
     * @return the top item in the stack
     * @throws NoSuchElementException if the stack is empty
     */
    public E pop() throws NoSuchElementException{
    	if (isEmpty()){
    		throw new NoSuchElementException("Cannot pop an element from empty stack");
    	}
    	E item = elementData[size - 1];
    	elementData[size - 1] = null;
    	size--;
    	return item;
    }

    /**
     * Return the top item from the stack without removing it
     * @return the top item in the stack
     * @throws NoSuchElementException if the stack is empty
     */
    public E peek() throws NoSuchElementException{
    	if (isEmpty()){
    		throw new NoSuchElementException("Cannot peek an element from empty stack");
    	}
    	return elementData[size - 1];
    }

    /**
     * Find how many items are in the stack
     * @return the number of items in the stack
     */
    public int size(){
    	return size;
    }

    /**
     * Determine if the stack is empty
     * @return true if the size is 0, false otherwise
     */
    public boolean isEmpty(){
    	return (size == 0);
    }

    /**
     * Clears out the data structure
     */
    public void clear(){
    	for (int i = 0; i < size; i++){
    		elementData[i] = null;
    	}
    	size = 0;
    }
    
    /**
     * @return a comma-separated, bracketed version of the list
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

    
    // post: ensures that the underlying array has the given capacity; if not,
    //       the size is doubled (or more if given capacity is even larger)
    private void ensureCapacity(int capacity) {
        if (capacity > elementData.length) {
            int newCapacity = elementData.length * 2 + 1;
            if (capacity > newCapacity) {
                newCapacity = capacity;
            }
            elementData = Arrays.copyOf(elementData, newCapacity);
        }
    }

}
