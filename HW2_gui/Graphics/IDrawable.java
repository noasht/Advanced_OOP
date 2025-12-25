package Graphics;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

/**
 * The IDrawable interface defines the methods required for drawable objects. It
 * includes methods for loading images and drawing the object on a graphics
 * context.
 */
public interface IDrawable {

	public final static int SIZE_PICTURE = 65;
	/**
	 * The path where images are stored.
	 */
	public final static String PICTURE_PATH = "bin/image/";

	/**
	 * Loads the images required for drawing the object.
	 * 
	 * @param nm the name or path of the image to load
	 */
	public void loadImages(String nm);

	/**
	 * Draws the object on the given graphics context.
	 * 
	 * @param g the graphics context on which to draw the object
	 */
	public void drawObject(Graphics g);
	
	public BufferedImage getImage1();
	public BufferedImage getImage2();	
	public BufferedImage getImage3();
	public BufferedImage getImage4();
}
