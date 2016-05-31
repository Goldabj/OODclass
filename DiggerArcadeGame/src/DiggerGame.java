import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JOptionPane;

/**
 * Runs the game digger and contains all the methods that are neccisary to run
 * the game
 *
 * @author goldacbj. Created Feb 9, 2015.
 */
public class DiggerGame {
	protected int currentLevel;
	protected boolean isGameOver;
	protected boolean isGameWon;
	protected int score;
	protected Hero hero;
	private static final int RECTANGLE_WIDTH = 25;
	private static final int RECTANGLE_HEIGHT = 25;
	protected ArrayList<Enemy> nobbins;
	protected ArrayList<Enemy> hobbins;
	protected ArrayList<Gem> gems;
	protected ArrayList<Money> money;
	protected char[][] gameBoard;
	protected ArrayList<String> levels = new ArrayList<>();

	/**
	 * Consturcts a Digger Game at a random level 1.
	 *
	 */
	public DiggerGame() {
		this.levels = new ArrayList<>();
		// levels must be a text file with chars and be text that is 24 x 24
		this.levels.add("level1.txt");
		this.levels.add("level2.txt");
		this.levels.add("level3.txt");
		this.currentLevel = 1;
		this.isGameOver = false;
		this.isGameWon = false;
		this.score = 0;
		this.gameBoard = new char[24][24];
		this.gems = new ArrayList<>();
		this.money = new ArrayList<>();
		this.nobbins = new ArrayList<>();
		this.hobbins = new ArrayList<>();
		// starts the game at level 1
		loadLevel(this.levels.get(0));
	}

	/**
	 * Loads the game level by analyzing the level text file
	 *
	 * @param level
	 */
	public void loadLevel(String level) {
		// removes all previous gems, money, or enemies
		this.hobbins.clear();
		this.money.clear();
		this.gems.clear();
		this.nobbins.clear();

		Scanner scanner = null;
		try {
			scanner = new Scanner(new File(level));
		} catch (FileNotFoundException exception) {
		}

		// intializes the gameboard
		for (int r = 0; r < 24; r++) {
			String row = scanner.next();
			for (int c = 0; c < row.length(); c++) {
				this.gameBoard[r][c] = row.charAt(c);
			}
		}

		for (int r = 0; r < this.gameBoard.length; r++) {
			for (int c = 0; c < this.gameBoard[r].length; c++) {
				// adds the Gems
				if (this.gameBoard[r][c] == 'G') {
					Gem gem = new Gem(c, r);
					this.gems.add(gem);
					this.gameBoard[r][c] = 'D';
				}
				// adds the Hero
				if (this.gameBoard[r][c] == 'H') {
					this.hero = new Hero(c, r);
					this.gameBoard[r][c] = 'E';
				}
				// adds the money
				if (this.gameBoard[r][c] == 'M') {
					Money money = new Money(c, r);
					this.money.add(money);
					this.gameBoard[r][c] = 'D';
				}
				// adds the Hobbins
				if (this.gameBoard[r][c] == 'K') {
					Hobbin hobbin = new Hobbin(c, r);
					this.hobbins.add(hobbin);
					this.gameBoard[r][c] = 'E';
				}
				// adds the Nobbins
				if (this.gameBoard[r][c] == 'N') {
					Nobbin nobbin = new Nobbin(c, r);
					this.nobbins.add(nobbin);
					this.gameBoard[r][c] = 'D';
				}
			}
		}
		scanner.close();
	}

	/**
	 * Has the game go up one level from where it was previously.
	 *
	 */
	public void goUpLevel() {
		if (this.currentLevel < this.levels.size()) {
			loadLevel(this.levels.get(this.currentLevel));
		} else {
			JOptionPane.showMessageDialog(null, "Cannot go up level. "
					+ "You are at the highest level.");
		}
		this.currentLevel++;

	}

	/**
	 * Has the game go down one level from where it was previously.
	 *
	 */
	public void goDownLevel() {
		if (this.currentLevel - 2 > 0) {
			loadLevel(this.levels.get(this.currentLevel - 2));
		} else {
			JOptionPane.showMessageDialog(null, "Cannout go down level. "
					+ "You are at the highest level.");
		}
		this.currentLevel--;
	}

	/**
	 * returns true if the game is over
	 *
	 * @return
	 */
	public boolean isGameOver() {
		return this.isGameOver;
	}

