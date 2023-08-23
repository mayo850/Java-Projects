
/**
 * @author Izan Khan
 * @assignment CSC212-Lab9B
 * @version (April 10, 2019)
 * 
 * Description: A Cardinal class for our aviary with
 * a cardinal moving directly up and down.
 */

import java.awt.*;

public class Cardinal extends Bird implements Flyable {
	// data field
	private boolean isMovingUp;

	/**
	 * Constructs a cardinal with the specified position and red color
	 * 
	 * @param x - the x coordinate of this cardinal
	 * @param y - the y coordinate of this cardinal
	 */
	public Cardinal(int x, int y) {
		super(x, y, Color.RED);
		isMovingUp = true;

	}

	/**
	 * Moves this cardinal one "step" up or down but never out of the aviary.
	 */
//	@Override

	public void fly() {
		if (isMovingUp == true) {
			setPosition(super.getX(), super.getY() - Flyable.STEP_SIZE);
			if (super.getY() - Flyable.STEP_SIZE < 0) {
				isMovingUp = false;
			}
		}
		if (isMovingUp == false) {
			setPosition(super.getX(), super.getY() + Flyable.STEP_SIZE);
			if (!(super.getY() + Flyable.STEP_SIZE < (Aviary.WINDOW_SIZE - Flyable.FLYER_SIZE))) {
				isMovingUp = true;
			}
		}

	}

}
