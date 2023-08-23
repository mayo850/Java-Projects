
/**
 * Name: Izan 
 * Date: 09/29/2020
 * CSC 371
 * Lab 3--MatchingGame.java
 * 
 * MatchingGame plays a solitaire type game where adjacent pairs of numbers 
 * with the same 10s digit or the same 1s digit  in a list are removed. 
 * If all numbers are removed from the list, you win!
 */
import java.util.*;

public class MatchingGame {

	public static final int LIST_NUM = 20;
	public static final int RANGE = 90;
	public static final int LOW_NUM = 10;

	public static void main(String[] args) {

		// Create a list of random integers to begin the game
		List<Integer> numbers = new LinkedList<Integer>();
		Random rand = new Random();
		for (int i = 0; i < LIST_NUM; i++) {
			numbers.add(rand.nextInt(RANGE) + LOW_NUM);
		}
	
		System.out.println("Matching Game");
		System.out.println("Initial list: " + numbers);

		
		while(true) {
			// Get a ListIterator to process the list
			ListIterator<Integer> iter = numbers.listIterator();
			int first = 0,second = 0;
			if(iter.hasNext()) {
				second = iter.next();
			}
			int count = 0;
			while(iter.hasNext()) {
				first = iter.next();
				if(first%10==second%10 || first/10==second/10) {
					break;
				}
				second = first;
				count++;
			}
			if(!iter.hasNext() && first==second) {
				break;
			}
 
			if(count!=-1) {
					System.out.println("Removed : "+second+" "+first);
					numbers.remove(count);
					numbers.remove(count);
					System.out.println(numbers);  
			}else {
				break;
			}
		   
		}

		// Output the results
		if (numbers.isEmpty()) {
			System.out.println("\nYou Win!");
		} else {
			System.out.println("\nTry Again. There were " + numbers.size() + " values left.");
		}

	}

}
