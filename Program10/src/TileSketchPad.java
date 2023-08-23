
/**
 * @author Izan Khan
 * @assignment CSC212-Program10
 * @version (May 9, 2019)
 * 
 * TileSketchPad allows the user to drag the mouse to draw
 * rectangular tiles. If the user left clicks on the tile the tile moves
 * to the top of the pile. If the user right clicks on the tile, the
 * tile moves to the bottom of the pile. If the user clicks the shuffle
 * button, the tiles are assigned new random positions.If the user clicks
 * the sort button, the pile is ordered from tile with largest area on the
 * bottom to tile with smallest area on the top. Clicking the clear button,
 * clears the drawing area.
 * 
 * Citations of assistance (who and what): Anas Akkar - Mouse Clicked Method
 * 
 */
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

import javax.swing.*;
import javax.swing.event.*;

public class TileSketchPad extends MouseAdapter implements MouseListener, ActionListener {

	Tile obj = new Tile();

	public static void main(String[] args) {
		TileSketchPad gui = new TileSketchPad();
	}

	// constants
	public static final String[] COLOR_TEXT = { "Black", "Red", "Blue", "Green", "Magenta", "Cyan", "Yellow",
			"Orange" };
	public static final Color[] COLORS = { Color.BLACK, Color.RED, Color.BLUE, Color.GREEN, Color.MAGENTA, Color.CYAN,
			Color.YELLOW, Color.ORANGE };
	private final int FRAME_WIDTH = 600;
	private final int FRAME_HEIGHT = 400;

	// data fields
	private JPanel drawingPanel;
	private JFrame frame;
	private JComboBox<String> colorBox;
	private JButton clearButton;
	private JButton shuffleButton;
	private JButton sortButton;
	private int startX, startY;
	private Color currentDrawingColor;
	private Graphics graphicsPen;
	private ArrayList<Tile> tileList = new ArrayList<Tile>();

	/**
	 * Create the GUI with the drawing panel to display the tiles, clear button, and
	 * a combo box to select the color for the tile to be drawn.
	 */
	public TileSketchPad() {
		JPanel northPanel = createNorthPanel();

		// set up drawing panel
		drawingPanel = new JPanel();
		drawingPanel.setBackground(Color.WHITE);
		drawingPanel.addMouseListener(this);
		drawingPanel.addMouseMotionListener(this);

		// create South Panel
		colorBox = new JComboBox<String>(COLOR_TEXT);
		colorBox.addActionListener(this);
		JPanel colorPanel = new JPanel(new FlowLayout());
		colorPanel.add(colorBox);

		// overall frame
		frame = new JFrame("Sketch Pad");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(new BorderLayout());
		frame.add(northPanel, BorderLayout.NORTH);
		frame.add(drawingPanel, BorderLayout.CENTER);
		frame.add(colorPanel, BorderLayout.SOUTH);
		frame.setSize(new Dimension(FRAME_WIDTH, FRAME_HEIGHT));
		frame.setVisible(true);

		currentDrawingColor = Color.BLACK;
		graphicsPen = drawingPanel.getGraphics();

		frame.addMouseListener(this);

	}

	/**
	 * creates the north panel with the clear, shuffle, and sort buttons
	 * 
	 * @return the north panel
	 */
	private JPanel createNorthPanel() {
		clearButton = new JButton("Clear");
		shuffleButton = new JButton("Shuffle");
		sortButton = new JButton("Sort");

		clearButton.addActionListener(this);
		shuffleButton.addActionListener(this);
		sortButton.addActionListener(this);

		JPanel northPanel = new JPanel(new GridLayout(1, 3));
		northPanel.add(clearButton);
		northPanel.add(shuffleButton);
		northPanel.add(sortButton);

		return northPanel;
	}

	/**
	 * reacts to ActionEvents of clicking a button or choosing a color
	 * 
	 * @param event- the event causing the execution of the method
	 */
	public void actionPerformed(ActionEvent event) {
		Object source = event.getSource();

		if (source == clearButton) {
			clearPanel();
			tileList.clear();

		} else if (source == shuffleButton) {
			clearPanel();
			shuffle(600, 400);
			for (Tile t : tileList) {
				graphicsPen.setColor(t.getColor());
				graphicsPen.fillRect(t.getxCoordinates(), t.getyCoordinates(), t.getWidth(), t.getHeight());
			}
		} else if (source == sortButton) {
			clearPanel();
			sort();
		}

		setDrawingColor();
	}

