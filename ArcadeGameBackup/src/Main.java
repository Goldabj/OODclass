import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 * runs the digger game and all of its components
 *
 * @author goldacbj. Created Feb 20, 2015.
 */
public class Main {
	public static StartScreen sScreen = new StartScreen();
	public static JFrame frame = new JFrame();
	public static String path = "";

	public static void main(String[] args) throws InterruptedException {

		DiggerGame game = new DiggerGame();
		ScorePanel scorePanel = new ScorePanel(game);
		DiggerGameComponent gameComponent = new DiggerGameComponent(game);

		frame.setVisible(false);
		frame.setBounds(100, 100, 856, 925);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// shows the start up screen
		sScreen.setVisible(true);
		sScreen.setBounds(450, 450, 286, 150);
		sScreen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		while (sScreen.isVisible() == true) {
			frame.setVisible(false);
		}
		frame.setVisible(true);

		frame.setTitle("MINECRAFT DIGGER. Level" + game.getCurrentLevel());
		frame.add(gameComponent);
		frame.add(scorePanel, BorderLayout.NORTH);

		// updates the game
		while (!game.isGameOver()) {
			scorePanel.update();
			frame.setTitle("Level" + game.getCurrentLevel());
			Thread updateGame = new UpdateGameThread(game, gameComponent);
			updateGame.start();
			updateGame.join(2000);
			if (game.isGameWon()) {
				break;
			}
		}

		// runs if player lost the game
		if (game.isGameOver()) {
			JOptionPane.showMessageDialog(gameComponent, "GAME OVER. SCORE: "
					+ game.getScore());
			try {
				Thread.sleep(1000);
			} catch (InterruptedException exception) {
			}
			game = new DiggerGame();
			scorePanel = new ScorePanel(game);
			gameComponent = new DiggerGameComponent(game);

			main(null);
		}

		// runs if the playr won the game
		if (game.isGameWon()) {
			JOptionPane.showMessageDialog(gameComponent,
					"CONGRATS YOU WON!! SCORE: " + game.getScore());
			gameComponent.setFocusable(false);
			try {
				Thread.sleep(2000);
			} catch (InterruptedException exception) {
			}
			game = new DiggerGame();
			scorePanel = new ScorePanel(game);
			gameComponent = new DiggerGameComponent(game);
			main(null);
		}
	}

}
