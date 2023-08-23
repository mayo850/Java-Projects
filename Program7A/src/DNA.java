/**
 * @author Izan Khan
 * @assignment CSC212-Program7A
 * @version (10 March, 2019)
 * 
 * Description:
 * 
 * 
 * 
 * Cite Assistance (who and what):
 */
import java.io.*; // for File
import java.util.*; // for Scanner, Arrays

public class DNA {
	double[] MASSES = {135.128, 111.103, 151.128, 125.107};
	final static double MASS_DASH = 100.000;
	final static int NUCLEOTIDES = 4;
	final static int MIN_CODONS = 5;
	final static int NUCLEOTIDES_PER_CODONS = 3;
	final static int PERCENTAGE_MASS = 30;
	
	

	public static void main(String[] args) throws FileNotFoundException {
		intro();
		Scanner console = new Scanner(System.in);

		// prompt for file name
		System.out.print("Input file name? ");
		Scanner input = new Scanner(new File(console.nextLine()));

		// process each possible protein from the file
		while (input.hasNextLine()) {
			String name = input.nextLine();
			String sequence = input.nextLine().toUpperCase();

			// count number of "junk sections" in the DNA
			String sequenceWithoutJunk = sequence.replace("-", "");
			int junkCount = sequence.length() - sequenceWithoutJunk.length();

		}

		console.close();
		input.close();
	}

	/**
	 * Method intro displays a brief program description for the user
	 */
	public static void intro() {
		System.out.println("This program reports information about DNA");
		System.out.println("nucleotide sequences that may encode proteins.\n");
	}
	
	public static int[] getCounts (String a) {
		int[] count = new int[4];
		for(int i = 0; i < a.length(); ++i) {
		      char c = a.charAt(i);
		           if(c == 'A') { ++count[0]; }
		      else if(c == 'C') { ++count[1]; }
		      else if(c == 'G') { ++count[2]; }
		      else if(c == 'T') { ++count[3]; }
		    }
		return count;
	}
	
	

}