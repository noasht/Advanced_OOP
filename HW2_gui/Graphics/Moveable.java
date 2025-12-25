
package Graphics;

import mobility.Mobile;
import mobility.Point;

import animals.Animal;
import animals.Orientation;
/**
 * The Moveable class implements the IMoveable interface for moveable animals.
 * It provides functionality to retrieve the animal's name and speed, and to move the animal to a new location.
 */
public class Moveable implements IMoveable {
	String nameString;
	int Speed;
	Mobile locationPoint;
	  /**
     * Constructs a Moveable object for the specified animal.
     *
     * @param a the animal to be moved
     */
	public Moveable(String name,int speed,Mobile location) {
		this.nameString = name;
		this.Speed = speed;
		this.locationPoint = location;
	}
	 /**
     * Retrieves the name of the animal.
     * 
     * @return the name of the animal
     */
	public String getAnimaleName() {
		return this.nameString;
	}
	 /**
     * Retrieves the speed of the animal.
     * 
     * @return the speed of the animal
     */
	public int getSpeed() {
		return this.Speed;
	}
	  /**
     * Moves the animal to the specified location.
     * Calculates the distance moved and updates the animal's location.
     * 
     * @param p the new location to move the animal to
     * @return the distance moved
     */
	public double move(Point p) {
	    return this.locationPoint.moveMobile(p);
	}
}
