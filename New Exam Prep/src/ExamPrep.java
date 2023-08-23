import java.awt.*;

public class ExamPrep {

	public static void main(String[] args) {
		DrawingPanel panel = new DrawingPanel(300, 300);
		panel.setBackground(Color.LIGHT_GRAY);
		Graphics g = panel.getGraphics();
		for(int i=1; i<=500; i++) {
			if (panel.checkMouseClicked())
		drawCar(g, 10+i,30);
		panel.sleep(50);
		panel.clear();
		}
	  
	}

	public static void drawCar(Graphics g, int x, int y) {
		g.setColor(Color.BLACK);
		g.fillRect(x, y, 100, 50);
		g.setColor(Color.RED);
		g.fillOval(x + 10, y + 40, 20, 20);
		g.fillOval(x + 70, y + 40, 20, 20);
		g.setColor(Color.CYAN);
		g.fillRect(x + 70, y + 10, 30, 20);
	}

}
