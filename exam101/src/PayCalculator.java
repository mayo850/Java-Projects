/*
 * Name:
 * Date:
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

	public static final double PAY_S =20.50;
	public static final double PAY_M =12.75;
	public static final double PAY_J =8.25;
	public static final double TAX_FIRST =14.95;
	public static final double TAX_SECOND =16.95;
	public static final double TAX_THIRD =26.95;
	public static double highestNetPayment = Integer.MIN_VALUE;
	public static double lowestNetPayment = Integer.MAX_VALUE;
	public static double totalNetPayment = 0;
	public static double netPay = 0;
	
	public static void main(String[] args) {
//		Scanner console = new Scanner(System.in);
//		introduction();
//
//		int numEmployees = getInteger("Enter number of employees: ", console);
//		System.out.println();
//
//		for (int employee = 1; employee <= numEmployees; employee++) {
//			System.out.println("Record for employee " + employee);
//			double netPay = processOneEmployee(console, numEmployees);
//			System.out.println();
//		}
//		outputSummary(numEmployees, netPay, highestNetPayment, lowestNetPayment);
		
		String sentence = "python";
		
		System.out.print("\"" + sentence + "\"  \nshaheer");
		
		
		


	}
	
	
	
	
//	/*
//	 * Method introduction tells the user what value he will need to input
//	 * and what output the program will produce.
//	 */
//	public static void introduction(){
//		System.out.println("Pay Calculator");
//		System.out.println();
//		System.out.println("After entering the number of employees, the id and");
//		System.out.println("number of hours worked will be entered for each");
//		System.out.println("employee. The pay statement for each employee, as");
//		System.out.println("well as summary data, will be displayed.");
//		System.out.println();
//	}
//	public static int getInteger(String prompt, Scanner console) {
//		System.out.print(prompt);
//		int integer = console.nextInt();
//		return integer;
//	}
//	public static String getString(String prompt, Scanner console) {
//		System.out.print(prompt);
//		String employeesid = console.next();
//		return employeesid;
//				
//	}
//
//	public static double getDouble (String prompt, Scanner console) {
//		double Double = console.nextDouble();
//		return Double;
//	}
//
//	
//	public static double computeBasePay(String employeesid, double hoursWorked ) {
//		String fletter = employeesid.substring(0, 1);
//		double basePay = 0;
//		
//		if (fletter.equalsIgnoreCase("s")) {
//			
//			double hourlyPayment = PAY_S;
//			
//			if (hoursWorked <= 40) {
//				basePay = hoursWorked * hourlyPayment;
//			} else if (hoursWorked <= 60) {
//				basePay = ((hoursWorked - 40) * 2 * hourlyPayment) + (40 * hourlyPayment);
//			} else {
//				basePay = ((hoursWorked - 60) * 3 * hourlyPayment) + (40 * hourlyPayment) * 2;
//			}
//		}
//		if (fletter.equalsIgnoreCase("M")) {
//			double hourlyPayment = PAY_M;
//			if (hoursWorked <= 40) {
//				basePay = hoursWorked * hourlyPayment;
//			} else if (hoursWorked <= 60) {
//				basePay = ((hoursWorked - 40) * 2 * hourlyPayment) + (40 * hourlyPayment);
//			} else {
//				basePay = ((hoursWorked - 60) * 3 * hourlyPayment) + (40 * hourlyPayment) * 2;
//			}
//		}
//		if (fletter.equalsIgnoreCase("J")) {
//			double hourlyPayment = PAY_J;
//			if (hoursWorked <= 40) {
//				basePay = hoursWorked * hourlyPayment;
//			} else if (hoursWorked <= 60) {
//				basePay = ((hoursWorked - 40) * 2 * hourlyPayment) + (40 * hourlyPayment);
//			} else {
//				basePay = ((hoursWorked - 60) * 3 * hourlyPayment) + (40 * hourlyPayment) * 2;
//			}
//			
//		}
//		return basePay;
//	}
//		
//	
//	
//	
//	public static double computeTaxes (double basePay) {
//		double tax =0;
//		double taxRate = 0;
//		if (basePay < 200) {
//			taxRate = 14.95;
//		} else if (basePay >= 775) {
//			taxRate = 26.95;
//		} else {
//			taxRate = 16.95;
//		}
//		tax = (taxRate / 100) * (basePay);
//		return tax;
//	}
//	
//	public static double processOneEmployee(Scanner console, int numEmployees) {
//double basePay = 0;
//double tax = 0;
//
//		String employeesID = getString("\tEnter Id: ", console);
//		int hoursWorked = getInteger("\tEnter hours worked: ", console);
//		computeBasePay(employeesID, hoursWorked);
//		computeTaxes(basePay);
//		double netPay = basePay - tax;
//		outputPayStatment(basePay, tax, netPay);
//		totalNetPayment = totalNetPayment + netPay;
//
//		if (netPay > highestNetPayment) {
//			highestNetPayment = netPay;
//		}
//		if (netPay < lowestNetPayment) {
//			lowestNetPayment = netPay;
//		}
//		return netPay;
//	}
//	public static void outputPayStatment(double basePay, double tax, double netPayment) {
//		System.out.printf("\tBase Pay: $%,10.2f", basePay);
//		System.out.println();
//		System.out.printf("\tTaxes %3s: $%,10.2f,", tax);
//		System.out.println();
//		System.out.printf("\tNet Pay%2s: $%,10.2f", netPayment);
//		System.out.println();
//	}
//	
//	public static void outputSummary(int numEmployees, double netPay, double highestNetPayment,
//			double lowestNetPayment) {
//		double averageNetPayment = totalNetPayment / numEmployees;
//		System.out.println("Summary");
//		System.out.println();
//		System.out.printf("Total Net Pay%4s:$ %,9.2f", totalNetPayment);
//		System.out.println();
//		System.out.printf("Average Net Pay" + "%1s" + " $" + "%,10.2f", ":", averageNetPayment);
//		System.out.println();
//		System.out.printf("Highest Net Pay" + "%1s" + " $" + "%,10.2f", ":", highestNetPayment);
//		System.out.println();
//		System.out.printf("Lowest Net Pay" + "%2s" + " $" + "%,10.2f", ":", lowestNetPayment);
//
//	}
//
//}
//		
//		
//	
//	
}
	
//
