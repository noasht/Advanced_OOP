/**
 * @author 
 */
package animals;

import java.awt.Graphics;

import Graphics.CompetitionPanel;
import Olympics.Medal;
import mobility.Point;
/**
 * The Dolphin class represents a dolphin, which is a type of water animal.
 * It includes details about the dolphin's water type and overrides methods
 * to provide specific behaviors and sounds for the dolphin.
 */

public class Dolphin extends WaterAnimal{
	
    /** The type of water the dolphin lives in. */
	private TypeOfWater WaterType;
    /** The path to the image of the dolphin. */
	private static final String PATH_IMG = "KindDolphin2/dolphin2";
	/**
     * Constructs a new Dolphin with the specified properties.
     *
     * @param name the name of the dolphin
     * @param speed the speed of the dolphin
     * @param location the initial location of the dolphin
     * @param maxEnergy the maximum energy of the dolphin
     * @param energyPerMeter the energy consumption per meter traveled
     * @param pan the competition panel
     * @param track the track type
     */
	public Dolphin(String name,int speed,Point location,int maxEnergy,int energyPerMeter,CompetitionPanel pan,String track) {
		super(name,speed,location,maxEnergy,energyPerMeter,pan,PATH_IMG,track);
		this.WaterType = TypeOfWater.SEA;
	}
	  /**
     * Checks if this dolphin is equal to another object.
     *
     * @param obj the object to compare to
     * @return true if the object is a dolphin with the same water type and properties, false otherwise
     */
	public boolean equals(Object obj) {
		return (obj instanceof Dolphin) && (this.WaterType.equals(((Dolphin)obj).WaterType))
				&& (super.equals(obj));
	}
	/**
     * Returns a string representation of the dolphin, including its water type.
     *
     * @return a string representing the dolphin
     */
	public String toString() {
		String animalString = super.toString();
		return "\n" + animalString + "It water type is " + this.WaterType + "\n";
	}
	  /**
     * Returns the name of the animal class.
     *
     * @return the string "Dolphin"
     */
	@Override
	public String getAnimaleName(){ return "Dolphin"; }
	 /**
     * Returns the sound the dolphin makes.
     *
     * @return the string "Click-click"
     */
	@Override
	protected String animalIndividualSound() { return "Click-click"; }	
	/**
     * Draws the dolphin on the provided graphics context.
     *
     * @param g the graphics context
     */
	public void drawObject(Graphics g) {
        super.drawObject(g);
    }
}
