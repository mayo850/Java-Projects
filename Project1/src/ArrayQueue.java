/**
 Name(s): Izan & Joshua
 * Date: September 9, 2020
 * CSC 370
 * Lab 1--ArrayQueue	
 * An array implementation of a queue data structure
 */

import java.util.Arrays;
import java.util.NoSuchElementException;

public class ArrayQueue<E> implements QueueADT<E> {
	
	// data fields
    private E[] elementData; // list of values
    private int size;        // current number of elements in the queue
    
    public static final int DEFAULT_CAPACITY = 4;
    
    public ArrayQueue() {
		 this(DEFAULT_CAPACITY);
		
	}
  
 /**
  * constructs a queue with the desired capacity
  * @param capacity - the desired initial capacity
  * @throws IllegalArgumentException when capacity is negative
  */
  public ArrayQueue(int capacity) {
  if (capacity < 0) {
  	throw new IllegalArgumentException();
  }
  
  elementData = (E[]) new Object[capacity];
  size=0;
  
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
    
    @Override
    public void add (Object item) {
    	ensureCapacity(size+1);
    	size++;
    	elementData[size-1] = (E) item;
    }
   
    
   @Override
    public E remove() throws NoSuchElementException {
    	if(size <= 0) {
    		throw new NoSuchElementException("Can't remove from an empty queue.");
    	}
    	E value = elementData[0];
    	
    	for(int i=1; i<size; i++) {
    		elementData[i-1] = elementData[i];
    	}
    	
        elementData [size-1] = null;
        size--;
        return value;
    }

   @Override
   public E peek() throws NoSuchElementException{
 	   if(size <= 0) {
   		throw new NoSuchElementException("Can't peek an empty queue.");
   	}
 	   return elementData[0];
   }
   
   public int size() {
 	   return size;
   }
   
   public boolean isEmpty() {
 	   return (size == 0); 
 		 
   }
   
   public void clear() {
 	   for (int i = size -1 ; i>=0; i--) {
 		   elementData[i] = null;
 		   size -- ;
 	   }
   }

}
