import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Polygon;

/**
 * Draw a spaceship Has the methods to roatate the spaceship and also a mehtod
 * to move the spaceship
 * 
 * This is the class that you should change.
 * 
 * @author you (and Buffalo)
 *
 */
public class DrawingSpaceship {

	private static final int WIDTH = 20;
	private static final int HEIGHT = 40;
	private static final Color SHIP_COLOR = Color.blue;
	private int x;
	private int y;
	private double spaceshipAngle;

	public DrawingSpaceship(int x, int y) {
		this.x = x;
		this.y = y;
	}

	/**
	 * Draws the spaceship
	 * 
	 * @param g
	 *            the graphics object to draw on
	 */
	public void drawOn(Graphics2D g) {
		g.translate(this.x, this.y);
		g.rotate(this.spaceshipAngle * Math.PI / 180);
		// just an example, to give your a feel how to draw the spaceship
		// you'll have to modify this code heavily

		Polygon py = new Polygon();
		py.addPoint(0, -HEIGHT / 2);
		py.addPoint(WIDTH / 2, HEIGHT / 2);
		py.addPoint(-WIDTH / 2, HEIGHT / 2);
		g.setColor(SHIP_COLOR);
		g.fill(py);
		g.rotate(-this.spaceshipAngle * Math.PI / 180);
		g.translate(-this.x, -this.y);

	}

	/**
	 * 
	 * rotates the spaceship by the given amount of degrees, does not draw the
	 * roates spaceship, you must envoke the drawOn method to draw the rotated
	 * spaceship.
	 *
	 * @param degrees
	 *            -- degrees to rotate the spaceship
	 */
	public void setRotation(double degrees) {
		this.spaceshipAngle = degrees;
	}

	/**
	 * 
	 * moves the center positon of a spaceship to the given point position. You
	 * must envoke drawOn method to draw this spaceship.
	 *
	 * @param point
	 *            -- center point of the given spaceship
	 */
	public void moveTo(Point point) {
		Point previous = new Point(this.x, this.y);
		this.x = point.x;
		this.y = point.y;
	}

}
