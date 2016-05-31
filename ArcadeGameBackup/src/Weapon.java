import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;

/**
 * The Weapon is a weapon of the Hero in the digger game. It is set with the
 * space bar and destroys all neighboring block
 *
 * @author goldacbj. Created Feb 20, 2015.
 */
public class Weapon extends Entity {
	private int startX;
	private int startY;
	protected boolean fired;
	protected int timer;

	/**
	 * construcs a weapon in the specified x and y positoin
	 *
	 * @param x
	 * @param y
	 */
	public Weapon(int x, int y) {
		super(x, y);
		this.timer = 10;
		this.startX = x;
		this.startY = y;
		this.fired = false;
		try {
			this.image = ImageIO.read(new File("images/tnt.jpg"));
		} catch (IOException exception) {
			System.out.println("ERROR: closed money image not found");
		}
	}

	/**
	 * removes the weapon
	 *
	 */
	public void remove() {
		this.image = null;
	}

	/**
	 * moves the weapon to the specified x and y positon
	 *
	 * @param dirt
	 * @param hero
	 */
	public void move(ArrayList<Dirt> dirt, Hero hero) {
		if (!this.fired) {
			this.x = hero.getX();
			this.y = hero.getY();
		}
	}
}
