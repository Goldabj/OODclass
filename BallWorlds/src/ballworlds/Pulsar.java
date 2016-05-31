package ballworlds;

import java.awt.Color;
import java.awt.geom.Point2D;

import util.Random;

/**
 * 
 * A Pulsar is a ball that changes colors slowly from white to black, then back
 * to white
 *
 * @author goldacbj. Created Jan 29, 2015.
 */
public class Pulsar extends Ball {

	private static final double DIAMETER = 25;
	private int brightness;
	private boolean isGettingLighter;

	/**
	 * Contructs a white ball that is changing to black in a random spot on the
	 * BallEnvironment
	 *
	 * @param world
	 *            -- BallEnviroment where the ball is drawn on
	 */
	public Pulsar(BallEnvironment world) {
		super(world);
		double xPosition = Random.randInterval(0, world.getSize().getWidth());
		double yPosition = Random.randInterval(0, world.getSize().getHeight());
		super.setCenterPoint(new Point2D.Double(xPosition, yPosition));
		this.brightness = 255;
		this.isGettingLighter = true;
	}

	@Override
	public Color getColor() {
		Color color = new Color(this.brightness, this.brightness,
				this.brightness);
		return color;
	}

	@Override
	public void updatePosition() {
		// Doesn't move

	}

	@Override
	public void updateSize() {
		// Stays the same size

	}

	@Override
	public void updateColor() {
		if (this.brightness >= 255) {
			this.isGettingLighter = false;
		}
		if (this.brightness == 0) {
			this.isGettingLighter = true;
		}
		if (this.isGettingLighter) {
			this.brightness++;
		} else {
			this.brightness--;
		}

	}

	@Override
	public double getDiameter() {
		return DIAMETER;
	}

}
