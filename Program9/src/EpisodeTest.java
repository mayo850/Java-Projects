/**
 * Code to test the Episode class
 *
 */
public class EpisodeTest {
	public static void main(String[] args) {
		int[] episodes = { 5, 3, 6 };
		TVSeries series1 = new TVSeries("Rome", episodes);
		Episode episode1 = new Episode(series1, "TV-G", 60, 1, 1,
				"The Stolen Eagle", 23, 8, 44);
		try{
			episode1.setRating("TV-12");
		} catch (IllegalArgumentException error){
			System.out.println(error + " Correctly threw an exception.");
		}
		System.out.println(episode1);
		System.out.println();
		System.out.println(episode1.getFullTitle());
		System.out.println();
		System.out.println(episode1.getItemDetails());
		episode1.download();
		System.out.println("\nShould have popped up a window saying 4 episodes left.");
		System.out.println("After a download:");
		System.out.println(episode1.getItemDetails());

		Episode episode5 = new Episode(series1, "TV-G", 60, 1, 5,
				"The Lost City", 15, 6.1, 31);
		episode5.download();
		System.out.println("\nShould have popped up a window saying no episodes left.");
		System.out.println("After a download:");
		System.out.println(episode5.getItemDetails());
	}
}
