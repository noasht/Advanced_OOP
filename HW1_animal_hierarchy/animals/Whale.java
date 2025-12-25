/**
 * @author Noa Shem Tov
 */
package animals;

import Olympics.Medal;
import mobility.Point;
/**
 * The Whale class represents a whale, which is a type of water animal.
 * It includes details about the whale's food type and overrides methods
 * to provide specific behaviors and sounds for the whale.
 */
public class Whale extends WaterAnimal {
	 /**
     * The food type for the whale
     */
	private String foodType;
	 /**
     * Constructs a new Whale with default values.
     * The default food type for the whale is "Krill".
     */
	public Whale() {
		super();
		this.foodType = "Krill"; 
	}
	/**
     * Constructs a new Whale with the specified properties.
     *
     * @param name The name of the whale.
     * @param gender The gender of the whale.
     * @param weight The weight of the whale.
     * @param speed The speed of the whale.
     * @param medals The medals the whale has won.
     * @param location The location of the whale.
     * @param diveDept The dive depth of the whale.
     * @param foodType The type of food the whale eats.
     */
	public Whale(String name,Genders gender,double weight,double speed,Medal [] medals,Point location,double diveDept, String foodType) {
		super(name,gender,weight,speed,medals,location, diveDept);
		this.foodType = foodType;
	}
	 /**
     * Returns the name of the animal class.
     *
     * @return The string "Whale".
     */
	@Override
	protected String NameOfAnimalClass() { return "Whale"; }
	/**
     * Returns the sound the whale makes.
     *
     * @return The string "Splash".
     */
	@Override
	protected String animalIndividualSound() {	return "Splash"; }
	/**
     * Returns the food type the whale eats.
     *
     * @return The food type of the whale.
     */
	protected String GetFromWhaleFoodType() { return this.foodType; }
	/**
     * Checks if this whale is equal to another object.
     *
     * @param obj The object to compare to.
     * @return True if the object is a whale with the same food type and properties, false otherwise.
     */
	public boolean equals(Object obj) {
		return (obj instanceof Whale) && (this.foodType.equalsIgnoreCase(((Whale)obj).foodType))
				&& (super.equals(obj));
	}
	 /**
     * Returns a string representation of the whale, including its food type.
     *
     * @return A string representing the whale.
     */
	public String toString() {
		String animalString = super.toString();
		return "\n" + animalString + "\nThe whale feeds on " + this.foodType+ "\n";
	}
}
