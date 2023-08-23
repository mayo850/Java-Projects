/**
 * @author Izan Khan
 * @assignment CSC212-Lab 8B
 * @version (March 25, 2019)
 * 
 *          This class stores information about a location on Earth. Locations
 *          are specified using latitude and longitude. The class includes a
 *          method for computing the distance between two locations
 *
 */
public class GeoLocation {
	public static final double RADIUS = 3963.1676; // Earth radius in miles

	private double latitude;
	private double longitude;

	/**
	 * Constructs a GeoLocation object with the given latitude and longitude
	 * 
	 * @param latitude  to be stored for this GeoLocation object
	 * @param longitude to be stored for this GeoLocation object
	 */
	public GeoLocation(double latitude, double longitude) {
		this.latitude = latitude;
		this.longitude = longitude;
	}

	/**
	 * Returns the latitude of this GeoLocation
	 * 
	 * @return the latitude of this GeoLocation
	 */
	public double getLatitude() {
		return latitude;
	}

	/**
	 * Returns the longitude of this GeoLocation
	 * 
	 * @return the longitude of this GeoLocation
	 */
	public double getLongitude() {
		return longitude;
	}

	/**
	 * Returns a string representation of this GeoLocation
	 * 
	 * @return a string representation of this GeoLocation
	 */
	public String toString() {
		return "latitude: " + latitude + ", longitude: " + longitude;
	}

	/**
	 * calculates the distance from this GeoLocation to another GeoLocation
	 * 
	 * @param other the second GeoLocation to calculate the distance to
	 * @return distance from this GeoLocation to other GeoLocation
	 */
	public double distanceFrom(GeoLocation other) {
		double lat1 = Math.toRadians(latitude);
		double long1 = Math.toRadians(longitude);
		double lat2 = Math.toRadians(other.latitude);
		double long2 = Math.toRadians(other.longitude);
		// apply the spherical law of cosines with a triangle composed of the
		// two locations and the north pole
		double theCos = Math.sin(lat1) * Math.sin(lat2) + Math.cos(lat1) * Math.cos(lat2) * Math.cos(long1 - long2);
		double arcLength = Math.acos(theCos);
		return arcLength * RADIUS;
	}
}
