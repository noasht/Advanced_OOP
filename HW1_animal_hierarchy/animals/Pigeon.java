/**
 * @author Noa Shem Tov
 */
package animals;

import Olympics.Medal;
import mobility.Point;
/**
 * The Pigeon class represents a type of air animal, specifically a pigeon.
 * It extends the AirAnimal class and provides specific attributes and behaviors
 * for pigeons, including family, sound, and equality checks.
 */
public class Pigeon extends AirAnimal {
	/**
	 * Family of the pigeon
	 */
	private String family;
	 /**
     * Constructs a new Pigeon with default values.
     * The pigeon belongs to the "Rock Pigeon" family by default.
     */
	public Pigeon() {
		super();
		this.family = "Rock Pigeon";
	}
	/**
     * Constructs a new Pigeon with the specified properties.
     *
     * @param name The name of the pigeon.
     * @param gender The gender of the pigeon.
     * @param weight The weight of the pigeon.
     * @param speed The speed of the pigeon.
     * @param medals The medals the pigeon has won.
     * @param location The location of the pigeon.
     * @param wingspan The wingspan of the pigeon.
     * @param family The family of the pigeon.
     */
	public Pigeon(String name,Genders gender,double weight,double speed,Medal [] medals,Point location,double wingspan,String family) {
		super(name,gender,weight,speed,medals,location,wingspan);
		this.family = family;
	}
	 /**
     * Abstract method to return the name of the animal class.
     *
     * @return The name of the animal class as a string.
     */
	@Override
	protected String NameOfAnimalClass() { return "Pigeon";}
	 /**
     * Overrides the animalIndividualSound method to return the specific sound of a pigeon.
     *
     * @return The sound of the pigeon as a string.
     */
	@Override
	protected String animalIndividualSound() { return "Arr-rar-rar-rar-raah";}
	 /**
     * Checks if this pigeon is equal to another object.
     *
     * @param obj The object to compare to.
     * @return True if the object is a pigeon with the same family and properties, false otherwise.
     */
	public boolean equals(Object obj) {
		return (obj instanceof Pigeon) && (this.family.equalsIgnoreCase(((Pigeon)obj).family))
				&& (super.equals(obj));
	}
	/**
     * Returns a string representation of the pigeon, including its family.
     *
     * @return A string representing the pigeon.
     */
	public String toString() {
		String animalString = super.toString();
		return "\n" + animalString + "\nThis pigeon is from the " +this.family + " family\n";
	}
}
