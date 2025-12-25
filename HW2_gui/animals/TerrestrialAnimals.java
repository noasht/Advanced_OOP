/**
 */
package animals;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import Graphics.CompetitionPanel;
import Olympics.Medal;
import mobility.Point;
/**
 * The TerrestrialAnimals class represents an abstract class for terrestrial animals.
 * It extends the Animal class and adds functionality specific to terrestrial animals,
 * such as the number of legs they have.
 */
public abstract class TerrestrialAnimals extends Animal implements ITerrestrialAnimals {
    /** The ITerrestrialAnimals delegate used to represent the number of legs. */
	private ITerrestrialAnimals terrestrialAni;

	 /**
     * Constructs a new TerrestrialAnimal with the specified properties.
     *
     * @param name the name of the terrestrial animal
     * @param speed the speed of the terrestrial animal
     * @param location the initial location of the terrestrial animal
     * @param NoLegs the number of legs of the terrestrial animal
     * @param maxEnergy the maximum energy of the terrestrial animal
     * @param energyPerMeter the energy consumption per meter traveled
     * @param pan the competition panel
     * @param img1 the image file path for the terrestrial animal
     * @param track the track type
     */
	public TerrestrialAnimals(String name, int speed, Point location,int NoLegs,int maxEnergy, int energyPerMeter,CompetitionPanel pan,String img1,String track) {
		super(name,speed,location,maxEnergy, energyPerMeter,pan,img1,track);
		this.terrestrialAni = new DelegatorTerrestrialAnimals(NoLegs);
		
	}
	 /**
     * Abstract method to return the name of the animal class.
     *
     * @return the name of the animal class as a string
     */
	public abstract String getAnimaleName();
	 /**
     * Returns the category of the animal.
     *
     * @return the category of the animal ("Terrestrial")
     */
	public String Category() {
		return "Terrestrial";
	}
	  /**
     * Abstract method to return the individual sound of the animal.
     *
     * @return the sound the animal makes as a string
     */
	protected abstract String animalIndividualSound();
	 /**
     * Checks if this terrestrial animal is equal to another object.
     *
     * @param obj the object to compare to
     * @return true if the object is a terrestrial animal with the same number of legs and properties, false otherwise
     */
	public boolean equals(Object obj) {
		return (obj instanceof TerrestrialAnimals) && (this.terrestrialAni.equals(((TerrestrialAnimals)obj).terrestrialAni))
				&& (super.equals(obj));
	}
	 /**
     * Returns a string representation of the terrestrial animal, including its number of legs.
     * This method overrides the toString method in the Animal class and includes 
     * additional information about the number of legs of the terrestrial animal.
     *
     * @return a string representing the terrestrial animal
     */
	public String toString() {
		String animalString = super.toString();
		return animalString + this.terrestrialAni.toString();
	}

}
