import java.awt.Color;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

/**
 * An Entity is an object that can be modified during the playing of the Digger
 * Game
 *
 * @author goldacbj. Created Feb 20, 2015.
 */
public class Entity {
	protected int x;
	protected int y;
	protected Color color;
	protected BufferedImage image;

	/**
	 * Constructs and entity in the given x and y position
	 *
	 * @param x
	 * @param y
	 */
	public Entity(int x, int y) {
		this.x = x;
		this.y = y;
		this.color = Color.black;
	}

	/**
	 * returns the x position of the entity
	 *
	 * @return
	 */
	public int getX() {

		return this.x;
	}

	/**
	 * returns the y position of the entity
	 *
	 * @return
	 */
	public int getY() {

		return this.y;
	}

	/**
	 * returns the color of the entity
	 *
	 * @return
	 */
	public Color getColor() {

		return this.color;
	}

	/**
	 * moves the entity by the specified x and y amounts
	 *
	 * @param x2
	 * @param y2
	 */
	public void move(int x2, int y2) {
		this.x += x2;
		this.y += y2;

	}

	/**
	 * returns the Buffered Image of the entity
	 *
	 * @return
	 */
	public BufferedImage getImage() {

		return this.image;
	}

	/**
	 * returns true if this entity is the same as the compared Entity
	 *
	 * @param e
	 * @return
	 */
	public boolean Equals(Entity e) {
		if (e.getX() == this.x && e.getY() == this.y) {

			return true;
		}

		return false;
	}

	/**
	 * returns true if the entity at the specified x and y position is a empyt
	 * entity
	 *
	 * @param empties
	 *            -- array list of empties
	 * @param x
	 * @param y
	 * @return
	 */
	public static boolean isEmpty(ArrayList<Empty> empties, int x, int y) {
		for (Empty e : empties) {
			if (e.getX() == x && e.getY() == y) {

				return true;
			}

		}

		return false;
	}

	/**
	 * returns true if the entity at the x and y position is Dirt
	 *
	 * @param dirt
	 * @param x
	 * @param y
	 * @return
	 */
	public static boolean isDirt(ArrayList<Dirt> dirt, int x, int y) {
		for (Dirt d : dirt) {
			if (d.getX() == x && d.getY() == y) {

				return true;
			}

		}
		return false;
	}

}
