
/**
 * @author Izan Khan
 * @assignment CSC212-Lab8A
 * @version (March 20, 2019)
 * 
 *          The point class represents a point in two dimensions.
 */

public class Point {

	private int x;
	private int y;

	/**
	 * Constructs a point in the x-y plane at the specified location
	 * 
	 * @param x - the x-coordinate of the specified location
	 * @param y - the y-coordinate of the specified location
	 */
	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}

	/**
	 * Constructs a point at the default location (0,0)
	 */
	public Point() {
		this(0, 0);
	}

	/**
	 * Returns the x-coordinate of this point
	 * 
	 * @return the x-coordinate of this point
	 */
	public int getX() {
		return x;
	}

	/**
	 * Returns the y-coordinate of this point
	 * 
	 * @return the y-coordinate of this point
	 */
	public int getY() {
		return y;
	}

	/**
	 * Sets the location of this point to the specified int coordinates
	 * 
	 * @param x - x coordinate of the new location
	 * @param y - y coordinate of the new location
	 */
	public void setLocation(int x, int y) {
		this.x = x;
		this.y = y;
	}

	/**
	 * Changes this point's x-coordinate to the specified value
	 * 
	 * @param x- the specified value to become the x-coordinate
	 */
	public void setX(int x) {
		this.x = x;
	}

	/**
	 * Changes this point's y-coordinate to the specified value
	 * 
	 * @param y- the specified value to become the x-coordinate
	 */
	public void setY(int y) {
		this.y = y;
	}

	/**
	 * Translates this point, at (x, y), by dx along the x-axis and dy along the
	 * y-axis
	 * 
	 * @param dx the distance to move this point along the x-axis
	 * @param dy the distance to move this point along the y-axis
	 */
	public void translate(int dx, int dy) {
		x = x + dx;
		y = y + dy;
	}

	/**
	 * Returns the distance between this point and the origin (0, 0)
	 * 
	 * @return the distance between this point and the origin (0, 0)
	 */
	public double distanceFromOrigin() {
		return Math.sqrt(x * x + y * y);
	}

	/**
	 * Returns the distance between this point and a specified point
	 * 
	 * @param other the specified point whose distance to this point will be
	 *              computed
	 * @return the distance between this point's (x, y) coordinates and the
	 *         specified point's (x, y) coordinates
	 * 
	 */
	public double distance(Point other) {
		int dx = x - other.x;
		int dy = y - other.y;
		return Math.sqrt(dx * dx + dy * dy);
	}

	/**
	 * Returns a String representation of this point and its string representation
	 * in the x-y coordinate plane
	 * 
	 * @return the String representation of this point
	 */
	public String toString() {
		return "(" + x + ", " + y + ")";
	}

	/**
	 * Returns the "Manhattan distance" between the current Point object and given
	 * other point object.
	 * 
	 * @param other - the specified point whose distance to this point will be
	 *              computed
	 * @return the distance between this point's (x, y) coordinates and the
	 *         specified point's (x, y) coordinates.
	 */
	public int manhattanDistance(Point other) {
		int a = this.x - other.x;
		int b = this.y - other.y;
		return Math.abs(a) + Math.abs(b);
	}

	/**
	 * Returns true if the given point lines vertically with this point i.e if their
	 * x-coordinates are the same.
	 * 
	 * @param other - the specified point whose distance to this point will be
	 *              computed
	 * @return - true if the x coordinates are same or false if they are not.
	 */
	public boolean isVertical(Point other) {
		if (this.x != other.x) {
			return false;
		}
		return this.x == other.x;
	}

	/**
	 * Returns slope of the line drawn between this Point and the given other Point.
	 * 
	 * @param other - the specified point whose distance to this point will be
	 *              computed
	 * @return - the distance between this point's (x, y) coordinates and the
	 *         specified point's (x, y) coordinates.
	 */
	public double slope(Point other) {
		if (isVertical(other)) {
			throw new IllegalArgumentException("Slope is undefined");
		}
		double ab = (double) (this.y - other.y);
		double cd = (double) (this.x - other.x);

		return ab / cd;

	}

}
