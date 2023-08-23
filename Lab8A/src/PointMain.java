/**
 * @author Izan Khan
 * @assignment CSC212-Lab8A
 * @version (March 20, 2019)
 * 
 *          This program is used to test your implementation of the Point class
 *
 */
public class PointMain {

	public static void main(String[] args) {
		// create two Point objects
		Point p1 = new Point(7, 2);
		Point p2 = new Point(4, 3);

		// print each point and its distance from origin
		System.out.println("p1 is " + p1);
		System.out.println("distance from origin = " + p1.distanceFromOrigin());
		System.out.println("p2 is " + p2);
		System.out.println("distance from origin = " + p2.distanceFromOrigin());

		// Add your statement using manhattanDistance here
		System.out.println("Manhattan distance from p1 to p2 is " + p1.manhattanDistance(p2));

		// Add your statement using slope here
		System.out.println("slope of the line between p1 and p2 is " + p1.slope(p2));

		try {
			p1.isVertical(p2);
		} catch (IllegalArgumentException e) {
			System.out.println("Error: " + e);
		}

		// translate each point to a new location
		p1.translate(11, 6);
		p2.translate(1, 7);

		// print the points again
		System.out.println("p1 is " + p1);
		System.out.println("p2 is " + p2);

		// Add your statement using manhattanDistance here
		System.out.println("Manhattan distance from p1 to p2 is " + p1.manhattanDistance(p2));
		// Add your statement using slope here
		System.out.println("slope of the line between p1 and p2 is " + p1.slope(p2));

		try {
			p1.isVertical(p2);
		} catch (IllegalArgumentException e) {
			System.out.println("Error: " + e);
		}
	}
}