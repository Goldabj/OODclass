package twovstwo;

import java.util.ArrayList;
/**
 * 
 * Creates a player of the game. players can have a list
 * of games, and a number of wins
 *
 * @author goldacbj.
 *         Created Jan 12, 2015.
 */
public class Player {
	private String name;
	private ArrayList<String> games;
	private int wins;
	
	/**
	 * 
	 * initializes the player with the given name
	 *
	 * @param name
	 */
	public Player(String name) {
		this.name = name;
		this.games = new ArrayList<String>();
		this.wins = 0;
	}
	
	/**
	 * 
	 * adds a win to the player
	 *
	 * @param game
	 */
	public void addAWin(String game) {
		this.wins++;
		this.games.add(game + "(win)");
		
	}
	
	/**
	 * 
	 * adds a loss to the player
	 *
	 * @param game
	 */
	public void addALoss(String game) {
		this.games.add(game + "(Loss)");
	}
	
	/**
	 * 
	 * returns the number of wins the player has
	 *
	 * @return
	 */
	public int numOfWins() {
		return this.wins;
	}
	
	/**
	 * 
	 * returns the name of the player
	 *
	 * @return
	 */
	public String getName() {
		return this.name;
	}
	
	/**
	 * 
	 * returns the list of games that the player has 
	 * played in
	 *
	 * @return
	 */
	public ArrayList<String> getGames() {
		return this.games;
	}
}

