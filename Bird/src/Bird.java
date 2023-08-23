
/**
 * Name: Prajwal and Talha
 * Date: 6/3/2020
 * CSC 202-Lab 4
 * 
 * The abstract class for bird behavior.
 */

import java.awt.*;

public abstract class Bird {
	public static int STEP_SIZE = 5;
	public static int BIRD_SIZE = 2 * STEP_SIZE;

	// data fields
	private Point position;
	private Color color;

	// constructor
	public Bird(int x, int y, Color color) throws IllegalArgumentException {
		if (x < 0 || y < 0 || x >= (Aviary.WINDOW_SIZE - BIRD_SIZE) || y >= (Aviary.WINDOW_SIZE - BIRD_SIZE)) {
			throw new IllegalArgumentException("Bird must be within the aviary: (" + x + "," + y + ")");
		} else {
			position = new Point(x, y);
			this.color = color;
		}
	}

	// instance methods
	public Color getColor() {
		return this.color;
	}

	public Point getPosition() {
		return position;
	}

	public int getX() {
		return position.getX();
	}

	public int getY() {
		return position.getY();
	}
	
	

	// mutator methods
	public void setX(int x) throws IllegalArgumentException {
		if (x < 0 || x >= (Aviary.WINDOW_SIZE - BIRD_SIZE)) {
			throw new IllegalArgumentException("Bird must be within the aviary: (" + x + ")");
		} else {
			position.setX(x);
		}
	}

	public void setY(int y) throws IllegalArgumentException {
		if (y < 0 || y >= (Aviary.WINDOW_SIZE - BIRD_SIZE)) {
			throw new IllegalArgumentException("Bird must be within the aviary: (" + y + ")");
		} else {
			position.setY(y);
		}
	}
	
	

	public abstract void fly();
	
	
	
	/**
	 * Sets the position of this bird to the specified (x, y) coordinates
	 * 
	 * @param x - the x coordinate for this bird
	 * @param y - the y coordinate for this bird
	 */
	public void setPosition(int x, int y) {
		if (x < 0 || y < 0 || x >= (Aviary.WINDOW_SIZE - BIRD_SIZE) || y >= (Aviary.WINDOW_SIZE - BIRD_SIZE)) {
			throw new IllegalArgumentException();
		}
		this.position = new Point(x, y);

	}
	
	

}
