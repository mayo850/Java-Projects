/**
 * @author Izan Khan
 * @assignment CSC212-ProgramCh9
 * @version (April 14, 2019)
 * 
 * Description: Content.java implements a collection of VideoItems for on-line posting.
 * It provides methods to search for a video item given a phrase in its title and to
 * find the top-ranked item.
 * 
 * Citations of Assistance (who and what):
 */

public class Content {

	private String name; // the name of the content
	private VideoItem[] items; // the items

	
	/**Creates a Content object with hardcoded items */
	public Content(String name) {
		this.name = name;

		
		// Temporary Video Items to test the Content Class

		// Movies and TV Series
		items = new VideoItem[16];

		int[] thirteenNumEpisodesPerSeason =  {13};
		TVSeries thirteen = new TVSeries("13 Reasons Why", thirteenNumEpisodesPerSeason);

		items[0] = new Episode(thirteen,
					"TV-14", 48, 1, 1, "Tape 1, Side A", 26, 6, 10);
		items[1] = new Episode(thirteen,
				"TV-14", 55, 1, 2, "Tape 1, Side B", 21, 6, 11);
		items[2] = new Episode(thirteen, "TV-14", 51, 1, 3, "Tape 2, Side A", 19, 6, 9);

		items[3] = new Movie("Amadeus", "PG", 160, 100,8, 45);
		items[4] = new Movie("Emoji Movie", "PG", 86, 42, 1.5, 8);
		items[5] = new Movie("Forrest Gump", "PG-13", 142, 45, 8.7, 30);
		items[6] = new Movie("Invictus", "PG-13", 134, 18, 5.5, 3);
		items[7] = new Movie("Lincoln", "PG-13", 149, 85, 5.5, 3);

		int[] ncisLANumEpisodesPerSeason =  {23,23,24,24,19,25,24,24,24,24,24,24,24,24};
		TVSeries ncisLA = new TVSeries("NCIS-LA", ncisLANumEpisodesPerSeason);

		items[8] = new Episode(ncisLA, "TV-14", 41, 7, 5, "Blame it on Rio", 123, 10, 20);
		items[9] = new Episode(ncisLA, "TV-14", 43, 7, 6, "Unspoken", 111, 5.5, 2);
		items[10] = new Episode(ncisLA, "TV-14", 40, 14, 22, "Beastmaster", 34, 5.5, 2);
		items[11] = new Episode(ncisLA, "TV-14", 41, 14, 23, "Rendezvous", 111, 5.5, 2);

		items[12] = new Movie("Schindler's List", "R", 195, 76, 5.5, 3);

		int[] sherlockNumEpisodesPerSeason =  {3, 4}; // array of 2 integers, 3 and 3
		TVSeries sherlock = new TVSeries("Sherlock", sherlockNumEpisodesPerSeason);

		items[13] = new Episode(sherlock,
					"TV-14", 90, 1, 1, "A Study in Pink", 56, 6, 20);
		items[14] = new Episode(sherlock, "TV-14", 90, 1, 2,
				"The Blind Banker", 35, 5.5, 2);

		items[15] = new Movie("Solomon Kane", "R", 104, 69, 5.5, 3);
	}
	/**
	 *@return a short string description of all video items in the Content object
	 */
	public String toString() {
		String result = "";
		for (int i = 0; i < items.length; i++) {
			result += items[i].toString() + "\n";
		}
		return result;
	}

	/**
	 * Provides array of all of the video items
	 *@return an array of all of the video items
	 */
	
	public VideoItem[] getItems() {
		return items;
	}

	/**
	 * Provides the name of the collection of video items
	 *@return the name of the collection of video items
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * findVideoItem searches for a video item with a title that contains
	 * the identified search phrase
	 * @param searchPhrase - the phrase which is being searched for
	 * @return the first video item with the searchPhrase in its title
	 */
	public VideoItem findVideoItem(String searchPhrase){
		//search in the items array
		for(int i=0; i < items.length; i++){
			//if any item's title contains the search phrase, return the item
			if(items[i] != null && items[i].getTitle().toLowerCase().contains(searchPhrase.toLowerCase()))
				return items[i];
		}
		return null;
	}

	

	/**
	 * topRanked finds the video item with the highest rank
	 * @return the VideoItem with the highest rank or the first encountered
	 * if more than one item has the same highest rank
	 */

	public VideoItem topRanked() {
		int topIndex = -1;
		//for each item
		for(int i=0; i < items.length; i++){
			//if the item's rating is greater than the top index's rating
			if(items[i] != null){
				if(topIndex == -1)
					topIndex = i;
				//if the ranking is item is greater than
				else if(items[i].getRanking() > items[topIndex].getRanking()){
					topIndex = i;
				}
			}
		}
		if(topIndex == -1)
			return null;
		//return the top rated item
		return items[topIndex];
	}

}
