/**
 * @author Noa Shem Tov
 */
package animals;
/**
 * The IReptile interface represents a reptile and defines methods related to reptile behavior.
 */
public interface IReptile {
	/**
	 * static final int MAX_SPEED = 5; // Maximum speed for reptiles
	 */
	static final int MAX_SPEED = 5;
	 /**
     * Speeds up the reptile by the specified amount.
     *
     * @param SpeedingUp The amount by which to speed up.
     * @return True if the speed was successfully increased, false otherwise.
     */
	public boolean speedUp(int SpeedingUp);
}
