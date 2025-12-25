/**
 * @author 
 */
package mobility;
/**
 * The ILocatable interface represents an object that has a location and can set its location.
 */
public interface ILocatable {
	/**
     * Gets the current location of the object.
     *
     * @return The current location as a Point object.
     */
	public Point getLocation();

    /**
     * Sets the location of the object to the specified Point.
     *
     * @param ObjectPoint The Point object representing the new location.
     * @return True if the location was successfully set, false otherwise.
     */
	public boolean setLocation(Point ObjectPoint);

}
