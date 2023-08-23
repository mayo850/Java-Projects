import java.util.*;
public class Divider {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int i=0;
		
		do {
			
	   System.out.println("Enter the Dividend: ");
	   int dividend = scan.nextInt();
	   
	   System.out.println("Enter the Divisor: ");
	   int divisor = scan.nextInt();
	   
	   int quotient = dividend/divisor;
	   int remainder = dividend%divisor;
	   
	   System.out.println("Quotient is: " + quotient + "\tRemainder is: " + remainder);
	   System.out.println("");
	   
	   i--;
		 }
		while (true); 
		
		

	}

}