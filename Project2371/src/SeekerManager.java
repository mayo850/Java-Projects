
/**
 * Name:
 * Date:
 * CSC 371
 * Project 2--SeekerManager
 * 
 * Program Description:
 * 
 * 
 * 
 * Cite assistance (who and what):
 * 
 * 
 * 
 */

import java.util.List;



public class SeekerManager {
	
	SeekerNode seekerRingFront;
	SeekerNode capturedListFront;

	public SeekerManager(List<String> names) {
		// Throw exception if invalid argument is received
				if(names == null || names.size() == 0) {
					throw new IllegalArgumentException();
				}
				
				// Initialize the front of the list
				seekerRingFront = new SeekerNode(names.get(0));

				
				// Create a temporary node
				SeekerNode tempNode = seekerRingFront;
				
				// Iterate over names list and add each name to seeker ring link list
				for (int i = 1; i < names.size(); i++)
				{
					tempNode.next = new SeekerNode(names.get(i));
					tempNode = tempNode.next;
				}	
	
	}
	
	public void printSeekingRing() {
		// Check if any seeker has won the game
				if(seekerRingFront != null && seekerRingFront.next == null) {
					
					// Display win message
					System.out.println("  " + seekerRingFront.name + " won the game!");
					return;
				}
				
				// Create a temporary node to traverse the list
				SeekerNode tempNode = seekerRingFront;
				
				//Iterate over the list
				while(tempNode != null) {
					
					if(tempNode.next != null) {
						// Display the seeking member info
						System.out.println("  " + tempNode.name + " is seeking " + tempNode.next.name);				
					}
					else {
						// Display the seeking member info
						System.out.println("  " + tempNode.name + " is seeking " + seekerRingFront.name);				
					}
					
					tempNode = tempNode.next;
				}
	}
	
	public void printCapturedList() {
		// Check if anyone is captured
				if(capturedListFront == null) {
					// No one is captured, hence return back without displaying anything.
					return;
				}
				
				// Create a temporary node to iterate the captured list
				SeekerNode tempNode = capturedListFront;
				
				// Iterate over the captured list
				while(tempNode != null) {
					
					// Display the captured member info
					System.out.println("  " + tempNode.name + " was captured by " + tempNode.capturedBy);
					
					tempNode = tempNode.next;
				}
	}
	
	public boolean seekingRingContains(String name) {
		// Create a temporary node to iterate the seeking list
				SeekerNode tempNode = seekerRingFront;
				
				// Iterate the linked list
				while(tempNode != null) {
					//Check if the current element is the desired element
					if(tempNode.name.equalsIgnoreCase(name)) {
						return true;	// desired name found, return true
					}
					
					tempNode = tempNode.next;
				}
				
				return false;	
	}

	public boolean capturedListContains(String name) {
		// Create a temporary node to iterate the seeking list
				SeekerNode tempNode = capturedListFront;
				
				// Iterate the linked list
				while(tempNode != null) {
					//Check if the current element is the desired element
					if(tempNode.name.equalsIgnoreCase(name)) {
						return true; 	// desired name found, return true
					}
					
					tempNode = tempNode.next;
				}
				
				return false;
	}
	
	public boolean gameOver() {
		// Check if there is only one element in the seeking list
				if(seekerRingFront != null && seekerRingFront.next == null) {
					return true;
				}
				
				return false;	
	}
	
	public void captured(String name) {
		// Game is over, throw exception
				if(gameOver()) {
					throw new IllegalStateException();
				}
				
				// Create a temporary node to traverse the list
				SeekerNode tempNode = seekerRingFront;
				SeekerNode prevNode = null;

				boolean nameFound = false;	// flag value to check if name exists in list
				
				while(tempNode != null) {
					
					if(tempNode.name.equalsIgnoreCase(name)) {
						nameFound = true;	// name exists
					}
					
					prevNode = tempNode;
					tempNode = tempNode.next;
				}
				
				// throw exception if name is not found
				if(!nameFound) { 
					throw new IllegalArgumentException();
				}
				
				// Store the info of last node
				SeekerNode end = prevNode;
				tempNode = seekerRingFront;
				prevNode = null;
						
				// Iterate the list to remove node from seeker ring and add it to captured list
				while(tempNode != null) {
					
					if(tempNode.name.equalsIgnoreCase(name)) {
						
						if(prevNode == null) {
							/* Name is found at the front of the list */
							
							// Update the front of the list
							seekerRingFront = seekerRingFront.next;
							
							// Add to the captured list
							if(capturedListFront == null) {
								// Check if there is no player captured
								capturedListFront = new SeekerNode(tempNode.name);
							}
							else {
								tempNode.next = capturedListFront;
								capturedListFront = tempNode;
							}
							capturedListFront.capturedBy = end.name;
						}
						else {
							// Remove the node from seeking list
							prevNode.next = tempNode.next;
							
							// Add to the captured list
							if(capturedListFront == null) {
								// Check if there is no player captured
								capturedListFront = new SeekerNode(tempNode.name);
							}
							else {
								tempNode.next = capturedListFront;
								capturedListFront = tempNode;
							}
							capturedListFront.capturedBy = prevNode.name;
						}
					}
					
					prevNode = tempNode;
					tempNode = tempNode.next;
				}
				
	}
	
	
	// The SeekerNode class is used to store the information for one
	// player in the game of seeker. Initially the "capturedBy" field
	// is set to null, but when the person is captured, this should be
	// set to the name of the captor.

	private static class SeekerNode {
		private String name; // this person's name
		private String capturedBy; // name of who captured this person (null if
									// still in the seeking ring)
		private SeekerNode next; // next node in the list

		private SeekerNode(String name) {
			this(name, null);
		}

		private SeekerNode(String name, SeekerNode next) {
			this.name = name;
			this.capturedBy = null;
			this.next = next;
		}
	}

}
