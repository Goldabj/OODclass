import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Point2D;

import javax.swing.JComponent;


public class ResponsiveCircleComponent extends JComponent {
	private Ellipse2D circle;
	private Color color;
	private Point2D centerPoint;
	
	/**
	 * Construct the circle to Ellipse2D and sets the color as Blue
	 *
	 */
	public ResponsiveCircleComponent() {
		this.centerPoint = new Point2D.Double(20, 20);
		this.circle = new Ellipse2D.Double(centerPoint.getX(), centerPoint.getY(), 70, 70);
		this.color = Color.BLUE;
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		g2.setColor(this.color);
		g2.fill(this.circle);
	
	}
	
	/**
	 * 
	 * returns the circle
	 *
	 * @return
	 */
	public Ellipse2D getCircle() {
		return this.circle;
	}
	
	/**
	 * return the color of the circle
	 *
	 * @return
	 */
	public Color getColor() {
		return this.color;
	}
	
	/**
	 * changes the color of the circle
	 *
	 * @param color
	 */
	public void setColor(Color color) {
		this.color = color;
	}
	
	public void moveCircle(Point2D point) {
		this.centerPoint = point;
	}

}
