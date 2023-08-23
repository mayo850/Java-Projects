// Selection sort timing program

import javax.swing.*;
import java.util.*;

public class SelectionSort {

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
		selectionSort(list);
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

	public static void selectionSort(int[] list) {
		for (int i = 0; i < list.length - 1; i++) {
			// find index of smallest element
			int smallest = i;
			for (int j = i + 1; j < list.length; j++) {
				if (list[j] < list[smallest]) {
					smallest = j;
				}
			}

			swap(list, i, smallest); // swap smallest to front
		}
	}

	public static void swap(int[] list, int i, int j) {
		int temp = list[i];
		list[i] = list[j];
		list[j] = temp;
	}
}
