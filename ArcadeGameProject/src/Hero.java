import java.awt.Color;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;

/**
 * 
 * The Hero of the digger game, he can move, collect gems and money and he can
 * fire a gun
 *
 * @author goldacbj. Created Feb 9, 2015.
 */
public class Hero extends Entity {
	private boolean isAlive = true;
	private int lives = 3;
	private int startX;
	private int startY;
	private int xVelo = 0;
	private int yVelo = 0;
	private boolean isWeaponReady = true;
	public Weapon weapon;

	/**
	 * Consturcts the hero in a given position with three lives
	 *
	 */
	public Hero(int startingX, int startingY) {
		super(startingX, startingY);
		this.startX = startingX;
		this.startY = startingY;
		this.color = Color.blue;
		this.weapon = new Weapon(this.getX(), this.getY());
		try {
			this.image = ImageIO.read(new File(Main.path + "images/face.jpg"));
		} catch (IOException exception) {
			System.out.println("ERROR: closed money image not found");
		}
	}

	/**
	 * moves the hero if the hero is able to move
	 *
	 * @param boardWidth
	 *            -- width of the gameboard
	 * @param boardLength
	 *            -- lenght of the gameboard
	 * @param money
	 *            -- money in the digger game
	 * @param empties
	 *            -- empty entities in the digger game
	 */
	public void updateHero(int boardWidth, int boardLength,
			ArrayList<Money> money, ArrayList<Empty> empties) {
		Money leftMoney = null;
		Money rightMoney = null;
		Money upMoney = null;
		Money downMoney = null;
		
		try {
			this.image = ImageIO.read(new File(Main.path + "images/face.jpg"));
		} catch (IOException exception) {
			System.out.println("ERROR: closed money image not found");
		}
		
		for (int i = 0; i < money.size(); i++) {
			Money m = money.get(i);
			if (!m.isOpen(empties) && !m.isLethal(empties)) {
				if (m.getX() == this.x - 1 && m.getY() == this.y) {

					leftMoney = m;
				}
				if (m.getX() == this.x + 1 && m.getY() == this.y) {
					rightMoney = m;
				}
				if (m.getX() == this.x && m.getY() == this.y - 1) {
					upMoney = m;
				}
				if (m.getX() == this.x && m.getY() == this.y + 1) {
					downMoney = m;
				}
			}
		}

		if (this.xVelo < 0 && this.x > 0) {
			if (leftMoney == null) {
				this.x += this.xVelo;
			} else if (this.x > 2) {
				this.x += this.xVelo;
			}
		}
		if (this.xVelo > 0 && this.x < boardWidth) {
			if (rightMoney == null) {
				this.x += this.xVelo;
			} else if (this.x < boardWidth - 2) {
				this.x += this.xVelo;
			}
		}
		if (this.yVelo < 0 && this.y > 0) {
			if (upMoney == null) {
				this.y += this.yVelo;
			} else if (this.y > 2) {
				this.y += this.yVelo;
			}
		}
		if (this.yVelo > 0 && this.y < boardLength) {
			if (downMoney == null) {
				this.y += this.yVelo;
			} else if (this.y < boardLength - 2) {
				this.y += this.yVelo;
			}

		}

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
		this.isAlive = false;

	}

	/**
	 * fires the weapon if it is ready to use and in the direction of the hero.
	 *
	 */
	public void fireWeapon() {
		if (isWeaponLoaded()) {
			this.weapon.fired = true;
		}
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
		this.x = this.startX;
		this.y = this.startY;
		this.isAlive = true;
	}

	/**
	 * sets the velocity of the hero in the x and y directions
	 *
	 * @param x
	 * @param y
	 */
	public void setVelocity(int x, int y) {
		this.xVelo = x;
		this.yVelo = y;
	}

	/**
	 * returns the XVelocity of the hero
	 * 
	 * @return
	 */
	public int getXVelocity() {
		return this.xVelo;
	}

}
