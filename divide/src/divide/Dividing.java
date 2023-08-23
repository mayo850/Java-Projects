package divide;
import java.util.*;
public class Dividing {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String answer = "";
		do {
	   System.out.println("Enter Dividend");
		int dividend = scan.nextInt();
		System.out.println("Enter Divisor");
		int divisor = scan.nextInt();
		
		int quotient = (dividend/divisor);
		int remainder = dividend%divisor;
		
		System.out.print("Quotient is " + quotient + "\t Remainder is "+remainder);
		
		System.out.println("Do you want to contine? (Yes or No)");
		answer = scan.nextLine();
		 
		} while (answer.equalsIgnoreCase("Yes")); 
		
		

	}

}
