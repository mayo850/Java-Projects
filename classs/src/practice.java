import javax.swing.JOptionPane;

public class practice {

	public static void main(String[] args) {
		String input = JOptionPane.showInputDialog(null, "Enter your name.");
		String easter = "Easter Bunny";
		boolean easter1 = input.equalsIgnoreCase(easter);
		
		if(easter1) {
			JOptionPane.showMessageDialog(null, "Give me some Peeps!");
				
		} else {
			JOptionPane.showMessageDialog(null, "I'm ready for a day off!");
		}

	}

}
