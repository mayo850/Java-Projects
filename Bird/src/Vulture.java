/**
 * Name:Prajwal and Talha
 * Date:6/3/2020 
 * CSC 202-Lab 4
 * 
 * The Vulture class defines a vulture's behavior in our aviary
 */

import java.awt.Color;

public class Vulture extends Bird {
	// constant
	private static int MAX_STEPS = 6;

	// data fields
	private int direction = 0;
	private int countStep = 0;

	// constructor
	public Vulture(int xCord, int yCord) {

		super(xCord, yCord, Color.BLACK);
	}

	// instance method
	public void fly() {
		int x = getX();
		int y = getY();
		countStep++;

		if (direction == 0) {
			y = y - STEP_SIZE;
			setY(y);
		}
		else if (direction == 1) {
			x = x - STEP_SIZE;
			setX(x);
		}
		else if (direction == 2) {
			y = y + STEP_SIZE;
			setY(y);
		}
		else if (direction == 3)
			x = x + STEP_SIZE;
		setX(x);

		if (countStep >= MAX_STEPS) {
			countStep = 0;
			direction++;
			if (direction > 3) {
				direction = 0;
			}
		}

	}

}
