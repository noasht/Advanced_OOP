/**
 * @author Noa Shem Tov 
 */
package animals;
/**
 * Represents an abstract class for Air Animals, extending the Animal class.
 */
import Olympics.Medal;
import mobility.Point;

public abstract class AirAnimal extends Animal {
	
    /** The wingspan of the AirAnimal. */
	private double wingspan;
	 /**
     * Default constructor for AirAnimal.
     * Initializes with default values.
     */
	public AirAnimal() {
		super(new Point(0,100));
		this.wingspan = 30;
	}
	 /**
     * Parameterized constructor for AirAnimal.
     * @param name The name of the AirAnimal.
     * @param gender The gender of the AirAnimal (MALE, FEMALE, HERMAPHRODITE).
     * @param weight The weight of the AirAnimal.
     * @param speed The speed of the AirAnimal.
     * @param medals The medals won by the AirAnimal.
     * @param location The current location of the AirAnimal.
     * @param wingspan The wingspan of the AirAnimal.
     */
	public AirAnimal(String name,Genders gender,double weight,double speed,Medal [] medals,Point location,double wingspan ) {
		super(name,gender,weight,speed,medals,location);
		if(wingspan <= 0)
			this.wingspan = 30;
		else this.wingspan = wingspan;
	}
	/**
     * Returns the name of the specific AirAnimal class.
     * This method must be implemented in subclasses to return the specific class name.
     * @return The name of the AirAnimal class.
     */
	protected abstract String NameOfAnimalClass();
	/**
     * Returns the specific sound made by the AirAnimal.
     * This method must be implemented in subclasses to return the specific sound.
     * @return The sound made by the AirAnimal.
     */
	protected abstract String animalIndividualSound();
	/**
     * Checks if this AirAnimal is equal to another object.
     * Two AirAnimals are considered equal if they have the same wingspan and other attributes are equal.
     * @param obj The object to compare with.
     * @return True if the objects are equal, false otherwise.
     */
	public boolean equals(Object obj) {
		return (obj instanceof AirAnimal) && (this.wingspan == ((AirAnimal)obj).wingspan)
				&& (super.equals(obj));
	}
	  /**
     * Generates a string representation of the AirAnimal.
     * @return A string describing the AirAnimal, including its class name, attributes, and wingspan.
     */
	public String toString() {
		String animalString = super.toString();
		return animalString + "Its wingspan - " + this.wingspan; 
	}
}
