/**
 * @author
 */
package animals;

import java.awt.Graphics;

import Graphics.CompetitionPanel;
import Olympics.Medal;
import mobility.Point;
/**
 * The Whale class represents a whale, which is a type of water animal.
 * It includes details about the whale's food type and overrides methods
 * to provide specific behaviors and sounds for the whale.
 */
public class Whale extends WaterAnimal {
	 /**
     * The food type for the whale
     */
	private String foodType;
    /** The path to the image of the whale. */
	private static final String PATH_IMG = "KindWhale1/whale1";
	  /**
     * Constructs a new Whale with the specified properties.
     * The default food type for the whale is "Krill".
     *
     * @param name the name of the whale
     * @param speed the speed of the whale
     * @param location the initial location of the whale
     * @param maxEnergy the maximum energy the whale can have
     * @param energyPerMeter the energy consumption per meter traveled
     * @param pan the competition panel to which the whale belongs
     * @param track the type of track the whale is on
     */
	public Whale(String name,int speed,Point location,int maxEnergy,int energyPerMeter,CompetitionPanel pan,String track) {
		super(name,speed,location,maxEnergy,energyPerMeter,pan,PATH_IMG,track);
		this.foodType = "Krill";
	}
	 /**
     * Returns the name of the animal class.
     *
     * @return the string "Whale"
     */
	@Override
	public String getAnimaleName() { return "Whale"; }
	/**
     * Returns the sound the whale makes.
     *
     * @return The string "Splash".
     */
	@Override
	protected String animalIndividualSound() {	return "Splash"; }
	 /**
     * Returns the food type the whale eats.
     *
     * @return the food type of the whale
     */
	protected String GetFromWhaleFoodType() { return this.foodType; }
	 /**
     * Checks if this whale is equal to another object.
     * This method compares the food type and other properties of the whales 
     * to determine equality.
     *
     * @param obj the object to compare to
     * @return true if the object is a whale with the same food type and properties, false otherwise
     */
	public boolean equals(Object obj) {
		return (obj instanceof Whale) && (this.foodType.equalsIgnoreCase(((Whale)obj).foodType))
				&& (super.equals(obj));
	}
	 /**
     * Returns a string representation of the whale, including its food type.
     * This method overrides the toString method in the Animal class and includes 
     * additional information about the whale's food type.
     *
     * @return a string representing the whale
     */
	public String toString() {
		String animalString = super.toString();
		return "\n" + animalString + "\nThe whale feeds on " + this.foodType+ "\n";
	}
	 /**
     * Draws the whale on the provided graphics context.
     * This method overrides the drawObject method in the Drawable class and is 
     * used to render the whale on the screen.
     *
     * @param g the graphics context
     */
	public void drawObject(Graphics g) {
        super.drawObject(g);
    }
}
