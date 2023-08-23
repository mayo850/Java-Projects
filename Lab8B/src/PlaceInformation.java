/**
 * @author Izan Khan
 * @assignment CSC212-Lab 8B
 * @version (March 25, 2019)
 *
 *          PlaceInformation class stores information about a place of interest.
 *          It keeps track of its name, street address, search tag(s), and
 *          location.
 */

public class PlaceInformation {
	// fields
	private String name;
	private String address;
	private String tag;
	private GeoLocation coordinates;

	/**
	 * Constructs a PlaceInformation object with the given name, address, tag,
	 * latitude and longitude
	 * 
	 * @param name      - the name for this PlaceInformation object
	 * @param address   - the address for this PlaceInformation object
	 * @param tag       - the tag for this PlaceInformation object
	 * @param latitude  - the latitude for this PlaceInformation object
	 * @param longitude - the longitude for this PlaceInformation object
	 */

	public PlaceInformation(String name, String address, String tag, double latitude, double longitude) {
		this.name = name;
		this.address = address;
		this.tag = tag;
		coordinates = new GeoLocation(latitude, longitude);
	}

	/**
	 * Returns the name of this PlaceInformation object
	 * 
	 * @return the name of this PlaceInformation object
	 */
	public String getName() {
		return name;
	}

	/**
	 * Returns the address of this PlaceInformation object
	 * 
	 * @return the address of this PlaceInformation object
	 */
	public String getAddress() {
		return address;
	}

	/**
	 * Returns the tag of this PlaceInformation object
	 * 
	 * @return the tag of this PlaceInformation object
	 */
	public String getTag() {
		return tag;
	}

	/**
	 * Returns a string representation of this PlaceInformation object
	 * 
	 * @return a string representation of this PlaceInformation object
	 */
	public String toString() {

		return name + " (" + coordinates + ")";
	}

	/**
	 * Returns the GeoLocation of this PlaceInformation object
	 * 
	 * @return the GeoLocation of this PlaceInformation object
	 */
	public GeoLocation getLocation() {
		return coordinates;
	}

	/**
	 * computes the distance from this PlaceInformation object to a second location.
	 * 
	 * @prarm secondLocation the GeoLocation object of the second location
	 * @return the distance from this PlaceInformation object and the second
	 *         location provided
	 * 
	 */
	public double distanceFrom(GeoLocation secondLocation) {
		return coordinates.distanceFrom(secondLocation);
	}
}
