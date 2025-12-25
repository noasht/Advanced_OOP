package Graphics;
/**
 * The IAnimal interface represents behaviors specific to animals.
 * It extends the IMoveable interface to include movement capabilities
 * and adds functionality for eating.
 */
public interface IAnimal extends IMoveable {
	 /**
     * Feeds the animal with the specified amount of energy.
     * 
     * @param energy the amount of energy to feed the animal
     * @return true if the feeding is successful, false otherwise
     */
	 public boolean eat(int energy);
}
