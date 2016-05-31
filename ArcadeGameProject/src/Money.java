import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;

/**
 * The money bags of the digger game, they can be moved, and they can be broken
 * open and collected
 *
 * @author goldacbj. Created Feb 10, 2015.
 */
public class Money extends Entity {
	private int startingX;
	private int startingY;
	private static final int VALUE = 50;
	private boolean isOpen;
	private int timer = 10;
	private BufferedImage openMoneyImage;
	private boolean isLethal = false;

	/**
	 * Constucts a bag of money at the given positoin
	 *
	 * @param statingPoint
	 */
	public Money(int startingX, int startingY) {
		super(startingX, startingY);
		this.startingX = startingX;
		this.startingY = startingY;
		this.isOpen = false;
		this.color = Color.YELLOW;

		try {
			this.image = ImageIO.read(new File(Main.path + "images/sand.png"));
			// need to get a better image still
			this.openMoneyImage = ImageIO.read(new File(Main.path
					+ "images/closedmoney.jpg"));
		} catch (IOException exception) {
			System.out.println("ERROR: money image not found");
		}
	}

	/**
	 * drops the money if there is no dirt beneth it
	 *
	 * @param empties
	 */
	public void updateMoney(ArrayList<Empty> empties) {
		try {
			this.image = ImageIO.read(new File(Main.path + "images/sand.png"));
			// need to get a better image still
			this.openMoneyImage = ImageIO.read(new File(Main.path
					+ "images/closedmoney.jpg"));
		} catch (IOException exception) {
			System.out.println("ERROR: money image not found");
		}
		
		this.isLethal = isEmpty(empties, this.x, this.y + 1);
		if (this.isLethal) {
			if (this.timer == 0) {
				isOpen(empties);
				this.move(0, 1);
			} else {
				this.timer--;
				// wiggle();
			}
		} else {
			this.timer = 10;
		}
	}

	public void wiggle() {
		double rand = Math.random();
		if (rand > 0.5) {
			this.move(-1 / 10, 0);
		} else {
			this.move(1 / 10, 0);
		}
		this.x = this.startingX;
		this.y = this.startingY;

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
	 * returns true if the bag of money has been opened (has atleast two
	 * consecutive empty block below it)
	 *
	 * @return
	 */
	public boolean isOpen(ArrayList<Empty> empties) {
		if (isEmpty(empties, this.x, this.y + 2)
				&& isEmpty(empties, this.x, this.y + 1)) {
			this.isOpen = true;
		}
		return this.isOpen;
	}

	/**
	 * Opens the money
	 *
	 */
	public void Open() {
		this.isOpen = true;
	}

	/**
	 * returns the open money images
	 *
	 * @return
	 */
	public BufferedImage getOpenMoneyImage() {
		return this.openMoneyImage;
	}

	/**
	 * returns if the money is falling
	 *
	 * @param emties
	 * @return
	 */
	public boolean isLethal(ArrayList<Empty> emties) {
		this.isLethal = isEmpty(emties, this.x, this.y + 1);
		return this.isLethal;
	}

}
