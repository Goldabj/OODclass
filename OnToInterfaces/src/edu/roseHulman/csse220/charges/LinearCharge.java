package edu.roseHulman.csse220.charges;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;

public class LinearCharge implements Charge {
	private static final int NUMBER_OF_STEPS = 100;
	private double startX;
	private double startY;
	private double endX;
	private double endY;
	private double charge;

	public LinearCharge(double startX, double startY, double endX, double endY, double charge){
		this.startX = startX;
		this.startY = startY;
		this.endX = endX;
		this.endY = endY;
		this.charge = charge;
		
	}
	
	@Override
	public Vector forceAt(int x, int y) {
		// TODO Auto-generated method stub.
		double px = this.startX;
		double py = this.startY;
		double stepX = (this.endX - this.startX) / LinearCharge.NUMBER_OF_STEPS;
		double stepY = (this.endY - this.startY) / LinearCharge.NUMBER_OF_STEPS;
		double partialCharge = this.charge / LinearCharge.NUMBER_OF_STEPS + 1;
		
		Vector force = Vector.ZERO;
		for(int i = 0; i <= LinearCharge.NUMBER_OF_STEPS; i++) {
			PointCharge smallCharge = new PointCharge(px, py, partialCharge);
			Vector partailForce  = smallCharge.forceAt(x, y);
			force = force.add(partailForce);
			px += stepX;
			py += stepX;
		}
		
		return force;
	}

	@Override
	public void drawOn(Graphics2D g) {
		Point2D start = new Point2D.Double(this.startX, this.startY);
		Point2D end = new Point2D.Double(this.endX, this.endY);
		Line2D line = new Line2D.Double(start, end);
		
		if(this.charge >= 0) {
			g.setColor(Color.BLUE);
		}else {
			g.setColor(Color.RED);
		}
		
		g.draw(line);

	}

}
