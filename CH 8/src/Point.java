/**
 * @author Izan Khan
 * @assignment CSC212- Routine Assignment Ch8
 * @version March 23, 2019
*/


/*
 * The point class represents a point in two dimensions. 
 */

public class Point {

	// fields
	private int x;
	private int y;

	// constructors
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
	 * @param newX x coordinate of the new location
	 * @param newY y coordinate of the new location
	 */
	public void setLocation(int x, int y) {
		this.x = x;
		this.y = y;
	}

	/**
	 * Translates this point, at (x, y), by dx along the x-axis and dy along the
	 * y-axis
	 * 
	 * @param the distance to move this point along the x-axis
	 * @param the distance to move this point along the y-axis
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

	public int quadrant() {
		if (getX() > 0 && getY() > 0)
			return 1;
		else if (getX() < 0 && getY() > 0)
			return 2;
		else if (getX() < 0 && getY() < 0)
			return 3;
		else if (getX() > 0 && getY() < 0)
			return 4;
		else
			return 0;
	}

	public void flip() {
		int temp = 0;

		temp = this.x;
		this.x = this.y;
		this.y = temp;

		this.y *= -1;
		this.x *= -1;

	}

	public boolean closerToOriginThan(Point other) {
		if ((Math.sqrt(this.x * this.x + this.y * this.y)) < (Math.sqrt(other.x * other.x + this.y * this.y))) {
			return false;
		} else
			return true;

	}

	public void add(Point other) {
		int dx = this.x + other.x;
		int dy = this.y + other.y;

		setLocation(dx, dy);
	}

	/**
	 * Returns a String representation of this point and its string representation
	 * in the x-y coordinate plane
	 * 
	 * @return the String representation of this point
	 */
	public String toString() {
		return "(" + this.x + ", " + this.y + ")";
	}

}
