import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JFrame;


public class ResponsiveCircleMain {

	/**
	 * The width of the frame.
	 */
	public static final int WIDTH = 300;
	/**
	 * The height of the frame.
	 */
	public static final int HEIGHT = 300;
	
	public static void main(String[] args) {
		JFrame frame = new JFrame();
		
		frame.setTitle("A Circle");
		final ResponsiveCircleComponent c = new ResponsiveCircleComponent();
		c.setPreferredSize(new Dimension(WIDTH,HEIGHT));
		frame.add(c);
		
		final JButton changeColorButton = new JButton("Change Color");
		// add actionLisenter to change color button
		changeColorButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("Button Clicked!");
				repaintCircle(c);
				c.repaint();
			}
		});
		frame.add(changeColorButton, BorderLayout.SOUTH);
		
		c.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub.
				
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub.
				
			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub.
				
			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub.
				
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub.
				
			}
			
		});
		
		frame.pack();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);

	}
	/**
	 * repaints the color of the circle to either green or Blue.
	 *
	 * @param c
	 */
	public static void repaintCircle(ResponsiveCircleComponent c) {
		if(c.getColor().equals(Color.GREEN)) {
			c.setColor(Color.BLUE);
		}else {
			c.setColor(Color.GREEN);
		}
		c.repaint();
	
	}
	
}
