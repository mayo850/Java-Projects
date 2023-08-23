
/**
 * Name:
 * Date:
 * CSC 371
 * Lab 7--BubbleSort
 * 
 * This implementation of the bubble sort iterates exchanging
 * adjacent elements until a pass has no exchanges.
 */
import java.util.Arrays;

public class BubbleSort {

	public static void sort(Comparable[] a) {

		while (!isSorted(a)) {
			for (int i = 1; i < a.length; i++) {
				if (less(a[i], a[i - 1])) {
					exch(a, i, i - 1);
				}
			}
		}
	}

	public static boolean less(Comparable v, Comparable w) {
		return v.compareTo(w) < 0;
	}

	public static void exch(Comparable[] a, int i, int j) {
		Comparable temp = a[i];
		a[i] = a[j];
		a[j] = temp;
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
