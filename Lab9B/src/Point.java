/**
 * A Point object represents a pair of (x, y) coordinates.
 * This version includes multiple constructors and the equals
 * method. 
 */

public class Point {
	// data fields
	private int x;
	private int y;

	/**
	 * Constructs a point at the origin (0, 0)
	 */
	public Point() {
		this(0, 0); // calls Point(int, int) constructor
	}

	/**
	 * Constructs a point at the given x, y
	 * @param x- the x coordinate for the point
	 * @param y- the y coordinate for the point
	 */
	public Point(int x, int y) {
		setPosition(x, y);
	}

	/**
	 * Provides the distance between this point and (0,0)
	 * @return the distance between this point and (0,0).
	 */
	public double distanceFromOrigin() {
		return Math.sqrt(x * x + y * y);
	}

	/**
	 * Determines if the states of the objects are equal
	 * @return true if the x and y coordinates are equal
	 */
	@Override
	public boolean equals(Object object1) {
		if (object1 instanceof Point) {
			Point other = (Point) object1;
			return x == other.x && y == other.y;
		} else { // not a Point object
			return false;
		}
	}

	/**
	 * Provides the x coordinate of this point
	 * @return- the x coordinate of this point
	 */
	public int getX() {
		return x;
	}

	/**
	 * Provides the y coordinate of this point
	 * @return- the y coordinate of this point
	 */
	public int getY() {
		return y;
	}

	/**
	 * sets this point's (x, y) position to the given values
	 * @param x - the x coordinate to be stored for this point
	 * @param y- the y coordinate to be stored for this point
	 */
	public void setPosition(int x, int y) {
		this.x = x;
		this.y = y;
	}

	/**
	 * Provides a string represenation of this point
	 * @return a string representation of this point
	 */
	public String toString() {
		return "(" + x + ", " + y + ")";
	}

	/**
	 * shifts this point's location by the given amount
	 * @param dx - the amount the x coordinate will be shifted
	 * @param dy - the amount the y coordinate will be shifted
	 */
	public void translate(int dx, int dy) {
		setPosition(x + dx, y + dy);
	}
}
