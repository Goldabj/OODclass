import java.awt.geom.Point2D;


public class Hobbin implements Enemy {
	private Point2D startingPosition;
	private Point2D currentPosition;
	private static final int SPEED = 7;
	private boolean isAlive;
	
	/**
	 * Constucts a hobbin in the given position;
	 *
	 * @param statingPositoin
	 */
	public Hobbin(int startingX, int startingY) {
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
