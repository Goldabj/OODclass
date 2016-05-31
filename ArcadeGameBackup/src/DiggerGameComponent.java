import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JComponent;

/**
 * Draw the interactable Digger Game
 *
 * @author goldacbj. Created Feb 10, 2015.
 */
@SuppressWarnings("serial")
public class DiggerGameComponent extends JComponent {
	DiggerGame game;

	/**
	 * Construcs a digger game component with a key listerner, up moves the hero
	 * up down moves the hero down.. etc. U has the game go up a level and D has
	 * the game go down a level
	 *
	 * @param diggerGame
	 *            The digger game that is being drawn
	 */
	public DiggerGameComponent(DiggerGame diggerGame) {
		this.game = diggerGame;
		this.setBounds(100, 100, 895, 895);
		this.setFocusable(true);

		// adds a key listener to the gamecomponent
		this.addKeyListener(new KeyListener() {

			@Override
			public void keyPressed(KeyEvent arg0) {
				if (arg0.getKeyCode() == KeyEvent.VK_LEFT) {
					if (DiggerGameComponent.this.game.hero.getX() > 0) {
						DiggerGameComponent.this.game.hero.setVelocity(-1, 0);
					} else {
						DiggerGameComponent.this.game.hero.setVelocity(0, 0);

					}
				}

				if (arg0.getKeyCode() == KeyEvent.VK_RIGHT) {
					if (DiggerGameComponent.this.game.hero.getX() < DiggerGameComponent.this.game.BOARD_WIDTH - 1) {
						DiggerGameComponent.this.game.hero.setVelocity(1, 0);
					} else {
						DiggerGameComponent.this.game.hero.setVelocity(0, 0);

					}
				}

				if (arg0.getKeyCode() == KeyEvent.VK_UP) {
					if (DiggerGameComponent.this.game.hero.getY() > 0) {
						DiggerGameComponent.this.game.hero.setVelocity(0, -1);
					} else {
						DiggerGameComponent.this.game.hero.setVelocity(0, 0);

					}
				}

				if (arg0.getKeyCode() == KeyEvent.VK_DOWN) {
					if (DiggerGameComponent.this.game.hero.getY() < DiggerGameComponent.this.game.BOARD_LENGTH - 1) {
						DiggerGameComponent.this.game.hero.setVelocity(0, 1);
					} else {
						DiggerGameComponent.this.game.hero.setVelocity(0, 0);

					}

				}

				if (arg0.getKeyCode() == KeyEvent.VK_U) {
					DiggerGameComponent.this.game.goUpLevel();
				}

				if (arg0.getKeyCode() == KeyEvent.VK_D) {
					DiggerGameComponent.this.game.goDownLevel();
				}

				if (arg0.getKeyCode() == KeyEvent.VK_SPACE) {
					DiggerGameComponent.this.game.hero.fireWeapon();
				}

			}

			@Override
			public void keyReleased(KeyEvent arg0) {
				DiggerGameComponent.this.game.hero.setVelocity(0, 0);

			}

			@Override
			public void keyTyped(KeyEvent arg0) {
			}

		});

	}

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		this.game.drawOn(g);
	}
}
