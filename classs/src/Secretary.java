/**
 * A secretary employee in our law office hierarchy scenario
 */
public class Secretary extends Employee{
	
	// constructor
	public Secretary() {
		super(0);
	}
	
	
	/**
	 * Method to print the dictation from a secretary
	 * @param text--the words for the dictation
	 */
	public void takeDictation(String text) {
		System.out.println("Taking Dictation: " + text);
	}
}
