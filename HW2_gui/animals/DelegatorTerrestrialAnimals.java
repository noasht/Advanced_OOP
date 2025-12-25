package animals;
/**
 * Represents a delegator class for terrestrial animals.
 * This class implements the ITerrestrialAnimals interface and provides 
 * the basic properties and behaviors of terrestrial animals, such as the number of legs.
 */

public class DelegatorTerrestrialAnimals implements ITerrestrialAnimals {
	
    /** The number of legs of the terrestrial animal. */
	private int noLegs;
	  /**
     * Constructs a DelegatorTerrestrialAnimals with the specified number of legs.
     *
     * @param NoLegs the number of legs of the terrestrial animal
     */
	public DelegatorTerrestrialAnimals(int NoLegs) {
		this.noLegs = NoLegs;
	}
	  /**
     * Retrieves the number of legs of the terrestrial animal.
     *
     * @return the number of legs
     */
	@Override
	public int GetLegs() {
		return this.noLegs ;
	}
	  /**
     * Compares this delegator terrestrial animal to the specified object. 
     * The result is true if and only if the argument is not null and is a DelegatorTerrestrialAnimals object that has 
     * the same number of legs as this one.
     *
     * @param obj the object to compare this DelegatorTerrestrialAnimals against
     * @return true if the given object represents a DelegatorTerrestrialAnimals equivalent to this one, false otherwise
     */
	public boolean equals(Object obj) {
		return (obj instanceof DelegatorTerrestrialAnimals) && (this.noLegs == ((DelegatorTerrestrialAnimals)obj).noLegs);
	}
	   /**
     * Returns a string representation of the delegator terrestrial animal.
     * This method is intended to be used for debugging purposes, 
     * and the format of the returned string may vary between implementations.
     *
     * @return a string representation of the delegator terrestrial animal
     */
	public String toString() {
		return "it has " + this.noLegs + " legs";
	}
}
