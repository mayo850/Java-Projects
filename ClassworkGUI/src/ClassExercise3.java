//Name: Izan Khan & Kidus

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


	public class ClassExercise3 implements ActionListener{
		
		private JTextField text = new JTextField("The text can be made to all uppercase or lowercase");
		private JButton button1=new JButton("Upper case");
		private JButton button2=new JButton("Lower Case");
	
		
		public static void main (String[] args) {
			ClassExercise3 gui = new ClassExercise3();
		}
		
		
		public ClassExercise3(){
			
			 JPanel panel = new JPanel(new BorderLayout());
			panel.add(button1, BorderLayout.NORTH);
			panel.add(text,BorderLayout.CENTER);
			panel.add(button2, BorderLayout.SOUTH);
			
			button1.addActionListener (this); 
			button2.addActionListener(this);
			
			JFrame frame = new JFrame();
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.setSize(350, 125);
			frame.setTitle("Silly String Game");
			frame.add(panel);
			frame.setVisible(true); 
		
		}
		
		public void actionPerformed (ActionEvent event) {
		Object source = event.getSource(); 
		if(source == button1) {
		String usertext = text.getText(); 
	
		String newText = usertext.toUpperCase();
		text.setText(newText);
		}
		if(source == button2) {
		String usertext = text.getText(); 
		
		String newText = usertext.toLowerCase();
		text.setText(newText);
		
		}
	}

}


