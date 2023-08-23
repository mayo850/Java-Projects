import java.util.*;
import java.text.*;

public class csc1 {

	public static void main(String[] args) {

		int[] numbers1 = { 6, 7, 3, 4, 11, 13, 17, 5 };
		arrayMystery2(numbers1, 15);

	}

	public static void arrayMystery1(int[] list) {
		for (int i = 1; i < list.length - 1; i++) {
			if (list[i - 1] < list[i + 1]) {
				list[i] = list[i] + list[i + 1];
			} else {
				list[i] = list[i] + list[i - 1];
			}

		}
		System.out.println(Arrays.toString(list));
		
	}
	
	public static void arrayMystery2(int[] list, int limit) {
		int index = list.length -1 ;
		while (index >= 0 && list[index] < limit) {
			if (list[index] % 3 == 1) {
				list [index]--;
			}
			index--;
		}
		System.out.println(Arrays.toString(list));
		System.out.println(5%3);
	}

}
