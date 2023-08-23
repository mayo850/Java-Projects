/**
 * @author Izan Khan
 * @assignment CSC212-Lab9A
 * @version (April 3, 2019)
 * 
 *          Description: StudentAdvanceTicket represents a ticket purchased by a
 *          ticket before an event by a student with a student ID.
 *
 */
public class StudentAdvanceTicket extends AdvanceTicket {

	/**
	 * Constructs a student ticket bought before an event
	 * 
	 * @param days the number of days before the event that the ticket was purchased
	 */
	public StudentAdvanceTicket(String number, int days) {
		super(number, days);
	}

	/**
	 * Provides the price of the ticket purchased depending on the number of days
	 * the ticket was purchased before the event and requiring a student ID
	 * 
	 * @return the price of the ticket
	 */
	public double getPrice() {
		double price = super.getPrice()/2;
		return price;
	}

	/**
	 * Provides a string representation of the ticket including ID REQUIRED
	 * 
	 * @return a string representation of the ticket
	 */
	public String toString() {
		return super.toString() + " (ID required)";
	}

}
