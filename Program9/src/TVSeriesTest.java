/**
 * Tests the implementation of the TVSeries class
 */
public class TVSeriesTest {

	public static void main(String[] args) {
		int[] episodes = { 15, 12, 13 };
		TVSeries item1 = new TVSeries("House Of Cards", episodes);
		System.out.println(item1);
		System.out.println("\nThe title is " + item1.getTitle());
		System.out.println("The number of seasons is " + item1.getNumSeasons());

		try{
			System.out.println(item1.getNumEpisodesInSeason(0) + " This should have thrown an exception.");
		} catch(IllegalArgumentException error){
			System.out.println(error + " Correctly threw an exception.");
		}

		try{
			System.out.println(item1.getNumEpisodesInSeason(4) + " This should have thrown an exception.");
		} catch(IllegalArgumentException error){
			System.out.println(error + " Correctly threw an exception.");
		}

		try{
			System.out.println("Season 2 has " + item1.getNumEpisodesInSeason(2) + " episodes.");
		} catch(IllegalArgumentException error){
			System.out.println(error + " This incorrectly threw an exception.");
		}

	}
}
