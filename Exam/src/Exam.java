import java.util.*;

public class Exam {
	public static final double SENTINEL = -1;

	public static void main(String[] args) {
		int SENTINEL = -1;
		Scanner console = new Scanner(System.in);
		giveIntro();
		computeCommission(console);

	}

	public static void giveIntro() {

		System.out.println(
				"This program calculates automobile sales comissions, \nrepeating until you enter a price of -1.");
		System.out.println("");
	}

	public static void computeCommission(Scanner console) {
		double total = 0;
		double commission = 0;

		double input = 0;
		System.out.print("Enter sales price (-1 to stop): ");
		input = console.nextDouble();

		while (input != SENTINEL) {

			if (input < 10000) {
				commission = input * 0.02;
				System.out.printf("Commission is $%.2f\n", commission);
				System.out.println("");
				total = total + commission;

			} else if (input < 20000) {
				commission = ((input - 10000) * 0.015) + 200;
				System.out.printf("Commission is $%.2f\n", commission);
				System.out.println("");
				total = total + commission;
			} else {
				commission = ((input - 20000) * 0.01) + 350;
				System.out.printf("Commission is $%.2f\n" , commission);
				System.out.println("");
				total = total + commission;
			}
			System.out.print("Enter sales price (-1 to stop): ");
			input = console.nextDouble();

		}

		System.out.printf("Total sales commission = $%.2f\n", total);

	}

}
