/**
 * Name: talha and prajwal
 * Date:6/3/2020
 * CSC 202-Lab 4
 *
 * The Bluebird class defines the behavior of a bluebird in our aviary
 */

import java.awt.*;

public class Bluebird extends Bird {

	public static final int MAX_STEPS = 4;

	private int count;
	private boolean isMovingRight;



	public Bluebird(int x, int y) {
		super(x, y, Color.BLUE);
		count = 0;
		isMovingRight = false;

	}


	public void fly() {
		if (isMovingRight == false) {
			setPosition(getX() + STEP_SIZE,getY());
			if (!(getX() + STEP_SIZE < (Aviary.WINDOW_SIZE - BIRD_SIZE))) {
				isMovingRight = true;
			}
		}
		if (isMovingRight == true) {
			setPosition(getX() - STEP_SIZE, getY());
			if (getX() - STEP_SIZE < 0) {
				isMovingRight = false;
			}
		}
		if (count <= MAX_STEPS) {
			setPosition(getX(), getY() - STEP_SIZE);
			count++;
		} else {
			setPosition(getX(), getY() + STEP_SIZE);
			count++;
		}
		if (count > (MAX_STEPS * 2)) {
			count = 1;
		}
	}

}
