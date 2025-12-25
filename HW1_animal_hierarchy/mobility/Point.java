/**
 * @author Noa Shem Tov
 */
package mobility;
/**
 * The Point class represents a point in a 2-dimensional space.
 * It encapsulates the coordinates (X, Y) of the point and provides methods
 * to initialize, retrieve coordinates, check equality, and obtain a string representation.
 * point is immutable
 */
public class Point {
	/**
	 * X-coordinate of the point
	 * Y-coordinate of the point
	 */
	private int X;
	private int Y;
	/**
     * Initializes the point with default coordinates (0, 0).
     */
	private void DefaultValuesForXANDY() {
		this.X = 0;
		this.Y = 0;
	}
	 /**
     * Constructs a new Point with default coordinates (0, 0).
     */
	public Point() {
		DefaultValuesForXANDY();
	}
	 /**
     * Constructs a new Point with specified coordinates (x, y).
     * If either x or y is negative, initializes with default coordinates (0, 0).
     *
     * @param x The X-coordinate of the point.
     * @param y The Y-coordinate of the point.
     */
	public Point(int x,int y) {
		if(x >= 0 && y >= 0) {
			this.X = x;
			this.Y = y;
		}
		else DefaultValuesForXANDY();
	}
	/**
     * Returns the X-coordinate of the point.
     *
     * @return The X-coordinate of the point.
     */
	public int GetFromPointX(){ return this.X;}
    /**
     * Returns the Y-coordinate of the point.
     *
     * @return The Y-coordinate of the point.
     */

	public int GetFromPointY(){ return this.Y;}
	/**
     * Checks if this point is equal to another object.
     *
     * @param obj The object to compare to.
     * @return True if the object is a Point with the same coordinates, false otherwise.
     */
	public boolean equals(Object obj) {
		return (obj instanceof Point) && (this.X == ((Point)obj).X) && (this.Y == ((Point)obj).Y);
	}
	   /**
     * Returns a string representation of the point in the format "Point (X, Y)".
     *
     * @return A string representing the point.
     */
	public String toString() {
		return "Point (" + this.X + ", " + this.Y + ")"; 
	}
}
