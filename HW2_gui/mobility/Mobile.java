/**
 * @author 
 */
package mobility;
import java.lang.Math;
/**
 * The Mobile class represents a mobile object that can move and calculate distances.
 * It implements the ILocatable interface and maintains its current location and total distance traveled.
 */
public abstract class Mobile implements ILocatable {
	/**
	 * Point location = Current location of the mobile object
	 * double totalDistance = Total distance traveled by the mobile object
	 */
	private Point location;
	private double totalDistance;
	/**
     * Constructs a Mobile object with a specified initial location.
     *
     * @param object The initial location of the mobile object.
     */
	public Mobile(Point object) {
		this.location =  new Point(object.GetFromPointX(),object.GetFromPointY());
		this.totalDistance = 0;		
	}
	 /**
     * Constructs a Mobile object with default location (0, 0).
     */
	public Mobile() {
		this.location = new Point();
		this.totalDistance = 0;	
	}
	 /**
     * Adds the given distance to the total distance traveled.
     *
     * @param addition The distance to add to the total distance.
     */
	protected void addTotalDistance(double addition) {
		this.totalDistance = this.totalDistance + addition;
	}
	/**
     * Calculates the distance between the current location and a specified point.
     *
     * @param objePoint The point to calculate the distance to.
     * @return The distance between the current location and the specified point.
     */
	protected double calcDistance(Point objePoint) {
		double addition = Math.sqrt(Math.pow((objePoint.GetFromPointX() - this.getLocation().GetFromPointX()), 2)
				+ Math.pow((objePoint.GetFromPointY() - this.getLocation().GetFromPointY()), 2));
		addTotalDistance(addition);
		return addition;
	}
	 /**
     * Moves the mobile object to the specified point and calculates the distance moved.
     *
     * @param objePoint The point to move the mobile object to.
     * @return The distance moved.
     */
	public double moveMobile(Point objePoint) {
	    if (isValidLocation(objePoint)) {
	        return Set(objePoint);
	    }
	    return 0;
	}
	/**
     * Sets the location of the mobile object to the specified point if it is valid.
     *
     * @param objePoint The point to set as the new location.
     * @return The distance moved if the location change is valid, otherwise 0.
     */
	private double Set(Point objePoint) {
		double ans = 0;
		ans = calcDistance(objePoint);
		this.location = new Point(objePoint.GetFromPointX(),objePoint.GetFromPointY());
		return ans;
	}
	 /**
     * Checks if the specified point is a valid location for the mobile object.
     *
     * @param ObjectPoint The point to check.
     * @return True if the point is valid (not null and different from current location), false otherwise.
     */
	public boolean setLocation(Point ObjectPoint) {
		if(Set(ObjectPoint) == 0)
			return false;
		return true;	
	}
	  /**
     * Checks if the specified point is a valid location for the mobile object.
     *
     * @param ObjectPoint The point to check.
     * @return True if the point is valid (not null and different from current location), false otherwise.
     */
	private boolean isValidLocation(Point ObjectPoint) {
		if(ObjectPoint == null || location.equals(ObjectPoint))
			return false;
		return true;
	}
	  /**
     * Returns the current location of the mobile object.
     *
     * @return The current location as a Point object.
     */
	public Point getLocation(){ return this.location;}
	public Mobile GetMobile() {	return this; }
	public double GetTotalDistance() {return this.totalDistance;}
	/**
     * Checks if this mobile object is equal to another object.
     *
     * @param obj The object to compare to.
     * @return True if the objects are equal (same location and total distance), false otherwise.
     */
	public boolean equals(Object obj) {
		return (obj instanceof Mobile) && (this.location.equals(((Mobile)obj).location))
				&& (this.totalDistance == ((Mobile)obj).totalDistance) ;
	}
	 /**
     * Returns a string representation of the mobile object, including its current location and total distance traveled.
     *
     * @return A string representing the mobile object.
     */
	public String toString() {
		String locationString = this.location.toString();
		String returnValue = "Current location \n" + locationString + "\nThe Total Distance is " + this.totalDistance;
		return returnValue;
	}
}
