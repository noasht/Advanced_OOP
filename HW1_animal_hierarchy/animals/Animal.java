/**
 * @author Noa Shem Tov
 */
package animals;

import java.util.Arrays;
import Olympics.Medal;
import mobility.Mobile;
import mobility.Point;
/**
 * Abstract class representing an Animal, extending Mobile.
 */
public abstract class Animal extends Mobile {
	private String name;
	private Genders gender;
	private double weight;
	private double speed;
	private Medal [] medals;

    /**
     * Default constructor initializes with default values.
     *
     * @param DefaultPoint The default location point of the animal.
     */
	public Animal(Point DefaultPoint) {
		super(DefaultPoint);
		this.name = "Animal";
		this.gender = Genders.MALE;
		this.weight = 1;
		this.speed = 1;
		this.medals = new Medal[1];
		this.medals[0] = new Medal();
	}
	/**
     * Parameterized constructor for initializing Animal with specific attributes.
     *
     * @param name     The name of the animal.
     * @param gender   The gender of the animal.
     * @param weight   The weight of the animal.
     * @param speed    The speed of the animal.
     * @param medals   The medals won by the animal.
     * @param location The initial location of the animal.
     * 
     * because all the class are immutable so i did assignment instead of create something new and do setters
     * point is immutable,
     * Medal is immutable
     */
	public Animal(String name,Genders gender,double weight,double speed,Medal [] medals, Point location) {
		super(location);
		this.name = name;
		this.gender = gender;
		this.weight = weight;
		this.speed = speed;
		this.medals = medals;
	}
	 /**
     * Retrieves the speed of the animal.
     *
     * @return The speed of the animal.
     */
	public double GetFromAnimalSpeed() { return this.speed;}
	 /**
     * Sets the speed of the animal by adding a speed increment.
     *
     * @param SpeedingUp The speed increment to add.
     * @return True if speed was successfully set, false otherwise.
     */
	protected boolean SetSpeedFromAnimal(int SpeedingUp) {
		this.speed = this.speed + SpeedingUp;
		return true;
	}
	 /**
     * Prints the sound produced by the animal.
     */
	public void makeSound() {
		System.out.println("Animal < " + NameOfAnimalClass() + " > said < " + animalIndividualSound()+ " >");
	}
	 /**
     * Abstract method to get the name of the animal class.
     *
     * @return The name of the animal class.
     */
	protected abstract String NameOfAnimalClass();
	 /**
     * Abstract method to get the sound produced by the animal.
     *
     * @return The sound produced by the animal.
     */
	protected abstract String animalIndividualSound();
	/**
     * Retrieves the location of the animal.
     *
     * @return The location point of the animal.
     */
	public Point getLocation(){ return super.getLocation();}
	/**
     * Checks if the current animal object is equal to another object.
     *
     * @param obj The object to compare with.
     * @return True if the objects are equal, false otherwise.
     */
	public boolean equals(Object obj) {
		return (super.equals(obj)) && (obj instanceof Animal) && (this.name.equals(((Animal)obj).name)) 
				&& (this.gender.equals(((Animal)obj).gender)) && (this.weight == ((Animal)obj).weight) && (this.speed == ((Animal)obj).speed)
				&& (Arrays.equals(this.medals,((Animal)obj).medals));
	}
	/**
     * Generates a string representation of the animal object.
     *
     * @return The string representation of the animal, including its attributes.
     */
	public String toString() {
		String MobileString = super.toString();
		String locationString = super.getLocation().toString();
		String nameStringOfClassString = NameOfAnimalClass();
		String animalString = nameStringOfClassString + "\n" + "The name is - " + this.name + "\n" +
				"It weighs - " + this.weight + "\n" + 
				"Its speed is - " + this.speed + "\n" +
				"Medals it has won - " + Arrays.toString(this.medals) + "\n" +
				"Its location is - " + locationString + "\n" +
				MobileString+ "\n" ;
		return animalString; 
	}
}
