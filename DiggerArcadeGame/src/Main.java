import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Main {

	public static void main(String[] args) {
		DiggerGame game = new DiggerGame();
		DiggerGameComponent gameComponent = new DiggerGameComponent(game);
		ScorePanel scorePanel = new ScorePanel(game);

		JFrame frame = new JFrame();
		frame.setTitle("Level" + game.getCurrentLevel());
		frame.add(gameComponent);
		frame.add(scorePanel, BorderLayout.NORTH);

		frame.setVisible(true);
		frame.setBounds(100, 100, 800, 800);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
//		Runnable enemyUpdate = new EnemyMoveThread();
//		Thread enemyUpdateT = new Thread(enemyUpdate);
//		enemyUpdateT.start();

		while (!game.isGameOver()) {
			scorePanel.update();
			frame.setTitle("Level" + game.getCurrentLevel());
			game.UpdateGame();
			try {
				Thread.sleep(500);
			} catch (InterruptedException exception) { }
		}
		if(game.isGameOver) {
			JOptionPane.showMessageDialog(gameComponent, "GAME OVER. SCORE: " + game.getScore());
			gameComponent.setFocusable(false);
			try {
				Thread.sleep(5000);
			} catch (InterruptedException exception) {
			}
		}
		if(game.isGameWon) {
			JOptionPane.showMessageDialog(gameComponent, "CONGRATS YOU WON!! SCORE: " + game.getScore());
			gameComponent.setFocusable(false);
			try {
				Thread.sleep(4000);
			} catch (InterruptedException exception) { }
		}
	}

	/**
	 * 
	 * saves the current state of the game that was being played
	 *
	 * @param game
	 */
	public void saveGame(DiggerGame game) {

	}

}
