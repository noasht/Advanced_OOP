/**
 * @author 
 */
package animals;

import java.awt.Graphics;

import Graphics.CompetitionPanel;
import Olympics.Medal;
import mobility.Point;
/**
 * The Pigeon class represents a type of air animal, specifically a pigeon.
 * It extends the AirAnimal class and provides specific attributes and behaviors
 * for pigeons, including family, sound, and equality checks.
 */
public class Pigeon extends AirAnimal {
	
    /** The family of the pigeon. */
	private String family;
    /** The path to the image of the pigeon. */
	private static final String PATH_IMG = "KindPigeon/pigeon";
	/**
     * Constructs a new Pigeon with the specified properties.
     *
     * @param name the name of the pigeon
     * @param speed the speed of the pigeon
     * @param location the initial location of the pigeon
     * @param maxEnergy the maximum energy of the pigeon
     * @param energyPerMeter the energy consumption per meter traveled
     * @param pan the competition panel
     * @param track the track type
     */
	public Pigeon(String name,int speed,Point location,int maxEnergy,int energyPerMeter,CompetitionPanel pan,String track) {
		super(name,speed,location,maxEnergy,energyPerMeter,pan,PATH_IMG,track);
		this.family = "Rock Pigeon";
		
	}
	 /**
     * Abstract method to return the name of the animal class.
     *
     * @return The name of the animal class as a string.
     */
	@Override
	public String getAnimaleName() { return "Pigeon";}
	 /**
     * Overrides the animalIndividualSound method to return the specific sound of a pigeon.
     *
     * @return The sound of the pigeon as a string.
     */
	@Override
	protected String animalIndividualSound() { return "Arr-rar-rar-rar-raah";}
	 /**
     * Checks if this pigeon is equal to another object.
     *
     * @param obj The object to compare to.
     * @return True if the object is a pigeon with the same family and properties, false otherwise.
     */
	public boolean equals(Object obj) {
		return (obj instanceof Pigeon) && (this.family.equalsIgnoreCase(((Pigeon)obj).family))
				&& (super.equals(obj));
	}
	/**
     * Returns a string representation of the pigeon, including its family.
     *
     * @return A string representing the pigeon.
     */
	public String toString() {
		String animalString = super.toString();
		return "\n" + animalString + "\nThis pigeon is from the " +this.family + " family\n";
	}
	 /**
     * Draws the pigeon on the provided graphics context.
     *
     * @param g the graphics context
     */
	public void drawObject(Graphics g) {
        super.drawObject(g);
    }
}
