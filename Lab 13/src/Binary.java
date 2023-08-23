// Binary search demo program

import javax.swing.*;
import java.io.*;
import java.util.*;

public class Binary {

	public static int numberOfValuesChecked = 0;
	
	public static void main(String[] args) throws FileNotFoundException {
		Scanner input = new Scanner(
				new File("sorted.txt"));
		int[] list = readData(input);

		int desiredValue = Integer.parseInt(JOptionPane.showInputDialog(null,
				"Enter number to search for:"));

		int pos = binarySearch(list, desiredValue);
		if (pos >= 0) {
			JOptionPane.showMessageDialog(null, desiredValue
					+ " is in position " + pos);
		} else {
			JOptionPane.showMessageDialog(null, desiredValue + " not in list");
		}
		JOptionPane
				.showMessageDialog(null,
						"Number of values checked in search = "
								+ numberOfValuesChecked);
	}

	public static int[] readData(Scanner input) {
		int[] data = new int[1000];
		for (int i = 0; i < data.length; i++) {
			data[i] = input.nextInt();
		}
		return data;
	}

	public static int binarySearch(int[] list, int target) {
		int min = 0;
		int max = list.length - 1;

		while (min <= max) {
			// increment counter here
			numberOfValuesChecked++;
			
			
			int mid = (max + min) / 2;
			if (list[mid] == target) {
				return mid; // found it!
			} else if (list[mid] < target) {
				min = mid + 1; // too small
			} else { // list[mid] > target
				max = mid - 1; // too large
			}
		}

		return -(min + 1); // not found
	}
}
