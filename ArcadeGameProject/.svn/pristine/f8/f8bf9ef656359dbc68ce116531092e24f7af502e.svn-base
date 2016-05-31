import java.util.ArrayList;

/**
 * A empty block is an Entity that anything can move thorugh
 *
 * @author goldacbj. Created Feb 20, 2015.
 */
public class Empty extends Entity {
	private ArrayList<Empty> neighbors = new ArrayList<>();

	/**
	 * Constructs and empty block in the given x and y positions
	 *
	 * @param x
	 * @param y
	 */
	public Empty(int x, int y) {
		super(x, y);

	}

	/**
	 * adds a neighboring empty block to the array
	 *
	 * @param empty
	 */
	public void setNeighbor(Empty empty) {
		this.neighbors.add(empty);

	}

	/**
	 * returns all the the neighboring empyt block of the current empyt block
	 *
	 * @return
	 */
	public ArrayList<Empty> getNeighbors() {

		return this.neighbors;
	}

	/**
	 * asses if the given empty block is a neighbor of this empyt
	 *
	 * @param empty
	 * @return
	 */
	public boolean isNeighbor(Empty empty) {
		for (Empty e : this.neighbors) {
			if (e.equals(empty)) {

				return true;
			}

		}

		return false;
	}

}
