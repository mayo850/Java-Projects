/**
 * @author Izan Khan
 * @assignment CSC212-ProgramCh9
 * @version (April 14, 2019)
 * 
 * Description: This class represents a one episode of a TV series with 
 * the series, the episode number, and the season number of this episode.
 * 
 * Cite Assistance (who and what):
 *
 */
import java.util.*;

import javax.swing.JOptionPane;

public class Episode extends VideoItem{
    private TVSeries series;
    private int episodeNumber;
    private int seasonNumber;

    public Episode(TVSeries tvSeries, String rating,
                    int lengthInMins, int seasonNumber,
                   int episodeNumber, String title, int numDownloads, double ranking, int numResponses){
        super(title, rating, lengthInMins, numDownloads, ranking, numResponses);
        this.seasonNumber = seasonNumber;
        this.episodeNumber = episodeNumber;
        this.series = tvSeries;
    }

    public int getEpisodeNum() {
        return episodeNumber;
    }

    public TVSeries getSeries() {
        return series;
    }

    public int getSeason() {
        return seasonNumber;
    }

    public int episodesLeftThisSeason(){
        //get the number of episodes in this season
        int numEpisodesThisSeason = series.getNumEpisodesInSeason(seasonNumber);
        return numEpisodesThisSeason - episodeNumber;
    }

    @Override
    public String toString() {
        return String.format("\"%s\" Season %d, Episode: %d", series.getTitle(), seasonNumber, episodeNumber);
    }

    @Override
    public void setRating(String rating) {
        if(rating.equals("TV-MA") || rating.equals("TV-14") ||
            rating.equals("TV-PG") || rating.equals("TV-G")){
            super.setRating(rating);

        }
        else{
            throw new IllegalArgumentException("Invalid rating");
        }
    }

    @Override
    public String getFullTitle() {
        return toString() + ", \'" + super.getTitle()+"\"";
    }

    @Override
    public String getItemDetails() {
        String result = String.format("\"%s\"\nSeason %d, Episode: %d\n", series.getTitle(), seasonNumber, episodeNumber);
        result += String.format("%s\n", getTitle());
        result += super.getItemDetails();
        return result;
    }

    @Override
    public void download() {
        super.download();
        String numEpisodes = episodesLeftThisSeason() == 0 ? "No" : String.valueOf(episodesLeftThisSeason());
        JOptionPane.showMessageDialog(null, numEpisodes+" episodes left in this season.");
    }
}