
/**
 * @author Izan Khan
 * @assignment CSC212-Routine13
 * @version 10 May, 2019
 * 
 * Add your statements where indicated to sort and search an array
 * or array list as indicated.
 */

import java.util.*;
import java.io.*;

public class OrderingHealthProfiles {

	public static void main(String[] args) throws FileNotFoundException {
		// Create ArrayList and Array
		OrderByBasicInfo object = new OrderByBasicInfo();
		ArrayList<HealthProfile> listPatients = getData();
		HealthProfile[] arrayPatients = createArray(listPatients);
		int foundIndex = 0;
		// Output array in file order
		System.out.println("Original array elements:");
		outputArray(arrayPatients);

		// ADD STATEMENTS to sort array by ID number and search for myProfile
		HealthProfile myProfile = new HealthProfile("763728912", "Aguilera", "Christina", new SimpleDate(12, 18, 1980),
				62, 105);

		Arrays.sort(arrayPatients);
		foundIndex = Arrays.binarySearch(arrayPatients, myProfile);

		// output array sorted by id number and result of binary search
		System.out.println("\nArray sorted by id number:");
		outputArray(arrayPatients);

		System.out.println("\nThe element with id " + myProfile.getIdNum() + " has index " + foundIndex);

		// ADD ONE STATEMENT to sort the array by height, but if equal, by weight

		Arrays.sort(arrayPatients, new OrderByBasicInfo());

		// output array sorted by height/weight
		System.out.println("\nArray sorted by height/weight:");
		outputArray(arrayPatients);
		Collections.sort(listPatients);

		// ADD STATEMENTS to sort the ArrayList by ID number and search for myProfile
		myProfile = new HealthProfile("373685746", "Heavy", "Harold", new SimpleDate(10, 6, 1934), 68, 221);
		Collections.sort(listPatients);
		foundIndex = Arrays.binarySearch(arrayPatients, myProfile);

		// output ArrayList sorted by ID number and result of binary search
		System.out.println("\nArrayList sorted by id number:");
		outputList(listPatients);
		System.out.println("\nThe element with id " + myProfile.getIdNum() + " has index " + foundIndex);

		// ADD ONE STATEMENT to sort the ArrayList by body mass index
		Collections.sort(listPatients, new OrderByBMI());

		// output ArrayList sorted by bmi
		System.out.println("\nArrayList sorted by bmi:");
		outputList(listPatients);
	}

	/**
	 * getData method reads a file of patient health profiles storing each
	 * individual's profile as an element in an array list returning the array.
	 * 
	 * @return the array list of health profiles created from the file
	 * @throws FileNotFoundException when the file patientProfiles.txt can not be
	 *                               found
	 */
	public static ArrayList<HealthProfile> getData() throws FileNotFoundException {
		Scanner input = new Scanner(new File("patientProfiles.txt"));

		ArrayList<HealthProfile> listPatients = new ArrayList<HealthProfile>();

		while (input.hasNext()) {
			String idNumber = input.next();
			String lastName = input.next();
			String firstName = input.next();
			int month = input.nextInt();
			int day = input.nextInt();
			int year = input.nextInt();
			SimpleDate birthDate = new SimpleDate(month, day, year);
			int height = input.nextInt();
			int weight = input.nextInt();

			HealthProfile patient = new HealthProfile(idNumber, lastName, firstName, birthDate, height, weight);
			listPatients.add(patient);
		}

		return listPatients;
	}

	/**
	 * creates an array with the same elements as an array list
	 * 
	 * @param listPatients the array list of patients to be copied
	 * @return an array with a copy of the array list's elements
	 */
	public static HealthProfile[] createArray(ArrayList<HealthProfile> listPatients) {
		HealthProfile[] arrayPatients = new HealthProfile[listPatients.size()];

		for (int i = 0; i < listPatients.size(); i++) {
			arrayPatients[i] = listPatients.get(i);
		}

		return arrayPatients;
	}

	/**
	 * Output the elements of an array list, one per line
	 * 
	 * @param list- the array list to be displayed
	 */
	private static void outputArray(HealthProfile[] list) {
		for (int i = 0; i < list.length; i++) {
			System.out.println(list[i]);
		}
	}

	/**
	 * Output the elements of an array, one per line
	 * 
	 * @param list- the array to be displayed
	 */
	private static void outputList(ArrayList<HealthProfile> list) {
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i) + "  bmi: " + list.get(i).getBmi());
		}
	}

}
