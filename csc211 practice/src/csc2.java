import java.util.Arrays;

public class csc2 {

	public static void main(String[] args) {
		int value =1;
		int [] list = new int[5];
		
		value++;
		list[value + 1] = 4;
		mystery(value,list);
		System.out.println(value + " " + Arrays.toString(list));
		
		
		value--;
		list[value - 1] = 2;
		mystery(value,list);
		System.out.println(value + " " + Arrays.toString(list));
		
		
			

	}

	public static void mystery(int value, int [] myList) {
		myList[value]--;
		value++;
		myList[value + 1] = myList[value-1];
		System.out.println(value + " " + Arrays.toString(myList));
	}
	
}
