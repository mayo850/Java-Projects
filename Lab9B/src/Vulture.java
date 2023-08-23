
/**
 * @author Izan Khan
 * @assignment CSC212-Lab9B
 * @version (April 10, 2019)
 * 
 * Description: A Vulture class for our aviary with
 * a vulture moving counterclockwise in a square
 */

import java.awt.*;

public class Vulture extends Bird implements Flyable {
	// constant
	public static final int NUM_STEPS = 6;

	// data field
	private int direction;

	/**
	 * Constructs a vulture with the specified position and black color
	 * 
	 * @param x - the x coordinate of this vulture
	 * @param y - the y coordinate of this vulture
	 */
	public Vulture(int x, int y) {
		super(x, y, Color.BLACK);
		direction = 0;
	}

	/**
	 * Moves this vulture in a counterclockwise square
	 */
//	@Override
	public void fly() {
		if (direction == 0) {
			super.setPosition(super.getX(), super.getY() - Flyable.STEP_SIZE * NUM_STEPS);
			direction++;
		} else if (direction == 1) {
			super.setPosition(super.getX() + Flyable.STEP_SIZE * NUM_STEPS, super.getY());
			direction++;
		} else if (direction == 2) {
			super.setPosition(super.getX(), super.getY() + Flyable.STEP_SIZE * NUM_STEPS);
			direction++;
		} else if (direction == 3) {
			super.setPosition(super.getX() - Flyable.STEP_SIZE * NUM_STEPS, super.getY());
			direction = 0;
		}

	}

}
