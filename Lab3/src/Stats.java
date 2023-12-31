
/**
 * Name: Izan
 * Date: 09/29/2020
 * CSC 371
 * Lab 3--Stats.java
 * 
 * This programs computes the average of a list of numbers
 * after the outliers have been removed.
 */

import java.util.*;
import java.io.*;
import java.text.*;
public class Stats {

	public static void main(String[] args) throws FileNotFoundException {
		DecimalFormat df = new DecimalFormat("##.###");

		Scanner fileInput = new Scanner(new File("data.txt"));
		List<Double> numbers = new LinkedList<Double>();

		while (fileInput.hasNextDouble()) {
			numbers.add(fileInput.nextDouble());
		}

		double average = computeAverage(numbers);
		double standDev = computeStandardDev(numbers, average);
		
		System.out.println("Stats for list");
		System.out.println("The number of values is " + numbers.size());
		System.out.println("The average is " + df.format(average));
		System.out.println("The standard deviation is " + df.format(standDev));

		removeOutliers(numbers, average, standDev);

		System.out.println("\n\nRemoving outliers, the adjusted list has " + numbers.size() + " values.");
		System.out.println("Without outliers, the average is " + df.format(computeAverage(numbers)));

	}
	
	/**
	 * computes the average of a list of double numbers
	 * @param list- the list of double numbers
	 * @return the average of the list
	 */
	public static double computeAverage(List<Double> list){
		Iterator<Double> itr = list.iterator();
		double sum = 0;
		int size = list.size();
		
		if(itr.hasNext()) {
			for(int i = 0; i < size; i++) {
				sum += itr.next();
			}
			
			return sum/size;
		}
		
		return sum;
	}
	
	/**
	 * computes the standard deviation of a list of double numbers
	 * @param list-the list of double numbers
	 * @param average- the average of that list
	 * @return the standard deviation of that list
	 */
	public static double computeStandardDev(List<Double> list, double average){
		Iterator<Double> itr = list.iterator();
		int size = list.size();
		
		double var = 0;
		
		for(int i = 0; i < size; i++) {
			
			double listVal = itr.next();;
			double sdToMean = Math.pow(listVal - average, 2);
			
			var += sdToMean;	
		}
		
		double averageOfDiff = var/size;
		
		return Math.sqrt(averageOfDiff);
	}
	
	/**
	 * Removes all numbers more than two standard deviations from the average
	 * from the list.
	 * @param list - the list of double numbers
	 * @param average - the average of that list
	 * @param standDev - the standard deviation of that list
	 */
	public static void removeOutliers(List<Double> list, double average, double standDev){

		Iterator<Double> itr = list.iterator();
		int size = list.size();
		
		for(int i = 0; i < size; i++) {
			double var = itr.next();
			if(var < average - 2*standDev) {
				itr.remove();
			}
		}
		
	}
	
}
