/**
 * @author 
 */
package animals;
/**
 * The IReptile interface represents a reptile and defines methods related to reptile behavior.
 */
public interface IReptile {
	
    /** The maximum speed for reptiles. */
	static final int MAX_SPEED = 5;
	  /**
     * Speeds up the reptile by the specified amount.
     *
     * @param SpeedingUp the amount by which to speed up
     * @return true if the speed was successfully increased, false otherwise
     */
	public boolean speedUp(int SpeedingUp);
}
