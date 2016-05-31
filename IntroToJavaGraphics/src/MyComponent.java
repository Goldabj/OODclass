import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;

import javax.swing.JComponent;



public class MyComponent extends JComponent {
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		Graphics2D g2 = (Graphics2D) g;
		
		Rectangle box = new Rectangle(10, 10, 40, 120);
		g2.draw(box);
		g2.translate(100, 100);
		g2.draw(box);
		g2.rotate(Math.PI/ 4.0);
		g2.draw(box);
		

		
//		for(int i = 0; i < this.getWidth(); i += 10) {
//			box = new Rectangle(i, i, 10, 10);
//			g2.draw(box);
//		}
//		
//		Ellipse2D.Double circle = new Ellipse2D.Double(50 , 50, 50, 50);
//		g2.draw(circle);
//		
//		Line2D.Double line = new Line2D.Double(20, 20, 30, 30);
//		g2.draw(line);
//		
//		Point2D.Double point = new Point2D.Double(100, 100);
		
	}
}
