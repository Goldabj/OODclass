
package twovstwo;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;


/**
 * Imagine a game where a match consists of two players (Team 1) 
 * play against two others (Team 2).
 * 
 * These games occur within a league where every match the participants
 * change.  So an opponent in this match might be a teammate in the next
 * match.
 * 
 * Even though the game is played on teams, individual participants are 
 * ranked by the number of games their team won.
 * 
 * Write a program that takes inputs about the particular games and
 * determines the best player (as determined by number of games won).
 * It should also print out the player's complete record of games,
 * including only games that that player participated in.  
 * 
 * Here's an example:
 * 
Enter the players - four names, seperated by spaces (or exit to quit).
Axe Boomer Crusher Doombot
Team 1 has Axe and Boomer.  Team 2 has Crusher and Doombot.
Which team won? (1 or 2)
2
Enter the players - four names, seperated by spaces (or exit to quit).
Doombot Axe Boomer Crusher
Team 1 has Doombot and Axe.  Team 2 has Boomer and Crusher.
Which team won? (1 or 2)
2
Enter the players - four names, seperated by spaces (or exit to quit).
Xander Zoomy Ninja Monster
Team 1 has Xander and Zoomy.  Team 2 has Ninja and Monster.
Which team won? (1 or 2)
1
Enter the players - four names, seperated by spaces (or exit to quit).
exit
Best Player: Crusher
Axe & Boomer vs Crusher & Doombot (win)
Doombot & Axe vs Boomer & Crusher (win)
 * 
 * Here's a second example (slightly longer):
 * 
Enter the players - four names, seperated by spaces (or exit to quit).
Axe Boomer Crusher Doombot
Team 1 has Axe and Boomer.  Team 2 has Crusher and Doombot.
Which team won? (1 or 2)
2
Enter the players - four names, seperated by spaces (or exit to quit).
Axe Doombot Crusher Boomer
Team 1 has Axe and Doombot.  Team 2 has Crusher and Boomer.
Which team won? (1 or 2)
1
Enter the players - four names, seperated by spaces (or exit to quit).
Axe Crusher Edge Franz
Team 1 has Axe and Crusher.  Team 2 has Edge and Franz.
Which team won? (1 or 2)
1
Enter the players - four names, seperated by spaces (or exit to quit).
Edge Doombot Giant Franz
Team 1 has Edge and Doombot.  Team 2 has Giant and Franz.
Which team won? (1 or 2)
2
Enter the players - four names, seperated by spaces (or exit to quit).
Giant Boomer Hercules Doombot
Team 1 has Giant and Boomer.  Team 2 has Hercules and Doombot.
Which team won? (1 or 2)
2
Enter the players - four names, seperated by spaces (or exit to quit).
Giant Edge Hercules Franz
Team 1 has Giant and Edge.  Team 2 has Hercules and Franz.
Which team won? (1 or 2)
1
Enter the players - four names, seperated by spaces (or exit to quit).
exit
Best Player: Doombot
Axe & Boomer vs Crusher & Doombot (win)
Axe & Doombot vs Crusher & Boomer (win)
Edge & Doombot vs Giant & Franz (loss)
Giant & Boomer vs Hercules & Doombot (win)
 * 
 * @author hewner
 *
 */
@SuppressWarnings("unused")
public class TwoVsTwoMain {

	/**
	 * Runs the program
	 *
	 * @param args not used
	 * @throws FileNotFoundException
	 */
	public static void main(String[] args) throws FileNotFoundException {
		Scanner input = new Scanner(System.in);
		
		//uncomment this line to read input from the sample file
		//so you don't have to type stuff in every time
		//the text file is the same as example two, but feel
		//free to modify it as you need
		//
		//input = new Scanner(new File("sampleTwoVsTwo.txt"));

		HashMap<String, Player> players = new HashMap<>();;
		
		while (true) {
			System.out.println("Enter the players - four names, seperated by spaces (or exit to quit).");
			String[] names = input.nextLine().trim().split(" ");
			if (names[0].equals("exit")) {
				break;
			}
			System.out.printf("Team 1 has %s and %s.  Team 2 has %s and %s.%n", names[0],names[1],names[2],names[3]);
			System.out.println("Which team won? (1 or 2)");
			int winner = input.nextInt();
			// removes the enter
			input.nextLine();

			//initializes players
			for(int i = 0; i < 3; i++) {
				if(!(players.containsKey(names[i]))) {
					Player newPlayer = new Player(names[i]);
					players.put(names[i], newPlayer);
				}
			}
	
			Player player1 = players.get(names[0]);
			Player player2 = players.get(names[1]);
			Player player3 = players.get(names[2]);
			Player player4 = players.get(names[3]);
			 
			//initializes teams
			Team team1 = new Team(player1, player2);
			Team team2 = new Team(player3, player4);
			
			//creates the game
			Game game = new Game(team1, team2);
			
			//inputs the result of game
			if(winner == 1) {
				game.result(team1, team2);
			}
			
			if(winner == 2) {
				game.result(team2, team2);
			}
				
		}
		input.close();
		
		//calculate the best player
		int tempPlayerWins = 0;
		int highestPlayerWins = 0;
		Player bestPlayer = null;
		Set<String> playerNames = players.keySet();
		for(String key : playerNames) {
			tempPlayerWins = players.get(key).numOfWins();
			if(tempPlayerWins > highestPlayerWins) {
				bestPlayer = players.get(key);
			}
		}
	
		//print resutls
		System.out.println("Best Player : " + bestPlayer);
		for(int i = 0; i < bestPlayer.getGames().size(); i++) {
			ArrayList<String> games = bestPlayer.getGames();
			System.out.println(games.get(i));	
		}
		
		

	}
}
