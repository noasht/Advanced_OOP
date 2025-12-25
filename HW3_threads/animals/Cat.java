/**
 @authors Noa Shem Tov  , Linoy Nisim Pur  */
package animals;

import java.awt.Graphics;

import Graphics.CompetitionPanel;
import Olympics.Medal;
import mobility.ILocatable;
import mobility.Point;

/**
 * Represents a Cat, extending TerrestrialAnimals.
 * This class provides the basic properties and behaviors of a cat, 
 * including the ability to determine if it is castrated and to produce its characteristic sound.
 */
public class Cat extends TerrestrialAnimals{
	
    /** Indicates whether the cat is castrated. */
	private boolean Castrated;
    /** The path to the image of the cat. */
	private static final String PATH_IMG = "KindCat2/cat2";
	  /**
     * Constructs a Cat with the specified properties.
     *
     * @param name the name of the cat
     * @param speed the speed of the cat
     * @param location the initial location of the cat
     * @param maxEnergy the maximum energy of the cat
     * @param energyPerMeter the energy consumption per meter traveled
     * @param pan the competition panel
     * @param track the track type
     */
	public Cat(String name,int speed, Point location,int maxEnergy,int energyPerMeter,CompetitionPanel pan,String track) {
		super(name,speed,location,4,maxEnergy,energyPerMeter,pan,PATH_IMG,track);
		this.Castrated = false;
	}
	  /**
     * Retrieves the name of the animal class.
     *
     * @return the name of the animal class ("Cat")
     */
	@Override
	public String getAnimaleName() { return "Cat"; }
	  /**
     * Retrieves the sound produced by the cat.
     *
     * @return the sound of the cat ("Meow")
     */
	@Override
	protected String animalIndividualSound() { return "Meow"; }
	 /**
     * Checks if the current cat object is equal to another object.
     *
     * @param obj the object to compare with
     * @return true if the objects are equal, false otherwise
     */
	public boolean equals(Object obj) {
		return (obj instanceof Cat) && (this.Castrated == ((Cat)obj).Castrated) 
				&& (super.equals(obj));
	}
	/**
     * Generates a string representation of the cat object.
     *
     * @return the string representation of the cat, including whether it is castrated
     */
	public String toString() {
		String animalString = super.toString();
		return "\n" + animalString + "If it is Castrated ? - " + this.Castrated + "\n";
	}
	 /**
     * Retrieves the number of legs of the cat.
     *
     * @return the number of legs, which is 4
     */
	@Override
	public int GetLegs() {
		return 4;
	}
	  /**
     * Draws the cat on the provided graphics context.
     *
     * @param g the graphics context
     */
	public void drawObject(Graphics g) {
        super.drawObject(g);
    }
}
