package slides;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 * This class demonstrates ActionListeners.
 * 
 * @author Curt Clifton. Created Oct 7, 2008.
 */
public class BreakfastMain {

	/**
	 * Starts the program.
	 * 
	 * @param args
	 *            ignored
	 */
	public static void main(String[] args) {
	

		JFrame frame = new JFrame();
		frame.setTitle("Breakfast for Goldilocks");

		JButton eatButton = new JButton("Eat Porridge");
		frame.add(eatButton);

		final String omg = JOptionPane.showInputDialog("What do you want to say");
		
		class MamaBearListener implements ActionListener {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("eew, too cold!");
			}
		}

	
		frame.pack();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}

}
