/**
 * Code to test the VideoItem class
 */
public class VideoItemTest {
	public static void main(String[] args) {

		VideoItem item1 = new VideoItem("Forrest Gump", "PG-13", 142, 45, 8, 2);
		VideoItem item2 = new VideoItem("The Shawshank Redemption", "R", 142, 111, 10, 50);
		VideoItem item3 = new VideoItem("Emoji Movie", "PG", 86, 42, 1.5, 8);
		
		System.out.println(item1.getRankingString());
		System.out.println(item2.getRankingString());
		System.out.println(item3.getRankingString());
		
		try{
			item1.setRanking(-0.5, 20);
			System.out.println("This is an error. The rank was invalid");
		} catch (IllegalArgumentException error){
			System.out.println(error + " Correctly threw an exception.");
		}
		
		try{
			item1.setRanking(10.5, 20);
			System.out.println("This is an error. The rank was invalid");
		} catch (IllegalArgumentException error){
			System.out.println(error + " Correctly threw an exception.");
		}
		
		try{
			item1.setRanking(7.4, -2);
			System.out.println("This is an error. The number of reponses was invalid");
		} catch (IllegalArgumentException error){
			System.out.println(error + " Correctly threw an exception.");
		}
		
		try{
			item1.processAnotherRanking(11);
			System.out.println("This is an error. The rank was invalid");
		} catch (IllegalArgumentException error){
			System.out.println(error + " Correctly threw an exception.");
		}
		
		try{
			item1.processAnotherRanking(-1);
			System.out.println("This is an error. The rank was invalid");
		} catch (IllegalArgumentException error){
			System.out.println(error + " Correctly threw an exception.");
		}
		
		System.out.println(item1.getRanking());
		item1.processAnotherRanking(10);
		System.out.println(item1.getRanking());
		item1.processAnotherRanking(10);
		System.out.println(item1.getRanking());
		System.out.println(item1.getRankingString());	
	}
}
