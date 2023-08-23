/**
 * @author Izan Khan
 * @assignment CSC212-Lab9A
 * @version (April 3, 2019)
 * 
 *          Description: This program is simple client code to demonstrate
 *          polymorphism with the Ticket class hierarchy.
 *
 */

public class TicketDemo {

	public static final int SIZE = 8;

	public static void main(String[] args) {

		Ticket[] tickets = new Ticket[SIZE];

		tickets[0] = new AdvanceTicket("23B", 5);
		tickets[1] = new AdvanceTicket("5A", 11);
		tickets[2] = new StudentAdvanceTicket("7G", 4);
		tickets[3] = new StudentAdvanceTicket("19E", 12);
		tickets[4] = new WalkUpTicket("17L");
		tickets[5] = new AdvanceTicket("1B", 10);
		tickets[6] = new StudentAdvanceTicket("90E", 7);
		tickets[7] = new WalkUpTicket("15X");

		for (Ticket ticket : tickets) {
			System.out.println(ticket);
		}
	}
}
