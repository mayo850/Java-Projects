
/*
 * Name: Izan Khan
 * Date: 6 October 2018
 * Course: CSC 211
 * Program: Programming Assignment Ch3
 * 
 * Decription: Program will give some directions to the user, prompt the user to enter five values,
 * and produce a nicely formatted four column table with rows for various interest rates of a fixed
 * interest loan compounded monthly. Each row will give the annual interest rate for the loan, the 
 * monthly payment for the loan, the total of those payments over the term of the loan, and the total 
 * interest paid over the term of the loan.
 *
 *
 *Citations of Assistance (who and what): Help from senior: Mobashir Ali
 * 
 */

import java.util.*;

public class LoanTable {
	public static final int NUMBER_OF_MONTHS = 12;

	public static void main(String[] args) {
		directions();
		System.out.println(" ");
		Scanner console = new Scanner(System.in);
		double principal = getDouble("Enter principal: ", console);
		int term = getInteger("Enter term of loan in years: ", console);
		double initialRate = getDouble("Enter initial interest rate: ", console);
		String incrementStatement = "Enter an increment for the interest rate: ";
		double increment = getDouble(incrementStatement, console);
		double maxRate = getDouble("Enter a maximum interest rate: ", console);
		System.out.println(" ");
		createTable(principal, term, initialRate, increment, maxRate);
	}

// instructions of program

	public static void directions() {
		System.out.println("You will be asked to enter the principal of a loan,");
		System.out.println("the term of the loan, an initial interest rate, an");
		System.out.println("increment for the interest rate, and a maximum interest");
		System.out.println("rate. A table will show your monthly payment, the total");
		System.out.println("of your payments and the total interest for the increasing");
		System.out.println("interest rates.");

	}

//ask user to enter the value of term of loan. 
//has two parameter string for the text on main method
// consist of scanner object for a user to enter a value
// and return the value to the main method	

	public static int getInteger(String prompt, Scanner console) {
		System.out.print(prompt);
		int value = console.nextInt();
		return value;

	}

// enter the values which are a double
// has two parameters, String for the text of the prompt on 
// main method and a Scanner object which is used to enter values
// getDouble returns a value to the main method.
	public static double getDouble(String prompt, Scanner console) {
		System.out.print(prompt);

		double value = console.nextDouble();
		return value;
	}

// gives the user the output from the values entered in main method 
// of increasing interest rate and monthly payment and total payment
// total interest till certain interest rate.
	public static void createTable(double principal,int term, 
			                   double initialRate,double increment,double maxRate) {
		System.out.printf("Report for a loan of $%,.2f", principal);
		System.out.println(" for " + term + " years ");
		System.out.println("compound monthly. ");
		System.out.println();
		System.out.printf("%8s%13s%13s%13s\n","Interest","Monthly","Total", "Total");
		System.out.printf("%8s%13s%13s%13s \n","Rate","Payment","Payment","Interest");
		System.out.println("---------------------------------------------------");
		System.out.print("");

		for (double i = initialRate; i <= maxRate; i = i + increment) {

			computeMonthlypayment(initialRate, principal, term);
			double monthlyPayments = computeMonthlypayment(i, principal, term);
			double totalPayment = (monthlyPayments * NUMBER_OF_MONTHS) * term;
			double totalInterest = totalPayment - principal;

			System.out.printf("%7.2f%% %,13.2f %,13.2f %,13.2f \n",
					             i,monthlyPayments,totalPayment,totalInterest);
		}

	}

// gives monthly payments based on three formal
// parameters: the initial principal and interest rate
// and term of the loan. 
// Interest rate is calculated from the initial rate
// divided by 12 months and Number of Total periods 
// is calculated by multiplying the terms
// by 12 months.
// Monthly payment is calculated by its formula that uses the calculated
// original principal , intrerest rate, number of total periods 
// which is returned to the method createTable.

	public static double computeMonthlypayment(double initialRate,double principal,
			                                                            int term) {
		double interestRate = (initialRate / 100) / NUMBER_OF_MONTHS;
		double numberTotalPeriods = term * NUMBER_OF_MONTHS;
		double monthlyPayments = (interestRate * principal) / (1 - (Math.pow((1 + interestRate), -numberTotalPeriods)));
		return monthlyPayments;
	}
}
