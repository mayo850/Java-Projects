/**
 * @author Izan Khan
 * @assignment CSC212-Lab10
 * @version (May 05, 2019)
 * 
 *          A Point object represents a pair of (x, y) coordinates. Sixth
 *          version: multiple constructors and this keyword. Class invariant: x
 *          >= 0 && y >= 0.
 */

public class Point implements Comparable<Point> {
	// data fields
	private int x;
	private int y;

	/**
	 * Constructs a new point at the origin (0,0)
	 */
	public Point() {
		this(0, 0); // calls Point(int, int) constructor
	}

	/**
	 * Constructs a new point with the given (x, y) coordinates
	 * 
	 * @param x - the x coordinate of the point
	 * @param y - the y coordinate of the point
	 */
	public Point(int x, int y) {
		setLocation(x, y);
	}

	/**
	 * @return the distance from this point and (0,0)
	 */
	public double distanceFromOrigin() {
		return Math.sqrt(x * x + y * y);
	}

	/**
	 * @returns true if obj is a Point and stores the same coordinates otherwise, it
	 *          returns false.
	 */
	public boolean equals(Object obj) {
		if (obj instanceof Point) {
			Point other = (Point) obj;
			return x == other.x && y == other.y;
		} else { // not a Point object
			return false;
		}
	}

	/**
	 * @return the x-coordinate of the point
	 */
	public int getX() {
		return x;
	}

	/**
	 * @return the y-coordinate of the point
	 */
	public int getY() {
		return y;
	}

	/**
	 * stores the given (x,y) as this point's coordinates
	 * 
	 * @param x - the x coordinate of the point
	 * @param y - the y coordinate of the point
	 */
	public void setLocation(int x, int y) {
		if (x < 0 || y < 0) {
			throw new IllegalArgumentException();
		}
		this.x = x;
		this.y = y;
	}

	/**
	 * @return a String representation of the point
	 */
	public String toString() {
		return "(" + x + ", " + y + ")";
	}

	/**
	 * shifts the point by dx and dy units
	 * 
	 * @param dx - the amount to shift in the horizontal direction
	 * @param dy - the amount to shift in the vertical direction
	 */
	public void translate(int dx, int dy) {
		setLocation(x + dx, y + dy);
	}

	/**
	 * ADD YOUR COMPARE TO METHOD HERE
	 */
	public int compareTo(Point other) {
		if (this.distanceFromOrigin() < other.distanceFromOrigin()) {
			return -1;
		} else if (this.distanceFromOrigin() > other.distanceFromOrigin()) {
			return 1;
		} else {
			return 0;
		}
	}

}
