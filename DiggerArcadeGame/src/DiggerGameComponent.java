import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JComponent;

/**
 * Draw the interactable Digger Game
 *
 * @author goldacbj. Created Feb 10, 2015.
 */
public class DiggerGameComponent extends JComponent {
	DiggerGame game;

	public DiggerGameComponent(DiggerGame diggerGame) {
		this.game = diggerGame;
		this.setBounds(100, 100, 500, 500);
		this.setFocusable(true);
		
		// adds a key listener to the gamecomponent
		this.addKeyListener(new KeyListener() {

			@Override
			public void keyPressed(KeyEvent arg0) {
				if (arg0.getKeyCode() == KeyEvent.VK_LEFT) {
					if (DiggerGameComponent.this.game.hero.getPositon().getX() > 0) {
						DiggerGameComponent.this.game.hero.move(-1, 0);
						DiggerGameComponent.this.game.heroUpdate();
						repaint();
					}
				}

				if (arg0.getKeyCode() == KeyEvent.VK_RIGHT) {
					if (DiggerGameComponent.this.game.hero.getPositon().getX() < DiggerGameComponent.this.game.gameBoard.length - 1) {
						DiggerGameComponent.this.game.hero.move(1, 0);
						DiggerGameComponent.this.game.heroUpdate();
						repaint();
					}
				}

				if (arg0.getKeyCode() == KeyEvent.VK_UP) {
					if (DiggerGameComponent.this.game.hero.getPositon().getY() > 0) {
						DiggerGameComponent.this.game.hero.move(0, -1);
						DiggerGameComponent.this.game.heroUpdate();
						repaint();
					}
				}

				if (arg0.getKeyCode() == KeyEvent.VK_DOWN) {
					if (DiggerGameComponent.this.game.hero.getPositon().getY() < DiggerGameComponent.this.game.gameBoard[1].length - 1) {
						DiggerGameComponent.this.game.hero.move(0, 1);
						DiggerGameComponent.this.game.heroUpdate();
						repaint();
					}

				}

				if (arg0.getKeyCode() == KeyEvent.VK_U) {
					DiggerGameComponent.this.game.goUpLevel();
					repaint();
				}

				if (arg0.getKeyCode() == KeyEvent.VK_D) {
					DiggerGameComponent.this.game.goDownLevel();
					repaint();
				}

			}

			@Override
			public void keyReleased(KeyEvent arg0) {
				// Does nothing
			}

			@Override
			public void keyTyped(KeyEvent arg0) {
				// Does nothing
			}

		});

	}

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		this.game.drawOn(g);
	}
}
