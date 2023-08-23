/**
 * A Point object represents a pair of (x, y) coordinates.
 */

public class Point {
	// data fields
	private int x;
	private int y;

	/**
	 * Contructs a point at the origin (0, 0)
	 */
	public Point() {
		this(0, 0); 
	}

	/**
	 * Constructs a point at (x, y)
	 * @param x the desired x coordinate of the point
	 * @param y the desired y coordinate of the point
	 */
	public Point(int x, int y) {
		setPosition(x, y);
	}

	/**
	 * returns the distance from this point to (0, 0)
	 * @return the distance from this point to (0, 0)
	 */
	public double distanceFromOrigin() {
		return Math.sqrt(x * x + y * y);
	}

	/**
	 * returns the x-coordinate of this point
	 * @return the x-coordinate of this point
	 */
	public int getX() {
		return x;
	}

	/**
	 * returns the y-coordinate of this point
	 * @return y-coordinate of this point
	 */
	public int getY() {
		return y;
	}
	
	/**
	 * sets this point's x coordinate to x
	 * @param x the desired x coordinate
	 */
	public void setX(int x){
		this.x = x;
	}

	/**
	 * sets this point's y coordinate to y
	 * @param y the desired y coordinate
	 */
	public void setY(int y) {
		this.y = y;
	}

	/**
	 * sets this point's coordinates to x and y
	 * @param x the desired x coordinate 
	 * @param y the desired y coordinate
	 */
	public void setPosition(int x, int y){
		setX(x);
		setY(y);
	}

	/**
	 * shifts this point by dx horizontally and dy vertically
	 * @param dx the amount of horizontal shift
	 * @param dy the amount of vertical shift
	 */
	public void translate(int dx, int dy) {
		setPosition(x + dx, y + dy);
	}
	
	@ Override
	public String toString() {
		return "(" + x + ", " + y + ")";
	}
}
