package twovstwo;

/**
 * 
 * A game consisits of two teams, with two players on 
 * each team and there is a reuslt of the game
 *
 * @author goldacbj.
 *         Created Jan 12, 2015.
 */
public class Game {
	private Team team1;
	private Team team2;
	private String game;
	
	/**
	 * 
	 * intializes the game
	 *
	 * @param team1
	 * @param team2
	 */
	public Game(Team team1, Team team2) {
		this.team1 = team1;
		this.team2 = team2;
		this.game = team1.getTeamPlayers() +  " vs. " + team2.getTeamPlayers();
	}
	
	/**
	 * 
	 * adds the win to the winning team and adds the loss
	 * to the losing team
	 *
	 * @param winningTeam
	 * @param lossingTeam
	 */
	public void result(Team winningTeam, Team lossingTeam) {
		winningTeam.winner(this.game);
		lossingTeam.losser(this.game);
	}
}
