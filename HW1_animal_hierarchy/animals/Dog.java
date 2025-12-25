/**
 * @author Noa Shem Tov
 */
package animals;

import Olympics.Medal;
import mobility.Point;
/**
 * Represents a Dog, extending TerrestrialAnimals.
 */
public class Dog extends TerrestrialAnimals {

	private String breed;
	/**
     * Default constructor initializes with 4 legs and Labrador breed.
     */
	public Dog() {
		super(4);
		this.breed = "Labrador";		
	}
	/**
     * Parameterized constructor for initializing Dog with specific attributes.
     *
     * @param name     The name of the dog.
     * @param gender   The gender of the dog.
     * @param weight   The weight of the dog.
     * @param speed    The speed of the dog.
     * @param medals   The medals won by the dog.
     * @param location The initial location of the dog.
     * @param breed    The breed of the dog.
     */
	public Dog(String name,Genders gender,double weight,double speed,Medal [] medals,Point location,String breed ) {
		super(name,gender,weight,speed,medals,location, 4);
		this.breed = breed;
	}
	/**
     * Retrieves the name of the animal class.
     *
     * @return The name of the animal class ("Dog").
     */
	@Override
	protected String NameOfAnimalClass() { return "Dog"; }
	 /**
     * Retrieves the sound produced by the dog.
     *
     * @return The sound of the dog ("Woof Woof").
     */
	@Override
	protected String animalIndividualSound() { return "Woof Woof"; }
	/**
     * Checks if the current dog object is equal to another object.
     *
     * @param obj The object to compare with.
     * @return True if the objects are equal, false otherwise.
     */
	public boolean equals(Object obj) {
		return (obj instanceof Dog) && (this.breed.equals(((Dog)obj).breed))
				&& (super.equals(obj));
	}
	/**
     * Generates a string representation of the dog object.
     *
     * @return The string representation of the dog, including its breed.
     */
	public String toString() {
		String dogString = "This dog is of the breed - " + this.breed + "\n";
		String animalString = super.toString();
		return animalString + dogString;
	}
}
