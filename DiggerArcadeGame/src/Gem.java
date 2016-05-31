import java.awt.geom.Point2D;

/**
 * The Gems of the the digger game, they are in every level and must
 * be collected to win. they dont move
 * 
 * @author goldacbj.
 *         Created Feb 9, 2015.
 */
public class Gem {
	private Point2D position;
	static final int VALUE = 100;
	private boolean isCollected;

	/**
	 * Constructs a Gem in the given position
	 *
	 * @param positoin
	 */
	public Gem(int positionX, int positionY) {
		this.position = new Point2D.Double(positionX, positionY);
		this.isCollected = false;
	}
	
	/**
	 * returns the value of the gem
	 *
	 * @return
	 */
	public static int getValue() {
		return VALUE;
	}
	
	/**
	 * returns the positon of the gem.
	 *
	 * @return
	 */
	public Point2D getPosition() {
		return this.position;
	}
	
	/**
	 * returns true if the gem has been collected
	 *
	 */
	public boolean isCollected() {
		return this.isCollected;
	}
	
	/**
	 * Changes isCollected to true if it has been collected
	 *
	 */
	public void collected() {
		this.isCollected = true;
	}
}
