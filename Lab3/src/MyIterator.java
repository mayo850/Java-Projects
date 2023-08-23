import java.io.File;
import java.text.DecimalFormat;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Scanner;



 class MyIterator<E> implements Iterator<E>{

	 
	 public static void main(String[] args) throws NoSuchElementException {
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
		public static double computeAverage(List<Double> list) throws NoSuchElementException{
			try {
				Iterator<Double> itr = list.iterator();
			double sum = 0;
			int size = list.size();
			
			if(itr.hasNext()) {
				int i = 0;
				while( i < size){
					sum += itr.next();
					i++;
				}
				
				return sum/size;
			}
			
			return sum;
				
			} catch (Exception NoSuchElementException) {
				System.out.println("No Such Element Found exception is occured !!! ");
			}
			
		}
		
		/**
		 * computes the standard deviation of a list of double numbers
		 * @param list-the list of double numbers
		 * @param average- the average of that list
		 * @return the standard deviation of that list
		 */
		public static double computeStandardDev throws ConcurrentModificationException(List<Double> list, double average){
			try {
				Iterator<Double> itr = list.iterator();
			int size = list.size();
			
			double var = 0;
			int i = 0;
			
			while( i < size){
				
				double listVal = itr.next();;
				double sdToMean = Math.pow(listVal - average, 2);
				
				var += sdToMean;
				i++; 	
			}
			
			double averageOfDiff = var/size;
			
			return Math.sqrt(averageOfDiff);
				
			} catch (Exception ConcurrentModificationException) {
				System.out.println("\nConcurrent Modification Exception is occured !!! ");
			}
			
		}
		
		/**
		 * Removes all numbers more than two standard deviations from the average
		 * from the list.
		 * @param list - the list of double numbers
		 * @param average - the average of that list
		 * @param standDev - the standard deviation of that list
		 */
		public static void removeOutliers throws IllegalStateException(List<Double> list, double average, double standDev){
			try {
				Iterator<Double> itr = list.iterator();
			int size = list.size();
			
			int i = 0;
			while( i < size){
				double var = itr.next();
				if(var < average - 2*standDev) {
					itr.remove();
				}
				i++;
			}
				
			} catch (Exception IllegalStateException) {
				System.out.println("Illegal State Exception is occured !!! ");
				
			}

			
			
		}

}
