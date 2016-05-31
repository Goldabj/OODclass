import java.awt.Color;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;

/**
 * A nobbin in the digger game tires to kill the hero and can only move in paths
 * that have been cleared.
 *
 * @author goldacbj. Created Feb 10, 2015.
 */
public class Nobbin extends Entity {
	private static final int SPEED = 7;
	private boolean isAlive;

	private int timer = 2;

	private int startingX;
	private int startingY;
	private Entity last;
	private ArrayList<Entity> lasts = new ArrayList<>();

	/**
	 * constructs the nobbin in the current positon
	 *
	 * @param startingPositon
	 */
	public Nobbin(int x, int y) {
		super(x, y);
		this.startingX = x;
		this.startingY = y;
		this.isAlive = true;
		this.color = Color.red;
		this.last = new Entity(x, y);
		this.lasts.add(new Entity(x, y));

		try {
			this.image = ImageIO
					.read(new File(Main.path + "images/nobbin.png"));
		} catch (IOException exception) {
			System.out.println("ERROR: closed money image not found");
		}
	}

	/**
	 * has the nobbin move toward the hero if it is able to
	 *
	 * @param empties
	 * @param hero
	 */
	public void updateNobbin(ArrayList<Empty> empties, Hero hero) {
		if (this.timer == 0) {

			if (neighborCount(empties) == 1) {
				int tempX = this.x;
				int tempY = this.y;
				this.x = this.last.getX();
				this.y = this.last.getY();

				this.last = new Entity(tempX, tempY);

				if (this.last.Equals(this)) {
					Entity e = getNext(empties);
					this.x = e.getX();
					this.y = e.getY();

				}

			} else if (neighborCount(empties) == 2) {

				Entity next = getNext(empties);
				this.last = new Entity(this.x, this.y);
				this.x = next.getX();
				this.y = next.getY();

			} else {

				Entity next = choosePath(empties);
				this.lasts.add(next);
				this.last = new Entity(this.x, this.y);

				this.x = next.getX();
				this.y = next.getY();

			}

			if (this.lasts.size() > 500) {
				this.lasts.remove(this.lasts.size() - 1);

			}

			if (this.x == hero.getX() && this.y == hero.getY()) {
				hero.died();

			}

			this.timer = 2;

		} else {

			this.timer--;
		}

		if (this.lasts.size() > 50) {
			this.lasts.clear();
		}

	}

	/**
	 * creates a path for the nobbin to travel to get to the hero
	 *
	 * @param empties
	 * @return
	 */
	public Entity choosePath(final ArrayList<Empty> empties) {
		ArrayList<Empty> paths = new ArrayList<>();

		for (Empty e : empties) {
			boolean isLast = false;

			for (Entity e2 : this.lasts) {
				if (e.Equals(e2)) {
					isLast = true;

				}
			}

			if (!e.Equals(this.last) && !isLast) {
				if (e.Equals(new Empty(this.x - 1, this.y))) {
					paths.add(e);

				} else if (e.Equals(new Empty(this.x + 1, this.y))) {
					paths.add(e);

				} else if (e.Equals(new Empty(this.x, this.y - 1))) {
					paths.add(e);

				} else if (e.Equals(new Empty(this.x, this.y + 1))) {
					paths.add(e);

				}

			}

		}

		if (paths.size() == 0) {
			this.lasts.remove(removeALast());

			return choosePath(empties);
		}

		return paths.get((int) (Math.random() * (paths.size() - 1)));

	}

	/**
	 * removes the enitiy that he nobbin was last at from the specifed path it
	 * is to go. this way it does not get stuck going in circles
	 *
	 * @return
	 */
	public Entity removeALast() {
		ArrayList<Entity> e = new ArrayList<>();
		for (Entity l : this.lasts) {
			if (l.Equals(new Entity(this.x + 1, this.y))) {
				e.add(l);

			} else if (l.Equals(new Entity(this.x - 1, this.y))) {
				e.add(l);

			} else if (l.Equals(new Entity(this.x, this.y + 1))) {
				e.add(l);

			} else if (l.Equals(new Entity(this.x, this.y - 1))) {
				e.add(l);

			}

		}

		return e.get((int) (Math.random() * (e.size() - 1)));

	}

	/**
	 * returns the next empty entity next the nobbin
	 *
	 * @param empties
	 * @return
	 */
	public Entity getNext(ArrayList<Empty> empties) {
		for (Empty e : empties) {
			if (!e.Equals(this.last)) {
				if (e.Equals(new Empty(this.x - 1, this.y))) {

					return e;
				}

				if (e.Equals(new Empty(this.x + 1, this.y))) {

					return e;
				}

				if (e.Equals(new Empty(this.x, this.y - 1))) {

					return e;
				}

				if (e.Equals(new Empty(this.x, this.y + 1))) {

					return e;
				}

			}

		}

		return null;

	}

	/**
	 * returns the number of neighboring empty entites next the Nobbin
	 *
	 * @param empties
	 * @return
	 */
	public int neighborCount(ArrayList<Empty> empties) {
		int neighbors = 0;

		if (isEmpty(empties, this.x + 1, this.y)) {
			neighbors++;

		}

		if (isEmpty(empties, this.x - 1, this.y)) {
			neighbors++;

		}

		if (isEmpty(empties, this.x, this.y + 1)) {
			neighbors++;

		}

		if (isEmpty(empties, this.x, this.y - 1)) {
			neighbors++;

		}

		return neighbors;
	}

	/**
	 * moves the Nobbin in the new specified x and y directoins
	 *
	 * @param newX
	 * @param newY
	 */
	public void updatePosition(int newX, int newY) {
		this.x = newX;
		this.y = newY;

	}

	/**
	 * resets the nobbin the starting x and y positions
	 *
	 */
	public void resetPositoin() {
		this.x = this.startingX;
		this.y = this.startingY;

	}

}
