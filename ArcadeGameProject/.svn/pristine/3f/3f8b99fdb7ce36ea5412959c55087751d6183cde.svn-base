import java.awt.Color;
import java.awt.geom.Point2D;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

/**
 * The Gems of the the digger game, they are in every level and must
 * be collected to win. they dont move
 * 
 * @author goldacbj.
 *         Created Feb 9, 2015.
 */
public class Gem extends Entity{
	private Point2D position;
	static final int VALUE = 100;

	/**
	 * Constructs a Gem in the given position
	 *
	 * @param positoin
	 */
	public Gem(int positionX, int positionY) {
		super(positionX, positionY);
		this.color = Color.green;
		
		try {
			this.image = ImageIO.read(new File(Main.path + "images/diamond.png"));
		} catch (IOException exception) {
			System.out.println("ERROR: closed money image not found");
		}
	}
	
	/**
	 * returns the value of the gem
	 *
	 * @return
	 */
	public static int getValue() {
		return VALUE;
	}
	
}
