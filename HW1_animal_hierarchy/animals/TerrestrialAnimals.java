/**
 * @author Noa Shem Tov
 */
package animals;

import Olympics.Medal;
import mobility.Point;
/**
 * The TerrestrialAnimals class represents an abstract class for terrestrial animals.
 * It extends the Animal class and adds functionality specific to terrestrial animals,
 * such as the number of legs they have.
 */
public abstract class TerrestrialAnimals extends Animal {
	private int noLegs;
	/**
     * Constructs a new TerrestrialAnimal with default values.
     * The default location for the animal is at Point(0, 20).
     *
     * @param noLegs The number of legs of the terrestrial animal.
     */
	public TerrestrialAnimals(int NoLegs) {
		super(new Point(0,20));
		this.noLegs = NoLegs;
	}
	/**
     * Constructs a new TerrestrialAnimal with the specified properties.
     *
     * @param name The name of the terrestrial animal.
     * @param gender The gender of the terrestrial animal.
     * @param weight The weight of the terrestrial animal.
     * @param speed The speed of the terrestrial animal.
     * @param medals The medals the terrestrial animal has won.
     * @param location The location of the terrestrial animal.
     * @param noLegs The number of legs of the terrestrial animal.
     */
	public TerrestrialAnimals(String name,Genders gender,double weight,double speed,Medal [] medals,Point location,int NoLegs ) {
		super(name,gender,weight,speed,medals,location);
		this.noLegs = NoLegs;
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
     * Checks if this terrestrial animal is equal to another object.
     *
     * @param obj The object to compare to.
     * @return True if the object is a terrestrial animal with the same number of legs and properties, false otherwise.
     */
	public boolean equals(Object obj) {
		return (obj instanceof TerrestrialAnimals) && (this.noLegs == ((TerrestrialAnimals)obj).noLegs) 
				&& (super.equals(obj));
	}
	  /**
     * Returns a string representation of the terrestrial animal, including its number of legs.
     *
     * @return A string representing the terrestrial animal.
     */
	public String toString() {
		String animalString = super.toString();
		return animalString + "it has " + this.noLegs + " legs\n";
	}

}
