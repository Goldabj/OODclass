import java.awt.Color;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

/**
 * A dirt is a Entity that can only be moved through by a hero or a hobbin
 *
 * @author goldacbj. Created Feb 20, 2015.
 */
public class Dirt extends Entity {

	/**
	 * Constructs a dirt block in the given x and y positions
	 *
	 * @param x
	 * @param y
	 */
	public Dirt(int x, int y) {
		super(x, y);
		this.color = new Color(156, 93, 82);

		try {
			this.image = ImageIO.read(new File(Main.path + "images/dirt.jpg"));
		} catch (IOException exception) {
			System.out.println("ERROR: Dirt image not found");
		}
	}

}
