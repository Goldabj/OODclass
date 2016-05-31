import java.awt.geom.Point2D;

/**
 * 
 * The Hero of the digger game, he can move, collect gems and money
 * and he can fire a gun
 *
 * @author goldacbj.
 *         Created Feb 9, 2015.
 */
public class Hero {
	private boolean isAlive;
	private int lives;
	private Point2D currentPosition;
	private Point2D startingPosition;
	private boolean isWeaponReady;
	private static final int SPEED = 5;
	
	/**
	 * Consturcts the hero in a given position with three lives
	 *
	 */
	public Hero(int startingX, int startingY) {
		this.startingPosition = new Point2D.Double(startingX, startingY);
		this.currentPosition = this.startingPosition;
		this.lives = 3;
		this.isAlive = true;
		this.isWeaponReady = true;
	}
	
	/**
	 * returns if the hero is alive or not.
	 *
	 * @return
	 */
	public boolean isAlive() {
		return this.isAlive;
	}
	
	/**
	 * returns the amount of lives the hero has left
	 *
	 * @return
	 */
	public int getLives() {
		return this.lives;
	}
	
	/**
	 * removes a life from the hero
	 *
	 */
	public void died() {
		this.lives--;
		if(this.lives == 0) {
			this.isAlive = false;
		}
	}
	
	/**
	 * returns the position of the hero
	 *
	 * @return
	 */
	public Point2D getPositon() {
		return this.currentPosition;
	}
	
	/**
	 * fires the weapon if it is ready to use and in the direction of the hero.
	 *
	 */
	public void fireWeapon() {
		if(isWeaponLoaded()){
			Weapon gun = new Weapon(this.getDirection());
			
		}
	}
	/**
	 * 
	 * Gets direction of hero based upon its previous movements.
	 *
	 * @return
	 */
	public String getDirection(){
		return null;
		
	}
	
	/**
	 * returns true if the weapon has been recharged
	 * 
	 * @return
	 */
	public boolean isWeaponLoaded() {
		return this.isWeaponReady;
	}
	
	/**
	 * resets the hero to his starting Positon
	 *
	 */
	public void resetPosition() {
		this.currentPosition = this.startingPosition;
	}
	
	/**
	 * sets the hero to the new starting position
	 *
	 * @param startingPositon
	 */
	public void setStartingPosition(Point2D startingPosition) {
		this.startingPosition = startingPosition;
	}
	
	/**
	 * moves the Hero in the specified x and y direction
	 *
	 */
	public void move(int x, int y) {
		double currentX = this.currentPosition.getX();
		double currentY = this.currentPosition.getY();
		this.currentPosition = new Point2D.Double(currentX + x, currentY +y);
	}

}
