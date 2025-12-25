/**
 * @author 
 */
package mobility;

import Graphics.IClonable;

/**
 * The Point class represents a point in a 2-dimensional space. 
 * It encapsulates the coordinates (X, Y) of the point and provides methods 
 * to initialize, retrieve coordinates, check equality, and obtain a string representation.
 */
public class Point implements IClonable {
	/**
	 * X-coordinate of the point Y-coordinate of the point
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
	 * Constructs a new Point with specified coordinates (x, y). If either x or y is
	 * negative, initializes with default coordinates (0, 0).
	 *
	 * @param x The X-coordinate of the point.
	 * @param y The Y-coordinate of the point.
	 */
	public Point(int x, int y) {
		if (x >= 0 && y >= 0) {
			this.X = x;
			this.Y = y;
		} else
			DefaultValuesForXANDY();
	}

	/**
	 * Returns the X-coordinate of the point.
	 *
	 * @return The X-coordinate of the point.
	 */
	public int GetFromPointX() {
		return this.X;
	}

	/**
	 * Returns the Y-coordinate of the point.
	 *
	 * @return The Y-coordinate of the point.
	 */

	public int GetFromPointY() {
		return this.Y;
	}
	/**
     * Sets the Y-coordinate of the point if the value is non-negative.
     *
     * @param Y The Y-coordinate to set.
     * @return True if the Y-coordinate was set successfully, false otherwise.
     */
	protected boolean SetPointY(int Y) {
		if (Y >= 0) {
			this.Y = Y;
			return true;
		}
		return false;
	}
	 /**
     * Sets the X-coordinate of the point if the value is non-negative.
     *
     * @param X The X-coordinate to set.
     * @return True if the X-coordinate was set successfully, false otherwise.
     */
	protected boolean SetPointX(int X) {
		if (X >= 0) {
			this.X = X;
			return true;
		}
		return false;

	}

	/**
	 * Checks if this point is equal to another object.
	 *
	 * @param obj The object to compare to.
	 * @return True if the object is a Point with the same coordinates, false
	 *         otherwise.
	 */
	public boolean equals(Object obj) {
		return (obj instanceof Point) && (this.X == ((Point) obj).X) && (this.Y == ((Point) obj).Y);
	}

	/**
	 * Returns a string representation of the point in the format "Point (X, Y)".
	 *
	 * @return A string representing the point.
	 */
	public String toString() {
		return "Point (" + this.X + ", " + this.Y + ")";
	}
	/**
     * Creates a clone of this point.
     *
     * @return A clone of this point, or null if the cloning fails.
     */
	@Override
	public Object Iclone() {
		try {
			return super.clone();
		} catch (Exception e) {
			System.out.println("Replication error");
			return null;
		}
	}
}
