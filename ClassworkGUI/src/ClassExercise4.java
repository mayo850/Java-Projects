// Names: Izan Khan & Kidus

import java.awt.*;
import java.awt.event.*; 
import javax.swing.*;

 class ClassExercise4 implements ActionListener{
// main method to call constructor
   public static void main(String[] args){
                              // one line of code
	   ClassExercise4 gui = new ClassExercise4();
}
// data fields of at least the components that must be accessed outside the constructor in the actionPerformed 
// method.
   
   JTextField text = new JTextField(10);
   JButton button1 = new JButton("Button 1");
    JButton button2 = new JButton("Button 2");
    JButton button3 = new JButton("Button 3");
    JButton button4 = new JButton("Button 4");
   JButton button5 = new JButton("Button 5");
   
   
// constructor creates the frame with a layout and all of the components
   public ClassExercise4(){
	   JPanel northPanel = new JPanel(new FlowLayout());
	   northPanel.add(new JLabel("Enter your name: "));
	   northPanel.add(text);
	   
	   
	   JPanel centerPanel = new JPanel(new GridLayout(2,2));
	   button1.setBackground(Color.BLUE);
	   centerPanel.add(button1);
	   button2.setBackground(Color.BLUE);
	   centerPanel.add(button2);
	   button3.setBackground(Color.BLUE);
	   centerPanel.add(button3);
	   button4.setBackground(Color.BLUE);
	   centerPanel.add(button4);
	   
	   
	   JPanel eastPanel = new JPanel(new BorderLayout());
	   button5.setBackground(Color.BLUE);
	   eastPanel.add(button5, BorderLayout.EAST);
	   
	   button1.addActionListener(this);
	   button2.addActionListener(this);
	   button3.addActionListener(this);
	   button4.addActionListener(this);
	   button5.addActionListener(this);
	   text.addActionListener(this);
	   
	   JFrame frame = new JFrame();
	   frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	   frame.setSize(400, 400);
	   frame.setTitle("Layout Practice");
	   frame.add(northPanel, BorderLayout.NORTH);
	   frame.add(centerPanel);
	   frame.add(eastPanel, BorderLayout.EAST);
	   frame.setVisible(true);
	   
}
// method to react to action events like pressing enter in text field or clicking a button
public void actionPerformed(ActionEvent event){ 
	Object source = event.getSource();
	if (source == button1){
		JOptionPane.showMessageDialog(null, "You clicked Button 1");
}
	 else if (source == button2) {
		 JOptionPane.showMessageDialog(null, "You clicked Button 2");
	}
	 else if (source == button3) {
		 JOptionPane.showMessageDialog(null, "You clicked Button 3");
	}
	 else if (source == button4) {
		 JOptionPane.showMessageDialog(null, "You clicked Button 4");
	}
	 else if (source == button5) {
		 JOptionPane.showMessageDialog(null, "You clicked Button 5");
	}
	 else if (source == text) {
		 String name = text.getText();
		 JOptionPane.showMessageDialog(null, "Hello, " + name);
	}

}
}