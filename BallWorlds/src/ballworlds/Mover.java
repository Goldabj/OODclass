package ballworlds;

import java.awt.Color;
import java.awt.geom.Point2D;

import util.Random;

/**
 * A Mover is a ball that moves a given velocity
 *
 * @author goldacbj. Created Jan 29, 2015.
 */
public class Mover extends Ball {

	private static final double DIAMETER = 25;
	private double xVeloicty;
	private double yVelocity;

	/**
	 * 
	 * Constructs the mover with a random X and Y velocity, which is between -2
	 * and 2.
	 *
	 * @param world
	 */
	public Mover(BallEnvironment world) {
		super(world);
		this.xVeloicty = Random.randInterval(-2, 2);
		this.yVelocity = Random.randInterval(-2, 2);
	}

	@Override
	public Color getColor() {
		return Color.DARK_GRAY;
	}

	@Override
	public void updatePosition() {
		super.moveTo(new Point2D.Double(super.getCenterPoint().getX()
				+ this.xVeloicty, super.getCenterPoint().getY()
				+ this.yVelocity));

	}

	@Override
	public void updateSize() {
		// stays the same size

	}

	@Override
	public void updateColor() {
		// stays the same color

	}

	@Override
	public double getDiameter() {
		return DIAMETER;
	}

}
