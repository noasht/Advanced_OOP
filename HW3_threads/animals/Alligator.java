/**
 @authors Noa Shem Tov  , Linoy Nisim Pur  */
package animals;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import Graphics.CompetitionPanel;
import Olympics.Medal;
import mobility.Point;

/**
 * Represents an Alligator, a type of animal that can live both on land and in water.
 * This class implements the IReptile, ITerrestrialAnimals, and IWaterAnimal interfaces.
 */

public class Alligator extends Animal implements IReptile, ITerrestrialAnimals, IWaterAnimal {

    /** The terrestrial animal delegate. */
	private ITerrestrialAnimals TerAni;
    /** The water animal delegate. */
	private IWaterAnimal WatAni;
    /** The area where the alligator lives. */
	private String AreaOfLiving;
    /** The path to the image of the alligator. */
	private static final String PATH_IMG = "KindAlligator2/alligator2";

	  /**
     * Constructs an Alligator with the specified properties.
     *
     * @param name the name of the alligator
     * @param speed the speed of the alligator
     * @param location the initial location of the alligator
     * @param maxEnergy the maximum energy of the alligator
     * @param energyPerMeter the energy consumption per meter traveled
     * @param pan the competition panel
     * @param track the track type
     */
	
	public Alligator(String name, int speed, Point location, int maxEnergy, int energyPerMeter,CompetitionPanel pan,String track) {
		super(name, speed, location, maxEnergy, energyPerMeter,pan,PATH_IMG,track);
		this.AreaOfLiving = "North Carolina";
		this.TerAni = new DelegatorTerrestrialAnimals(4);
		this.WatAni = new DelegatorWaterAnimal();
	}

	 /**
     * Gets the name of the alligator.
     *
     * @return the name of the alligator
     */
	
	@Override
	public String getAnimaleName() {
		return "Alligator";
	}
	  /**
     * Gets the category of the alligator.
     *
     * @return the category of the alligator, which is "Water"
     */
	
	public String Category() {
		return "Water";
	}

	  /**
     * Speeds up the alligator by a specified amount.
     *
     * @param SpeedingUp the amount to speed up
     * @return true if the speed was successfully increased, false otherwise
     */
	
	public boolean speedUp(int SpeedingUp) {
		return SetAlligatorSpeed(SpeedingUp);
	}
	 /**
     * Sets the speed of the alligator by adding a speed increment.
     *
     * @param SpeedingUp the speed increment to add
     * @return true if speed was successfully set, false otherwise
     */
	
	protected boolean SetAlligatorSpeed(int SpeedingUp) {
		if (SpeedingUp < 0 || SpeedingUp + this.getSpeed() > MAX_SPEED)
			return false;
		return SetSpeedFromAnimal(SpeedingUp);
	}
	   /**
     * Gets the individual sound of the alligator.
     *
     * @return the sound of the alligator
     */
	
	@Override
	protected String animalIndividualSound() {
		return "Roar";
	}
	   /**
     * Compares this alligator to the specified object. The result is true if and only if the argument is not null
     * and is an Alligator object that has the same area of living and properties as this alligator.
     *
     * @param obj the object to compare this Alligator against
     * @return true if the given object represents an Alligator equivalent to this alligator, false otherwise
     */
	
	public boolean equals(Object obj) {
		return (obj instanceof Alligator) && (this.AreaOfLiving.equals(((Alligator) obj).AreaOfLiving))
				&& (this.WatAni.equals(((Alligator) obj).WatAni)) && (this.TerAni.equals(((Alligator) obj).TerAni))
				&& (super.equals(obj));
	}
	
	   /**
     * Returns a string representation of the alligator. This method is intended to be used for debugging purposes,
     * and the format of the returned string may vary between implementations.
     *
     * @return a string representation of the alligator
     */

	public String toString() {
		String animalString = super.toString();
		return animalString + "It lives in  " + this.AreaOfLiving + this.TerAni.toString() + this.WatAni.toString();
	}

	  /**
     * Dives to a specified depth.
     *
     * @param DiveDepth the depth to dive
     * @return true if the dive was successful, false otherwise
     */
	@Override
	public boolean Dive(double DiveDepth) {
		return this.WatAni.Dive(DiveDepth);
	}

    /**
     * Gets the number of legs of the alligator.
     *
     * @return the number of legs, which is 4
     */
	@Override
	public int GetLegs() {
		return 4;
	}
    /**
     * Draws the alligator on the provided graphics context.
     *
     * @param g the graphics context
     */
	public void drawObject(Graphics g) {
        super.drawObject(g);
    }
	
}
