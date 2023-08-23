
/**
 * Name: Izan 	
 * Date: 11/4/2020
 * CSC 371
 * Lab 7--InsertionOptimizedSort
 * 
 * This sort improves on the insertion sort by shifting the elements
 * instead of using exchanges.
 */
import java.util.Arrays;

public class InsertionOptimizedSort {

	public static void sort(Comparable[] a) {
		int N = a.length;
		for(int i =1; i < N; i++) {
			Comparable temp = a[i];
			int j = i;
			
			while((j>0) && less(temp, a[j-1])) {
				a[j] = a[j-1];
				
				j--;
			}
			
			a[j] = temp;
		}
	}

	public static boolean less(Comparable v, Comparable w) {
		return v.compareTo(w) < 0;
	}

	public static boolean isSorted(Comparable[] a) {
		for (int i = 1; i < a.length; i++) {
			if (less(a[i], a[i - 1])) {
				return false;
			}
		}
		return true;
	}

	public static void main(String[] args) {
		String[] a = new String[] { "emu", "dog", "ant", "cow", "fox", "bug" };
		sort(a);
		System.out.println(Arrays.toString(a));
		if (isSorted(a)) {
			System.out.println("Sorted!");
		} else {
			System.out.println("There's a problem. Not sorted!");
		}

		Integer[] nums = new Integer[] { 1, 2, 3, 4, 5 };
		sort(nums);
		System.out.println("\n" + Arrays.toString(nums));
		if (isSorted(nums)) {
			System.out.println("Sorted!");
		} else {
			System.out.println("There's a problem. Not sorted!");
		}

		nums = new Integer[] { 5, 4, 3, 2, 1 };
		sort(nums);
		System.out.println("\n" + Arrays.toString(nums));
		if (isSorted(nums)) {
			System.out.println("Sorted!");
		} else {
			System.out.println("There's a problem. Not sorted!");
		}

		nums = new Integer[] { 2, 1, 5, 3, 4 };
		sort(nums);
		System.out.println("\n" + Arrays.toString(nums));
		if (isSorted(nums)) {
			System.out.println("Sorted!");
		} else {
			System.out.println("There's a problem. Not sorted!");
		}

		nums = new Integer[] { 100, -5, 14, 23, 2, 17, 12, 1000, 14, 2 };
		sort(nums);
		System.out.println("\n" + Arrays.toString(nums));
		if (isSorted(nums)) {
			System.out.println("Sorted!");
		} else {
			System.out.println("There's a problem. Not sorted!");
		}

		nums = new Integer[] { 100, -5, 14, 23, 2, 17, 12, 1000, 14, 2, 3, 4, 9, 8, 7, 6, 22 };
		sort(nums);
		System.out.println("\n" + Arrays.toString(nums));
		if (isSorted(nums)) {
			System.out.println("Sorted!");
		} else {
			System.out.println("There's a problem. Not sorted!");
		}
	}

}
