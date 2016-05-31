/**
 * a Thread that implements runnable that updates the Digger game and the Digger
 * game Component
 *
 * @author goldacbj. Created Feb 20, 2015.
 */
public class UpdateGameThread extends Thread implements Runnable {
	private DiggerGame game;
	private DiggerGameComponent gameComponent;

	/**
	 * Construct the thread with the specified game and game component
	 *
	 * @param diggerGame
	 * @param diggerGameComponent
	 */
	public UpdateGameThread(DiggerGame diggerGame,
			DiggerGameComponent diggerGameComponent) {
		this.game = diggerGame;
		this.gameComponent = diggerGameComponent;
	}

	@Override
	public void run() {
		this.game.updateEverything();
		this.gameComponent.repaint();
		try {
			this.sleep(200);
		} catch (InterruptedException exception) {
			// TODO Auto-generated catch-block stub.
			exception.printStackTrace();
		}

	}

}
