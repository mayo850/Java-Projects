/**
 * @author Izan Khan
 * @assignment CSC212-ProgramCh9
 * @version (April 14, 2019)
 * <p>
 * Description: This class represents a movie.
 * <p>
 * Cite Assistance (who and what):
 */

public class Movie extends VideoItem {

    public Movie(String title, String rating, int length, int numDownloads, double ranking, int numResponses) {
        super(title, rating, length, numDownloads, ranking, numResponses);
    }

    @Override
    public String toString() {
        return getTitle();
    }

    @Override
    public void setRating(String rating) {
        if (rating.equals("G") || rating.equals("PG") || rating.equals("PG-13") || rating.equals("R")) {
            super.setRating(rating);
        }
        throw new IllegalArgumentException("Invalid rating.");
    }

    @Override
    public String getItemDetails() {
        return getTitle()+ "\n" + super.getItemDetails();
    }
}

