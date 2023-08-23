
/**
 * Name(s): Izan Khan
 * Date: September 21, 2020
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
		front = new ListNode();
		back = front;
	}

	// all of the methods required when implementing ListADT<E>
	@Override
	public String toString() {
		if (size == 0) {
			return "[]";
		} else {
			String result = "[" + front.next.data.toString();
			ListNode current = front.next.next;
			for (int i = 1; i < size; i++) {
				result += ", " + current.data;
				current = current.next;
			}
			result += "]";
			return result;
		}
	}

	@Override
	public boolean isEmpty() {
		return (size == 0);
	}

	@Override
	public void add(E value) {
		back.next = new ListNode<E>(value);
		back = back.next;
		size++;
	}

	@Override
	public int size() {
		return size;
	}

	@Override
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

	@Override
	public int indexOf(E value) {
		int index = 0;
		ListNode<E> current = front;
		while (current.next != null) {

			current = current.next;
			if (current.data == value) {
				return index;
			}
			index++;
		}
		return -1;
	}

	@Override
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

	@Override
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

	@Override
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
		if (size == 0) {
			back = front;
		}
	}

	@Override
	public void set(int index, E value) {
		if (index < 0 || index >= size) {
			throw new IndexOutOfBoundsException("index: " + index);
		}
		ListNode<E> current = front;
		for (int i = 0; i <= index; i++) {
			current = current.next;
		}
		current.data = value;
	}

	public void clear() {
		front.next = null;
		back = front;
		size = 0;
	}

	public Iterator<E> iterator() {
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

	// LinkedIterator provides an iterator for the SentinelList class
	private class LinkedIterator implements Iterator<E> {
		private ListNode<E> current;
		
		private ListNode<E> before;
		private ListNode<E> keep;
		
		

		private LinkedIterator() {
			this.current = front.next;
			before = null;
			keep = null;
	
			
		}

		public boolean hasNext() {
			return current != null;
		}

		public E next() {
			if (!hasNext()) {
				throw new NoSuchElementException("No next element");
			}
			E result = current.data;
			keep = before;
			before = current; // to remove
			current = current.next;
			return result;
		}

		public void remove() {
			if(before == null) {
				throw new IllegalStateException();
			}
			if(keep == null) {
				
			}
		}

	}

}
