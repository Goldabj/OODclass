package rotatingshapes;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyListener;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;

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
	
	@Override
	protected void paintComponent(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		square1.draw(g2);
		square2.draw(g2);
		
	}	

}
