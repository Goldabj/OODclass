package rotatingshapes;

import java.awt.Dimension;

import javax.swing.JFrame;

/**
 * Basic viewer classes. Nothing too exciting here.
 * 
 * @author hewner
 *
 */
public class RotatingShapesMain {

	private static final Dimension FRAME_SIZE = new Dimension(640, 480);

	/**
	 * The main - creates the window.
	 * 
	 * You can modify this if you want but you probably don't need to.
	 * 
	 * @param args
	 *            ignored
	 */
	public static void main(String[] args) {
		JFrame frame = new JFrame();

		frame.setTitle("Move some rectangles");

		RotatingShapesComponent bars = new RotatingShapesComponent(frame);
		bars.setPreferredSize(FRAME_SIZE);
		frame.add(bars);
		frame.pack();

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);

		for (int i = 0; i < bars.getShapes().size(); i++) {
			bars.annimate(bars.getShapes().get(i));
		}
	}

}
