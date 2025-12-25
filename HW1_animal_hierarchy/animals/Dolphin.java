/**
 * @author Noa Shem Tov
 */
package animals;

import Olympics.Medal;
import mobility.Point;
/**
 * The Dolphin class represents a dolphin, which is a type of water animal.
 * It includes details about the dolphin's water type and overrides methods
 * to provide specific behaviors and sounds for the dolphin.
 */

public class Dolphin extends WaterAnimal {
	
	private TypeOfWater WaterType;
	 /**
     * Constructs a new Dolphin with default values.
     * The default water type for the dolphin is TypeOfWater.SEA.
     */
	public Dolphin() {
		super();
		this.WaterType = TypeOfWater.SEA; 
	}
	/**
     * Constructs a new Dolphin with the specified properties.
     *
     * @param name The name of the dolphin.
     * @param gender The gender of the dolphin.
     * @param weight The weight of the dolphin.
     * @param speed The speed of the dolphin.
     * @param medals The medals the dolphin has won.
     * @param location The location of the dolphin.
     * @param diveDept The dive depth of the dolphin.
     * @param waterType The type of water the dolphin lives in.
     */
	public Dolphin(String name,Genders gender,double weight,double speed,Medal [] medals,Point location,double diveDept, TypeOfWater WaterType) {
		super(name,gender,weight,speed,medals,location, diveDept);
		this.WaterType = WaterType;
	}
	/**
     * Checks if this dolphin is equal to another object.
     *
     * @param obj The object to compare to.
     * @return True if the object is a dolphin with the same water type and properties, false otherwise.
     */
	public boolean equals(Object obj) {
		return (obj instanceof Dolphin) && (this.WaterType.equals(((Dolphin)obj).WaterType))
				&& (super.equals(obj));
	}
	 /**
     * Returns a string representation of the dolphin, including its water type.
     *
     * @return A string representing the dolphin.
     */
	public String toString() {
		String animalString = super.toString();
		return "\n" + animalString + "It water type is " + this.WaterType + "\n";
	}
	/**
     * Returns the name of the animal class.
     *
     * @return The string "Dolphin".
     */
	@Override
	protected String NameOfAnimalClass() { return "Dolphin"; }
	 /**
     * Returns the sound the dolphin makes.
     *
     * @return The string "Click-click".
     */
	@Override
	protected String animalIndividualSound() { return "Click-click"; }

}
