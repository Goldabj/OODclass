package ballworlds;

import java.awt.geom.Point2D;

import util.Random;

/**
 * A ball that bounces off the walls.
 * 
 * @author Curt Clifton. Created Jan 22, 2011.
 */
public abstract class AbstractBouncer extends Ball {
	private double velocityX;
	private double velocityY;

	/**
	 * Constructs a abstract bouncer in the given world.
	 * 
	 * @param world
	 */
	public AbstractBouncer(BallEnvironment world) {
		super(world);
		this.velocityX = Random.randInterval(-2, 2);
		this.velocityY = Random.randInterval(-2, 2);
	}

	@Override
	public void updatePosition() {
		// creates new points
		double updatedX = super.getCenterPoint().getX() + this.velocityX;
		double updatedY = super.getCenterPoint().getY() + this.velocityY;
		Point2D.Double updatedPoint = new Point2D.Double(updatedX, updatedY);
		// checks to see if these points are in the world
		if (!(super.getWorld().isInsideWorldX(updatedPoint))) {
			this.velocityX = -1 * this.velocityX;
		}
		if (!(super.getWorld().isInsideWorldY(updatedPoint))) {
			this.velocityY = -1 * this.velocityY;
		}
		// moves the center to the new position
		super.moveTo(new Point2D.Double(updatedX, updatedY));

	}
}
