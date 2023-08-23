
/**
 * Name(s):
 * Date:
 * CSC 371
 * Lab 2--SentinelList.java 
 *
 * An implementation of a singly linked list with a dummy front node,
 * a reference to the last node, and a size field
 */
import java.util.*;

public class SentinelList<E> implements ListADT<E> {
	// data fields
	private ListNode<E> front; // reference to "dummy" node
	private ListNode<E> back; // reference to last node
	private int size; // number elements in list

	// constructor
	public SentinelList() {
		size = 0;
		front = new ListNode<E>();
		back = front;

	}

	// all of the methods required when implementing ListADT<E>
	public String toString() {
		if (size == 0) {
			return "[]";
		} else {
			String result = "[" + front.next.data;
			ListNode<E> current = front.next.next;
			while (current != null) {
				result += ", " + current.data;
				current = current.next;
			}
			result += "]";
			return result;
		}
	}

	public boolean isEmpty() {
		return (size == 0);
	}

	public void add(E value) {

		back.next = new ListNode<E>(value);
		back = back.next;
		size++;

	}

	public int size() {
		return size;
	}

	public E get(int index) {
		if (index < 0 || index >= size) {
			throw new IndexOutOfBoundsException("index: " + index);
		}
		ListNode<E> current = front.next;
		for (int i = 0; i < index; i++) {
			current = current.next;
		}
		return current.data;
	}

	public int indexOf(E value) {
		int index = 0;
		ListNode<E> current = front.next;
		while (current != null) {
			if (current.data == value) {
				return index;
			}
			index++;
			current = current.next;
		}
		return -1;
	}

	public boolean contains(E value) {
		ListNode<E> current = front.next;
		while (current != null) {
			if (current.data == value) {
				return true;
			}
			current = current.next;
		}
		return false;
	}

	public void add(int index, E value) {
		if (index < 0 || index > size) {
			throw new IndexOutOfBoundsException("index: " + index);
		}

		ListNode<E> current = front;
		for (int i = 0; i < index; i++) {
			current = current.next;
		}
		current.next = new ListNode<E>(value, current.next);
		size++;
	}

	public void remove(int index) {
		if (index < 0 || index >= size) {
			throw new IndexOutOfBoundsException("index: " + index);
		}
		ListNode<E> current = front;
		for (int i = 0; i <= index - 1; i++) {
			current = current.next;
		}
		current.next = current.next.next;

		size--;
		
		if(size == 0) {
			back = front;
		}
		
	}

	public void set(int index, E value) {
		if (index < 0 || index >= size) {
			throw new IndexOutOfBoundsException("index: " + index);
		}

		ListNode<E> current = front.next;
		for (int i = 0; i < index; i++) {
			current = current.next;
		}
		current.data = value;
	}

	public void clear() {
		front.next = null;
		back = front;
		size = 0;
	}

	
	public Iterator<E> iterator(){
		return new LinkedIterator();
	}
	
	// ListNode is a class for storing a single node of a linked list.
	private class ListNode<E> {
		private E data;
		private ListNode<E> next;

		// default constructor with null data and a null link
		private ListNode() {
			this(null, null);
		}

		// constructs a node with this data and a null link
		private ListNode(E data) {
			this(data, null);

		}

		// constructs a node with this data and this link
		private ListNode(E data, ListNode<E> next) {
			this.data = data;
			this.next = next;
		}

	}

	 //LinkedIterator provides an iterator for the SentinelList class
	 private class LinkedIterator implements Iterator<E> {
	 private ListNode<E> current;
	 
	 private LinkedIterator() {
		 this.current = front.next;
	 }
	 
	 public boolean hasNext() {
		 return current != null;
	 }
	 
	 public E next() {
		 if(!hasNext()) {
			 throw new NoSuchElementException();
		 }
		 
		 E element = current.data;
		 current = current.next;
		 return element;
	 }
	 
	 public void remove() {
		 throw new UnsupportedOperationException();
	 }
	
	
	 }

}
