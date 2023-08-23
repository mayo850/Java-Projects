public class LinkedIntList {

	private ListNode front; // first value in the list

	public LinkedIntList() {
		front = null;
	}

	/**
	 * creates comma separated, bracketed version of the list
	 * 
	 * @return a String of the form [2, 5, 7]
	 */
	public String toString() {
		if (front == null) {
			return "[]";
		} else {
			String result = "[" + front.data;
			ListNode current = front.next;
			while (current != null) {
				result += ", " + current.data;
				current = current.next;
			}
			result += "]";
			return result;
		}
	}

	/**
	 * creates a linked looking version of the list
	 * 
	 * @return String of this form: front -> [2] -> [5] -> [7]/
	 */
	public String toLinkedForm() {
		if (front == null) {
			return "front /";
		} else {
			String result = "front -> [" + front.data + "] ";
			ListNode current = front.next;
			while (current != null) {
				result += "-> [" + current.data + "] ";
				current = current.next;
			}
			result += "/";
			return result;
		}
	}

	
	
	
	/**
	 * adds elements from the array to a linked list
	 * 
	 * @param array - elements to be added to linked list
	 * 
	 *              Let's you use code like this in the client to more easily create
	 *              a linked list. LinkedIntList myList = new LinkedIntList(); int[]
	 *              array = {5, 4, 9}; myList.createListFromArray(array);
	 */
	public void createListFromArray(int[] array) {
		for (int i = array.length - 1; i >= 0; i--) {
			front = new ListNode(array[i], front);
		}
	}

	public void addBeginAndEnd(int val) {
		ListNode front1 = new ListNode(val);
		front1.next = front;
		front = front1;
		
		ListNode current = front;
		
	
		
		while(current.next != null) {
			current = current.next;
		}
		
		current.next = new ListNode(val);
		
		
	}
	
	
	public int lastIndexOf(int val) {
		ListNode current = front;
		
		int count = 0;
		int index = -1;
		
		while(current.next != null) {
			count ++;
			
			if(current.data == val) {
				index = count;
			} 
			
			current = current.next;
			
		}
		
		return index;
	}
	
	
			public boolean findValue(int val) {
				ListNode current = front;
				ListNode temp = null;
				
				while(current.next != null) {
					if(current.data == val) {
						if(temp == null) {
							return true;
						} else {
							temp.next = current.next;
							current.next = front;
							front = current;
							return true;
						}
						
					}
					temp = current;
					current = current.next;
				}
				return false;
			}
	
	
	
	
	public void removeStartAndEnd() {
		ListNode current = front;
		ListNode temp = null;
		
		System.out.print(current);
	
//		front = front.next;
//		current = front;
//		
//		while(current.next != null) {
//			
//			temp = current;
//			current = current.next;
//		}
//		
//		temp.next= current.next;
//		current = temp.next;
		
		
		
		
	}
	
	
	public void removeAll(int val) {
		if(front == null) {
			return;
		}
		
		ListNode current = front;
		ListNode temp = null;
		
		while(current != null && current.data == val) {
			current = front.next;
			front = current;
		}
		
		while(current.next != null) {
		while(current.next != null && current.data != val) {
			temp = current;
			current = current.next;
		}
		
		temp.next = current.next;
		current = temp.next;
		
		}
	}
	
	public void removeRange(int start, int end) {
		if(start > end) {
			throw new IllegalArgumentException();
		}
		
		if(front == null) {
			return;
		}
		
		ListNode current = front;
		ListNode temp = null;
		
		while(current != null && (current.data > start && current.data<end)) {
			current = front.next;
			
			front = current;
		}
		
		while(current != null) {
			
			while(current != null && (current.data > start && current.data<end)) {
				
				current = current.next;
				temp.next = current;
				
				if(current == null) {
					return;
				}
			}
			
			
			
			temp = current;
			current = current.next;
			
		}
		
	}
	
	
	
	public void doubleList(){
	    if(front == null){
	        return;
	    }
	    
	    ListNode current = front;
	    ListNode temp = null;
	    
	    while(current != null){
	        temp = current;
	        
	        current.next = new ListNode(temp.data);
	        
	        current = current.next;
	    }
	    
	    current = temp;
	    front = current;
	    
	}
	
	
	
	public void bringLastToFront() {
		ListNode current = front;
		ListNode temp = null;
		ListNode last = null;
		
		
		while(current.next != null) {
			temp = current;
			last = current.next;
			current = current.next;
		}
		
		last.next = front;
		temp.next = null;
		front = last;
		;
		
		
		
		
		
	}
	
		
	private class ListNode {
		private int data; // data stored in this node
		private ListNode next; // link to next node in the list

		/**
		 * post: constructs a node with data 0 and null link
		 */
		private ListNode() {
			this(0, null);
		}

		private ListNode(int data) {
			this(data, null);
		}

		private ListNode(int data, ListNode next) {
			this.data = data;
			this.next = next;
		}
	}
}