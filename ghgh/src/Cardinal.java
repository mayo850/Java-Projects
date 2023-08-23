
/**
 * Name: Prajwal and Talha
 * Date:6/3/2020
 * CSC 202-Lab 4
 * 
 * The Cardinal class defines the behavior of a Cardinal in our aviary
 */

import java.awt.Color;

public class Cardinal extends Bird {
	// data field
	private boolean moveUp;

	// constructor
	public Cardinal(int xCord, int yCord) {
		super(xCord, yCord, Color.RED);
		moveUp = true;
	}

	// instance method
	public void fly() {
		int yCord = getY();
		if (moveUp) {
			
			int y = yCord - STEP_SIZE;
			if (y < 0) {
				moveUp = false;
				y = yCord + STEP_SIZE;
			}
			setY(y);
		} else {
			
			int y = yCord + STEP_SIZE;
			if (y >= Aviary.WINDOW_SIZE - BIRD_SIZE) {
				moveUp = true;
				y = yCord - STEP_SIZE;
			}
			setY(y);
		}
	}

}
