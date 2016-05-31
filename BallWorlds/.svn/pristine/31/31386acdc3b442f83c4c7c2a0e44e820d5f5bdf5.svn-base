package ballworlds;

import java.awt.Color;
import java.awt.geom.Point2D;

import util.Random;

/**
 * A ball that moves and grows in size at the same time. Then when it reaches a
 * max size of between 2 and 10 times the orignal size, it "Explodes" -- the
 * ball disapears and two new balls are born in that spot
 *
 * @author goldacbj. Created Jan 29, 2015.
 */
public class Exploder extends AbstractBouncer {

	private double diameter;
	private double sizeMax;

	/**
	 * 
	 * Constructs the original exploder with a diameter of 25
	 *
	 * @param world-- world where the ball is drawn on
	 */
	public Exploder(BallEnvironment world) {
		super(world);
		this.diameter = 25;
		this.sizeMax = this.diameter * (Random.randInterval(2, 10));
	}

	/**
	 * Creates the "child" Exploders, with a diamter of 25, and in the positon
	 * of where the parent Exploder "Exploded"
	 * 
	 * @param world
	 * @param centerPoint -- centerPoint of the balls
	 */
	public Exploder(BallEnvironment world, Point2D centerPoint) {
		super(world);
		this.diameter = 25;
		this.sizeMax = this.diameter * (Random.randInterval(2, 10));
		super.setCenterPoint(centerPoint);
	}

	@Override
	public Color getColor() {
		return Color.CYAN;
	}

	@Override
	public void updateSize() {
		if (this.diameter >= this.sizeMax) {
			super.die();
			super.getWorld().addBall(
					new Exploder(super.getWorld(), super.getCenterPoint()));
			super.getWorld().addBall(
					new Exploder(super.getWorld(), super.getCenterPoint()));
		}
		this.diameter += .5;

	}

	@Override
	public void updateColor() {
		// stays the same color

	}

	@Override
	public double getDiameter() {
		return this.diameter;
	}

}
