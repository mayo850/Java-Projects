import java.util.Arrays;

public class SortingTimer {

	public static void main(String[] args) {

		System.out.printf("%10s   %11s   %11s  %11s  %11s \n", "n", "Selection", "Insertion", "OptInsertion", "BinaryInsertion");
		for (int n = 10000; n <= 100000; n += 10000) {
			Double[] originalArray = getRandomArray(n);
			
			Double[] copy = Arrays.copyOf(originalArray, originalArray.length);
			long startTime = System.currentTimeMillis();
			SelectionSort.sort(copy);
			long endTime = System.currentTimeMillis();
			double sortingTime1 = (endTime - startTime) / 1000.0;
			
			copy = Arrays.copyOf(originalArray, originalArray.length);
			startTime = System.currentTimeMillis();
			InsertionSort.sort(copy);
			endTime = System.currentTimeMillis();
			double sortingTime2 = (endTime - startTime) / 1000.0;
			
			copy = Arrays.copyOf(originalArray, originalArray.length);
			startTime = System.currentTimeMillis();
			InsertionOptimizedSort.sort(copy);
			endTime = System.currentTimeMillis();
			double sortingTime3 = (endTime - startTime) / 1000.0;
			
			copy = Arrays.copyOf(originalArray, originalArray.length);
			startTime = System.currentTimeMillis();
			BinaryInsertionSort.sort(copy);
			endTime = System.currentTimeMillis();
			double sortingTime4 = (endTime - startTime) / 1000.0;
			
//			copy = Arrays.copyOf(originalArray, originalArray.length);
//			startTime = System.currentTimeMillis();
//			BubbleSort.sort(copy);
//			endTime = System.currentTimeMillis();
//			double sortingTime5 = (endTime - startTime) / 1000.0;
			
//			copy = Arrays.copyOf(originalArray, originalArray.length);
//			startTime = System.currentTimeMillis();
//			EmuSort.sort(copy);
//			endTime = System.currentTimeMillis();
//			double sortingTime6 = (endTime - startTime) / 1000.0;
				
			System.out.printf("%10d %13.9f %13.9f %13.9f %16.9f \n", n, sortingTime1, sortingTime2, sortingTime3, sortingTime4);
		}

	}

	public static Double[] getRandomArray(int arrayLength) {
		Double[] result = new Double[arrayLength];
		for (int i = 0; i < result.length; i++) {
			result[i] = Math.random();
		}
		return result;
	}

}
