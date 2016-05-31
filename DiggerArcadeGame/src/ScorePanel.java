import java.awt.BorderLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;


public class ScorePanel extends JPanel {
	protected DiggerGame game;
	private JLabel scoreLabel;
	private JLabel livesLabel;
	private int score;
	private int lives;

	public ScorePanel(DiggerGame game) {
		
		this.game = game;
		this.score = this.game.getScore();
		this.lives = this.game.hero.getLives();
		this.scoreLabel = new JLabel();
		this.livesLabel = new JLabel();
		
		this.scoreLabel.setText("SCORE: " + this.score);
		this.livesLabel.setText("Lives: " + this.lives);
		this.add(this.scoreLabel, BorderLayout.CENTER);
		this.add(this.livesLabel, BorderLayout.EAST);
	}
	
	public void update() {
		this.score = this.game.getScore();
		this.lives = this.game.hero.getLives();
		this.scoreLabel.setText("SCORE: " + this.score);
		this.livesLabel.setText("LIVES :" + this.lives);
	}
}
