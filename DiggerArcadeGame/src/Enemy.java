import java.awt.geom.Point2D;


/**
 *The enemy of the Digger game
 *
 * @author goldacbj.
 *         Created Feb 10, 2015.
 */
public interface Enemy {

	/**
	 * updates the position of the monster by the specified amount in the
	 * x direction and y direction 
	 *
	 */
	public void updatePosition(int x, int y);
	
	/**
	 * returns the positon of the enemy
	 *
	 * @return
	 */
	public Point2D getPosition();
	
	/**
	 * returns if the enemy is alive 
	 *
	 * @return
	 */
	public boolean isAlive();
	
	/**
	 * kills the enemy
	 *
	 */
	public void dead();
	
	/**
	 * 
	 * resets the enemy to the sarting position
	 *
	 */
	public void resetPositoin();
}
