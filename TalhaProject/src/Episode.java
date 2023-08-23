/**
 * @author 

name = Talha Hassan
Date = 4/2/2020
 * @assignment CSC 202-Program Project 2
 * @version (put date here)
 * 
 * Description: This class represents a one episode of a TV series with 
 * the series, the episode number, and the season number of this episode.
 * 
 * Cite Assistance (who and what):
 *Assistance taken: Rana helped me strategize the setRating method by explaining how to use the .equals method and helped in drafting the toString methods.
 * 
 */
import javax.swing.JOptionPane;

public class Episode extends VideoItem{
	private TVSeries series;
	private int episodeNumber;
	private int seasonNumber;
	/**
	 * Constructs a TVSeries object, assigns some of the parameter values to the private data fields.
	 * @param series: the tv series that the episode belongs to.
	 * @param rating: the rating (R, TV-13, etc) of this episode.
	 * @param lengthMin: the length of this episode in minutes.
	 * @param seasonNumber: the season number in which the episode belongs.
	 * @param episodeNumber: the episode number in a particular season.
	 * @param title: the title of this episode.
	 * @param numDownloads: the number of times this video item has been downloaded.
	 * @param ranking: the rank of the episode 0-10 by responders.
	 * @param numResponses: the number of people who have ranked this episode.
	 * 
	 */
	
	public Episode(TVSeries series, String rating, int lengthMin, int seasonNumber, int episodeNumber, String title, int numDownloads, double ranking, int numResponses) throws IllegalArgumentException{
		super(title, rating, lengthMin, numDownloads, ranking, numResponses);
		if (seasonNumber <= 0 || seasonNumber > series.getNumSeasons()) {
			throw new IllegalArgumentException("Invalid season number.");
		}
		if (episodeNumber <= 0 ||seasonNumber > series.getNumEpisodesInSeason(seasonNumber)) {
			throw new IllegalArgumentException("Invalid episode number.");
		}
		this.series = series;
		this.episodeNumber = episodeNumber;
		this.seasonNumber = seasonNumber;
		
	}
	/**
	 * provides the episode number
	 * @return: the episode number which would be an int
	 */
	
	public int getEpisodeNum() {
		return episodeNumber;
		
	}
	/**
	 * second accessor method provides the tv series.
	 * @return: the tv series
	 */
	
	public TVSeries getSeries() {
		return series;
		
	}
	/**
	 * third accessor method, provides the season number
	 * @return: an int, season number
	 */
	
	public int getSeason() {
		return seasonNumber;		
	}
	/**
	 * this method provides the 
	 * @return: the episodes left in the season after the particular episode.
	 */
	public int episodesLeftThisSeason() {
		int episodesLeft = series.getNumEpisodesInSeason(seasonNumber) - episodeNumber;
		return episodesLeft;
    }
	/**
	 * This method Provides a String representation of the TVSeries item.
	 * @return: a string containing the title, season number and episode number.
	 */
	
	public String toString() {
		return ('"' + series.getTitle() + '"' + " Season " + seasonNumber + ", " + "Episode: " + episodeNumber);
	}
	/**
	 * This method sets the rating of the episode
	 * @param rating: the rating (R, TV-13, etc) of this episode
	 * 
	 */
	@Override	
	public void setRating(String rating) throws IllegalArgumentException{
		if (!rating.equals("TV-MA") && !rating.equals("TV-14") && !rating.equals("TV-PG") && !rating.equals("TV-G")) {
			throw new IllegalArgumentException("Invalid rating.");
		}
		else {
			super.setRating(rating);
		}
	}
	/**
	 * This method provides the full title of the episode
	 * @return: it returns a string which includes the titl;e of the episode.
	 */
	@Override
	public String getFullTitle() {
		return toString() + ", " + this.getTitle();
	}
	/**
	 * This method provides the details of the particular  episode.
	 * @return: it returns a string which includes the title, the season number and episode number. 
	 */
	@Override
	public String getItemDetails(){
		String result = '"' + series.getTitle() + '"' + "\n" + "Season " + seasonNumber + ", Episode " + episodeNumber + "\n" + '"' + getTitle() + '"' + "\n" + super.getItemDetails();
		return result;
	}
	/**
	 * This method increments the number of downloads and then displays a message about the number of episodes left. 
	 * return: this method does not return anything thus it is a void. 
	 */
	@Override
	public void download() {
		super.download();
		if(episodesLeftThisSeason() > 0) {
			JOptionPane.showMessageDialog(null, +episodesLeftThisSeason() + " episodes left in this season. ");
			
		}
		else {
			JOptionPane.showMessageDialog(null, "No episodes left in this season. ");
		}
	}
	
	
	
	
	}
