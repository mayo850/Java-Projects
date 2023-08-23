/**
 * Code to test the Movie class
 */
public class MovieTest {
	public static void main(String[] args){
		Movie movie1 = new Movie("Fantastic Mr. Fox", "G", 115, 412, 7, 87);
		System.out.println(movie1.getItemDetails());
		try{
			movie1.setRating("GP-13");
		}catch (IllegalArgumentException error) {
			System.out.println(error + " Correctly threw an exception.");
		}
		
		try{
			movie1.setRating("PG-13");
		}catch (IllegalArgumentException error) {
			System.out.println(error + " Incorrectly threw an exception.");
		}
		
		System.out.println("\n" + movie1.getItemDetails());
		System.out.println("\n" + movie1);
	}
}
