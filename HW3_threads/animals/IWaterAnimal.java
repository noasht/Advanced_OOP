package animals;
/**
 * The IWaterAnimal interface represents water animals and defines methods related to their behavior.
 */
public interface IWaterAnimal {
	
    /** The maximum dive depth for water animals. */
	static final int  MAX_DIVE = -800;
	 /**
     * Allows the water animal to dive to a specified depth.
     *
     * @param DiveDepth the depth to dive to
     * @return true if the dive is successful, false otherwise
     */
	public boolean Dive(double DiveDepth);
}
