// Merge sort demo program

import java.util.*;

import javax.swing.JOptionPane;

public class MergeSort {
	public static void main(String[] args) {
		int listSize = Integer.parseInt(JOptionPane.showInputDialog(null,
				"Enter size of list to be sorted:"));

		int[] list = new int[listSize];

		generateNumbers(list);

		System.out.println("First 10 list values prior to sorting:");
		for (int i = 0; i < 10; i++) {
			System.out.println("[" + i + "] " + list[i]);
		}
		
		long startTime = System.currentTimeMillis();
		mergeSort(list);
		long endTime = System.currentTimeMillis();
		double elapsedTimeInSecs = (endTime - startTime) / 1000.0;
		
		JOptionPane.showMessageDialog(null, "Sorting the list of " + list.length + " values took " + elapsedTimeInSecs + " secs");

		System.out.println("\nFirst 10 list values after sorting:");
		for (int i = 0; i < 10; i++) {
			System.out.println("[" + i + "] " + list[i]);
		}
	}

	public static void generateNumbers(int[] array) {
		Random r = new Random();
		for (int i = 0; i < array.length; i++) {
			// Using random integers ranging from 0 to array.length-1
			array[i] = r.nextInt(array.length);
		}
	}

	// Places the elements of the given array into sorted order
	// using the merge sort algorithm.
	// post: array is in sorted (nondecreasing) order
	public static void mergeSort(int[] array) {
		if (array.length > 1) {
			// split array into two halves
			int[] left = leftHalf(array);
			int[] right = rightHalf(array);

			// recursively sort the two halves
			mergeSort(left);
			mergeSort(right);

			// merge the sorted halves into a sorted whole
			merge(array, left, right);
		}
	}

	// Returns the first half of the given array.
	public static int[] leftHalf(int[] array) {
		int size1 = array.length / 2;
		int[] left = new int[size1];
		for (int i = 0; i < size1; i++) {
			left[i] = array[i];
		}
		return left;
	}

	// Returns the second half of the given array.
	public static int[] rightHalf(int[] array) {
		int size1 = array.length / 2;
		int size2 = array.length - size1;
		int[] right = new int[size2];
		for (int i = 0; i < size2; i++) {
			right[i] = array[i + size1];
		}
		return right;
	}

	// Merges the given left and right arrays into the given
	// result array. Second, working version.
	// pre : result is empty; left/right are sorted
	// post: result contains result of merging sorted lists;
	public static void merge(int[] result, int[] left, int[] right) {
		int i1 = 0; // index into left array
		int i2 = 0; // index into right array

		for (int i = 0; i < result.length; i++) {
			if (i2 >= right.length
					|| (i1 < left.length && left[i1] <= right[i2])) {
				result[i] = left[i1]; // take from left
				i1++;
			} else {
				result[i] = right[i2]; // take from right
				i2++;
			}
		}
	}
}