	/**
	 * save the point when the mouse is pressed
	 * 
	 * @param event- the mouse event causing the execution of the method
	 */
	public void mousePressed(MouseEvent event) {
		startX = event.getX();
		startY = event.getY();
	}

	/**
	 * saves the point, and if different from the first point, adds the tile to the
	 * list
	 * 
	 * @param event- the mouse event causing the execution of the method
	 */
	public void mouseReleased(MouseEvent event) {
		int x = event.getX();
		int y = event.getY();
		int upperLeftX = Math.min(startX, x);
		int upperLeftY = Math.min(startY, y);
		int width = Math.abs(x - startX);
		int height = Math.abs(y - startY);

		// draw a rectangle only when mouse press and release points are
		// different, i.e., not when mouse is clicked
		if (width > 0 && height > 0) {
			graphicsPen.setColor(currentDrawingColor);
			graphicsPen.fillRect(upperLeftX, upperLeftY, width, height);
			// you will add some code here
			Tile data = new Tile(upperLeftX, upperLeftY, width, height, currentDrawingColor);
			tileList.add(data);

		}
	}

	/**
	 * clears the drawing panel by drawing a large white rectangle
	 */
	private void clearPanel() {
		Rectangle rect = frame.getBounds();
		graphicsPen.setColor(Color.WHITE);
		graphicsPen.fillRect(0, 0, rect.width, rect.height);

	}

	/**
	 * save the color selected from the combo box as the current drawing color
	 */
	private void setDrawingColor() {
		String colorChoice = (String) colorBox.getSelectedItem();
		for (int i = 0; i < COLOR_TEXT.length; i++) {
			if (colorChoice.equals(COLOR_TEXT[i])) {
				currentDrawingColor = COLORS[i];
			}
		}
	}

	@Override
	public void mouseClicked(MouseEvent event) {
		int index = 0;
		Tile atTop;
		Tile atBottom;

		for (int i = 0; i < tileList.size(); i++) {
			if (tileList.get(i).containsPoint(event.getX(), event.getY())) {
				index = i;
			}
		}
		if (event.getButton() == MouseEvent.BUTTON1 && tileList.get(index).containsPoint(event.getX(), event.getY())) {
			atTop = tileList.get(index);
			tileList.remove(index);
			tileList.add(atTop);
			graphicsPen.setColor(atTop.getColor());
			graphicsPen.fillRect(atTop.getxCoordinates(), atTop.getyCoordinates(), atTop.getWidth(), atTop.getHeight());
		} else if (event.getButton() == MouseEvent.BUTTON3
				&& tileList.get(index).containsPoint(event.getX(), event.getY())) {
			atBottom = tileList.get(index);
			tileList.remove(index);
			tileList.add(0, atBottom);
			graphicsPen.setColor(atBottom.getColor());
			graphicsPen.fillRect(atBottom.getxCoordinates(), atBottom.getyCoordinates(), atBottom.getWidth(),
					atBottom.getHeight());

		}
	}

	/**
	 * Each tile is assigned a random new x coordinate and a random new y coordinate
	 * so that the entire width and height of the tile will still be visible in the
	 * panel.
	 * 
	 * @param width
	 * @param height
	 */
	public void shuffle(int width, int height) {

		Collections.shuffle(tileList);
		Random randomVault = new Random();
		for (Tile t : tileList) {

			t.setX_Coordinates(randomVault.nextInt(width - t.getWidth()));
			t.setY_Coordinates(randomVault.nextInt(height - t.getHeight()));

		}
	}

	/**
	 * when the sort button is pressed, the tiles will be sorted by area,
	 */
	public void sort() {

		Collections.sort(tileList);

		for (Tile t : tileList) {
			graphicsPen.setColor(t.getColor());
			graphicsPen.fillRect(t.getxCoordinates(), t.getyCoordinates(), t.getWidth(), t.getHeight());
		}
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}
}
