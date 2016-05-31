package linearLightsOut;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 * Runs the Linear Lights Out application.
 * 
 * @author Brendan Goldacker. Created Jan 18, 2010.
 */
public class LinearMain {

	/**
	 * Starts here.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		// creates an input box that ask how many buttons to create.
		String nButtonsString = JOptionPane
				.showInputDialog("How many buttons would you like?");
		int nButtons = Integer.parseInt(nButtonsString);

		// Creates a frame
		JFrame myFrame = new JFrame();
		myFrame.getDefaultCloseOperation();
		myFrame.setVisible(true);

		// Creates and runs the game
		myFrame.add(new LinearGameComponent(nButtons, myFrame));

	}
}