	/**
	 * Returns true if the player has completed the level
	 *
	 * @return
	 */
	public boolean isLevelComplete() {
		if (this.gems.size() == 0) {
			return true;
		}
		return false;
	}

	/**
	 * keeps the sate of the gameboard, but resets the hero and enimies to their
	 * starting positions
	 *
	 */
	protected void Resorection() {
		// reset Hero Position
		this.hero.resetPosition();
		// reset Hobbins positoins
		for (int i = 0; i < this.hobbins.size(); i++) {
			this.hobbins.get(i).resetPositoin();
		}
		// resest Nobbins positons
		for (int i = 0; i < this.nobbins.size(); i++) {
			this.nobbins.get(i).resetPositoin();
		}
	}

	/**
	 * returns the current score of the game
	 *
	 * @return
	 */
	public int getScore() {
		return this.score;
	}

	/**
	 * Updates the current Game according to the rules of the game
	 *
	 */
	public void heroUpdate() {
		this.gameBoard[(int) this.hero.getPositon().getY()][(int) this.hero
				.getPositon().getX()] = 'E';
		// if hero is at same positon of gem
		for (int i = 0; i < this.gems.size(); i++) {
			if (this.hero.getPositon().equals(this.gems.get(i).getPosition())) {
				this.score += Gem.getValue();
				this.gems.remove(i);
			}

		}

		// if hero is at same postion of money
		for (int i = 0; i < this.money.size(); i++) {
			if (this.money.get(i).isOpen()
					&& this.hero.getPositon().equals(
							this.money.get(i).getPosition())) {
				this.score += this.money.get(i).getValue();
				this.money.remove(i);
			}
			// TODO: finish this
		}

		// checks to see if the level is complete or game is won
		if (isLevelComplete()) {
			if (this.currentLevel >= this.levels.size()) {
				this.isGameWon = true;
			} else {
				loadLevel(this.levels.get(this.currentLevel));
				this.currentLevel++;
			}
		}

		// moves the money if bottom is taken out
		for (int i = 0; i < this.money.size(); i++) {
			Point2D moneyPosition = this.money.get(i).getPosition();
			for (int j = (int) moneyPosition.getY(); j < this.gameBoard.length - 1; j++)
				moneyPosition = this.money.get(i).getPosition();
			if (this.gameBoard[(int) moneyPosition.getY() + 1][(int) moneyPosition
					.getX()] == 'E') {
				this.money.get(i).move(0, 1);

				// killing the enemy or hero when money is dropped
				for (int k = 0; k < this.hobbins.size(); k++) {
					if (this.money.get(i).getPosition()
							.equals(this.hobbins.get(k).getPosition())) {
						this.hobbins.remove(i);
					}
				}
				for (int k = 0; k < this.nobbins.size(); k++) {
					if (this.money.get(i).getPosition()
							.equals(this.nobbins.get(k).getPosition())) {
						this.nobbins.remove(i);
					}
				}
				if (this.money.get(i).getPosition()
						.equals(this.hero.getPositon())) {
					this.hero.died();
					if (this.hero.getLives() == 0) {
						this.isGameOver = true;
					} else {
						Resorection();
					}
				}

			} else {
				break;
			}
		}
	}

	// moving the money when it is pushed by hero or hobbin??

