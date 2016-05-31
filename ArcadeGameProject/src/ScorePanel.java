import java.awt.BorderLayout;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * A JPanel that displays the Digger Game score and the hero lives left
 *
 * @author goldacbj. Created Feb 20, 2015.
 */
public class ScorePanel extends JPanel {
	protected DiggerGame game;
	private JLabel scoreLabel;
	private JLabel livesLabel;
	private int score;
	private int lives;

	/**
	 * Constructs the panel with the score and hero lives
	 *
	 * @param game
	 */
	public ScorePanel(DiggerGame game) {

		this.game = game;
		this.score = this.game.getScore();
		this.lives = this.game.hero.getLives();
		this.scoreLabel = new JLabel();
		this.scoreLabel.setFont((new Font(this.scoreLabel.getFont().getName(),
				Font.PLAIN, 25)));
		this.livesLabel = new JLabel();
		this.livesLabel.setFont((new Font(this.livesLabel.getFont().getName(),
				Font.PLAIN, 25)));

		this.scoreLabel.setText("SCORE: " + this.score);
		this.livesLabel.setText("Lives: " + this.lives);
		this.add(this.scoreLabel, BorderLayout.CENTER);
		this.add(this.livesLabel, BorderLayout.EAST);
	}

	/**
	 * updates the text of the score Panel labels
	 *
	 */
	public void update() {
		this.score = this.game.getScore();
		this.lives = this.game.hero.getLives();
		this.scoreLabel.setText("SCORE: " + this.score + "           ");
		this.livesLabel.setText("LIVES :" + this.lives);
	}
}
