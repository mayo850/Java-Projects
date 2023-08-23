
/**
 * @author Izan Khan
 * @assignment CSC212-Lab9B
 * @version (April 10, 2019)
 * 
 * Description: Class to describe the behavior of all birds for our aviary
 */

import java.awt.*;

public abstract class Bird {
	// data fields
	private Point position;
	private Color birdColor;

	/**
	 * Constructs a Bird at position (x, y) with the specified color
	 * 
	 * @param x         - the x coordinate of this bird's position
	 * @param y         - the y coordinate of this bird's position
	 * @param birdColor - the color of the bird
	 * @throws IllegalArgumentException when the bird's position is invalid
	 * 
	 */
	public Bird(int x, int y, Color color) {
		if (x < 0 || x >= Aviary.WINDOW_SIZE || y < 0 || y >= Aviary.WINDOW_SIZE) {
			throw new IllegalArgumentException();
		}
		this.birdColor = color;
		position = new Point(x, y);

	}

	/**
	 * Provides the color of the flying creature as a Color class object
	 * 
	 * @return the Color of the creature
	 */
	public Color getColor() {
		return birdColor;
	}

	/**
	 * Provides the flyer's (x, y) position as a Point class object
	 * 
	 * @return the (x, y) position
	 */
	public Point getPosition() {
		return position;
	}

	/**
	 * Provides the x coordinate of this bird's position
	 * 
	 * @return the x coordinate of this bird's position
	 */
	public int getX() {
		return position.getX();
	}

	/**
	 * Provides the y coordinate of this bird's position
	 * 
	 * @return the y coordinate of this bird's position
	 */
	public int getY() {
		return position.getY();
	}

	/**
	 * Sets the position of this bird to the specified (x, y) coordinates
	 * 
	 * @param x - the x coordinate for this bird
	 * @param y - the y coordinate for this bird
	 */
	public void setPosition(int x, int y) {
		if (x < 0 || x >= Aviary.WINDOW_SIZE || y < 0 || y >= Aviary.WINDOW_SIZE) {
			throw new IllegalArgumentException();
		}
		this.position = new Point(x, y);

	}
}
