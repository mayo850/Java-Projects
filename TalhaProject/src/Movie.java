/**

 * @author
Name = Talha Hassan
Date = 4/2/2020
 * @assignment CSC 202-Program Project 2
 * @version (put date here)
 * 
 * Description: This class represents a movie.
 * 
 * Cite Assistance (who and what):
 *
 */
import java.util.*;

public class Movie extends VideoItem {
/**
 * Constructs a movie item object.
 * @param title: the title of this video item.
 * @param rating: the rating (R, PG-13, etc) of this movie item.
 * @param length: the length of this movie item in minutes.
 * @param numDownloads: the number of times this movie item has been downloaded.
 * @param ranking: the rank of the item 0-10 by responders.
 * @param numResponses: the number of people who have ranked this movie item.
 * returns nothing (it is a constructor)
 */
	public Movie(String title, String rating, int length, int numDownloads, double ranking, int numResponses) {
		super(title, rating, length, numDownloads, ranking, numResponses);
	}
	/**
	 * Provides a String representation of this movie item inside inverted commas.
	 * returns the title in inverted commas.
	 */
	public String toString() {
		
	String result = '"' + getTitle() + '"';
	return result;
	}
	/**
	 * @param rating: the rating (R, PG-13, etc) of this movie item.
	 * This method sets the rating for the movie item
	 */

	@Override
	public void setRating(String rating) {
		if (!rating.equals("G") && !rating.equals("PG") && !rating.equals("PG-13") && !rating.equals("R")) {
			throw new IllegalArgumentException("Invalid rating.");
		}
		else {
			super.setRating(rating);
		}
		
		
	}
	/**
	 * returns a string.
	 * This method provides the details of the movie item in form of a string.
	 */
	@Override
	public String getItemDetails() {
		String result = '"' + getTitle() + '"' +"\n" + super.getItemDetails();
		return result;
		
	}
	

}

