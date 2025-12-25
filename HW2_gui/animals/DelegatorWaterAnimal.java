package animals;
/**
 * Represents a delegator class for water animals.
 * This class implements the IWaterAnimal interface and provides the basic properties and behaviors of water animals,
 * such as diving depth.
 */
public class DelegatorWaterAnimal implements IWaterAnimal{
	
    /** The current dive depth of the water animal. */
	private double diveDept;
	  /**
     * Constructs a DelegatorWaterAnimal with a default dive depth of 0.
     */
	public DelegatorWaterAnimal() {
		this.diveDept = 0;
	}
	  /**
     * Constructs a DelegatorWaterAnimal with the specified dive depth.
     *
     * @param diveDept the initial dive depth of the water animal
     */
	public DelegatorWaterAnimal(double diveDept) {
		if(diveDept < MAX_DIVE || diveDept > 0)
			this.diveDept = 0;
		else this.diveDept = diveDept;
	}
	
	  /**
     * Allows the water animal to dive to a specified depth.
     *
     * @param DiveDepth the depth to dive to. Must be negative and within the maximum dive depth limit.
     * @return true if the dive is successful, false otherwise
     */
	public boolean Dive(double DiveDepth) {
		if (this.diveDept + DiveDepth < MAX_DIVE  || DiveDepth > 0)
			return false;
		return SetDiveDepth(DiveDepth);
	}
	  /**
     * Sets the dive depth of the water animal.
     *
     * @param DiveDepth the depth to set. Must be negative and within the maximum dive depth limit.
     * @return true if the dive depth is successfully set, false otherwise
     */
	protected boolean SetDiveDepth(double DiveDepth) {
			this.diveDept = diveDept + DiveDepth;
			return true;
	}
	 /**
     * Compares this delegator water animal to the specified object.
     * The result is true if and only if the argument is not null and is a DelegatorWaterAnimal object that has
     * the same dive depth as this one.
     *
     * @param obj the object to compare this DelegatorWaterAnimal against
     * @return true if the given object represents a DelegatorWaterAnimal equivalent to this one, false otherwise
     */
	public boolean equals(Object obj) {
		return (obj instanceof DelegatorWaterAnimal) && (this.diveDept == ((DelegatorWaterAnimal)obj).diveDept);
	}
	/**
     * Returns a string representation of the delegator water animal.
     * This method is intended to be used for debugging purposes,
     * and the format of the returned string may vary between implementations.
     *
     * @return a string representation of the delegator water animal
     */
	public String toString() {
		return "It is located at a depth of - " + this.diveDept; 
	}
}