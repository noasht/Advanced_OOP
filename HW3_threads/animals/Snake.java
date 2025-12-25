/**
 * @author 
 */
package animals;

import java.awt.Graphics;

import Graphics.CompetitionPanel;
import Olympics.Medal;
import mobility.Point;
/**
 * The Snake class represents a type of terrestrial animal that is a reptile.
 * It extends the TerrestrialAnimals class and implements the IReptile interface,
 * providing specific attributes and behaviors for snakes.
 */
public class Snake extends TerrestrialAnimals implements IReptile {
	
    /** The length of the snake. */
	private double length;
    /** The toxicity level of the snake. */
	private SnakeToxicityLevel Poisonous; 
    /** The path to the image of the snake. */
	private static final String PATH_IMG = "KindSnake2/snake2";

	/**
     * Constructs a new Snake with the specified properties.
     *
     * @param name the name of the snake
     * @param speed the speed of the snake
     * @param location the initial location of the snake
     * @param maxEnergy the maximum energy of the snake
     * @param energyPerMeter the energy consumption per meter traveled
     * @param pan the competition panel
     * @param track the track type
     */
	public Snake(String name,int speed,Point location,int maxEnergy,int energyPerMeter,CompetitionPanel pan,String track) {
		super(name,speed,location,0,maxEnergy,energyPerMeter,pan,PATH_IMG,track);
		this.Poisonous = SnakeToxicityLevel.LOW;
		this.length = 1.5;
	}
	  /**
     * Overrides the speedUp method to increase the snake's speed.
     *
     * @param SpeedingUp the amount by which to increase the speed
     * @return true if the speed increase is successful, false otherwise
     */
	@Override
	public boolean speedUp(int SpeedingUp) { return SetSnakeSpeed(SpeedingUp); }
	 /**
     * Returns the name of the animal class.
     *
     * @return the name of the animal class ("Snake")
     */
	@Override
	public String getAnimaleName() { return "Snake"; }
	 /**
     * Returns the individual sound of the animal.
     *
     * @return the sound the animal makes ("ssssssss")
     */
	@Override
	protected String animalIndividualSound() {	return "ssssssss"; }
	  /**
     * Sets the speed of the snake.
     *
     * @param SpeedingUp the amount by which to increase the speed
     * @return true if the speed is successfully set, false otherwise
     */
	protected boolean SetSnakeSpeed(int SpeedingUp) {
		if(SpeedingUp < 0 || SpeedingUp + this.getSpeed() > MAX_SPEED )
			return false;
		return SetSpeedFromAnimal(SpeedingUp);
	}
	/**
     * Checks if this snake is equal to another object.
     *
     * @param obj The object to compare to.
     * @return True if the object is a snake with the same toxicity level and properties, false otherwise.
     */
	public boolean equals(Object obj) {
		return (obj instanceof Snake) && (this.Poisonous.equals(((Snake)obj).Poisonous)) 
				&& (super.equals(obj));
	}
	 /**
     * Returns a string representation of the snake, including its toxicity level.
     *
     * @return A string representing the snake.
     */
	public String toString() {
		String animalString = super.toString();
		return animalString + "\nPoisonous level -  " + this.Poisonous + "\n";
	}
	  /**
     * Returns the number of legs the snake has.
     *
     * @return the number of legs (0)
     */
	@Override
	public int GetLegs() {
		return 0;
	}
	/**
     * Draws the snake on the provided graphics context.
     *
     * @param g the graphics context
     */
	public void drawObject(Graphics g) {
        super.drawObject(g);
    }
}
