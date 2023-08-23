/**
 * @author Izan Khan
 * @assignment CSC212-Lab9A
 * @version (April 3, 2019)
 * 
 *          An abstract class to represent a ticket for an event storing the
 *          ticket number.
 */
public abstract class Ticket {

	// fields
	private String number;

	/**
	 * Constructs a ticket with a ticket number
	 * 
	 * @param number- the ticket number for this ticket
	 */
	public Ticket(String number) {
		this.number = number;
		numTickets++;
	}

	/**
	 * Provides the price of this ticket
	 * 
	 * @return the ticket price
	 */
	public abstract double getPrice();

	/**
	 * Provides a string representation of a ticket
	 * 
	 * @return a string representation of a ticket
	 */
	public String toString() {
		return "Number: " + number + ", Price: $" + getPrice();
	}

	/**
	 * Provides the number of tickets sold
	 * 
	 * @return the number of tickets
	 */
	private static int numTickets = 0;

	public static int getNumTickets() {
		return numTickets;
	}
}
