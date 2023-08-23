
/**
 * @author Izan Khan
 * @assignment  CSC212--GUI Lab
 * @version (April 20, 2019)
 * 
 * Description: A GUI which allows the user to enter two integers and
 *              displays the sum!
 */

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class MegaCalcGUI implements MouseListener {
	// main method to call the constructor jump-starting the program

	// on-screen components stored as fields

	JTextField operand1Field = new JTextField(4);
	JTextField operand2Field = new JTextField(4);
	JButton plusButton = new JButton(" + ");
	JButton clearButton = new JButton("Clear");
	JLabel resultLabel = new JLabel("");

	public MegaCalcGUI() {
		// set up components

		// panel for the north
		JPanel panel = new JPanel(new FlowLayout());
		panel.add(operand1Field);
		panel.add(plusButton);
		panel.add(operand2Field);

		JPanel panel2 = new JPanel(new FlowLayout());
		panel2.add(new JLabel("Sum = "));
		panel2.add(resultLabel);

		JPanel panel3 = new JPanel(new BorderLayout());
		// panel.setLayout(new BorderLayout());
		panel3.add(clearButton, BorderLayout.SOUTH);
		// overall frame
		JFrame frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("MegaCalc");
		frame.setSize(250, 150);
		frame.setLocationRelativeTo(null);
		frame.setLayout(new BorderLayout());
		frame.add(panel, BorderLayout.NORTH);
		frame.add(panel2, BorderLayout.WEST);
		frame.add(panel3, BorderLayout.SOUTH);

		frame.setVisible(true);
		plusButton.addMouseListener(this);
		clearButton.addMouseListener(this);
		// plusButton.addActionListener((ActionListener) this);
		// clearButton.addActionListener((ActionListener) this);

		plusButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int sum = 0;
				try {
					sum = Integer.parseInt(operand1Field.getText()) + Integer.parseInt(operand2Field.getText());
					resultLabel.setText(String.valueOf(sum));
				} catch (NumberFormatException error) {
					JOptionPane.showMessageDialog(frame, "Only integers allowed!");
				}
			}
		});

		clearButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				resultLabel.setText("");
				operand1Field.setText("");
				operand2Field.setText("");
			}
		});

	}

	public static void main(String s[]) {
		MegaCalcGUI gui = new MegaCalcGUI();
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {

	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent arg0) {

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		plusButton.setForeground(Color.magenta);
		clearButton.setForeground(Color.magenta);
	}

	@Override
	public void mouseExited(MouseEvent e) {
		plusButton.setForeground(Color.black);
		clearButton.setForeground(Color.black);
	}

}
