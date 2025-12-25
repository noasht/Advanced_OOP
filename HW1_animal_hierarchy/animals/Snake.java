/**
 * @author Noa Shem Tov
 */
package animals;

import Olympics.Medal;
import mobility.Point;
/**
 * The Snake class represents a type of terrestrial animal that is a reptile.
 * It extends the TerrestrialAnimals class and implements the IReptile interface,
 * providing specific attributes and behaviors for snakes.
 */
public class Snake extends TerrestrialAnimals implements IReptile {
	

	private double length;
	private SnakeToxicityLevel Poisonous; 
	 /**
     * Constructs a new Snake with default values.
     * The snake is non-poisonous with a default length of 1.5 meters.
     */
	public Snake() {
		super(0);
		this.Poisonous = SnakeToxicityLevel.NON;
		this.length = 1.5;
	}
	/**
     * Constructs a new Snake with the specified properties.
     *
     * @param name The name of the snake.
     * @param gender The gender of the snake.
     * @param weight The weight of the snake.
     * @param speed The speed of the snake.
     * @param medals The medals the snake has won.
     * @param location The location of the snake.
     * @param type The toxicity level of the snake.
     * @param length The length of the snake.
     */
	public Snake(String name,Genders gender,double weight,double speed,Medal [] medals,Point location, SnakeToxicityLevel type, double length) {
		super(name,gender,weight,speed,medals,location,0);
		this.Poisonous = type;
		if(length <= 0)
			this.length = 1.5;
		else this.length = length;
	}
	/**
     * Overrides the speedUp method to increase the snake's speed.
     *
     * @param SpeedingUp The amount by which to increase the speed.
     * @return True if the speed increase is successful, false otherwise.
     */
	@Override
	public boolean speedUp(int SpeedingUp) { return SetSnakeSpeed(SpeedingUp); }
	 /**
     * Abstract method to return the name of the animal class.
     *
     * @return The name of the animal class as a string.
     */
	@Override
	protected String NameOfAnimalClass() { return "Snake"; }
	 /**
     * Abstract method to return the individual sound of the animal.
     *
     * @return The sound the animal makes as a string.
     */
	@Override
	protected String animalIndividualSound() {	return "ssssssss"; }
	/**
     * Sets the speed of the snake.
     *
     * @param SpeedingUp The amount by which to increase the speed.
     * @return True if the speed is successfully set, false otherwise.
     */
	protected boolean SetSnakeSpeed(int SpeedingUp) {
		if(SpeedingUp < 0 || SpeedingUp + this.GetFromAnimalSpeed() > MAX_SPEED )
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
		return "\n" + animalString + "Poisonous level -  " + this.Poisonous + "\n";
	}
}
