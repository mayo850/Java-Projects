// Test Class for Tickets

public class MainTickets {

	public static void main(String[] args) {
		WalkUpTicket ticket1 = new WalkUpTicket("5J");
		System.out.println("WalkUpTicket");
		System.out.println(ticket1);
		System.out.println("Total number of tickets: " + Ticket.getNumTickets());
		System.out.println();

		AdvanceTicket ticket2 = new AdvanceTicket("7B", 6);
		System.out.println("AdvanceTicket");
		System.out.println(ticket2);
		System.out.println("Total number of tickets: " + Ticket.getNumTickets());
		System.out.println();

		StudentAdvanceTicket ticket3 = new StudentAdvanceTicket("10J", 17);
		System.out.println("StudentAdvanceTicket");
		System.out.println(ticket3);
		System.out.println("Total number of tickets: " + Ticket.getNumTickets());
		System.out.println();
	}

}
