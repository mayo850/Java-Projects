import java.util.ArrayList;

public class RemoveDuplicatesExample {

	public static void main(String[] args) {
		ArrayList<String> myList = new ArrayList<String>();
		myList.add("an");
		myList.add("an");
		myList.add("an");
		myList.add("ant");
		myList.add("bee");
		myList.add("bee");
		myList.add("cat");
		myList.add("cat");
		removeDuplicates(myList);
		System.out.println(myList);

	}
	//twod array of strings = String[][]
	public static void removeDuplicates(ArrayList<String> array) {
		for (int i = 0 ; i < (array.size() -1); i++) {
			if (array.get(i).equals(array.get(i+1))) {
				array.remove(i);
				i--;
			}
		}
		
	}

}
