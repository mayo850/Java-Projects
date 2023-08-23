
/**
 * @author
 * Name = Talha Hassan
 * Date = 4/2/2020
 * @assignment CSC 202-Program Project 2
 * @version (put date here)
 * 
 * Description: This class represents a TV series with a title
 * and the number of episodes per season
 * 
 * Cite Assistance (who and what):
 *
 */
public class TVSeries {
	private String title;
	private int[] numEpisodesInSeason;
	/**
	 * this method constructs a tvseries object and assigns the parameter values to there corresponding private data fields.
	 * @param title: the title of this video item
	 * @param numEpisodesInSeason: the number of episodes in a particular season.
	 */
	
	public TVSeries(String title, int[] numEpisodesInSeason) {
		this.title = title;
		this.numEpisodesInSeason = numEpisodesInSeason;
		
	}
	/**
	 * this method return the title of the tvSeries item.
	 */
	
	public String getTitle() {
		return title;
		
	}
	/**
	 * this method returns the number of seasons. 
	 */
	
	public int getNumSeasons() {
		return numEpisodesInSeason.length;
		
	}
	/**
	 * 
	 * @param numSeason: the season number containing the episodes.
	 * @return: number of episodes in that particular season.
	 * @throws IllegalArgumentException
	 */
	public int getNumEpisodesInSeason(int numSeason) throws IllegalArgumentException {
		if (numSeason <= 0 || numSeason > numEpisodesInSeason.length) {
			throw new IllegalArgumentException ("Season number invalid. Correctly threw an eception.");
		} else {
			return numEpisodesInSeason[numSeason - 1];
			
		}
		
	}
	/**
	 * Provides a String representation of this TvSeries item including its season number
	 * and number of episodes
	 * @return: returns a string representation of the Tv series item.
	 */
	
	public String toString() {
		int num = numEpisodesInSeason.length;
		String result = ('"'  + title + '"' + " TV Series\n");
		for (int i = 0; i < num ; i++) {
			result = result +("\tSeasons " +(i+1)+" has "+numEpisodesInSeason[i] + " episodes. \n");	
		}
		return result;
	}
	
	
}
