
/**
 * @author Izan Khan
 * @assignment CSC212-Lab9B
 * @version (April 10, 2019)
 * 
 * Description: A Mosquito class for our aviary with
 * a mosquito moving to random positions
 */

import java.awt.*;
import java.util.*;

public class Mosquito implements Flyable {
	// data fields
	private Point position;
	private Color color;
	private Random rand;

	/**
	 * Constructs a Mosquito with the specified position and magenta color
	 * 
	 * @param x - the x coordinate of this mosquito
	 * @param y - the y coordinate of this mosquito
	 */
	public Mosquito(int x, int y) {
		if (x < 0 || x >= Aviary.WINDOW_SIZE || y < 0 || y >= Aviary.WINDOW_SIZE) {
			throw new IllegalArgumentException();
		}
		this.color = color;
		position = new Point(x, y);
		rand = new Random();

	}

	// getColor
//	@Override
	public Color getColor() {
		return Color.MAGENTA;
	}

	// getPosition
//	@Override
	public Point getPosition() {
		return position;
	}

	/**
	 * Moves this mosquito to a random position but never out of the aviary.
	 */
//	@Override
	public void fly() {
		int RandomX = rand.nextInt(500);
		int RandomY = rand.nextInt(500);

		position = new Point(RandomX, RandomY);
	}

}