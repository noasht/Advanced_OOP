/**
 * @author Noa Shem Tov
 */
package animals;

import Olympics.Medal;
import mobility.Point;
/**
 * The WaterAnimal class represents an abstract class for water animals.
 * It extends the Animal class and provides functionality specific to water animals,
 * such as diving capabilities and dive depth management.
 */
public abstract class WaterAnimal extends Animal {
	private static final int  MAX_DIVE = -800;
	private double diveDept;
	/**
     * Constructs a new WaterAnimal with default values.
     * The default location for the animal is at Point(50, 0) and initial dive depth is 0.
     */
	public WaterAnimal() {
		super(new Point(50,0));
		this.diveDept = 0;
	}
	/**
     * Constructs a new WaterAnimal with the specified properties.
     *
     * @param name The name of the water animal.
     * @param gender The gender of the water animal.
     * @param weight The weight of the water animal.
     * @param speed The speed of the water animal.
     * @param medals The medals the water animal has won.
     * @param location The location of the water animal.
     * @param diveDepth The initial dive depth of the water animal.
     */
	public WaterAnimal(String name,Genders gender,double weight,double speed,Medal [] medals,Point location,double diveDept) {
		super(name,gender,weight,speed,medals,location);
		if(diveDept < MAX_DIVE)
			this.diveDept = 0;
		else this.diveDept = diveDept;
	}
	 /**
     * Allows the water animal to dive to a specified depth.
     *
     * @param diveDepth The depth to dive to. Must be negative and within the maximum dive depth limit.
     * @return True if the dive is successful, false otherwise.
     */
	public boolean Dive(double DiveDepth) {
		if (this.diveDept + DiveDepth < MAX_DIVE  || DiveDepth > 0)
			return false;
		return SetDiveDepth(DiveDepth);
	}
	/**
     * Sets the dive depth of the water animal.
     *
     * @param diveDepth The depth to set. Must be negative and within the maximum dive depth limit.
     * @return True if the dive depth is successfully set, false otherwise.
     */
	protected boolean SetDiveDepth(double DiveDepth) {
			this.diveDept = diveDept + DiveDepth;
			return true;
	}
	/**
     * Abstract method to return the name of the animal class.
     *
     * @return The name of the animal class as a string.
     */
	protected abstract String NameOfAnimalClass();
	 /**
     * Abstract method to return the individual sound of the animal.
     *
     * @return The sound the animal makes as a string.
     */
	protected abstract String animalIndividualSound();
	 /**
     * Checks if this water animal is equal to another object.
     *
     * @param obj The object to compare to.
     * @return True if the object is a water animal with the same dive depth and properties, false otherwise.
     */
	public boolean equals(Object obj) {
		return (obj instanceof WaterAnimal) && (this.diveDept == ((WaterAnimal)obj).diveDept) && (super.equals(obj));
	}
	 /**
     * Returns a string representation of the water animal, including its current dive depth.
     *
     * @return A string representing the water animal.
     */
	public String toString() {
		String animalString = super.toString();
		return animalString + "It is located at a depth of - " + this.diveDept; 
	}
}
