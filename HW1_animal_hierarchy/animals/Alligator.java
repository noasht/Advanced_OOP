/**
 * @author Noa Shem Tov
 */
package animals;

import Olympics.Medal;
import mobility.Point;
/**
 * Represents an Alligator, which is a type of WaterAnimal and implements the IReptile interface.
 */
public class Alligator extends WaterAnimal implements IReptile {
	
    /** The area where the Alligator lives. */
	private String AreaOfLiving;
	 /**
     * Default constructor for Alligator.
     * Initializes with default values.
     */
	public Alligator() {
		super();
		this.AreaOfLiving = "North Carolina";
	}
	/**
     * Parameterized constructor for Alligator.
     * @param name The name of the Alligator.
     * @param gender The gender of the Alligator (MALE, FEMALE, HERMAPHRODITE).
     * @param weight The weight of the Alligator.
     * @param speed The speed of the Alligator.
     * @param medals The medals won by the Alligator.
     * @param location The current location of the Alligator.
     * @param diveDept The diving depth capability of the Alligator.
     * @param AreaOfLiving The area where the Alligator lives.
     */
	public Alligator(String name,Genders gender,double weight,double speed,Medal [] medals,Point location,double diveDept,String AreaOfLiving ) {
		super(name,gender,weight,speed,medals,location, diveDept);
		this.AreaOfLiving = AreaOfLiving;
	}
	 /**
     * Returns the name of the Alligator class.
     * @return The string "Alligator".
     */
	@Override
	protected String NameOfAnimalClass() {	return "Alligator"; } ;
	/**
     * Increases the speed of the Alligator.
     * @param SpeedingUp The speed to increase by.
     * @return True if the speed was successfully increased, false otherwise.
     */
	public boolean speedUp(int SpeedingUp) {
		return SetAlligatorSpeed(SpeedingUp);
	}
	 /**
     * Checks and sets the speed of the Alligator.
     * @param SpeedingUp The speed to set.
     * @return True if the speed was successfully set, false if the speed is invalid.
     */
	protected boolean SetAlligatorSpeed(int SpeedingUp) {
		if(SpeedingUp < 0 || SpeedingUp + this.GetFromAnimalSpeed() > MAX_SPEED )
			return false;
		return SetSpeedFromAnimal(SpeedingUp);
	}
	/**
     * Returns the sound made by the Alligator.
     * @return The sound "Roar".
     */
	@Override
	protected String animalIndividualSound() {	return "Roar";	}
	/**
     * Checks if this Alligator is equal to another object.
     * Two Alligators are considered equal if they have the same area of living and other attributes are equal.
     * @param obj The object to compare with.
     * @return True if the objects are equal, false otherwise.
     */
	public boolean equals(Object obj) {
		return (obj instanceof Alligator) && (this.AreaOfLiving.equals(((Alligator)obj).AreaOfLiving))
				&& (super.equals(obj));
	}
	 /**
     * Generates a string representation of the Alligator.
     * @return A string describing the Alligator, including its class name, attributes, and area of living.
     */
	public String toString() {
		String animalString = super.toString();
		return NameOfAnimalClass() + animalString + "It lives in  " + this.AreaOfLiving + "\n";
	}
}
