/**
 * This program displays "birds" flying in an aviary. The birds move in
 * patterns as determined by their classes and will always remain in the aviary.
 * 
 * Note: The sound is controlled by a constant which can be changed to false
 * if you don't want to hear the tweeting!
 */
import java.awt.*;
import java.awt.image.BufferedImage;

public class Aviary {
	
	public static final String BACKGROUND = "sky1.jpg";
	public static final String SOUND_FILE_NAME = "birdSounds.wav";
	public static final boolean SOUND_ON = true;
	public static final int WINDOW_SIZE = 500;  // height and width of the window in pixels
	public static final int ITERATIONS = Integer.MAX_VALUE;  // number of iterations to loop
	public static final int SLEEP_AMOUNT = 100;

	public static void main(String[] args) {
		
		// Initialize the graphics window
		DrawingPanel panel = new DrawingPanel(100, 100);
		panel.loadImageAndResizeWindow(BACKGROUND);
		
		//set up for "double buffering"
		BufferedImage bufferImg = new BufferedImage(panel.getWidth(), panel.getHeight(), BufferedImage.TYPE_INT_RGB);
		BufferedImage background = panel.loadImage(BACKGROUND);
		Graphics bufferG = bufferImg.getGraphics(); 
		Graphics panelG = panel.getGraphics(); 

		// Start the sound!
		if (SOUND_ON) {
			panel.playSoundFile(SOUND_FILE_NAME);
		}
		
		// create several flying creatures 
		Bird[] birds = {new Cardinal(50, 28), new Cardinal(300, 200),
				new Vulture(180, 120), new Vulture(375, 400),
				new Hummingbird(200, 125), new Hummingbird(350, 20),
				new Bluebird(395, 150), new Bluebird(255, 400)
				};
		
		// draw birds in initial positions
		bufferG.drawImage(background, 0, 0, null);
		for (Bird bird : birds) {
			bufferG.setColor(bird.getColor());
			Point pos = bird.getPosition();
			bufferG.fillOval(pos.getX(), pos.getY(), Bird.BIRD_SIZE, Bird.BIRD_SIZE);
		}
		panelG.drawImage(bufferImg, 0, 0, null);

		for (int i = 0; i < ITERATIONS; i++) {
			// draw the background to the buffer
			bufferG.drawImage(background, 0, 0, null);
			// tell each creature to fly, and redraw the creature in the buffer
			for (Bird bird : birds) {
				bird.fly();
				bufferG.setColor(bird.getColor());
				Point position = bird.getPosition();
				bufferG.fillOval(position.getX(), position.getY(), Bird.BIRD_SIZE, Bird.BIRD_SIZE);
			}
			panel.sleep(SLEEP_AMOUNT);
			// draw the buffer in the panel
			panelG.drawImage(bufferImg, 0, 0, null);
			
			// end the program if the window closes before the end of the loop
			if (!panel.isVisible()){
				System.exit(0);
			}
		}
		
	}
}
