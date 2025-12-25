/**
 @authors Noa Shem Tov  , Linoy Nisim Pur
 */
package animals;


import Graphics.CompetitionPanel;
/**
 * Represents an abstract class for Air Animals, extending the Animal class.
 */
import mobility.Point;

/**
 * Represents an abstract class for Air Animals, extending the Animal class.
 * This class provides the basic properties and behaviors of air animals.
 * It defines the specific properties of air animals, such as wingspan, 
 * and includes methods to retrieve the name and sound of the animal, 
 * as well as to compare and represent the animal as a string.
 */

public abstract class AirAnimal extends Animal {
	
    /** The wingspan of the air animal. */
	private double wingspan;
	
	/**
     * Constructs an AirAnimal with the specified properties.
     *
     * @param name the name of the air animal
     * @param speed the speed of the air animal
     * @param location the initial location of the air animal
     * @param maxEnergy the maximum energy of the air animal
     * @param energyPerMeter the energy consumption per meter traveled
     * @param pan the competition panel
     * @param img1 the image file path for the air animal
     * @param track the track type
     */
	
	public AirAnimal(String name,int speed,Point location,int maxEnergy,int energyPerMeter,CompetitionPanel pan,String img1,String track) {
		super(name,speed,location,maxEnergy,energyPerMeter,pan,img1,track);
		this.wingspan = 30;
	}
	 /**
     * Gets the name of the air animal.
     *
     * @return the name of the air animal
     */
	
	public abstract String getAnimaleName();
	
	/**
     * Gets the individual sound of the air animal.
     *
     * @return the sound of the air animal
     */
	
	protected abstract String animalIndividualSound();
	
	 /**
     * Gets the category of the air animal.
     *
     * @return the category of the air animal, which is "Air"
     */
	
	public String Category() {
		return "Air";
	}
	
	 /**
     * Compares this air animal to the specified object. The result is true if and only if the argument is not null
     * and is an AirAnimal object that has the same wingspan and properties as this air animal.
     *
     * @param obj the object to compare this AirAnimal against
     * @return true if the given object represents an AirAnimal equivalent to this air animal, false otherwise
     */
     
	public boolean equals(Object obj) {
		return (obj instanceof AirAnimal) && (this.wingspan == ((AirAnimal)obj).wingspan)
				&& (super.equals(obj));
	}
	
	  /**
     * Returns a string representation of the air animal. This method is intended to be used for debugging purposes,
     * and the format of the returned string may vary between implementations.
     *
     * @return a string representation of the air animal
     */
	
	public String toString() {
		String animalString = super.toString();
		return animalString + "Its wingspan - " + this.wingspan; 
	}
}
