import java.awt.geom.Point2D;

/**
 * The money bags of the digger game, they can be moved, and they 
 * can be broken open and collected
 *
 * @author goldacbj.
 *         Created Feb 10, 2015.
 */
public class Money {
	private Point2D startingPositon;
	private Point2D currentPositon;
	private static final int VALUE = 50;
	private boolean isOpen;
	private boolean isCollected;
	
	/**
	 * Constucts a bag of money at the given positoin
	 *
	 * @param statingPoint
	 */
	public Money(int startingX, int startingY) {
		this.startingPositon = new Point2D.Double(startingX, startingY);
		this.currentPositon = this.startingPositon;
		this.isCollected = false;
		this.isOpen = false;
	}
	
	/**
	 * moves the bag of money in the given x and y direction
	 *
	 * @param x
	 * @param y
	 */
	public void move(int x, int y) {
		this.currentPositon = new Point2D.Double(this.currentPositon.getX() + x, this.currentPositon.getY() + y);
	}
	
	/**
	 * returns the value of the money
	 *
	 * @return
	 */
	public int getValue() {
		return this.VALUE;
	}
	
	/**
	 * returns the position of the bag of money
	 *
	 * @return
	 */
	public Point2D getPosition() {
		return this.currentPositon;
	}
	
	
	/**
	 * returns true if the money has been collected
	 *
	 * @return
	 */
	public boolean isCollected() {
		return this.isCollected;
	}
	
	/**
	 * returns true if the bag of money has been opened
	 *
	 * @return
	 */
	public boolean isOpen() {
		return this.isOpen;
	}

	
}
