package ballworlds;

import java.awt.Color;
import java.awt.geom.Point2D;

public class SpecialBall extends AbstractBouncer {
	private double diameter;
	private double diameterMin;
	private Color color;

	public SpecialBall(BallEnvironment world) {
		super(world);
		this.diameter = 40;
		this.diameterMin = this.diameter * Math.random() + .1;
		this.color = Color.MAGENTA;
	}
	
	public SpecialBall(BallEnvironment world, Point2D centerPoint) {
		super(world);
		this.diameter = 40;
		this.diameterMin = this.diameter * Math.random() + .1;
		this.color = Color.MAGENTA;
		super.setCenterPoint(centerPoint);
	}

	@Override
	public Color getColor() {
		return this.color;
	}

	@Override
	public void updateSize() {
		if (this.diameter <= this.diameterMin) {
			super.die();
			super.getWorld().addBall(
					new SpecialBall(super.getWorld(), super.getCenterPoint()));
			super.getWorld().addBall(
					new SpecialBall(super.getWorld(), super.getCenterPoint()));
		}
		this.diameter -= .5;

	}

	@Override
	public void updateColor() {
		this.color = new Color((int) Math.random() * 255,
				(int) Math.random() * 255, (int) Math.random() * 255);
	}

	@Override
	public double getDiameter() {
		return this.diameter;
	}

}
