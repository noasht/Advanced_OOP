
package Graphics;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;

import javax.imageio.ImageIO;

import animals.Animal;
import animals.Orientation;
import mobility.Mobile;
import mobility.Point;

/**
 * The Drawable class provides functionality to draw an animal object on the
 * screen. It handles the loading of images for different orientations and the
 * actual drawing of the animal.
 */
public class Drawable implements IDrawable {

	private BufferedImage image1;
	private BufferedImage image2;
	private BufferedImage image3;
	private BufferedImage image4;

	Mobile locationPoint;
	Orientation orien;
	CompetitionPanel panel;

	/**
	 * Constructs a Drawable object for the specified animal.
	 *
	 * @param a the animal to be drawn
	 */
	public Drawable(Mobile location, Orientation orien, CompetitionPanel pan, String Path) {
		this.locationPoint = location;
		this.orien = orien;
		this.panel = pan;
		loadImages(Path);
	}

	/**
	 * Loads the images for the different orientations of the animal.
	 * 
	 * @param img_path the path to the images
	 */
	public void loadImages(String img_path) {
		try {
			image1 = ImageIO.read(new File(PICTURE_PATH + img_path + "E.png"));
			image2 = ImageIO.read(new File(PICTURE_PATH + img_path + "S.png"));
			image3 = ImageIO.read(new File(PICTURE_PATH + img_path + "W.png"));
			image4 = ImageIO.read(new File(PICTURE_PATH + img_path + "N.png"));
		} catch (IOException e) {
			System.out.println("Cannot load image");
		}
	}

	public BufferedImage getImage1() {
		return this.image1;
	}

	public BufferedImage getImage2() {
		return this.image2;
	}

	public BufferedImage getImage3() {
		return this.image3;
	}

	public BufferedImage getImage4() {
		return this.image4;
	}

	/**
	 * Draws the animal object on the given graphics context.
	 * 
	 * @param g the graphics context
	 */
	public void drawObject(Graphics g) {

		if (orien == Orientation.EAST) // animal move to the east side
			g.drawImage(image1, locationPoint.getLocation().GetFromPointX(), locationPoint.getLocation().GetFromPointY() - SIZE_PICTURE / 10,
					SIZE_PICTURE, SIZE_PICTURE, panel);
		else if (orien == Orientation.SOUTH) // animal move to the south side
			g.drawImage(image2, locationPoint.getLocation().GetFromPointX(), locationPoint.getLocation().GetFromPointY() - SIZE_PICTURE / 10,
					SIZE_PICTURE, SIZE_PICTURE, panel);
		else if (orien == Orientation.WEST) // animal move to the west side
			g.drawImage(image3, locationPoint.getLocation().GetFromPointX(), locationPoint.getLocation().GetFromPointY() - SIZE_PICTURE / 10,
					SIZE_PICTURE, SIZE_PICTURE, panel);
		else if (orien == Orientation.NORTH) // animal move to the north side
			g.drawImage(image4, locationPoint.getLocation().GetFromPointX() - SIZE_PICTURE / 2,
					locationPoint.getLocation().GetFromPointY() - SIZE_PICTURE / 10, SIZE_PICTURE, SIZE_PICTURE, panel);
		else {
			g.drawImage(image1, locationPoint.getLocation().GetFromPointX(), locationPoint.getLocation().GetFromPointY() - SIZE_PICTURE / 10,
					SIZE_PICTURE, SIZE_PICTURE, panel);
		}
	}
}