/**
 * @author Izan Khan
 * @assignment CSC212-Lab9A
 * @version (April 3, 2019)
 * 
 *          Description: WalkUpTicket represents a ticket purchased the day of
 *          the event from the ticket office.
 *
 */
public class WalkUpTicket extends Ticket {
	/**
	 * Constructs a ticket purchased the day of the event
	 */
	public WalkUpTicket(String number) {
		super(number);
	}

	/**
	 * Provides the price of the ticket purchased the day of the event
	 * 
	 * @return the ticket price
	 */

	public double getPrice() {
		return 50.0;
	}
}
