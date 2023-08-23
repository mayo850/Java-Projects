/**
 * @author Izan Khan
 * @assignment CSC212-Lab9A
 * @version (April 3, 2019)
 * 
 *          Description: AdvanceTicket represents a ticket bought before an
 *          event
 *
 */
public class AdvanceTicket extends Ticket {
	// field
	private int days;

	public static final int TEN_DAYS = 10;

	/**
	 * Constructs a ticket bought before an event
	 * 
	 * @param days the number of days before the event that the ticket was purchased
	 */
	public AdvanceTicket(String number, int days) {
		super(number);
		this.days = days;
	}

	/**
	 * Provides the price of the ticket purchased depending on the number of days
	 * the ticket was purchased before the event
	 * 
	 * @return the price of the ticket
	 */

	public double getPrice() {

		if (days >= TEN_DAYS) {
			return 30.0;
		} else {
			return 40.0;
		}
	}
}
