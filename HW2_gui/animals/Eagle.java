/**
 * @author 
 */
package animals;

import java.awt.Graphics;

import Graphics.CompetitionPanel;
import Olympics.Medal;
import mobility.Point;

/**
 * The Eagle class represents an eagle, which is an air animal.
 */
public class Eagle extends AirAnimal {
	
    /** The path to the image of the eagle. */
	private static final String PICTURE_PATHEAGLE = "KindEagle3/eagle3";
    /** The maximum altitude of flight for the eagle. */
	private double altitudeOfFlight;
    /** The maximum allowed altitude of flight. */
	private static final int MAX_ALTITUDE = 1000;
	/**
     * Constructs a new Eagle with the specified properties.
     *
     * @param name the name of the eagle
     * @param speed the speed of the eagle
     * @param location the initial location of the eagle
     * @param maxEnergy the maximum energy of the eagle
     * @param energyPerMeter the energy consumption per meter traveled
     * @param pan the competition panel
     * @param track the track type
     */
	public Eagle(String name,int speed,Point location,int maxEnergy,int energyPerMeter,CompetitionPanel pan,String track) {
		super(name,speed,location,maxEnergy,energyPerMeter,pan,PICTURE_PATHEAGLE,track);
		this.altitudeOfFlight = 100;
	}
	@Override
	 /**
     * Retrieves the name of the animal class.
     *
     * @return the name of the animal class ("Eagle")
     */
	public String getAnimaleName() { return "Eagle";	}
	@Override
	 /**
     * Retrieves the sound produced by the eagle.
     *
     * @return the sound of the eagle ("Clack-wack-chack")
     */
	protected String animalIndividualSound() { return "Clack-wack-chack"; }
	/**
     * Checks if the current eagle object is equal to another object.
     *
     * @param obj the object to compare with
     * @return true if the objects are equal, false otherwise
     */
	public boolean equals(Object obj) {
		return (obj instanceof Eagle) && (this.altitudeOfFlight == ((Eagle)obj).altitudeOfFlight)
				&& (super.equals(obj));
	}
	 /**
     * Generates a string representation of the eagle object.
     *
     * @return the string representation of the eagle, including its altitude of flight
     */
	public String toString() {
		String animalString = super.toString();
		return "\n" + animalString + "\nIts altitude Of Flight is " + this.altitudeOfFlight + "\n" ;
	}
	 /**
     * Draws the eagle on the provided graphics context.
     *
     * @param g the graphics context
     */
	public void drawObject(Graphics g) {
        super.drawObject(g);
    }
}
