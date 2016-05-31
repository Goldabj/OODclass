package rotatingshapes;

import java.awt.Graphics;
import java.util.ArrayList;

import javax.swing.JComponent;
import javax.swing.JFrame;

@SuppressWarnings("serial")
public class RotatingShapesComponent extends JComponent {
	
	private RotatingShape square1, square2, circle1, circle2;
	
	// To see a video of the final version of this project in action, go here:
	// http://youtu.be/GyK3twPGR0M
	
	public RotatingShapesComponent(JFrame frame) {
		
		square1 = new RotatingShape(0,0);
		square2 = new RotatingShape(300,300);
		
		// HINT: If you want to add a keyboard listener, 
		// add it to the frame not this component
		// frame.addKeyListener(square1);
		
	}
	
	public void annimate(RotatingShape shape) {
		Thread animation = new AnimationThread(shape, this);
		animation.start();
	}
	
	public ArrayList<RotatingShape> getShapes() {
		ArrayList<RotatingShape> shapes = new ArrayList<>();
		shapes.add(square1);
		shapes.add(square2);
//		shapes.add(circle1);
//		shpaes.add(circle2);
		
		return shapes;
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		// draws a blank component
		
	}	

}
