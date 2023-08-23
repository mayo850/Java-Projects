
/*
 * Name: Izan Khan
 * Date: 15 - 0ctober - 2018
 * Course: CSC211
 * Program:   Program 4--PayCalculator
 * 
 * Description: 
 * 
 * 
 * Citations of Assistance (who and what):
 */

import java.util.*;

public class PayCalculator {
	public static final double FIRST_TAX_RATE = 14.95;
	public static final double SECOND_TAX_RATE = 16.95;
	public static final double THIRD_TAX_RATE = 26.95;
	public static final double FIRST_PAY_PER_HOUR = 20.50;
	public static final double SECOND_PAY_PER_HOUR = 12.75;
	public static final double THIRD_PAY_PER_HOUR = 8.25;
	public static double averageNetPayment = 0;
	public static double tax = 0;
	public static double basePay = 0;
	public static double netPay = 0;
	public static double highestNetPayment = Integer.MIN_VALUE;
	public static double lowestNetPayment = Integer.MAX_VALUE;
	public static double totalNetPayment = 0;

	public static void main(String[] args) {
		Scanner console = new Scanner(System.in);
		introduction();

		int numEmployees = getInteger("Enter number of employees: ", console);
		System.out.println();

		for (int employee = 1; employee <= numEmployees; employee++) {
			System.out.println("Record for employee " + employee);
			double netPay = processOneEmployee(console, numEmployees);
			System.out.println();
		}
		outputSummary(numEmployees, netPay, highestNetPayment, lowestNetPayment);

	}

	/*
	 * Method introduction tells the user what value he will need to input and what
	 * output the program will produce.
	 */
	public static void introduction() {
		System.out.println("Pay Calculator");
		System.out.println();
		System.out.println("After entering the number of employees, the id and");
		System.out.println("number of hours worked will be entered for each");
		System.out.println("employee. The pay statement for each employee, as");
		System.out.println("well as summary data, will be displayed.");
		System.out.println();
	}

	public static int getInteger(String prompt, Scanner console) {
		System.out.print(prompt);
		int integer = console.nextInt();
		return integer;

	}

	public static String getString(String prompt, Scanner console) {
		System.out.print(prompt);
		String employeesID = console.next();
		return employeesID;
	}

	public static double getDouble(String prompt, Scanner console) {
		System.out.print(prompt);
		double Double = console.nextInt();
		return Double;

	}

	public static double processOneEmployee(Scanner console, int numEmployees) {

		String employeesID = getString("\tEnter Id: ", console);
		int hoursWorked = getInteger("\tEnter hours worked: ", console);
		computeBasePay(employeesID, hoursWorked);
		computeTaxes(basePay);
		double netPay = basePay - tax;
		outputPayStatment(basePay, tax, netPay);
		totalNetPayment = totalNetPayment + netPay;

		if (netPay > highestNetPayment) {
			highestNetPayment = netPay;
		}
		if (netPay < lowestNetPayment) {
			lowestNetPayment = netPay;
		}
		return netPay;
	}

	public static double computeBasePay(String employeesID, double hoursWorked) {
		char first = employeesID.charAt(0);
		if ((first == 's') || (first == 'S')) {
			double hourlyPayment = FIRST_PAY_PER_HOUR;
			if (hoursWorked <= 40) {
				basePay = hoursWorked * hourlyPayment;
			} else if ((hoursWorked > 40) && (hoursWorked <= 60)) {
				basePay = ((hoursWorked - 40) * 2 * hourlyPayment) + (40 * hourlyPayment);
			} else {
				basePay = ((hoursWorked - 60) * 3 * hourlyPayment) + (40 * hourlyPayment) * 2;
			}
		}

		else if ((first == 'm') || (first == 'M')) {
			double hourlyPayment = SECOND_PAY_PER_HOUR;
			if (hoursWorked <= 40) {
				basePay = hoursWorked * hourlyPayment;
			} else if ((hoursWorked > 40) && (hoursWorked <= 60)) {
				basePay = ((hoursWorked - 40) * 2 * hourlyPayment) + (40 * hourlyPayment);
			} else {
				basePay = ((hoursWorked - 60) * 3 * hourlyPayment) + (40 * hourlyPayment) * 2;
			}
		}

		else if ((first == 'j') || (first == 'J')) {
			double hourlyPayment = THIRD_PAY_PER_HOUR;
			if (hoursWorked <= 40) {
				basePay = hoursWorked * hourlyPayment;
			} else if ((hoursWorked > 40) && (hoursWorked <= 60)) {
				basePay = ((hoursWorked - 40) * 2 * hourlyPayment) + (40 * hourlyPayment);
			} else {
				basePay = ((hoursWorked - 60) * 3 * hourlyPayment) + (40 * hourlyPayment) * 2;
			}
		}
		return basePay;
	}

	public static double computeTaxes(double basePay) {
		double taxRate = 0;
		if (basePay < 200) {
			taxRate = 14.95;
		} else if (basePay >= 775) {
			taxRate = 26.95;
		} else {
			taxRate = 16.95;
		}
		tax = (taxRate / 100) * (basePay);
		return tax;

	}

	public static void outputPayStatment(double basePay, double tax, double netPayment) {
		System.out.printf("\tBase Pay: $%,10.2f", basePay);
		System.out.println();
		System.out.printf("\tTaxes" + "%4s" + " " + "$" + "%,10.2f", ":", tax);
		System.out.println();
		System.out.printf("\tNet Pay" + "%2s" + " " + "$" + "%,10.2f", ":", netPayment);
		System.out.println();
	}

	public static void outputSummary(int numEmployees, double netPay, double highestNetPayment,
			double lowestNetPayment) {
		averageNetPayment = totalNetPayment / numEmployees;
		System.out.println("Summary");
		System.out.println();
		System.out.printf("Total Net Pay" + "%3s" + " $" + " " + "%,9.2f", ":", totalNetPayment);
		System.out.println();
		System.out.printf("Average Net Pay" + "%1s" + " $" + "%,10.2f", ":", averageNetPayment);
		System.out.println();
		System.out.printf("Highest Net Pay" + "%1s" + " $" + "%,10.2f", ":", highestNetPayment);
		System.out.println();
		System.out.printf("Lowest Net Pay" + "%2s" + " $" + "%,10.2f", ":", lowestNetPayment);

	}
}
