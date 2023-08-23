/**
 * @author Izan Khan
 * @assignment CSC212-Lab 8B
 * @version (March 25, 2019)
 * 
 *          This program manipulates three different GeoLocation object,
 *          reporting their latitude and longitude and the distances between
 *          them. The coordinates come from the TV show Breaking Bad.
 */
public class GeoLocationClient {
	public static void main(String[] args) {

		GeoLocation stash = new GeoLocation(34.988889, -106.614444);
		GeoLocation studio = new GeoLocation(34.989978, -106.614357);
		GeoLocation fbi = new GeoLocation(35.131281, -106.61263);

		System.out.println("the stash is at " + stash.toString());
		System.out.println("ABQ studio is at " + studio.toString());
		System.out.println("FBI building is at " + fbi.toString());

		System.out.println("distance in miles between:");
		System.out.println("    stash/studio = " + stash.distanceFrom(studio));
		System.out.println("    stash/fbi = " + stash.distanceFrom(fbi));
	}
}
