import java.awt.Dimension;

import javax.swing.JFrame;

/**
 * This class starts the DrawingSpaceship Exam Question
 * 
 * No need to modify this class
 * 
 * @author Buffalo
 */
public class DrawingSpaceshipViewer {
	private static final Dimension FRAME_SIZE = new Dimension(640,480);

	/**
	 * Starts the viewer.
	 *
	 * @param args ignored
	 */
	public static void main(String[] args) {
		JFrame frame = new JFrame();
		
		frame.setTitle("Drawing!");
		frame.setResizable(false);
		
		DrawingSpaceshipComponent bars = new DrawingSpaceshipComponent();
		bars.setPreferredSize(FRAME_SIZE);
		frame.add(bars);		
		frame.pack();
		
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
}
