import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Point2D;

import javax.swing.JComponent;

/**
 * TODO Put here a description of what this class does.
 *
 * @author goldacbj.
 *         Created Dec 17, 2014.
 */
public class FacesComponent extends JComponent {

	/**
	 * TODO Put here a description of what this constructor does.
	 *
	 */
	@Override
	protected void paintComponent(Graphics graphics) {
		super.paintComponent(graphics);
		
		Graphics2D graphics2 = (Graphics2D) graphics;
		
		// this.testDrawing(graphics2);
		this.testFaceDrawing(graphics2);

		this.testTransforming(graphics2);
	}

	/**
	 * Tests that two circles (one drawn, one filled) appear on the given
	 * Graphics2D object.
	 */
	private void testDrawing(Graphics2D graphics2) {
		// A red circle for testing
		Ellipse2D.Double circle = new Ellipse2D.Double(10, 10, 100, 100);

		graphics2.setColor(Color.red);
		graphics2.draw(circle);

		// A smaller filled blue circle for testing
		circle.x += 150;
		circle.width -= 50;
		circle.height -= 50;
		graphics2.setColor(Color.blue);
		graphics2.fill(circle);
	}

	/**
	 * Tests that Faces are drawn correctly on the given Graphics2 object.
	 */
	private void testFaceDrawing(Graphics2D graphics2) {
		Faces face = new Faces();
		face.drawOn(graphics2);

		face = new Faces(25, 25, 25, 0, Color.red, Color.green, Color.blue,
				Color.black);
		face.drawOn(graphics2);

		face = new Faces(125, 100, 25, 0, Color.black, Color.blue, Color.red,
				Color.blue);
		face.drawOn(graphics2);

		face = new Faces(200, 100, 50, 0, Color.black, Color.red, Color.green,
				Color.yellow);
		face.drawOn(graphics2);

		face = new Faces(300, 100, 25, 0, Color.black, Color.yellow, Color.blue,
				Color.green);
		face.drawOn(graphics2);
	}

	/**
	 * Tests that Faces are tranlated and rotated and then drawn correctly on
	 * the given Graphics2 object.
	 */
	private void testTransforming(Graphics2D graphics2) {
		final int numberOfFacesToTransform = 7;
		final Point2D center = new Point2D.Double(50, 200);
		final double radius = 25;
		final double angleToRotate = 0;
		Faces face = new Faces(center.getX(), center.getY(), radius,
				angleToRotate, Color.yellow, Color.black, Color.black,
				Color.black);

		for (int k = 0; k < numberOfFacesToTransform; ++k) {
			face.drawOn(graphics2);
			face.translate(2 * radius + 10, 20);
			face.rotate(30);
		}
	}
}

