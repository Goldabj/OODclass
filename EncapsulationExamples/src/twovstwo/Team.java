package twovstwo;

import java.util.ArrayList;

/**
 * 
 * creates a team of two players, a team can win or loss a game
 *
 * @author goldacbj.
 *         Created Jan 12, 2015.
 */
public class Team {
	private Player player1;
	private Player player2;
	private ArrayList<Player> team;
	
	/**
	 * 
	 * initializes the team with the two players
	 *
	 * @param player1
	 * @param player2
	 */
	public Team(Player player1, Player player2) {
		this.player1 = player1;
		this.player2 = player2;
		this.team = new ArrayList<Player>();
		this.team.add(player1);
		this.team.add(player2);
	}
	/**
	 * 
	 * returns the name of the two players
	 *
	 * @return
	 */
	public String getPlayers() {
		String playerString = player1.getName() + player2.getName();
		return playerString;
	}
	
	/**
	 * 
	 * adds a win to the team
	 *
	 * @param game
	 */
	public void winner(String game) {
		player1.addAWin(game);
		player2.addAWin(game);
	}
	
	/**
	 * 
	 * adds a loss to the team
	 *
	 * @param game
	 */
	public void losser(String game) {
		player1.addALoss(game);
		player2.addALoss(game);
	}
	
	/**
	 * 
	 * returns the a name string of the players
	 *
	 * @return
	 */
	public String getTeamPlayers() {
		String teamString = this.player1.getName() + " & " + this.player2.getName();
		return teamString;
	}
	
}
