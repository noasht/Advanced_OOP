/**
 * @author
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
 * The WaterAnimal class represents an abstract class for water animals.
 * It extends the Animal class and provides functionality specific to water animals,
 * such as diving capabilities and dive depth management.
 */
public abstract class WaterAnimal extends Animal implements IWaterAnimal {
	
    /** The IWaterAnimal delegate used to manage dive capabilities. */
	private IWaterAnimal waterAni;
	 /**
     * Constructs a new WaterAnimal with the specified properties.
     * This constructor initializes the water animal's name, speed, location, 
     * maximum energy, energy consumption per meter, competition panel, image path, 
     * and track type. It also initializes the IWaterAnimal delegate.
     *
     * @param name the name of the water animal
     * @param speed the speed of the water animal
     * @param location the initial location of the water animal
     * @param maxEnergy the maximum energy the water animal can have
     * @param energyPerMeter the energy consumption per meter traveled
     * @param pan the competition panel to which the water animal belongs
     * @param img1 the image file path for the water animal
     * @param track the type of track the water animal is on
     */
	public WaterAnimal(String name,int speed,Point location,int maxEnergy,int energyPerMeter,CompetitionPanel pan,String img1,String track)
	{
		super(name,speed,location,maxEnergy,energyPerMeter,pan,img1,track);
		this.waterAni = new DelegatorWaterAnimal();
	}
	 /**
     * Abstract method to return the name of the animal class.
     *
     * @return the name of the animal class as a string
     */
	public abstract String getAnimaleName();
	/**
     * Abstract method to return the individual sound of the animal.
     *
     * @return the sound the animal makes as a string
     */
	protected abstract String animalIndividualSound();
	  /**
     * Returns the category of the animal.
     *
     * @return the category of the animal ("Water")
     */
	public String Category() {
		return "Water";
	}
	/**
     * Checks if this water animal is equal to another object.
     * This method overrides the equals method in the Animal class and compares the 
     * dive depth and other properties of the water animals to determine equality.
     *
     * @param obj the object to compare to
     * @return true if the object is a water animal with the same dive depth and properties, false otherwise
     */
	public boolean equals(Object obj) {
		return (obj instanceof WaterAnimal) && (this.waterAni.equals(((WaterAnimal)obj).waterAni)) && (super.equals(obj));
	}
	/**
     * Returns a string representation of the water animal, including its current dive depth.
     * This method overrides the toString method in the Animal class and includes 
     * additional information about the current dive depth of the water animal.
     *
     * @return a string representing the water animal
     */
	public String toString() {
		String animalString = super.toString();
		return animalString + this.waterAni.toString(); 
	}
	 /**
     * Allows the water animal to dive to a specified depth.
     * This method implements the Dive method from the IWaterAnimal interface and 
     * delegates the dive action to the IWaterAnimal delegate.
     *
     * @param DiveDepth the depth to dive to
     * @return true if the dive is successful, false otherwise
     */
	@Override
	public boolean Dive(double DiveDepth) {
		return this.waterAni.Dive(DiveDepth);
	}
}
