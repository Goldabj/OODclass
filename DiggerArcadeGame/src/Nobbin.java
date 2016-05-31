import java.awt.geom.Point2D;

/**
 * A nobbin in the digger game tires to kill the hero and can only move
 * in paths that have been cleared.
 *
 * @author goldacbj.
 *         Created Feb 10, 2015.
 */
public class Nobbin implements Enemy {
	private	static final int SPEED = 7;
	private boolean isAlive;
	private Point2D startingPosition;
	private Point2D currentPosition;
	
	/**
	 * constructs the nobbin in the current positon
	 *
	 * @param startingPositon
	 */
	public Nobbin(int startingX, int startingY) {
		this.startingPosition = new Point2D.Double(startingX, startingY);
		this.currentPosition = this.startingPosition;
		this.isAlive = true;
	}
	

	@Override
	public void updatePosition(int x, int y) {
		this.currentPosition = new Point2D.Double(this.currentPosition.getX() + x, this.currentPosition.getY() + y);

	}

	@Override
	public Point2D getPosition() {
		return this.currentPosition;
	}

	@Override
	public boolean isAlive() {
		return this.isAlive;
	}

	@Override
	public void dead() {
		this.isAlive = false;

	}

	@Override
	public void resetPositoin() {
		this.currentPosition = this.startingPosition;
		
	}

}
