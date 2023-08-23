import java.util.ArrayList;
import java.util.List;

public class recursion {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		int[] candidates = {2, 3, 5};
//		sumToTargetDuplicates(candidates, 8);
		
//		int[] candidates = {1, 3, 4, 8, 10};
//		System.out.println(sumToTarget(candidates, 11));
//		
//		int[] candidates = {1, 4, 7, 8};
//		System.out.println(sumToTarget(candidates, 10));
		
		createParenthesized(3);
	}

	public static void sumToTargetDuplicates(int[]array, int target) {
		sumToTargetDuplicates(array, target, 0, 0, new ArrayList<Integer>());
	}
	
	
	private static void sumToTargetDuplicates(int[]array, int target, int sum, int index, List<Integer> myList) {
		if(sum == target) {
			System.out.println(myList);
		} else if(sum < target) {
			for(int i = index; i<array.length; i++) {
			myList.add(array[i]);
			sum += array[i];
			
			sumToTargetDuplicates(array, target, sum,  i, myList);
			
			sum -= array[i];
			myList.remove(myList.size()-1);
			}
		}
	}
	
	
	public static boolean sumToTarget(int[]array, int target) {
		return sumToTarget(array, target, 0, 0, new ArrayList<Integer>());
	}
	
	private static boolean sumToTarget(int[]array, int target, int sum, int index, List<Integer> myList) {

		if(sum == target) {
			return true;
		} else if( sum < target) {
			boolean value = false;
			for(int i = index; i<array.length; i++) {
				myList.add(array[i]);
				sum += array[i];
				
				if(sumToTarget(array, target, sum, i+1, myList)) {
					sumToTarget(array, target, sum, i+1, myList);
					value = true;
				}
				
				sum -= array[i];
				myList.remove(myList.size()-1);
			}
			return value;
		}
		return false;
	}

	public static void createParenthesized(int num) {
	createParenthesized(num, num, new ArrayList<Character>());
}
	private static void createParenthesized(int left, int right, List<Character> myList) {
		
		if(left == 0 && right == 0) {
		for(int i = 0; i < myList.size(); i++) {
				System.out.print(myList.get(i) );
			}
		System.out.println();
			
		} else {
			if(left>0) {
				myList.add('(');
				createParenthesized(left-1, right, myList);
				myList.remove(myList.size()-1);
			}
			
			if(right > left) {
				myList.add(')');
				createParenthesized(left, right-1, myList);
				myList.remove(myList.size()-1);	
			}
		}
		
	}

}
