
/*
 * Name: Izan Khan 
 * Date: 22 - October - 2018
 *  Course: CSC211
 * Program:   Programming Assignment CH. 5 Target Practice
 * 
 * Description: This program uses  graphics, mouse interaction, 
 * random number, and indefinite loops to produce a game in which 
 * the user will use the mouse to control the movement of the cursor
 * to direct the pursuer (Pac) where it should go. The aim
 * of this game is to catch the randomly-moving target with Pac.
 *
 */

import java.awt.*;
import java.util.*;
import java.awt.image.BufferedImage;

public class TargetPractice {
	public static final int PANEL_WIDTH = 800;
	public static final int PANEL_HEIGHT = 600;

	public static void main(String[] args) {
		DrawingPanel panel = new DrawingPanel(PANEL_WIDTH, PANEL_HEIGHT);
		Graphics g = panel.getGraphics();

		panel.playSoundFile("igi.wav");
		Random rand = new Random();
		openingScreens(panel, g);
		closingScreens(panel, g, rand);

	}

	public static void openingScreens(DrawingPanel panel, Graphics g) {
		panel.setBackground(Color.GREEN);
		BufferedImage birdImage = panel.loadImage("pac.jpg");
		g.drawImage(birdImage, 0, 0, 800, 600, null);
		g.setColor(Color.BLACK);
		g.setFont(new Font("Times New Roman", Font.BOLD, 30));
		g.drawString("Welcome!", 338, 218);
		g.setFont(new Font("Arial", Font.BOLD, 20));
		g.drawString("Click to proceed to next page", 260, 280);
		while (!panel.checkMouseClicked()) {
			panel.sleep(100);
		}
		panel.clear();
		panel.setBackground(Color.GREEN);
		g.setColor(Color.BLACK);
		g.setFont(new Font("Times New Roman", Font.BOLD, 30));
		g.drawString("Click the mouse to start", 250, 300);
		while (!panel.checkMouseClicked()) {
			panel.sleep(100);
		}

	}

	public static void closingScreens(DrawingPanel panel, Graphics g, Random rand) {
		panel.clear();
		int SquareX = PANEL_HEIGHT / 2;
		int SquareY = PANEL_HEIGHT / 2;

		int time = 100;

		// while loop for timer that starts the game
		while (time > 0) {
			if (time % 100 == 0) {

				drawPac(panel, g, SquareX, SquareY);
				panel.sleep(10);
				int speed = 0;

				SquareX = SquareXCoordinate(panel, SquareX, speed);
				SquareY = SquareYCoordinate(panel, SquareY, speed);
				time--;
				panel.clear();

			}

			// calculates the random coordinates for the target
			Random ran = new Random();
			int targetX = 0;
			int targetY = 60;
			int posTargetX = ran.nextInt(740);
			int posTargetY = ran.nextInt(560) + 40;

			time = 1000;
			int countForGame = 11;

			int score = 0;

			// This while loop runs the game itself
			while (panel.isVisible() && time > 0) {
				panel.clear();
				if (time % 100 == 0) {
					countForGame--;
				}
				// This updates the score, time, and target coordinates when user scores

				if (distance(SquareX, SquareY, targetX, targetY) <= 20) {
					score++;
					time += 100;
					countForGame++;
					targetX = posTargetX;
					targetY = posTargetY;
					drawTarget(panel, g, targetX, targetY);
					posTargetX = rand.nextInt(740);
					posTargetY = rand.nextInt(560) + 40;
				}
				g.setColor(Color.BLACK);
				g.drawString("Time Left: " + countForGame, PANEL_HEIGHT, 550);
				g.drawString("Score: " + score, PANEL_HEIGHT, 575);

				// When target gets within 2 pixel it calculates new position
				if (Math.abs(targetX - posTargetX) <= 2 && Math.abs(targetY - posTargetY) <= 2) {
					posTargetX = rand.nextInt(740);
					posTargetY = rand.nextInt(560) + 40;

				}

				// These if statements move the target to its new destination
				if (posTargetX < targetX && posTargetY < targetY) {
					targetX = targetX - 2;
					targetY = targetY - 2;
				} else if (posTargetX > targetX && posTargetY > targetY) {
					targetX = targetX + 2;
					targetY = targetY + 2;
				} else if (posTargetX > targetX && posTargetY < targetY) {
					targetX = targetX + 2;
					targetY = targetY - 2;
				} else if (posTargetX < targetX && posTargetY > targetY) {
					targetX = targetX - 2;
					targetY = targetY + 2;
				} else {
					targetX = posTargetX;
					targetY = posTargetY;

				}
				drawTarget(panel, g, targetX, targetY);

				drawPac(panel, g, SquareX, SquareY);

				int speed = 0;

				SquareX = SquareXCoordinate(panel, SquareX, speed);
				SquareY = SquareYCoordinate(panel, SquareY, speed);

				panel.sleep(10);
				time--;
			}
			panel.clear();
			g.setFont(new Font("Arial", Font.BOLD, 20));
			if (score >= 20) {
				g.setColor(Color.BLACK);

				g.drawString("You WIN!", 370, 280);
				g.drawString("Click to find score.", 338, 318);
			} else {
				g.setColor(Color.BLACK);

				g.drawString("You loose. Please try again!", 256, 218);
				g.drawString("Click to find score.", 315, 318);

			}
			while (!panel.checkMouseClicked()) {
				panel.sleep(100);
			}
			panel.clear();

			g.setFont(new Font("Arial", Font.BOLD, 20));
			g.drawString("Your Score was " + score, 288, 180);
		}

	}

