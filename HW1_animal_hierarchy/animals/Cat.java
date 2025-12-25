/**
 * @author Noa Shem Tov
 */
package animals;

import Olympics.Medal;
import mobility.Point;
/**
 * Represents a Cat, extending TerrestrialAnimals.
 */
public class Cat extends TerrestrialAnimals {

	private boolean Castrated;
	 /**
     * Default constructor initializes with 4 legs and not castrated.
     */
	public Cat() {
		super(4);
		this.Castrated = false;
	}
	 /**
     * Parameterized constructor for initializing Cat with specific attributes.
     *
     * @param name      The name of the cat.
     * @param gender    The gender of the cat.
     * @param weight    The weight of the cat.
     * @param speed     The speed of the cat.
     * @param medals    The medals won by the cat.
     * @param location  The initial location of the cat.
     * @param castrated Whether the cat is castrated or not.
     */
	public Cat(String name,Genders gender,double weight,double speed,Medal [] medals,Point location,boolean Castrated) {
		super(name,gender,weight,speed,medals,location,4);
		this.Castrated = Castrated;
	}
	 /**
     * Retrieves the name of the animal class.
     *
     * @return The name of the animal class ("Cat").
     */
	@Override
	protected String NameOfAnimalClass() { return "Cat"; }
	 /**
     * Retrieves the sound produced by the cat.
     *
     * @return The sound of the cat ("Meow").
     */
	@Override
	protected String animalIndividualSound() { return "Meow"; }
	/**
     * Checks if the current cat object is equal to another object.
     *
     * @param obj The object to compare with.
     * @return True if the objects are equal, false otherwise.
     */
	public boolean equals(Object obj) {
		return (obj instanceof Cat) && (this.Castrated == ((Cat)obj).Castrated) 
				&& (super.equals(obj));
	}
	/**
     * Generates a string representation of the cat object.
     *
     * @return The string representation of the cat, including whether it is castrated.
     */
	public String toString() {
		String animalString = super.toString();
		return "\n" + animalString + "If it is Castrated ? - " + this.Castrated + "\n";
	}
}
