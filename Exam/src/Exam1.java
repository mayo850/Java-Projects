
import java.util.*;


public class Exam1 {
	public static final double  SENTINEL = -1;
	public static void main(String[] args) {
		Scanner console = new Scanner(System.in);
		
	giveIntro();
	computeCommission(console);
	
	}
	
	public static void giveIntro ( ) {
	
		System.out.println("This program calculates automobile sales commissions,\nrepeating until you enter a price -1.");
	System.out.println();
	}
	
	public static void computeCommission(Scanner console) {
		
		double total = 0;
		double commission = 0;
		
		System.out.print("Enter sales price (-1 to stop): ");
		double salesPrice=console.nextDouble();
		System.out.println();
		
		while(salesPrice!=-1) {
			
			if (salesPrice < 10000) {
				commission = salesPrice*0.02;
				System.out.printf("Commission is $%.2f\n", commission);
				System.out.println();
				total += commission;
			}
			else if(salesPrice<20000) {
				commission=  200 + ((salesPrice- 10000) * 0.015);
				System.out.printf("Commission is $%.2f\n", commission);
				System.out.println();
				total += commission;
			}
			else  {
				commission= 350 + ((salesPrice-20000)*0.01);
				System.out.printf("Commission is $%.2f\n", commission);
				System.out.println();
				total += commission;
			}
			System.out.print("Enter sales price (-1 to stop): ");
			salesPrice=console.nextDouble();
			System.out.println();
		}
		
		System.out.printf("Total sales commission = $%.2f\n",total);
		
	}
	
	

}