	public void UpdateGame() {
		// updates hobbins positons
		for (int i = 0; i < this.hobbins.size(); i++) {
			Point2D heroPosition = this.hero.getPositon();
			Point2D hobbinPosition = this.hobbins.get(i).getPosition();
			// has the hobbin move toward the hero
			// also checks if money is next to the hobbin, if so it moves the
			// money too if it is able to.
			if (heroPosition.getX() - hobbinPosition.getX() > 0) {
				Money moneyNextToPos = this.moneyNextToPosition(
						this.hobbins.get(i), 1, 0);
				if (moneyNextToPos != null
						&& moneyNextToPos.getPosition().getX() > this.gameBoard[i].length) {
					moneyNextToPos.move(1, 0);
					this.hobbins.get(i).updatePosition(1, 0);
					this.gameBoard[(int) this.hobbins.get(i).getPosition()
							.getY()][(int) this.hobbins.get(i).getPosition()
							.getX()] = 'E';
				}
				if (moneyNextToPos == null) {
					this.hobbins.get(i).updatePosition(1, 0);
					this.gameBoard[(int) this.hobbins.get(i).getPosition()
							.getY()][(int) this.hobbins.get(i).getPosition()
							.getX()] = 'E';
				}

			} else if (heroPosition.getX() - hobbinPosition.getX() < 0) {
				Money moneyNextToPos = this.moneyNextToPosition(
						this.hobbins.get(i), -1, 0);
				if (moneyNextToPos != null
						&& moneyNextToPos.getPosition().getX() > 0) {
					moneyNextToPos.move(-1, 0);
					this.hobbins.get(i).updatePosition(-1, 0);
					this.gameBoard[(int) this.hobbins.get(i).getPosition()
							.getY()][(int) this.hobbins.get(i).getPosition()
							.getX()] = 'E';
				}
				if (moneyNextToPos == null) {
					this.hobbins.get(i).updatePosition(-1, 0);
					this.gameBoard[(int) this.hobbins.get(i).getPosition()
							.getY()][(int) this.hobbins.get(i).getPosition()
							.getX()] = 'E';
				}
			} else if (heroPosition.getY() - hobbinPosition.getY() > 0) {
				Money moneyNextToPos = this.moneyNextToPosition(
						this.hobbins.get(i), 0, 1);
				if (moneyNextToPos != null
						&& moneyNextToPos.getPosition().getY() > this.gameBoard.length) {
					moneyNextToPos.move(1, 0);
					this.hobbins.get(i).updatePosition(0, 1);
					this.gameBoard[(int) this.hobbins.get(i).getPosition()
							.getY()][(int) this.hobbins.get(i).getPosition()
							.getX()] = 'E';
				}
				if (moneyNextToPos == null) {
					this.hobbins.get(i).updatePosition(0, 1);
					this.gameBoard[(int) this.hobbins.get(i).getPosition()
							.getY()][(int) this.hobbins.get(i).getPosition()
							.getX()] = 'E';
				}
			} else if (heroPosition.getY() - hobbinPosition.getY() < 0) {
				Money moneyNextToPos = this.moneyNextToPosition(
						this.hobbins.get(i), 0, -1);
				if (moneyNextToPos != null
						&& moneyNextToPos.getPosition().getY() > 0) {
					moneyNextToPos.move(0, -1);
					this.hobbins.get(i).updatePosition(0, -1);
					this.gameBoard[(int) this.hobbins.get(i).getPosition()
							.getY()][(int) this.hobbins.get(i).getPosition()
							.getX()] = 'E';
				}
				if (moneyNextToPos == null) {
					this.hobbins.get(i).updatePosition(0, -1);
					this.gameBoard[(int) this.hobbins.get(i).getPosition()
							.getY()][(int) this.hobbins.get(i).getPosition()
							.getX()] = 'E';
				}
			}
		}
		// updates nobbins position
		for (int i = 0; i < this.nobbins.size(); i++) {
			Point2D heroPosition = this.hero.getPositon();
			Point2D nobbinPosition = this.nobbins.get(i).getPosition();
			double nobbinX = nobbinPosition.getX();
			double nobbinY = nobbinPosition.getY();
			// has the nobbins move toward the hero if it can go that way

			if ((nobbinX > 0)
					&& (this.gameBoard[(int) (nobbinY)][(int) (nobbinX - 1)] == 'E')
					&& (heroPosition.getX() - nobbinX < 0)) {
				Money moneyNextToNob = this.moneyNextToPosition(
						this.nobbins.get(i), -1, 0);
				if ((moneyNextToNob == null)) {
					this.nobbins.get(i).updatePosition(-1, 0);
				}
			}

			else if ((nobbinX < this.gameBoard[i].length)
					&& (this.gameBoard[(int) nobbinY][(int) (nobbinX + 1)] == 'E')
					&& (heroPosition.getX() - nobbinX > 0)) {
				Money moneyNextToNob = this.moneyNextToPosition(
						this.nobbins.get(i), 1, 0);
				if (moneyNextToNob == null) {
					this.nobbins.get(i).updatePosition(1, 0);
				}
			} else if ((nobbinY > 0)
					&& (this.gameBoard[(int) (nobbinY - 1)][(int) nobbinX] == 'E')
					&& (heroPosition.getY() - nobbinY < 0)) {
				Money moneyNextToNob = this.moneyNextToPosition(
						this.nobbins.get(i), 0, -1);
				if (moneyNextToNob == null) {
					this.nobbins.get(i).updatePosition(0, -1);
				}
			} else if ((nobbinY > this.gameBoard.length)
					&& (this.gameBoard[(int) (nobbinY + 1)][(int) nobbinX] == 'E')
					&& (heroPosition.getY() - nobbinY > 0)) {
				Money moneyNextToNob = this.moneyNextToPosition(
						this.nobbins.get(i), 0, 1);
				if (moneyNextToNob == null) {
					this.nobbins.get(i).updatePosition(0, 1);
				}
			}
			// if the nobbin cannot move toward the hero and just needs to
			// move somehwere
			else if ((nobbinX > 0)
					&& (this.gameBoard[(int) (nobbinY)][(int) (nobbinX - 1)] == 'E')) {
				Money moneyNextToNob = this.moneyNextToPosition(
						this.nobbins.get(i), -1, 0);
				if (moneyNextToNob == null) {
					this.nobbins.get(i).updatePosition(-1, 0);
				}
			} else if ((nobbinX < this.gameBoard[i].length)
					&& (this.gameBoard[(int) nobbinY][(int) (nobbinX + 1)] == 'E')) {
				Money moneyNextToNob = this.moneyNextToPosition(
						this.nobbins.get(i), 1, 0);
				if (moneyNextToNob == null) {
					this.nobbins.get(i).updatePosition(1, 0);
				}
			} else if ((nobbinY > 0)
					&& (this.gameBoard[(int) (nobbinY - 1)][(int) nobbinX] == 'E')) {
				Money moneyNextToNob = this.moneyNextToPosition(
						this.nobbins.get(i), 0, -1);
				if (moneyNextToNob == null) {
					this.nobbins.get(i).updatePosition(0, -1);
				}
			} else if ((nobbinY > this.gameBoard.length)
					&& (this.gameBoard[(int) (nobbinY + 1)][(int) nobbinX] == 'E')) {
				Money moneyNextToNob = this.moneyNextToPosition(
						this.nobbins.get(i), 0, 1);
				if (moneyNextToNob == null) {
					this.nobbins.get(i).updatePosition(0, 1);
				}
			}

		}
		// runs hobbin to nobbin
		for (int i = 0; i < this.nobbins.size(); i++) {
			if (isNobbinToHobbin()) {
				this.hobbins.add(new Hobbin((int) this.nobbins.get(i)
						.getPosition().getX(), (int) this.nobbins.get(i)
						.getPosition().getY()));
				this.nobbins.remove(i);
			}
		}

		// if hero is at same positon of hobbin
		for (int i = 0; i < this.hobbins.size(); i++) {
			if (this.hero.getPositon()
					.equals(this.hobbins.get(i).getPosition())) {
				this.hero.died();
				if (this.hero.getLives() == 0) {
					this.isGameOver = true;
				} else {
					Resorection();
				}
			}
		}
		// if hero is at same positon of nobbin
		for (int i = 0; i < this.nobbins.size(); i++) {
			if (this.hero.getPositon()
					.equals(this.nobbins.get(i).getPosition())) {
				this.hero.died();
				if (this.hero.getLives() == 0) {
					this.isGameOver = true;
				} else {
					Resorection();
				}
			}
		}
	}

