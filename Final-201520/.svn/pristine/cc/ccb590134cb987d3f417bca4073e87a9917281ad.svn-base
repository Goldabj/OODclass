package rotatingshapes;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.Shape;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;

public class RotatingShape implements KeyListener {

	private static final int WIDTH = 50;
	
	private int centerX;
	private int centerY;
	private Color color;
	
	public RotatingShape(int startingX, int startingY) {
		this.centerX = startingX;
		this.centerY = startingY;
		Random r = new Random();
		this.color = new Color(r.nextFloat(), r.nextFloat(), r.nextFloat());
	}
	
	public void draw(Graphics2D g) {
		g.setColor(this.color);
		g.fill(new Rectangle(centerX - WIDTH/2, centerY - WIDTH/2, WIDTH, WIDTH));
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
	}
}
