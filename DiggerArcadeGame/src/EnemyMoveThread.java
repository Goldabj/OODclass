import java.awt.geom.Point2D;

public class EnemyMoveThread extends DiggerGame implements Runnable {

	@Override
	public void run() {
		super.gameBoard[(int) super.hero.getPositon().getY()][(int) super.hero
				.getPositon().getX()] = 'E';
		System.out.println("running thread");
		// if hero is at same positon of gem
		for (int i = 0; i < super.gems.size(); i++) {
			if (super.hero.getPositon().equals(super.gems.get(i).getPosition())) {
				super.score += Gem.getValue();
				super.gems.remove(i);
			}

		}

		// if hero is at same postion of money
		for (int i = 0; i < super.money.size(); i++) {
			if (super.money.get(i).isOpen()
					&& super.hero.getPositon().equals(
							super.money.get(i).getPosition())) {
				super.score += super.money.get(i).getValue();
				super.money.remove(i);
			}
			// TODO: finish this
		}
		
		System.out.println("running thread part2");
		// checks to see if the level is complete or game is won
		if (isLevelComplete()) {
			if (super.currentLevel >= super.levels.size()) {
				super.isGameWon = true;
			} else {
				loadLevel(super.levels.get(super.currentLevel));
				super.currentLevel++;
			}
		}
		
		System.out.println("running thread part3");
		// moves the money if bottom is taken out
		for (int i = 0; i < super.money.size(); i++) {
			Point2D moneyPosition = super.money.get(i).getPosition();
			for (int j = (int) moneyPosition.getY(); j < super.gameBoard.length - 1; j++)
				moneyPosition = super.money.get(i).getPosition();
			if (super.gameBoard[(int) moneyPosition.getY() + 1][(int) moneyPosition
					.getX()] == 'E') {
				super.money.get(i).move(0, 1);

				// killing the enemy or hero when money is dropped
				for (int k = 0; k < super.hobbins.size(); k++) {
					if (super.money.get(i).getPosition()
							.equals(super.hobbins.get(k).getPosition())) {
						super.hobbins.remove(i);
					}
				}
				for (int k = 0; k < super.nobbins.size(); k++) {
					if (super.money.get(i).getPosition()
							.equals(super.nobbins.get(k).getPosition())) {
						super.nobbins.remove(i);
					}
				}
				if (super.money.get(i).getPosition()
						.equals(super.hero.getPositon())) {
					super.hero.died();
					if (super.hero.getLives() == 0) {
						super.isGameOver = true;
					} else {
						Resorection();
					}
				}

			} else {
				break;
			}
		}

		// moving the money when it is pushed by hero or hobbin??

		// updates hobbins positons
		for (int i = 0; i < super.hobbins.size(); i++) {
			Point2D heroPosition = super.hero.getPositon();
			Point2D hobbinPosition = super.hobbins.get(i).getPosition();
			// has the hobbin move toward the hero
			// also checks if money is next to the hobbin, if so it moves the
			// money too if it is able to.
			if (heroPosition.getX() - hobbinPosition.getX() > 0) {
				Money moneyNextToPos = super.moneyNextToPosition(
						super.hobbins.get(i), 1, 0);
				if (moneyNextToPos != null
						&& moneyNextToPos.getPosition().getX() > super.gameBoard[i].length) {
					moneyNextToPos.move(1, 0);
					super.hobbins.get(i).updatePosition(1, 0);
					super.gameBoard[(int) super.hobbins.get(i).getPosition()
							.getY()][(int) super.hobbins.get(i).getPosition()
							.getX()] = 'E';
				}
				if (moneyNextToPos == null) {
					super.hobbins.get(i).updatePosition(1, 0);
					super.gameBoard[(int) super.hobbins.get(i).getPosition()
							.getY()][(int) super.hobbins.get(i).getPosition()
							.getX()] = 'E';
				}

			} else if (heroPosition.getX() - hobbinPosition.getX() < 0) {
				Money moneyNextToPos = super.moneyNextToPosition(
						super.hobbins.get(i), -1, 0);
				if (moneyNextToPos != null
						&& moneyNextToPos.getPosition().getX() > 0) {
					moneyNextToPos.move(-1, 0);
					super.hobbins.get(i).updatePosition(-1, 0);
					super.gameBoard[(int) super.hobbins.get(i).getPosition()
							.getY()][(int) super.hobbins.get(i).getPosition()
							.getX()] = 'E';
				}
				if (moneyNextToPos == null) {
					super.hobbins.get(i).updatePosition(-1, 0);
					super.gameBoard[(int) super.hobbins.get(i).getPosition()
							.getY()][(int) super.hobbins.get(i).getPosition()
							.getX()] = 'E';
				}
			} else if (heroPosition.getY() - hobbinPosition.getY() > 0) {
				Money moneyNextToPos = super.moneyNextToPosition(
						super.hobbins.get(i), 0, 1);
				if (moneyNextToPos != null
						&& moneyNextToPos.getPosition().getY() > super.gameBoard.length) {
					moneyNextToPos.move(1, 0);
					super.hobbins.get(i).updatePosition(0, 1);
					super.gameBoard[(int) super.hobbins.get(i).getPosition()
							.getY()][(int) super.hobbins.get(i).getPosition()
							.getX()] = 'E';
				}
				if (moneyNextToPos == null) {
					super.hobbins.get(i).updatePosition(0, 1);
					super.gameBoard[(int) super.hobbins.get(i).getPosition()
							.getY()][(int) super.hobbins.get(i).getPosition()
							.getX()] = 'E';
				}
			} else if (heroPosition.getY() - hobbinPosition.getY() < 0) {
				Money moneyNextToPos = super.moneyNextToPosition(
						super.hobbins.get(i), 0, -1);
				if (moneyNextToPos != null
						&& moneyNextToPos.getPosition().getY() > 0) {
					moneyNextToPos.move(0, -1);
					super.hobbins.get(i).updatePosition(0, -1);
					super.gameBoard[(int) super.hobbins.get(i).getPosition()
							.getY()][(int) super.hobbins.get(i).getPosition()
							.getX()] = 'E';
				}
				if (moneyNextToPos == null) {
					super.hobbins.get(i).updatePosition(0, -1);
					super.gameBoard[(int) super.hobbins.get(i).getPosition()
							.getY()][(int) super.hobbins.get(i).getPosition()
							.getX()] = 'E';
				}
			}
		}
		System.out.println("running thread part4");
		// updates nobbins position
		for (int i = 0; i < super.nobbins.size(); i++) {
			Point2D heroPosition = super.hero.getPositon();
			Point2D nobbinPosition = super.nobbins.get(i).getPosition();
			double nobbinX = nobbinPosition.getX();
			double nobbinY = nobbinPosition.getY();
			// has the nobbins move toward the hero if it can go that way

			if ((nobbinX > 0)
					&& (super.gameBoard[(int) (nobbinY)][(int) (nobbinX - 1)] == 'E')
					&& (heroPosition.getX() - nobbinX < 0)) {
				Money moneyNextToNob = super.moneyNextToPosition(
						super.nobbins.get(i), -1, 0);
				if ((moneyNextToNob == null)) {
					super.nobbins.get(i).updatePosition(-1, 0);
				}
			}

			else if ((nobbinX < super.gameBoard[i].length)
					&& (super.gameBoard[(int) nobbinY][(int) (nobbinX + 1)] == 'E')
					&& (heroPosition.getX() - nobbinX > 0)) {
				Money moneyNextToNob = super.moneyNextToPosition(
						super.nobbins.get(i), 1, 0);
				if (moneyNextToNob == null) {
					super.nobbins.get(i).updatePosition(1, 0);
				}
			} else if ((nobbinY > 0)
					&& (super.gameBoard[(int) (nobbinY - 1)][(int) nobbinX] == 'E')
					&& (heroPosition.getY() - nobbinY < 0)) {
				Money moneyNextToNob = super.moneyNextToPosition(
						super.nobbins.get(i), 0, -1);
				if (moneyNextToNob == null) {
					super.nobbins.get(i).updatePosition(0, -1);
				}
			} else if ((nobbinY > super.gameBoard.length)
					&& (super.gameBoard[(int) (nobbinY + 1)][(int) nobbinX] == 'E')
					&& (heroPosition.getY() - nobbinY > 0)) {
				Money moneyNextToNob = super.moneyNextToPosition(
						super.nobbins.get(i), 0, 1);
				if (moneyNextToNob == null) {
					super.nobbins.get(i).updatePosition(0, 1);
				}
			}
			// if the nobbin cannot move toward the hero and just needs to
			// move somehwere
			else if ((nobbinX > 0)
					&& (super.gameBoard[(int) (nobbinY)][(int) (nobbinX - 1)] == 'E')) {
				Money moneyNextToNob = super.moneyNextToPosition(
						super.nobbins.get(i), -1, 0);
				if (moneyNextToNob == null) {
					super.nobbins.get(i).updatePosition(-1, 0);
				}
			} else if ((nobbinX < super.gameBoard[i].length)
					&& (super.gameBoard[(int) nobbinY][(int) (nobbinX + 1)] == 'E')) {
				Money moneyNextToNob = super.moneyNextToPosition(
						super.nobbins.get(i), 1, 0);
				if (moneyNextToNob == null) {
					super.nobbins.get(i).updatePosition(1, 0);
				}
			} else if ((nobbinY > 0)
					&& (super.gameBoard[(int) (nobbinY - 1)][(int) nobbinX] == 'E')) {
				Money moneyNextToNob = super.moneyNextToPosition(
						super.nobbins.get(i), 0, -1);
				if (moneyNextToNob == null) {
					super.nobbins.get(i).updatePosition(0, -1);
				}
			} else if ((nobbinY > super.gameBoard.length)
					&& (super.gameBoard[(int) (nobbinY + 1)][(int) nobbinX] == 'E')) {
				Money moneyNextToNob = super.moneyNextToPosition(
						super.nobbins.get(i), 0, 1);
				if (moneyNextToNob == null) {
					super.nobbins.get(i).updatePosition(0, 1);
				}
			}

		}
		// runs hobbin to nobbin
		for (int i = 0; i < super.nobbins.size(); i++) {
			if (isNobbinToHobbin()) {
				super.hobbins.add(new Hobbin((int) super.nobbins.get(i)
						.getPosition().getX(), (int) super.nobbins.get(i)
						.getPosition().getY()));
				super.nobbins.remove(i);
			}
		}
		
		System.out.println("running thread part5");
		// if hero is at same positon of hobbin
		for (int i = 0; i < super.hobbins.size(); i++) {
			if (super.hero.getPositon().equals(
					super.hobbins.get(i).getPosition())) {
				super.hero.died();
				if (super.hero.getLives() == 0) {
					super.isGameOver = true;
				} else {
					super.Resorection();
				}
			}
		}
		// if hero is at same positon of nobbin
		for (int i = 0; i < super.nobbins.size(); i++) {
			if (super.hero.getPositon().equals(
					super.nobbins.get(i).getPosition())) {
				super.hero.died();
				if (super.hero.getLives() == 0) {
					super.isGameOver = true;
				} else {
					super.Resorection();
				}
			}
		}
		System.out.println("end of thread");
	}
}
