/**
 * @author 
 */
package animals;

import java.awt.Graphics;

import Graphics.CompetitionPanel;
import Olympics.Medal;
import mobility.Point;
/**
 * Represents a Dog, extending TerrestrialAnimals.
 * This class provides the basic properties and behaviors of a dog, 
 * including its breed and the ability to produce its characteristic sound.
 */
public class Dog extends TerrestrialAnimals implements ITerrestrialAnimals{

    /** The breed of the dog. */
	private String breed;
    /** The path to the image of the dog. */
	private static final String PATH_IMG = "KindDog3/dog3";
	 /**
     * Constructs a Dog with the specified properties.
     *
     * @param name the name of the dog
     * @param speed the speed of the dog
     * @param location the initial location of the dog
     * @param maxEnergy the maximum energy of the dog
     * @param energyPerMeter the energy consumption per meter traveled
     * @param pan the competition panel
     * @param track the track type
     */
	public Dog(String name,int speed,Point location,int maxEnergy,int energyPerMeter,CompetitionPanel pan,String track) {
		super(name,speed,location,4,maxEnergy,energyPerMeter,pan,PATH_IMG,track);
		this.breed = "Labrador";
	}
	  /**
     * Retrieves the name of the animal class.
     *
     * @return the name of the animal class ("Dog")
     */
	@Override
	public String getAnimaleName() { return "Dog"; }
	 /**
     * Retrieves the sound produced by the dog.
     *
     * @return the sound of the dog ("Woof Woof")
     */
	@Override
	protected String animalIndividualSound() { return "Woof Woof"; }
	  /**
     * Checks if the current dog object is equal to another object.
     *
     * @param obj the object to compare with
     * @return true if the objects are equal, false otherwise
     */
	public boolean equals(Object obj) {
		return (obj instanceof Dog) && (this.breed.equals(((Dog)obj).breed))&& (super.equals(obj));
	}
	 /**
     * Generates a string representation of the dog object.
     *
     * @return the string representation of the dog, including its breed
     */
	public String toString() {
		String dogString = "This dog is of the breed - " + this.breed + "\n";
		String animalString = super.toString();
		return animalString + dogString;
	}
	/**
     * Retrieves the number of legs of the dog.
     *
     * @return the number of legs, which is 4
     */
	@Override
	public int GetLegs() {
		return 4;
	}
	/**
     * Draws the dog on the provided graphics context.
     *
     * @param g the graphics context
     */
	public void drawObject(Graphics g) {
        super.drawObject(g);
    }
}

