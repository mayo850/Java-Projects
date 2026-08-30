import java.io.File;
import java.io.FileNotFoundException;
import java.text.DecimalFormat;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Scanner;



	 class MyIterator {

	 
		 public static void main(String[] args) throws FileNotFoundException {
				DecimalFormat df = new DecimalFormat("##.###");

				List<Double> numbers = new LinkedList<>();

				try (Scanner fileInput = new Scanner(new File("data.txt"))) {
					while (fileInput.hasNextDouble()) {
						numbers.add(fileInput.nextDouble());
					}
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
			if (list.isEmpty()) {
				throw new NoSuchElementException("The list must contain at least one value.");
			}
			double sum = 0;
			for (double value : list) {
				sum += value;
			}
			return sum / list.size();
		}
		
		/**
		 * computes the standard deviation of a list of double numbers
		 * @param list-the list of double numbers
		 * @param average- the average of that list
		 * @return the standard deviation of that list
		 */
		public static double computeStandardDev(List<Double> list, double average) throws ConcurrentModificationException{
			if (list.isEmpty()) {
				throw new NoSuchElementException("The list must contain at least one value.");
			}
			double variance = 0;
			for (double value : list) {
				variance += Math.pow(value - average, 2);
			}
			return Math.sqrt(variance / list.size());
		}
		
		/**
		 * Removes all numbers more than two standard deviations from the average
		 * from the list.
		 * @param list - the list of double numbers
		 * @param average - the average of that list
		 * @param standDev - the standard deviation of that list
		 */
		public static void removeOutliers(List<Double> list, double average, double standDev) throws IllegalStateException{
			Iterator<Double> itr = list.iterator();
			while (itr.hasNext()) {
				double value = itr.next();
				if (Math.abs(value - average) > 2 * standDev) {
					itr.remove();
				}
			}
		}

}