	/*
	 * Draws a pursuer (Pac)
	 * 
	 * @param drawPac is the x-coordinate of the pursuer(Pac).
	 * 
	 * @param drawPac is the y-coordinate of the pursuer(Pac).
	 */
	public static void drawPac(DrawingPanel panel, Graphics g, int SquareX, int SquareY) {

		g.setColor(Color.WHITE);
		g.fillArc(SquareX, SquareY, 30, 30, 50, 300);
		g.setColor(Color.RED);
		g.fillArc(SquareX, SquareY, 30, 30, 30, 300);
		g.setColor(Color.BLACK);
		g.fillOval(SquareX + 9, SquareY + 4, 5, 5);
	}

	/*
	 * draws a target.
	 * 
	 * @param targetX is the x-coordinate of the target.
	 * 
	 * @param targetY is the y-coordinate of the target.
	 */
	public static void drawTarget(DrawingPanel panel, Graphics g, int targetX, int targetY) {

		g.setColor(Color.CYAN);
		g.fillRect(targetX, targetY, 30, 30);
		g.setColor(Color.PINK);
		g.fillRect(targetX + 10, targetY + 10, 10, 10);
		g.setColor(Color.YELLOW);
		g.fillOval(targetX + 12, targetY - 4, 7, 7);
		g.setColor(Color.YELLOW);
		g.fillOval(targetX + 31, targetY + 12, 7, 7);
		g.setColor(Color.YELLOW);
		g.fillOval(targetX + 12, targetY + 28, 7, 7);
		g.setColor(Color.YELLOW);
		g.fillOval(targetX - 8, targetY + 12, 7, 7);

	}

	/*
	 * This method helps Pac follow the cursor along the x-axis.
	 * 
	 * @param Square is the coordinate of the pursuer(Pac).
	 * 
	 * @param speed is the speed of the target.
	 */
	public static int SquareXCoordinate(DrawingPanel panel, int SquareX, int speed) {
		speed += 1;
		if (panel.getMouseX() < SquareX) {
			SquareX = (SquareX - 2) - speed;
		} else if (panel.getMouseX() > SquareX) {
			SquareX = (SquareX + 2) + speed;
		} else {
			SquareX = SquareX;
		}
		return SquareX;
	}

	/*
	 * This method helps Pac follow the cursor along the y-axis.
	 * 
	 * @param Square is the y coordinate of the pursuer(Pac)
	 * 
	 * @param speed is the speed of the target.
	 */
	public static int SquareYCoordinate(DrawingPanel panel, int SquareY, int speed) {
		speed += 1;
		if (panel.getMouseY() < SquareY) {
			SquareY = (SquareY - 2) - speed;
		} else if (panel.getMouseY() > SquareY) {
			SquareY = (SquareY + 2) + speed;
		} else {
			SquareY = SquareY;
		}

		return SquareY;
	}

	/*
	 * Determines the distance between the target and the Pac.
	 */

	public static double distance(int SquareX, int SquareY, int targetX, int targetY) {
		return (Math.sqrt(Math.pow((SquareX - targetX), 2)) + (Math.pow((SquareY - targetY), 2)));

	}

	/*
	 * Draws a villain.
	 */
	public static void drawVillain(DrawingPanel panel, Graphics g, int villainX, int villainY) {

		g.setColor(Color.WHITE);
		g.fillArc(villainX, villainY, 30, 30, 50, 300);
		g.setColor(Color.RED);
		g.fillArc(villainX, villainY, 30, 30, 30, 300);
		g.setColor(Color.BLACK);
		g.fillOval(villainX + 9, villainY + 4, 5, 5);
	}

}
