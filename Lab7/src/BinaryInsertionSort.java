
/**
 * Name: Izan and Anas
 * Date:
 * CSC 371
 * Lab 7--BinaryInsertionSort
 * 
 * This sort uses the shifting of the optimized insertion sort
 * along with binary search to find the index for the element
 * that is inserted.
 */
import java.util.Arrays;

public class BinaryInsertionSort {
	public static void sort(Comparable[] a) {

		for (int i = 1; i < a.length; i++) {
			Comparable temp = a[i];
			int min = 0;
			int max = i;
			
			while(min<max) {
				int mid = (max+min)/2;
				
				if(less(temp, a[mid])) {
					max = mid;
				} else {
					min = mid+1;
				}
			}
			
			for(int j =i; j > min; j--) {
				a[j] = a[j-1];
			}
			
			a[min] = temp;
			
	}
	}

	public static boolean less(Comparable v, Comparable w) {
		return v.compareTo(w) < 0;
	}

	public static boolean isSorted(Comparable[] a) {
		for (int i = 1; i < a.length; i++) {
			if (a[i].compareTo(a[i - 1]) < 0) {
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
