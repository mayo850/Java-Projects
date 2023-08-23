
// Names: Izan Khan
import java.awt.*;
import javax.swing.*;

public class ClassExercise2 {
	public static void main(String[] args) {
		ClassExercise2 gui = new ClassExercise2();
	}

	public ClassExercise2() {
		JFrame frame = new JFrame("GridLayout Pracice");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocation(500, 300);
		frame.setSize(500, 200);
		frame.setLayout(new GridLayout(2, 3));

		JButton button1 = new JButton("My Button");
		button1.setBackground(Color.BLUE);
		button1.setForeground(Color.BLACK);
		frame.add(button1);
		frame.setVisible(true);

		JTextField TextField = new JTextField();
		TextField.setBackground(Color.RED);
		TextField.setForeground(Color.BLACK);
		frame.add(TextField);

		JLabel message = new JLabel("Right Label");
		message.setBackground(Color.BLACK);
		message.setForeground(Color.BLUE);
		frame.add(message);

		JLabel message2 = new JLabel("Left Label");
		TextField.setBackground(Color.RED);
		TextField.setForeground(Color.BLACK);
		frame.add(message2);

		JButton button2 = new JButton("Center Button");
		button2.setBackground(Color.BLUE);
		button2.setForeground(Color.GREEN);
		frame.add(button2);

		JTextArea TextArea = new JTextArea();
		TextArea.setBackground(Color.RED);
		TextArea.setForeground(Color.WHITE);
		frame.add(TextArea);

		frame.setVisible(true);

	}
}