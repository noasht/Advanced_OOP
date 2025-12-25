/**
 * @author Noa Shem Tov
 */
package animals;

import Olympics.Medal;
import mobility.Point;
/**
 * The Eagle class represents an eagle, which is an air animal.
 */
public class Eagle extends AirAnimal {
	/** The variable altitudeOfFlight describes the maximum height at which an Eagle can fly or reach.
	 *  the maximum height can't be more then 1000
	 */
	private double altitudeOfFlight;
	private static final int MAX_ALTITUDE = 1000;
	/**
     * Default constructor for Eagle.
     * Initializes the altitude of flight to 100.
     */
	public Eagle() {
		super();
		this.altitudeOfFlight = 100;
	}
	/**
     * Parameterized constructor for Eagle.
     *
     * @param name The name of the eagle.
     * @param gender The gender of the eagle.
     * @param weight The weight of the eagle.
     * @param speed The speed of the eagle.
     * @param medals The array of medals won by the eagle.
     * @param location The current location of the eagle.
     * @param wingspan The wingspan of the eagle.
     * @param altitudeOfFlight The altitude of flight of the eagle.
     * 	Check if the input entered does not meet the condition, and if so, assign a default value of 100
     */
	public Eagle(String name,Genders gender,double weight,double speed,Medal [] medals,Point location,double wingspan,double altitudeOfFligh) {
		super(name,gender,weight,speed,medals,location,wingspan);
		if(altitudeOfFligh > MAX_ALTITUDE || altitudeOfFligh < 0)
			this.altitudeOfFlight = 100;
		else this.altitudeOfFlight = altitudeOfFligh;
	}
	@Override
	/**
	 * Retrieves the name of the animal class.
	 * @return The name of the animal class ("Eagle").
	 */
	protected String NameOfAnimalClass() { return "Eagle";	}
	@Override
	/**
	 * Retrieves the sound produced by the eagle.
	 * @return The sound of the eagle ("Clack-wack-chack").
	 */
	protected String animalIndividualSound() { return "Clack-wack-chack"; }
	/**
	 * Checks if the current eagle object is equal to another object.
	 * @param obj The object to compare with.
	 * @return True if the objects are equal, false otherwise.
	 */
	public boolean equals(Object obj) {
		return (obj instanceof Eagle) && (this.altitudeOfFlight == ((Eagle)obj).altitudeOfFlight)
				&& (super.equals(obj));
	}
	/**
	 * Generates a string representation of the eagle object.
	 * @return The string representation of the eagle, including its altitude of flight.
	 */
	public String toString() {
		String animalString = super.toString();
		return "\n" + animalString + "\nIts altitude Of Flight is " + this.altitudeOfFlight + "\n" ;
	}
}
