import java.awt.Color;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;

/**
 * A Hobbin is an enemy in the digger game. the Hobbin can move through dirt to
 * get to the hero
 *
 * @author goldacbj. Created Feb 20, 2015.
 */
public class Hobbin extends Entity {
	private int startingX;
	private int startingY;
	private int timer = 2;

	/**
	 * Constucts a hobbin in the given position;
	 *
	 * @param statingPositoin
	 */
	public Hobbin(int startingX, int startingY) {
		super(startingX, startingY);
		this.startingX = startingX;
		this.startingY = startingY;
		this.color = Color.WHITE;
		try {
			this.image = ImageIO.read(new File(Main.path
					+ "images/skeleton.jpg"));
		} catch (IOException exception) {
			System.out.println("ERROR: closed money image not found");
		}
	}

	/**
	 * resets the Hobbin to the starting position
	 *
	 */
	public void resetPositoin() {
		this.x = this.startingX;
		this.y = this.startingY;
	}

	/**
	 * moves the Hobbin if it is allow to move
	 *
	 * @param hero
	 *            -- hero of current digger game
	 * @param money
	 *            -- money in digger game
	 * @param empties
	 *            -- empty entities in the digger game
	 */
	public void updateHobbin(Hero hero, ArrayList<Money> money,
			ArrayList<Empty> empties) {
		Money leftMoney = null;
		Money rightMoney = null;
		Money upMoney = null;
		Money downMoney = null;
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

		if (this.timer == 0) {
			if (this.x < hero.getX() && rightMoney == null) {
				this.x += 1;

			} else if (this.x > hero.getX() && leftMoney == null) {
				this.x -= 1;
			} else {
				if (this.y > hero.getY() && upMoney == null) {
					this.y--;

				} else if (this.y < hero.getY() && downMoney == null) {
					this.y++;
				}
			}
			this.timer = 2;

		} else {
			this.timer--;

		}

	}
}
