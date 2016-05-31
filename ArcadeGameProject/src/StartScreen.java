import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * a Start up screen has a options button, quit button and start game button
 *
 * @author goldacbj. Created Feb 20, 2015.
 */
@SuppressWarnings("serial")
public class StartScreen extends JFrame {

	/**
	 * Constructs the start screen with the option, quit, and new game buttons
	 *
	 */
	public StartScreen() {
		this.setTitle("Main Menu");

		JPanel panel = new JPanel();

		add(panel, BorderLayout.CENTER);

		final JLabel title = new JLabel(" DIGGER: MINECRAFT ");
		title.setFont((new Font(title.getFont().getName(), Font.PLAIN, 25)));
		panel.add(title);

		final JButton newGameButton = new JButton("START");
		panel.add(newGameButton);

		final JButton options = new JButton("OPTIONS");
		panel.add(options);

		final JButton quitButton = new JButton("QUIT");
		panel.add(quitButton);

		final JLabel highScore = new JLabel("     High Score: " + 1000);
		panel.add(highScore, BorderLayout.CENTER);

		JPanel optionPanel = new JPanel();
		JTextField field = new JTextField("Add path to the texture pack");
		JButton okay = new JButton("Okay");
		optionPanel.add(field);
		optionPanel.add(okay);

		okay.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				remove(optionPanel);
				add(panel);
				repaint();

				Main.path = field.getText();
			}

		});

		quitButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				Main.frame.dispose();
			}
		});

		newGameButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				startGame();
				dispose();
			}
		});

		options.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				remove(panel);
				add(optionPanel);
				setSize(getWidth(), getHeight() + 1);
				repaint();
			}

		});
	}

	/**
	 * returns true if the game has been started
	 *
	 * @return
	 */
	public boolean startGame() {
		return true;
	}
}