	/**
	 * returns true if the Nobbin turns into a Hobbin there is a very low change
	 * of this happening
	 *
	 * @return
	 */
	public static boolean isNobbinToHobbin() {
		if (Math.random() < .05) {
			return true;
		}
		return false;
	}

	/**
	 * returns the money that is next to the enemy.
	 *
	 * @param enemy
	 * @param x
	 * @param y
	 * @return
	 */
	protected Money moneyNextToPosition(Enemy enemy, int x, int y) {
		double enemyX = enemy.getPosition().getX();
		double enemyY = enemy.getPosition().getY();
		for (int i = 0; i < this.money.size(); i++) {
			if (this.money.get(i).getPosition()
					.equals(new Point2D.Double(enemyX + x, enemyY + y))) {
				return this.money.get(i);
			}
		}
		return null;
	}

	/**
	 * returns if the player has won the game or not
	 *
	 * @return
	 */
	public boolean isGameWon() {
		return this.isGameWon;
	}

	/**
	 * Returns the current level of the game
	 *
	 * @return
	 */
	public int getCurrentLevel() {
		return this.currentLevel;
	}

	/**
	 * Draw the the Digger game
	 *
	 * @param g
	 *            -- Graphics
	 */
	public void drawOn(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		for (int r = 0; r < this.gameBoard.length; r++) {
			for (int c = 0; c < this.gameBoard[r].length; c++) {
				// draws dirt blocks
				if (this.gameBoard[r][c] == 'D') {
					Rectangle2D Dirt = new Rectangle2D.Double(c
							* DiggerGame.RECTANGLE_WIDTH, r
							* DiggerGame.RECTANGLE_HEIGHT,
							DiggerGame.RECTANGLE_WIDTH - 2,
							DiggerGame.RECTANGLE_HEIGHT - 2);
					g2.setColor(new Color(156, 93, 82));
					g2.fill(Dirt);
					g2.draw(Dirt);
				}
				// draws empty blocks
				if (this.gameBoard[r][c] == 'E') {
					Rectangle2D empty = new Rectangle2D.Double(c
							* DiggerGame.RECTANGLE_WIDTH, r
							* DiggerGame.RECTANGLE_HEIGHT,
							DiggerGame.RECTANGLE_WIDTH - 2,
							DiggerGame.RECTANGLE_HEIGHT - 2);
					g2.setColor(Color.BLACK);
					g2.fill(empty);
					g2.draw(empty);
				}

			}
		}
		// draws the hero
		Rectangle2D heroRectangle = new Rectangle2D.Double(this.hero
				.getPositon().getX() * DiggerGame.RECTANGLE_WIDTH, this.hero
				.getPositon().getY() * DiggerGame.RECTANGLE_HEIGHT,
				DiggerGame.RECTANGLE_WIDTH - 2, DiggerGame.RECTANGLE_HEIGHT - 2);
		g2.setColor(Color.BLUE);
		g2.fill(heroRectangle);
		g2.draw(heroRectangle);

		// draws the nobbins
		for (int i = 0; i < this.nobbins.size(); i++) {
			Rectangle2D nobbinRectangle = new Rectangle2D.Double(this.nobbins
					.get(i).getPosition().getX()
					* DiggerGame.RECTANGLE_WIDTH, this.nobbins.get(i)
					.getPosition().getY()
					* DiggerGame.RECTANGLE_HEIGHT,
					DiggerGame.RECTANGLE_WIDTH - 2,
					DiggerGame.RECTANGLE_HEIGHT - 2);
			g2.setColor(Color.RED);
			g2.fill(nobbinRectangle);
			g2.draw(nobbinRectangle);
		}

		// draws the hobbins
		for (int i = 0; i < this.hobbins.size(); i++) {
			Rectangle2D hobbinRectangle = new Rectangle2D.Double(this.hobbins
					.get(i).getPosition().getX()
					* DiggerGame.RECTANGLE_WIDTH, this.hobbins.get(i)
					.getPosition().getY()
					* DiggerGame.RECTANGLE_HEIGHT,
					DiggerGame.RECTANGLE_WIDTH - 2,
					DiggerGame.RECTANGLE_HEIGHT - 2);
			g2.setColor(Color.WHITE);
			g2.fill(hobbinRectangle);
			g2.draw(hobbinRectangle);
		}
		// draws the money
		for (int i = 0; i < this.money.size(); i++) {
			Rectangle2D moneyRectangle = new Rectangle2D.Double(this.money
					.get(i).getPosition().getX()
					* DiggerGame.RECTANGLE_WIDTH, this.money.get(i)
					.getPosition().getY()
					* DiggerGame.RECTANGLE_HEIGHT,
					DiggerGame.RECTANGLE_WIDTH - 2,
					DiggerGame.RECTANGLE_HEIGHT - 2);
			g2.setColor(Color.YELLOW);
			g2.fill(moneyRectangle);
			g2.draw(moneyRectangle);
		}

		// draws the gems
		for (int i = 0; i < this.gems.size(); i++) {
			Rectangle2D gemRectangle = new Rectangle2D.Double(this.gems.get(i)
					.getPosition().getX()
					* DiggerGame.RECTANGLE_WIDTH, this.gems.get(i)
					.getPosition().getY()
					* DiggerGame.RECTANGLE_HEIGHT,
					DiggerGame.RECTANGLE_WIDTH - 2,
					DiggerGame.RECTANGLE_HEIGHT - 2);
			g2.setColor(Color.GREEN);
			g2.fill(gemRectangle);
			g2.draw(gemRectangle);
		}
	}

}
