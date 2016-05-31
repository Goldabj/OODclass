package rotatingshapes;

import java.awt.Graphics2D;




public class AnimationThread extends Thread implements Runnable {
	
	private RotatingShape shape;
	private RotatingShapesComponent component;
	
	public AnimationThread(RotatingShape shape, RotatingShapesComponent component) {
		this.shape = shape;
		this.component = component;
	}
	
	
	@Override
	public void run() {
		Graphics2D g2 = (Graphics2D) this.component.getGraphics();
		while(!this.isInterrupted()) {
			g2.setColor(this.component.getBackground());
			this.shape.unDraw(g2);
			g2.rotate(3.14/128);
			this.shape.draw(g2);
			try {
				Thread.sleep(30);
			} catch (InterruptedException exception) {
				exception.printStackTrace();
				break;
			}
		}
	}

}
