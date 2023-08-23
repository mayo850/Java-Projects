
/**
 * @author Izan Khan
 * @assignment CSC212-Lab9B
 * @version (April 10, 2019)
 * 
 * Description: An interface with required constants methods for
 * all flying objects in our aviary
 */

import java.awt.*;

public interface Flyable {
	// STEP_SIZE is the number of pixels the creature moves horizontally or
	// vertically each step
	public static final int STEP_SIZE = 5;

	// FLYER_SIZE is the diameter of the creature in pixels
	public static final int FLYER_SIZE = 10;

	/**
	 * Provides the color of the flying creature as a Color class object
	 * 
	 * @return the Color of the creature
	 */
	public abstract Color getColor();

	/**
	 * Provides the flyer's (x, y) position as a Point class object
	 * 
	 * @return the (x, y) position
	 */
	public abstract Point getPosition();

	/**
	 * "Flies" the creature in a particular pattern
	 */
	public abstract void fly();
}
