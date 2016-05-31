import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;

import org.junit.Test;

/**
 * Tests GameOfLife.
 * 
 * @author Curt Clifton. Created Sep 24, 2008.
 */
public class GameOfLifeTest {

	/**
	 * Test method for {@link GameOfLife#GameOfLife(java.util.ArrayList)} and
	 * {@link GameOfLife#isOccupied(int, int)}.
	 */
	@Test
	public void testGameOfLife() {

		Coordinates randomCoordinate = new Coordinates(40, 50);
		ArrayList<Coordinates> coordinatesList = new ArrayList<>();
		coordinatesList.add(randomCoordinate);
		GameOfLife game = new GameOfLife(coordinatesList);

		assertTrue(game.isOccupied(40, 50));
		assertFalse(game.isOccupied(39, 49));
		assertFalse(game.isOccupied(39, 50));
		assertFalse(game.isOccupied(39, 51));
		assertFalse(game.isOccupied(40, 49));
		assertFalse(game.isOccupied(40, 51));
		assertFalse(game.isOccupied(41, 49));
		assertFalse(game.isOccupied(41, 50));
		assertFalse(game.isOccupied(41, 51));
	}

	/**
	 * Test method for {@link GameOfLife#getNeighborCount(int, int)}.
	 */
	@Test
	public void testGetNeighborCount() {

		Coordinates randomCoordinate = new Coordinates(20, 20);
		Coordinates randomCoordinate2 = new Coordinates(19, 20);
		Coordinates randomcoordinate3 = new Coordinates(20, 21);
		Coordinates randomCoordinate4 = new Coordinates(20, 19);
		Coordinates randomCoordinate5 = new Coordinates(50, 50);
		ArrayList<Coordinates> coordinateList = new ArrayList<>();
		coordinateList.add(randomCoordinate2);
		coordinateList.add(randomCoordinate);
		coordinateList.add(randomcoordinate3);
		coordinateList.add(randomCoordinate4);
		coordinateList.add(randomCoordinate5);
		GameOfLife game = new GameOfLife(coordinateList);

		assertEquals(3, game.getNeighborCount(20, 20));
		assertEquals(2, game.getNeighborCount(20, 21));
		assertEquals(2, game.getNeighborCount(20, 19));
		assertEquals(3, game.getNeighborCount(19, 20));
		assertEquals(0, game.getNeighborCount(50, 50));
		assertEquals(1, game.getNeighborCount(49, 50));
		assertEquals(0, game.getNeighborCount(40, 40));

	}

	/**
	 * Test method for {@link GameOfLife#nextGeneration()}.
	 */
	@Test
	public void testNextGen() {
		Coordinates randomCoordinate = new Coordinates(20, 20);
		Coordinates randomCoordinate2 = new Coordinates(19, 20);
		Coordinates randomcoordinate3 = new Coordinates(20, 21);
		Coordinates randomCoordinate4 = new Coordinates(20, 19);
		Coordinates randomCoordinate5 = new Coordinates(50, 50);
		Coordinates randomCoordinate6 = new Coordinates(21, 20);
		Coordinates randomCoordinate7 = new Coordinates(20, 22);
		Coordinates randomCoordinate8 = new Coordinates(19, 19);
		ArrayList<Coordinates> coordinateList = new ArrayList<>();
		coordinateList.add(randomCoordinate2);
		coordinateList.add(randomCoordinate);
		coordinateList.add(randomcoordinate3);
		coordinateList.add(randomCoordinate4);
		coordinateList.add(randomCoordinate5);
		coordinateList.add(randomCoordinate6);
		coordinateList.add(randomCoordinate7);
		coordinateList.add(randomCoordinate8);
		GameOfLife game = new GameOfLife(coordinateList);
		game.nextGeneration();

		assertFalse(game.isOccupied(50, 50));
		assertFalse(game.isOccupied(40, 40));
		assertTrue(game.isOccupied(19, 19));
		assertTrue(game.isOccupied(21, 20));
		assertEquals(1, game.getNeighborCount(21, 20));
		assertEquals(3, game.getNeighborCount(20, 20));
		assertEquals(0, game.getNeighborCount(19, 19));
		assertFalse(game.isOccupied(20, 20));
	}

}
