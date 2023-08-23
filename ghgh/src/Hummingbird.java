/**
 * Name: talha and prajwal
 * Date: 6/3/2020 
 * CSC 202-Lab 4
 * 
 * The Hummingbird class defines a hummingbird's behavior in our aviary
 */
import java.awt.Color;
import java.util.Random;

public class Hummingbird extends Bird{
	// class field
	private static Random randNum = new Random();

	// constructor
	public Hummingbird(int xCord, int yCord) {
		super(xCord, yCord,Color.MAGENTA);
	}
	


	// instance method
	public void fly() {
		int x = randNum.nextInt((Aviary.WINDOW_SIZE - BIRD_SIZE));
		int y = randNum.nextInt((Aviary.WINDOW_SIZE - BIRD_SIZE));
		setX(x);
		setY(y);
	}

}
