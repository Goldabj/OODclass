import java.awt.BorderLayout;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.Timer;

/**
 * This class is the starting point for the simulator for Conway's Game of Life.
 * 
 * @author Brendan Goldacker, Max Gordinm. Created Sep 24, 2008.
 */
public class GameOfLifeMain {

	private static final int WIDTH = 630;
	private static final int HEIGHT = 750;

	/**
	 * Starts the program
	 * 
	 * @param args
	 *            ignored
	 */
	public static void main(String[] args) {
		JFrame frame = new JFrame();

		frame.setSize(WIDTH, HEIGHT);
		frame.setTitle("Conway's Game of Life");

		ArrayList<Coordinates> coordList = getRandomList();
		final GameOfLife game = new GameOfLife(coordList);
		frame.add(game);

		/*
		 * This adds an update button to the frame. We'll cover more on how to
		 * do this over the rest of the term.
		 */
		final UpdateButton updateButton = new UpdateButton(game);
		frame.add(updateButton, BorderLayout.SOUTH);

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);

		// Optional: Add a Timer here to click the button every 50 milliseconds.
		// When importing the Timer, choose the javax.swing Timer.
		Timer timer = new Timer(50, updateButton);
		timer.start();

	}

	/**
	 * @return a list of coordinates representing the glider configuration
	 */
	private static ArrayList<Coordinates> getGliderList() {
		ArrayList<Coordinates> coordList = new ArrayList<Coordinates>();
		coordList.add(new Coordinates(80, 50));
		coordList.add(new Coordinates(80, 51));
		coordList.add(new Coordinates(80, 52));
		coordList.add(new Coordinates(81, 52));
		coordList.add(new Coordinates(82, 51));
		/*
		 * 
		 */
		coordList.add(new Coordinates(50, 20));
		coordList.add(new Coordinates(50, 21));
		coordList.add(new Coordinates(50, 22));
		coordList.add(new Coordinates(51, 20));
		coordList.add(new Coordinates(52, 21));
		/*
		 * 
		 */
		coordList.add(new Coordinates(89, 50));
		coordList.add(new Coordinates(89, 51));
		coordList.add(new Coordinates(89, 52));
		coordList.add(new Coordinates(0, 50));
		coordList.add(new Coordinates(1, 51));
		/*
		 * 
		 */
		coordList.add(new Coordinates(20, 21));
		coordList.add(new Coordinates(21, 20));
		coordList.add(new Coordinates(22, 20));
		coordList.add(new Coordinates(22, 21));
		coordList.add(new Coordinates(22, 22));
		return coordList;
	}

	/**
	 * 
	 * Creates a list of random coordinates for the board to start at.
	 *
	 * @return -- ArrayList of initial Coordinates
	 */
	private static ArrayList<Coordinates> getRandomList() {
		Random rand = new Random();
		ArrayList<Coordinates> coordList = new ArrayList<Coordinates>();
		for (int i = 0; i < 90; i++) {
			for (int j = 0; j < 90; j++) {
				int randomNum = rand.nextInt(10);
				if (randomNum < 4) {
					coordList.add(new Coordinates(i, j));
				}
			}
		}

		return coordList;

	}

}
