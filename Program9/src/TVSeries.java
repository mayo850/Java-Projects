/**
 * @author Izan Khan
 * @assignment CSC212-ProgramCh9
 * @version (April 14, 2019)
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

    TVSeries(String title, int[] numEpisodesInSeason){
        this.title = title;
        this.numEpisodesInSeason = numEpisodesInSeason.clone();
    }

    public String getTitle() {
        return title;
    }

    public int getNumSeasons(){
        return numEpisodesInSeason.length;
    }

    public int getNumEpisodesInSeason(int seasonNumber) throws IllegalArgumentException{
        //if season number is out of bounds
        if(seasonNumber < 1 || seasonNumber > numEpisodesInSeason.length)
            throw new IllegalArgumentException("Season number invalid.");
        //return the corresponding entry
        return numEpisodesInSeason[seasonNumber-1];
    }

    @Override
    public String toString() {
        String result = String.format("\"%s\" TV Series\n", title);
        for(int i=0; i < numEpisodesInSeason.length; i++){
            result += "\tSeason "+(i+1)+" has " + numEpisodesInSeason[i] + " episodes.\n";
        }
        return result;
    }
}
