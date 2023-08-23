// Sequential search demo program

import javax.swing.*;
import java.io.*;
import java.util.*;

public class Sequential {

	public static int numberOfValuesChecked = 0;

	public static void main(String[] args) throws FileNotFoundException {
		Scanner input = new Scanner(
				new File("sorted.txt"));
		int[] list = readData(input);

		int desiredValue = Integer.parseInt(JOptionPane.showInputDialog(null,
				"Enter number to search for:"));

		int pos = sequentialSearch(list, desiredValue);
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

	public static int sequentialSearch(int[] list, int target) {
		for (int i = 0; i < list.length; i++) {
			numberOfValuesChecked++;
			if (list[i] == target) {
				return i;
			}
		}
		return -1; // not found
	}
}
