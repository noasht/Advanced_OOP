package Graphics;

import mobility.Point;
/**
 * The IMoveable interface defines the methods required for moveable objects.
 * It includes methods for retrieving the name and speed of the object and for moving the object to a new location.
 */
public interface IMoveable {
	
	 /**
     * Retrieves the name of the animal.
     * 
     * @return the name of the animal
     */
	public String getAnimaleName();
	  /**
     * Retrieves the speed of the animal.
     * 
     * @return the speed of the animal
     */
	public int getSpeed();
	 /**
     * Moves the object to the specified location.
     * 
     * @param p the new location to move the object to
     * @return the distance moved
     */
	public double move(Point p);
}
