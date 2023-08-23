
/**
 * @author Izan Khan
 * @assignment  CSC212--GUI Lab
 * @version (21 April, 2019)
 * 
 * Description: A GUI which changes the color of the panel
 *              depending on which quarter of the panel is clicked.
 *              When the mouse moves, the panel returns to white.
 *              The number of clicks is also displayed.
 */

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

public class ClickColorsGUI extends MouseInputAdapter implements MouseListener, MouseMotionListener {
	// main method to call the constructor jump-starting the program

	// on-screen components stored as fields

	private int count = 0;
	JLabel resultLabel;

	JPanel panel = new JPanel(new BorderLayout());

	public ClickColorsGUI() {
		// set up components

		JFrame frame = new JFrame();
		frame.setTitle("Clicking Around");

		//System.out.println(count + "asa");

		frame.add(panel);
		frame.setSize(600, 400);
		frame.setLocationRelativeTo(null);

		resultLabel = new JLabel("Click anywhere in the panel");
		panel.add(resultLabel, BorderLayout.SOUTH);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);

		panel.addMouseListener(this);
		panel.addMouseMotionListener(this);
		// overall frame
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		int x = e.getX();
		int y = e.getY();
		int z = panel.getWidth();
		int w = panel.getHeight();

		this.count++;
		resultLabel.setText("You clicked " + String.valueOf(getCount()) + " times!");
		if (x < z / 2 && y < w / 2) {
			panel.setBackground(Color.RED);

		} else if (x < z / 2 && y > w / 2) {
			panel.setBackground(Color.BLUE);

		} else if (x > z / 2 && y < w / 2) {
			panel.setBackground(Color.YELLOW);

		} else if (x > z / 2 && y > w / 2) {
			panel.setBackground(Color.GREEN);

		}
	}

	public int getCount() {
		return this.count;
	}

	@Override
	public void mouseMoved(MouseEvent arg0) {

		panel.setBackground(Color.WHITE);
	}

	public static void main(String s[]) {
		ClickColorsGUI gui = new ClickColorsGUI();
	}
}
