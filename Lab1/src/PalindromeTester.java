/**
 Name(s): Izan & Joshua
 * Date: September 9, 2020
 * CSC 371
 * Lab 1--PalindromeTester
 * 
 * PalindromeTester allows the user to enter a word or phrase from the
 * console window and tests whether the input is a palindrome. A palidrome has
 * the same letters forwards and backwards ignoring case and punctuation marks.
 */

import java.util.*;

public class PalindromeTester {

	public static void main(String[] args) {
		//ArrayQueue<Character> myQueue = new ArrayQueue<Character>();
		ArrayStack<Character> myStack = new ArrayStack<Character>();
		
		System.out.println("Palindrome Tester\n");
		Scanner console = new Scanner(System.in);
		
		do {
			System.out.print("Enter a word or sentence: ");
			String phraseToTest = console.nextLine();	
			String phraseToCompare = "";
			
			for (int i = 0; i < phraseToTest.length(); i++) {
				phraseToTest = phraseToTest.toLowerCase();
				

				String[] stringArray= phraseToTest.split("\\W+");
				String result = new String();
			      for(int j = 0; j < stringArray.length;j++){
			         result = result+ stringArray[j];
			      }
			      phraseToTest=result;
			      
				if(phraseToTest.charAt(i) >= 'a' &&  phraseToTest.charAt(i) <= 'z') {
					
					myStack.push(phraseToTest.charAt(i));
					
				}
				
				
			}
			
			while(!myStack.isEmpty()) {
				phraseToCompare += myStack.pop();
			}
		
			
			if(phraseToTest.equals(phraseToCompare)) {
				System.out.println("You entered a palindrome.");
			} else {
				System.out.println("Nope, that's not a palindrome.");
			}
			
			
			
			
			
		}while (yesTo("\nDo you want to enter another word or sentence?", console));
		
		System.out.println("Thanks for using Palindrome Tester!");
		console.close();

	}
	
	/**
	 * asks the user a question, forcing an answer of "y" or "n";
	 * @param prompt String for the question prompt
	 * @param console Scanner to facilitate input
	 * @return  true if the answer was y, returns false otherwise
	 */
    public static boolean yesTo(String prompt, Scanner console) {
        System.out.print(prompt + " (y/n)? ");
        String response = console.nextLine().trim().toLowerCase();
        while (!response.equals("y") && !response.equals("n")) {
            System.out.println("Please answer y or n.");
            System.out.print(prompt + " (y/n)? ");
            response = console.nextLine().trim().toLowerCase();
        }
        return response.equals("y");
    }
    

}
