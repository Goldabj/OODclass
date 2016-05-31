public class Weapon extends DiggerGame {
	public double startX;
	public double startY;
	public String direction;
	public double currX;
	public double currY;

	public Weapon(String direction) {
		this.startX = super.hero.getPositon().getX();
		this.startY = super.hero.getPositon().getY();
		this.direction = direction;
	}

	public void move() {
		while (!isDirt()) {
			if (this.direction == "left") {
				this.currX -= 1;
			}
			if (this.direction == "right") {
				this.currX += 1;
			}
			if (this.direction == "up") {
				this.currY -= 1;
			}
			if (this.direction == "down") {
				this.currY += 1;
			}
		}
	}

	public boolean isDirt() {
		if (this.gameBoard[(int) this.currY][(int) this.currX] == 'D') {
			return true;
		}
		return false;
	}
}
