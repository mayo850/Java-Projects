
/**
 * Name: Izan and Anas
 * Date:
 * CSC 371
 * Lab 7--EmuSort.java
 * 
 * Can you describe how this sort works?
 */
import java.util.Arrays;

public class EmuSort {

	public static void sort(Comparable[] a) {
		int n = a.length;
		int[] count = new int[n];

		for (int i = 0; i < a.length; i++) {
			count[i] = 0;
		}

		for (int i = 0; i < n - 1; i++) {
			for (int j = i + 1; j < n; j++) {
				if (less(a[i], a[j])) {
					count[j]++;
				} else {
					count[i]++;
				}
			}
		}

		Comparable[] aux = Arrays.copyOf(a, a.length);
		for (int i = 0; i < n; i++) {
			a[count[i]] = aux[i];
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

		Integer[] nums = new Integer[] { 66, 33, 88, 99, 11, 44 };
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
