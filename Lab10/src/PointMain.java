/**
 * This program creates an ArrayList containing 10 Point 
 * objects with randomly generated coordinates between 0 and 9.
 * The list is then sorted and displayed. 
 */
import java.util.*;

public class PointMain {
	public static void main(String[] args) {
		Random rand = new Random();
		
		// Store 10 randomly generated points
		ArrayList<Point> points = new ArrayList<Point>();
		for (int i = 1; i <= 10; i++) {
			int x = rand.nextInt(10);
			int y = rand.nextInt(10);
			points.add(new Point(x, y));
		}
		
		// sort the points using the defined compareTo method in the Point class
		Collections.sort(points);
		
		// display the list of points ordered according to the compareTo method
		System.out.println("List of points:");
		for (Point ptr : points) {
			System.out.println("\t" + ptr + "  " + ptr.distanceFromOrigin());
		}
	}
}