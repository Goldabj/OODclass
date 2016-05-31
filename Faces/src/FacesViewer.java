import java.awt.Dimension;

import javax.swing.JFrame;


/**
 * creates a Jframe with dimensions 500x400
 *  with a faces component on it
 *
 * @author goldacbj.
 *         Created Dec 17, 2014.
 */
public class FacesViewer {
	private static final Dimension FRAME_DIMENSIONS = new Dimension(500, 400);
	

	/**
	 * creates a Jframe with a faces component on it
	 *
	 * @param args
	 */
	public static void main(String[] args) {
		JFrame facesFrame = new JFrame();
		
		facesFrame.setTitle("FACES FRAME");
		facesFrame.setSize(FRAME_DIMENSIONS);
		facesFrame.add(new FacesComponent());
		
		facesFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		facesFrame.setVisible(true);

	}

}
