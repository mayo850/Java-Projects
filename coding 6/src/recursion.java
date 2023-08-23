import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class recursion {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

//		System.out.println(multiplyOdds(4));

//		double result = sumEvenReciprocals(3);
//		System.out.println(result);

		// printChars(7);

//		String result = rangeAsString(2, 8);
//		System.out.println(result);

//		System.out.println(isNestedParens("((()))"));
//		
//		System.out.println(isNestedParens("((())"));
//	
//		System.out.println(isNestedParens("((()))"));
//		
//		System.out.println(isNestedParens("(()())"));

//		 System.out.print(hasX("hello"));

//		System.out.println(reverse("cake"));
//		System.out.println(reverse("java programming"));
//		System.out.println(reverse("cat"));
//		System.out.println(reverse("a"));
//		System.out.println(reverse(""));

//		DecimalFormat df = new DecimalFormat("#.##");
//		double answer = pow(3,12);
//		if(answer > 1) {
//		System.out.print(df.format(answer));
//		} else {
//			System.out.printf("%.8f",answer);
//		}
		
		
//		System.out.print(matchDigits(8764568,10764111));
		
//		
//		diceRoller(4);
		
//		System.out.print("team".substring(0,0));
		
		String chosen = "Iz2";
		
		
		System.out.print(chosen.substring(3));
		
//		System.out.println(1/2);
//		
//		System.out.println(indexOf("Barack Obama", "Bar"));	
//		System.out.println(indexOf("Barack Obama", "ck"));	
//		System.out.println(indexOf("Barack Obama", "a"));	
//		System.out.println(indexOf("Barack Obama", "McCain"));	
//		System.out.println(indexOf("Barack Obama", "BAR"));
		
//		System.out.println(dedup("bookkkkkeeper"));
		printChars(5);
//		
	}

	public static int multiplyOdds(int n) {
		if(n <= 0) {
			throw new IllegalArgumentException();
		}
		
		if(n == 1) {
			return 1;
		}
		
		return multiplyOdds(n-1) * (2*n-1);
	}

	

	public static void printChars(int num) {
		if (num <= 0) {
			throw new IllegalArgumentException();
		}

		if (num == 1) {
			System.out.print("*");
		}

		else if (num == 2) {
			System.out.print("**");
		} else {

			System.out.print("{");
			printChars(num - 2);
			System.out.print("}");
		}

	}

	public static String rangeAsString(int first, int last) {
		if (first > last) {
			throw new IllegalArgumentException();
		}

		if (last - first == 2) {
			return (first + " -> " + (first + 1) + " <- " + last);
		}

		if (last - first == 1) {
			return (first + " - " + last);
		}

		if (first == last) {
			return (first + "");
		}

		return (first + " -> " + rangeAsString(first + 1, last - 1) + " <- " + last);

	}

	public static boolean isNestedParens(String par) {

		if (par.length() == 0) {
			return true;
		}

		if ((par.length() % 2) != 0) {
			return false;

		}

		if (par.charAt(0) == '(' && par.charAt(par.length() - 1) == ')') {
			return isNestedParens(par.substring(1, par.length() - 1));
		}

		return false;

	}

	public static boolean hasX(String letters) {
		if(letters.length() == 0) {
			return false;
		}
		if(letters.toLowerCase().charAt(0) == 'x') {
			return true;
		}
		
		else {
			return hasX(letters.substring(1,letters.length()));
		}
	}

	public static String reverse(String input) {
		if (input.isEmpty()) {
			return "";
		}
		if (input.length() == 1) {
			return input;
		}

		return reverse(input.substring(1)) + input.charAt(0);

	}

	public static double pow(int base, double exponent) {
		if (exponent == 0 && base == 0) {
			throw new IllegalArgumentException("Undefined");
		}
		if (exponent > 0 && exponent < 1) {
			return Math.pow(base, exponent);
		}
		if (exponent == 0) {
			return 1;
		}
		if (exponent > 0 && exponent%2 == 0) {

			return pow(base*base, exponent/2);
		}

		if (exponent > 0) {

			return pow(base, exponent - 1) * base;
		}

		double baseNeg = 1.0 / base;

		return pow(base, exponent + 1) * (baseNeg);

	}

	public static int matchDigits(int one, int two) {
		if(one < 0 || two < 0) {
			throw new IllegalArgumentException();
		}
		
		if( one < 10 || two < 10 ) {
			if(one%10 == two%10) {
				return 1;
			}
			else {
				return 0;
			}

		}
		
		if(one%10 == two%10) {
			return matchDigits(one/10 , two/10) + 1;

		}
		
		return 0  + matchDigits(one/10 , two/10);
		
			}
	
	public static void diceRoller(int numDice) {
		List<Integer> soFar = new ArrayList<Integer>();
		
		diceRollerHelper(numDice, soFar);
	}
	private static void diceRollerHelper(int numDice, List<Integer> soFar) {
		if(numDice == 0) {
			System.out.println(soFar);
		}
		else {
		for(int i = 1; i <= 6; i++) {
			soFar.add(i);
			diceRollerHelper(numDice-1, soFar);
			soFar.remove(soFar.size()-1);
			
		}
		}
	}
	
	public static void permute(String input) {
		if(input.isEmpty()) {
			System.out.println(input);
		}
		
		else{
			
			for(int i = 0; i < input.length(); i++) {
				char c = input.charAt(i);
				
			}
			
		}
	}
	
	
	public static boolean isReverse(String first, String second){
	if(first.isEmpty() && second.isEmpty()) {
		return true;
	}
	
		if(first.length() == second.length()) {
			char word1 = Character.toLowerCase(first.charAt(0));
			char word2 = Character.toLowerCase(second.charAt(second.length()-1));
			if(word1 == word2) {
			
				return isReverse(first.substring(1), second.substring(0, second.length()-1));
			
			} else {
				return false;
			}
			
		
	}
		return false;
	
	}
	
	public static int indexOf(String one, String two) {
		if(one.length() == two.length()) {
			if(one.equals(two)) {
				return 0;
			}
		}
			
			else if(one.length() >= two.length()) {
				if(one.substring(0,two.length()).equals(two)) {
					return 0;
				} else {
					int result = 1 + indexOf(one.substring(1), two);
					if(result != 0) {
						return result;
					}
				} 
			}
			
		
	return -1;
	}

	public static String dedup(String word) {
		if(word.length()==1) {
			return word;
		} else if(word.charAt(0) == word.charAt(1)) {
			return dedup(word.substring(1));
		}else {
			return word.charAt(0) + dedup(word.substring(1));
		}
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
