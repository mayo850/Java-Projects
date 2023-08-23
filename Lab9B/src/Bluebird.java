
/**
 * @author Izan Khan
 * @assignment CSC212-Lab9B
 * @version (April 10, 2019)
 * 
 * Description: A Bluebird class for our aviary with
 * a bluebird moving in a zig-zag pattern.
 * 
 * Citations of Assistance (who and what): Kidus Getachew (fly method)
 */

import java.awt.*;

public class Bluebird extends Bird implements Flyable {
	// constant
	public static final int STEPS = 4;

	// data fields
	private boolean right;
	private int step;

	/**
	 * Constructs a Bluebird with the specified position and blue color
	 * 
	 * @param x - the x coordinate of this bluebird
	 * @param y - the y coordinate of this bluebird
	 */
	public Bluebird(int x, int y) {
		super(x, y, Color.BLUE);
		right = false;
		step = 0;
	}

	/**
	 * Moves this bluebird moves in a zig-zag pattern but never out of the aviary.
	 */
	
//	@Override
	public void fly() {
		if (right == false) {
			setPosition(super.getX() + STEP_SIZE, super.getY());
			if (!(super.getX() + STEP_SIZE < (Aviary.WINDOW_SIZE - FLYER_SIZE))) {
				right = true;
			}
		}
		if (right == true) {
			setPosition(super.getX() - STEP_SIZE, super.getY());
			if (super.getX() - STEP_SIZE < 0) {
				right = false;
			}
		}
		if (step <= STEPS) {
			setPosition(getX(), getY() - STEP_SIZE);
			step++;
		} else {
			setPosition(getX(), getY() + STEP_SIZE);
			step++;
		}
		if (step > (STEPS * 2)) {
			step = 1;
		}
	}

}