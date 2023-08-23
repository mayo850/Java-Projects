import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.swing.text.html.HTMLDocument.Iterator;

public class BackTracking {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

//		travel(1, 2);
//		

//		int[] candidates = {1, 3, 4, 8, 10};
//		sumToTargetLists(candidates, 11);

//		int[] candidates = {2, 3, 5};
//		sumToTargetDuplicates(candidates, 8);

//		int[] candidates = {1, 4, 7, 8};
//		System.out.println(sumToTarget(candidates, 10));

//		createParenthesized(2);

//		String name = "izan";
//		name = name.substring(0, name.length()-1);
//		
//		System.out.println(name);
		Character[] letter = new Character[3];
		
//		writeSquares(5);
		
		letter[0] = 'c';
		letter[1]= 'b';
		letter[2] = 'c';
		
		//System.out.print(11%6);
		int count = 0;
		for(int i = 0; i< letter.length; i++) {
		if (letter[i] == 'c') {
			count = count + 1;
		}
		System.out.println(count);
		}

	}

	public static void travel(int targetX, int targetY) {
		explore(targetX, targetY, 0, 0, "moves:");
	}

	private static void explore(int targetX, int targetY, int currX, int currY, String path) {

		if (currX == targetX && currY == targetY) {
			System.out.println(path);
		} else if (currX <= targetX && currY <= targetY) {

			explore(targetX, targetY, currX, currY + 1, path + " N");
			explore(targetX, targetY, currX + 1, currY, path + " E");
			explore(targetX, targetY, currX + 1, currY + 1, path + " NE");
		}

	}

	static int findSum(ArrayList<Integer> arr) {
		int sum = 0;
		for (int i = 0; i < arr.size(); i++)
			sum += arr.get(i);
		return sum;
	}

	public static void sumToTargetLists(int[] array, int target) {

	}

	public static void writeSquares(int n) {

		if (n < 1) {
			throw new IllegalArgumentException();
		}

		if (n == 1) {
			System.out.print(1 + " ");

		} else {
			if(n%2 != 1) {
				
			}
				
				
			
				}
		}
	

		

	
}

	// private static void


