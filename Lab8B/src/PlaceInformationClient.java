/**
 * This program constructs several PlaceInformation objects and prints
 * information about them and the distances between them and two other
 * locations, specifically London and Augustana College. It is intended to test
 * whether the PlaceInformation class is implemented correctly.
 */
public class PlaceInformationClient {
	public static void main(String[] args) {
		PlaceInformation[] data = {
				new PlaceInformation("Navy Pier", "East Grand Ave Chicago", "tourist", 41.891662, -87.608907),
				new PlaceInformation("Harris Pizza", "3903 14th Ave Rock Island", "restaurant", 41.497497, -90.546197),
				new PlaceInformation("SouthPark Mall", "4500 16th St Moline", "shopping", 41.468181, -90.502229) };

		GeoLocation london = new GeoLocation(51.5112139, -0.1198244);
		GeoLocation augie = new GeoLocation(41.5094771, -90.5787476);

		for (PlaceInformation info : data) {
			System.out.println("name    : " + info.getName());
			System.out.println("address : " + info.getAddress());
			System.out.println("tags    : " + info.getTag());
			System.out.println("toString: " + info);
			System.out.println("London  : " + info.distanceFrom(london));
			System.out.println("Augustana College : " + info.distanceFrom(augie));
			System.out.println();
		}
	}
}